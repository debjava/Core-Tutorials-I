/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : MessageDAO.java                                 	 	 *
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

/**
 * @author <a href="mailTo:debadatta.m@idealinvent.com?subject=problem in
 *         MessageDAO in mail module">Debadatta Mishra</a>
 * 
 */
public interface MessageDAO {

	/**
	 * Obtains the list of unprocessed records from the runtime table
	 * 
	 * @param connection
	 *            connection to the database holding the runtime table
	 * @param queryString
	 *            Query String which picks unprocessed records
	 * @return The list of Records from the database
	 */
	public List getRuntimeTableDataList(Connection connection,
			String queryString);

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
	public List getEmailDetailsList(Connection connection, String eventCode,
			long version);

	/**
	 * This method is used to obtain the list of cell details.
	 * 
	 * @param connection
	 *            of type {@link Connection}
	 * @param eventCode
	 *            of type String indicating the event code.
	 * @param version
	 *            of type long indicating the version no.
	 * @return a list of cell details
	 */
	public List getCellularDetailsList(Connection connection, String eventCode,
			long version);

	/**
	 * This method is used to update the Runtime table after the message has
	 * been sent successfully.
	 * 
	 * @param conn
	 *            of type {@link Connection}
	 * @param processStatus
	 *            of type String indicating the status
	 * @param seqNo
	 *            of type long indicating the sequence no of the database table.
	 * @return
	 */
	public boolean updateMsgTable(Connection conn, String processStatus,
			long seqNo);

	/**
	 * This method is used to obtain the data from the
	 * Message_Runtime_Configuration_Table. Here key in the map is the
	 * constraint information which is event_code and id.
	 * 
	 * @param connection
	 *            of type {@link Connection}
	 * @return a Map containg data from Master configuration table
	 */
	public Map getMsgConfigTableInfo(Connection connection);
}
