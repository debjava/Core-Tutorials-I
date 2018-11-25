/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : OracleMessageDAOImpl.java                                 	 	 *
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
import java.util.List;
import java.util.Map;

import com.iit.core.bean.MessageConfigTableBean;

/**
 * 
 * @author Debadatta Mishra
 *
 */
public class OracleMessageDAOImpl implements MessageDAO {

	/* (non-Javadoc)
	 * @see com.iit.core.db.MessageDAO#getCellularDetailsList(java.sql.Connection, java.lang.String, long)
	 */
	public List getCellularDetailsList(Connection connection, String eventCode,
			long version) {
		return SQLProcessor.getCellularDetailsList(connection, eventCode,
				version);
	}

	/* (non-Javadoc)
	 * @see com.iit.core.db.MessageDAO#getMsgConfigTableInfo(java.sql.Connection)
	 */
	public Map getMsgConfigTableInfo(Connection connection) {
		return SQLProcessor.getMsgConfigTableInfo(connection);
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
	public List getRuntimeTableDataList(Connection connection,
			String queryString) {
		return SQLProcessor.getRuntimeTableDataList(connection, queryString);
	}

	public boolean updateMsgTable(Connection conn, String processStatus,
			long seqNo) {
		return SQLProcessor.updateMsgTable(conn, processStatus, seqNo);
	}

	/* @deprecated
	 * (non-Javadoc)
	 * @see com.iit.core.db.MessageDAO#getMsgConfigTableInfoOld(java.sql.Connection)
	 */
	public MessageConfigTableBean getMsgConfigTableInfoOld(Connection connection) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.iit.core.db.MessageDAO#getEmailDetailsList(java.sql.Connection, java.lang.String, long)
	 */
	public List getEmailDetailsList(Connection connection, String eventCode,
			long version) {
		return SQLProcessor.getEmailDetailsList(connection, eventCode, version);
	}

}
