/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : SQLProcessor.java                                 	 	 *
 * Author                      : Debadatta Mishra                                            *
 * Creation Date               : Nov 25, 2007                                                *
 * Modification History        :                											 *
 *																						     *
 *     Version No.               Date               Brief description of change              *
 *  ---------------------------------------------------------------------------------------  *
 *                       |      			|				 								 *
 *                       |                  |											 	 *
 *  ---------------------------------------------------------------------------------------  *
 *********************************************************************************************/
package com.iit.core.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.iit.core.bean.CellularAddressDetailsBean;
import com.iit.core.bean.MailDetailsBean;
import com.iit.core.bean.MessageConfigTableBean;
import com.iit.core.bean.RuntimeTableConfigBean;
import com.iit.core.common.Common;
import com.iit.core.common.CommonDBConstant;
import com.iit.core.util.DatabaseUtil;

/**
 * This is a utility class for all database operation.
 * All methods are static here to eliminate the memory overhead.
 * 
 * @author <a href="mailTo:debadatta.m@idealinvent.com?subject=problem in
 *         SQLProcessor in mail module">Debadatta Mishra</a>
 * 
 */
public final class SQLProcessor {
	/**
	 * Logger for logging the messages.
	 */
	protected static Logger logger = Logger.getLogger(SQLProcessor.class);

	/**
	 * Default constructor
	 */
	protected SQLProcessor() {
		super();
	}

	/**
	 * Method which obtains the List of email Ids from the email table
	 * pertaining to that configuration
	 * 
	 * @param connection
	 *            Connection object
	 * @param eventCode
	 *            Event Code for the event
	 * @param version
	 *            Version of the event code
	 * @return List containing all the email id's
	 */
	public static List getEmailDetailsList(Connection connection,
			String refEventCode, long refVersion) {
		logger.debug("refEventCode========" + refEventCode);
		logger.debug("refVersion========" + refVersion);
		List emaildetailsList = new LinkedList();
		String queryString = CommonDBConstant.QUERY_EMAIL_DETAILS;

		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			ps = connection.prepareStatement(queryString);

			// Set Eventcode and the version as parameters for the where clause
			ps.setString(1, refEventCode);
			ps.setLong(2, refVersion);

			// Execute the query
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				MailDetailsBean mailDetailsBean = new MailDetailsBean();

				// Set the Event code into the bean
				String eventCode = resultSet.getString(1);
				mailDetailsBean.setEventCode(eventCode);
				// Set the version into the bean
				long version = resultSet.getInt(2);// Version
				mailDetailsBean.setVersion_no(version);

				String toName = resultSet.getString(3);// To name
				String emailIds = resultSet.getString(4);// email id
				mailDetailsBean.setTo_id(emailIds);

				String fromName = resultSet.getString(5);
				mailDetailsBean.setFrom_name(fromName);

				String ccId = resultSet.getString(6);// For Cc
				mailDetailsBean.setCc_(ccId);

				String bccId = resultSet.getString(7);// For Bcc
				mailDetailsBean.setBcc_(bccId);

				String subject = resultSet.getString(8);
				mailDetailsBean.setSubject(subject);
				int priority = resultSet.getInt(9);
				mailDetailsBean.setPriority(priority);
				mailDetailsBean.setConstraintName(eventCode, version);
				emaildetailsList.add(mailDetailsBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DatabaseUtil.closeResultSet(resultSet);
				// DatabaseUtil.closeStatement(stmt);
				DatabaseUtil.closePreparedStatement(ps);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return emaildetailsList;
	}

	protected static List getCellularDetailsList(Connection connection,
			String refEventCode, long refVersion) {
		List celldetailsList = new LinkedList();
		String queryString = CommonDBConstant.QUERY_CELL_DETAILS;

		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try {
			pstmt = connection.prepareStatement(queryString);
			pstmt.setString(1, refEventCode);
			pstmt.setLong(2, refVersion);

			// Execute the query
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				CellularAddressDetailsBean cellDetailsBean = new CellularAddressDetailsBean();
				String eventCode = resultSet.getString(1);
				cellDetailsBean.setEventCode(eventCode);
				long version = resultSet.getInt(2);
				cellDetailsBean.setVersion(version);
				String toName = resultSet.getString(3);
				cellDetailsBean.setName(toName);
				String fromName = resultSet.getString(4);
				cellDetailsBean.setFromName(fromName);
				String cellNo = resultSet.getString(5);// cellNo
				cellDetailsBean.setCellNo(cellNo);
				celldetailsList.add(cellDetailsBean);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DatabaseUtil.closeResultSet(resultSet);
				DatabaseUtil.closeStatement(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return celldetailsList;
	}

	/**
	 * @param connection
	 * @return
	 */
	protected static Map getMsgConfigTableInfo(Connection connection) {
		// Map msgConfTableMap = new HashMap();
		MessageConfigTableBean msgConfTableBean = null;

		String queryString = CommonDBConstant.GENERAL_SELECTALL_QUERY_STRING
				+ Common.BLANK_SPACE + CommonDBConstant.MSG_CONF_TABLE_NAME;
		Statement stmt = null;
		ResultSet resultSet = null;
		Map configMap = new HashMap();

		try {
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery(queryString);
			while (resultSet.next()) {
				msgConfTableBean = new MessageConfigTableBean();
				// Event Id from the database
				int eventId = resultSet.getInt(1);
				msgConfTableBean.setEventId(eventId);
				// Event Code
				String eventCode = resultSet.getString(2);
				msgConfTableBean.setEventCode(eventCode);
				// Version of the record
				long version = resultSet.getInt(3);
				String keyMap = new StringBuffer().append(eventCode)
						.append("_").append(new Long(version).toString())
						.toString();
				logger.info("Key Map::" + keyMap);

				msgConfTableBean.setVersion(version);
				String extnSysName = resultSet.getString(4);
				msgConfTableBean.setExternal_system(extnSysName);
				String description = resultSet.getString(5);
				msgConfTableBean.setDescription(description);
				String functionName = resultSet.getString(6);
				msgConfTableBean.setFunction_name(functionName);
				String functionType = resultSet.getString(7);
				msgConfTableBean.setFunction_type(functionType);
				String msgType = resultSet.getString(8);
				msgConfTableBean.setMessage_type(msgType);
				String templateName = resultSet.getString(9);
				msgConfTableBean.setTemplate_name(templateName);
				String templatePath = resultSet.getString(10);
				msgConfTableBean.setTemplate_path(templatePath);
				String fileAttachement = resultSet.getString(11);
				msgConfTableBean.setFile_attachement(fileAttachement);
				String attachmentType = resultSet.getString(12);
				msgConfTableBean.setAttachment_type(attachmentType);
				String attachmentPath = resultSet.getString(13);
				msgConfTableBean.setAttachement_path(attachmentPath);
				String dbServerPort = resultSet.getString(14);
				msgConfTableBean.setDb_server_port(dbServerPort);
				String dbServerIP = resultSet.getString(15);
				msgConfTableBean.setDb_server_ip(dbServerIP);
				String dbName = resultSet.getString(16);
				msgConfTableBean.setDb_name(dbName);
				String dbUserName = resultSet.getString(17);
				msgConfTableBean.setDb_username(dbUserName);
				String dbUserPwd = resultSet.getString(18);
				msgConfTableBean.setDb_user_pwd(dbUserPwd);
				String dbSid = resultSet.getString(19);
				msgConfTableBean.setDb_sid(dbSid);
				String deliveryFrequency = resultSet.getString(20);
				msgConfTableBean.setDelivery_frequency(deliveryFrequency);

				// Push the bean into them map with the EventCode_Version as the
				// key
				configMap.put(keyMap, msgConfTableBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DatabaseUtil.closeResultSet(resultSet);
				DatabaseUtil.closeStatement(stmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return configMap;
	}

	/**
	 * This method is used to update the runtime table to make the
	 * status as <code> P </code>.
	 * This method will be called only when mail or message is sent
	 * successfully to the destination.
	 * 
	 * @param conn of type {@link Connection}
	 * @param processStatus of type String indicating the ProcessStatus
	 * @param seqNo of type long indicating the sequence no of the table
	 * @return boolean true if sucess else false.
	 */
	protected static boolean updateMsgTable(Connection conn,
			String processStatus, long seqNo) {
		boolean updateFlag = false;
		PreparedStatement pStmt = null;

		String updateQueryString = CommonDBConstant.UPDATE_QUERY_STRING;

		try {
			pStmt = conn.prepareStatement(updateQueryString);
			pStmt.setString(1, processStatus);
			pStmt.setLong(2, seqNo);
			pStmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DatabaseUtil.closePreparedStatement(pStmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return updateFlag;
	}

	/**
	 * Obtains the unprocessed records from the runtime table
	 * 
	 * @param connection
	 *            connection to the database holding the runtime table
	 * @param queryString
	 *            Query String which pickes unprocessed records
	 * @return The list of Records from the database
	 */
	protected static List getRuntimeTableDataList(Connection connection,
			String queryString) {
		List dataList = new LinkedList();
		Statement stmt = null;
		ResultSet resultSet = null;
		try {
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery(queryString);
			while (resultSet.next()) {
				RuntimeTableConfigBean runtimeTableConfBean = new RuntimeTableConfigBean();

				long sequenceNo = resultSet.getLong(1);// Sequence no
				runtimeTableConfBean.setSequence_no(sequenceNo);
				String eventCode = resultSet.getString(2);// event code
				runtimeTableConfBean.setEventCode(eventCode);
				long version = resultSet.getLong(3);// Version
				runtimeTableConfBean.setVersion(version);
				String var1 = resultSet.getString(4);// var1
				runtimeTableConfBean.setVar1(var1);
				String var2 = resultSet.getString(5);
				runtimeTableConfBean.setVar2(var2);
				String var3 = resultSet.getString(6);
				runtimeTableConfBean.setVar3(var3);
				String var4 = resultSet.getString(7);
				runtimeTableConfBean.setVar4(var4);
				java.sql.Date var5 = resultSet.getDate(8);// var5
				runtimeTableConfBean.setVar5(var5);
				// 9 is for time stamp
				String processStatus = resultSet.getString(10);
				runtimeTableConfBean.setProcess_status(processStatus);
				runtimeTableConfBean.setConstraintName(eventCode, version);

				dataList.add(runtimeTableConfBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DatabaseUtil.closeResultSet(resultSet);
				DatabaseUtil.closeStatement(stmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dataList;
	}
}
