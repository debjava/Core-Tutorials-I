/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : Common.java                                 	 	 *
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
public interface Common 
{
	public final static String CONFIG_NAME = "config";
	public final static String BLANK = "";
	public final static String DATABASE_CONFIG_FILENAME = "databaseConfig.properties";
	public final static String INTERNAL_CONFIG_FILENAME = "internalConfig.xml";
	public final static String MESSAGE_CONFIG_FILENAME = "messageConfig.xml";
	public final static String SCHEDULER_CONFIG_FILENAME = "schedulerConfig.xml";
	/**
	 * This is the default secret key string used for triple des encryption
	 */
	public final static String SECRET_KEY = "®§[/Šž—”ž¶4 «Šv®Š?L­û";
	
	// For mail functionality
	/**
	 * String constants for refering the mail.smtp.host.
	 */
	final public static String MAIL_SMTP_HOST = "mail.smtp.host";
	/**
	 * String constant for refering the mail.debug
	 */
	final public static String MAIL_DEBUG = "mail.debug";
	/**
	 * String constant for refering the email destination type ie To
	 */
	final public static String MAIL_TO = "to";
	/**
	 * String constant for refering the email destination type ie Cc
	 */
	final public static String MAIL_CC = "cc";
	/**
	 * String constant for refering the email destination type ie Bcc
	 */
	final public static String MAIL_BCC = "bcc";
	/**
	 * String constant for comma (,)
	 */
	final public static String COMMON_COMMA = ",";
	/**
	 * String constant for double quotes.
	 */
	final public static String COMMON_DOUBLE_QUOTES = "";
	/**
	 * String constant for blank space.
	 */
	final public static String BLANK_SPACE =" ";
		
	
	//~~ The followings are the Error messages declared in the framework
	
	/**
	 * String Error messge if the Email object is null.
	 */
	final public static String ERR_EMAIL_OBJ_NULL = "Email object is null";
	/**
	 * String Error message if the destination email type is null.
	 */
	final public static String ERR_EMAIL_DESTN_NULL = "Email for destination type is null";
	/**
	 * String Error message if the FROM from the email is invalid
	 */
	final public static String ERR_INVLD_FRM_ADRS = " Invalid from address ";
	/**
	 * String Error message if the email id is invalid.
	 */
	final public static String ERR_INVLD_EMAIL_ID = " Invalid email address ";
	/**
	 * String error message that file size is more than one 1 MB.
	 */
	final public static String ERR_FILE_SIZE = "File Size more than one MB";
	/**
	 * String error message for blank parametr.
	 */
	public final static String ERR_BLANK_PARAMETER = "Passed String Parameter is null";
	/**
	 * String Error message if the attached file is more than one MB.
	 */
	final public static String ERR_ATTACHMENT_SIZE = "Attached file size is more than one MB, please attach another file";
	/**
	 * String error message that file path is null
	 */
	final public static String ERR_FILEPATH_NULL = "File Path is null";
	/**
	 * String error message that file is not found.
	 */
	final public static String ERR_FILE_NOT_FOUND = "File is not found, please provide the actual file path";
}
