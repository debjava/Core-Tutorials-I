/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : CommonDBConstant.java                                 	 	 *
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
package com.iit.core.common;

/**
 * @author Debadatta Mishra
 *
 */
public interface CommonDBConstant {
	//Remove the following
	
//	public static final String EMAIL_TABLE_NAME = "EMAIL_ADDRESS_CONFIGURATION";
	public static final String GENERAL_SELECTALL_QUERY_STRING = "select * from";
	//Remove the following
//	public static final String CELLULAR_TABLE_NAME = "SMS_ADDRESS_CONFIGURATION";
	public static final String MSG_CONF_TABLE_NAME = "MESSAGE_CONFIGURATION_TABLE";
//	public static final String MSG_RUNTIME_TABLE_NAME = "MESSAGE_RUNTIME_TABLE";
	
	public static final int DB_NAME = 1;// For oracle
	public static final String START_QUERY_MSG_RUNTIME_TAB = "select * from message_runtime_table "
			+ "where REGEXP_LIKE(process_status,'u','i')";
	public static final String QUERY_EMAIL_DETAILS = "select * from EMAIL_ADDRESS_CONFIGURATION "
			+ "where EVENT_CODE=? and VERSION_NO=? ";

	public static final String QUERY_CELL_DETAILS = "select * from SMS_ADDRESS_CONFIGURATION "
			+ "where EVENT_CODE=? and VERSION_NO=? ";

	public static final String UPDATE_QUERY_STRING = "UPDATE MESSAGE_RUNTIME_TABLE SET PROCESS_STATUS = ?"
			+ "WHERE SEQ_NO=?";
}
