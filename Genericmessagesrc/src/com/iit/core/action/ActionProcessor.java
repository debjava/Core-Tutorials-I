/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : ActionProcessor.java                                 	 	 *
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

package com.iit.core.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.iit.core.bean.MailDetailsBean;
import com.iit.core.bean.MessageConfigTableBean;
import com.iit.core.bean.RuntimeTableConfigBean;
import com.iit.core.common.CommonDBConstant;
import com.iit.core.data.TemplateData;
import com.iit.core.db.AbstractDAOFactory;
import com.iit.core.db.MessageDAO;

import com.iit.core.message.ExternalMailer;
import com.iit.core.message.Mailable;
import com.iit.core.util.DataCollector;
import com.iit.core.util.DatabaseUtil;
import com.iit.core.util.FileUtil;

/**
 * This is an implementation of Singleton design pattern. This class is the most
 * significant class for processing the application. The main part begins from
 * here.
 * <p>
 * 
 * @author <a href="mailTo:debadatta.m@idealinvent.com?subject=problem in
 *         ActionProcessor in mail module">Debadatta Mishra</a>
 */
public class ActionProcessor 
{

	/**
	 * Logger for logging the messages.
	 */
	protected static Logger logger = Logger.getLogger(ActionProcessor.class);

	/** Reference to hold the Message DAO */
	private static MessageDAO msgDAO = null;

	/**
	 * This is a thread-safe method which provides a single
	 * instance of type <code> {@link ActionProcessor} </code>
	 * 
	 * @return ActionProcessor object
	 */
	public static ActionProcessor getInstance() {
		msgDAO = AbstractDAOFactory.getDAOFactory(CommonDBConstant.DB_NAME)
		.getMessageDAO();
		return InstanceHolder.actionProcessor;
	}

	/**
	 * Internal class to hold the ActionProcessor instance
	 * This static class is used to maintain thread-safety
	 * in case of singleton design pattern.
	 */
	private static class InstanceHolder {
		private static final ActionProcessor actionProcessor = new ActionProcessor();
	}

	/**
	 * This method is used to process the overall mail
	 * and alert application. The main processing zone
	 * begins from this method.
	 * 
	 * @param conn of type {@link Connection}
	 * @param dbUserName of type String indicating the database user name
	 * @param dbPwd of type String indicating the database password
	 * @param dbURL of type String indicating the database url
	 */
	public void processAction(Connection conn, String intDBUserName,
			String intDBPwd, String intDBURL) {
		Connection externalConnection = null;
		try {

			// For reference see the actual query
			String queryString = CommonDBConstant.START_QUERY_MSG_RUNTIME_TAB;
			List dataList = msgDAO.getRuntimeTableDataList(conn, queryString);
			logger.debug("Runtime Table size: " + dataList.size());

			if (dataList.size() != 0) 
			{
				Map configMapToRead = new HashMap();
				configMapToRead = msgDAO.getMsgConfigTableInfo(conn);
				processList(dataList, configMapToRead, conn, intDBUserName,
						intDBPwd, intDBURL);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				/*
				 * Closing the connection
				 */
				if (externalConnection != null) 
				{
					externalConnection.close();
					externalConnection = null;
				}
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * Function which processes the runtime data list and sends out an email
	 * 
	 * @param dataList
	 *            List of RuntimeTableConfigBean from the runtime table
	 * @param configMapToRead
	 *            Configuration Map which holds data from the configuration
	 *            table
	 * @param internalConn
	 *            Internal Connection to the database
	 * @throws Exception
	 */
	private void processList(List dataList, Map configMapToRead,
			Connection internalConn, String intDBUserName, String intDBPwd,
			String intDBURL) throws Exception {

		Connection externalConnection = null;
		for (int i = 0, n = dataList.size(); i < n; i++) {
			RuntimeTableConfigBean runtimeTableConfBean = (RuntimeTableConfigBean) dataList
			.get(i);
//			String tempStr = runtimeTableConfBean.getConstraintName().trim();
			String tempStr = runtimeTableConfBean.getConstraintName();
			logger.debug("processList()-EventCode_Version: " + tempStr);
			MessageConfigTableBean msgConfTableBean = (MessageConfigTableBean) configMapToRead
			.get(tempStr);

			/* Now make an external database connection */
			String extern_dbUrl = msgConfTableBean.getDbUrl();
			String extern_userName = msgConfTableBean.getDb_username();
			String extern_password = msgConfTableBean.getDb_user_pwd();
			logger.debug("External db URL: " + extern_dbUrl);
			logger.debug("External DB UserName: " + extern_userName);
			logger.debug("External DB Password: " + extern_password);
			/*
			 * If we do not give this wait, there will be a connection
			 * establishing problem.It may lead to the system to unstable
			 * condition.
			 */
			Thread.sleep(2000);
			// If external user name is null, hit the internal database for the
			// template data
			if ((extern_userName == null)) 
			{
				externalConnection = DatabaseUtil.getPooledDbConnection(
						intDBUserName, intDBPwd, intDBURL);
			} else 
			{
				externalConnection = DatabaseUtil.getPooledDbConnection(
						extern_userName, extern_password, extern_dbUrl);
			}

			/*
			 * Store all the vars from the runtime table in the list
			 */
			List varList = new ArrayList();
			varList.add(runtimeTableConfBean.getVar1());
			varList.add(runtimeTableConfBean.getVar2());
			varList.add(runtimeTableConfBean.getVar3());
			varList.add(runtimeTableConfBean.getVar4());
			varList.add(runtimeTableConfBean.getVar5());

			String functionType = msgConfTableBean.getFunction_type();
			String functionName = msgConfTableBean.getFunction_name();
			logger.info("Function Name=========" + functionName);

			/*
			 * This tempDataMap is used to contain the data from the
			 * external system for velocity template. This data is
			 * provided by the implementation provided by the client.
			 * 
			 */
			Map tempDataMap = new HashMap();

			if (functionType.equalsIgnoreCase("java")) 
			{
				tempDataMap = DataCollector.getDataMap(functionName, varList,
						externalConnection);
			} 
			else if (functionType.equalsIgnoreCase("db")) 
			{
				/*
				 * Right now there is no specific implementation
				 * for this. Please provide the implementation if 
				 * there is a change request.
				 * 
				 */
			}
			else 
			{
				/*
				 * If there is new request, please provide the
				 * new implementation. But always check that
				 * cyclomatic complexity is less that 5 otherwise
				 * it may create performance overhead.
				 */
			}
			/*
			 * This is file of the template where the user has put the .vm file.
			 */
			String templatePath = msgConfTableBean.getTemplate_path();
			/*
			 * This is the name of the template
			 */
			String templateName = msgConfTableBean.getTemplate_name();
			/*
			 * This is the actual data that will be sent as email.
			 * Please provide another implementation so that you will
			 * receive as a String which will be sent as a short message
			 * in the cellular system.
			 */
			String sentMsgDataString = TemplateData.getTemplateDataString(
					templatePath, templateName, tempDataMap);
			logger.info("Data from external system to be sent across: "
					+ sentMsgDataString);

			if (msgConfTableBean.getMessage_type().equalsIgnoreCase("E")) {
				// boolean successFlag = sendMail(sentMsgDataString,
				// internalConn);
				if (sentMsgDataString == null
						|| sentMsgDataString.equalsIgnoreCase("")) {
					logger.warn("No data, Email/SMS not to be sent");
				} else {
					// Send message and update
					boolean successFlag = sendMail(sentMsgDataString,
							internalConn, runtimeTableConfBean.getEventCode(),
							runtimeTableConfBean.getVersion());
					updateStatus(successFlag, runtimeTableConfBean,
							internalConn);
				}
			} else if (msgConfTableBean.getMessage_type().equalsIgnoreCase("S")) {
				// Send SMS, right now there is no specific implementation for
				// it
			} else if (msgConfTableBean.getMessage_type().equalsIgnoreCase("B")) {
				// Send both email and sms
			}

		}
	}

	/**
	 * Update the status of the record processed in Runtime table
	 * 
	 * @param flag
	 *            Flag indicating success or failure in processing of record
	 * @param runtimeTableConfBean
	 *            Runtime table details
	 * @param internalConn
	 *            Internal Connection object
	 */
	private void updateStatus(boolean flag,
			RuntimeTableConfigBean runtimeTableConfBean, Connection internalConn) {
		if (flag) {
			long sequenceNo = runtimeTableConfBean.getSequence_no();
			msgDAO.updateMsgTable(internalConn, "P", sequenceNo);
		}
	}

	/**
	 * Function which actually sends mail using smtp
	 * 
	 * @param messageString
	 *            String to be sent across
	 * @param internalConn
	 *            Internal connection to mail moduel database
	 * @param eventCode
	 *            Event Code of the event
	 * @param version
	 *            Version of the Event Code
	 * @return
	 */
	private boolean sendMail(String messageString, Connection internalConn,
			String eventCode, long version) {

		logger.debug("EventCode========" + eventCode);
		logger.debug("Version===========" + version);

		boolean checkFlag = false;
		try {
			String mailPropertyFilePath = FileUtil.getMailPropertyFilePath();
			logger.info("mail property filePath=====>>>"+mailPropertyFilePath);

			Mailable mailer = new ExternalMailer(mailPropertyFilePath);
			// List emailDetailsList = msgDAO.getEmailDetailsList(internalConn);
			List emailDetailsList = msgDAO.getEmailDetailsList(internalConn,
					eventCode, version);

			for (int i = 0, n = emailDetailsList.size(); i < n; i++) {
				MailDetailsBean mailDetailsBean = (MailDetailsBean) emailDetailsList
				.get(i);
				String To = mailDetailsBean.getTo_id();
				String from = mailDetailsBean.getFrom_name();
				String Cc = mailDetailsBean.getCc_();
				String Bcc = mailDetailsBean.getBcc_();
				String Subject = mailDetailsBean.getSubject();
				int priority = mailDetailsBean.getPriority();
				String priority_str = new Integer(priority).toString();
				checkFlag = mailer.sendTextMail(from, To, Cc, Bcc, Subject,
						messageString, null);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return checkFlag;
	}

}
