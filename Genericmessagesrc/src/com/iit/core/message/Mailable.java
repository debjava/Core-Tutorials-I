/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : Mailable.java                                 				 *
 * Author                      : Debadatta Mishra                                            *
 * Creation Date               : Jan 17, 2007                                                *
 * Modification History        : Modified by Debadatta Mishra  on Feb 21, 2007               *
 *																						     *
 *     Version No.               Date               Brief description of change              *
 *  ---------------------------------------------------------------------------------------  *
 *                       | Feb 21, 2007     |	Functionality for file attachement			 *
 *                       |                  |	added										 *
 *  ---------------------------------------------------------------------------------------  *
 *********************************************************************************************/
package com.iit.core.message;

/**
 * <p align="justified">
 * 
 * This interface contains the following methods.
 * It is only used for messaging system in <b>ProcessMate</b>.
 * The underlying messaging system can be Email or cellular SMS.
 * The email can be of both type Intranet ie <b> Internal </b> or Internet
 * ie <b> External </b>. Based upon the future requirements, the generic
 * methods declaration and method signature are provided here.
 * 
 * <ol>
 * 
 * 	<li> <code>sendTextMail(From,To,Cc,Bcc,Subject,MsgBody,Priority)</code>
 * 	<li> <code>sendTextMailWithAttachment(From,To,Cc,Bcc,Subject,MsgBody,Priority,AttachmentFilePath)</code>
 * 
 * </ol>
 * 
 * </p>
 * <p align="justified">
 * <font size="2" face="Verdana" color="GREEN">
 * The underlying mail framework is a wrapper over the Sun java mail API and Apache
 * common Email API. In the future , if the underlying API gets changed, this interface
 * should not be altered so that other part of the application will not be affected.
 * </font>
 * </p>
 * @author <b><font face="Verdana">Debadatta Mishra</font></b>
 *
 */
public interface Mailable 
{
	/**
	 * <p align="justified">
	 * 
	 * This method is used to send the email based upon the following 
	 * parameters. The parameter for To,Cc and Bcc can include the list
	 * of Email ids separated by commas(,) and/or semicolon(;).
	 * 
	 * </p>
	 * <p align="justified">
	 * <font size="2" face="Verdana">
	 * This method is used for sending only plain text mail without any file attachment.
	 * </font> 
	 * </p>
	 * @param from_parm of type java.lang.String specifying the id of the incoming email.
	 * @param to_parm of type java.lang.String specifying the destination email id.
	 * @param cc_parm of type java.lang.String specifying the destination email ids for Cc.
	 * @param bcc_parm of type java.lang.String specifying the destination email ids for Bcc.
	 * @param subject_parm of type java.lang.String specifying the subject .
	 * @param message_parm of type java.lang.String specifying the message body.
	 * @param priority_parm of type java.lang.String specifying the priority of the email.
	 * The priority can be Normal or High more specifically, it indicates
	 * the Flag of the email.
	 * @return boolean value true if the email is sent successfully.
	 */
	public boolean sendTextMail(String from_parm, String to_parm, String cc_parm, String bcc_parm,
			String subject_parm, String message_parm,String priority_parm);
	
	/**
	 * <p align="justified">
	 * This method is used to send the email based upon the following 
	 * parameters. The parameter for To,Cc and Bcc and with attachement can include the list
	 * of Email ids separated by commas(,) and/or semicolon(;).
	 * </p>
	 * <p align="justified">
	 * This method is used for sending plain text mail with any file attachment. 
	 * </p>
	 * <p align="justified">
	 * 	<font size="3" color="red" face="Verdana" >
	 * 	It is to be noted that the attached file size should not be greater than
	 * 	1 MB othersize , it will throw Exception.
	 *  </font>
	 * </p>
	 * @param from_parm of type java.lang.String specifying the id of the incoming email.
	 * @param to_parm of type java.lang.String specifying the destination email id.
	 * @param cc_parm of type java.lang.String specifying the destination email ids for Cc.
	 * @param bcc_parm of type java.lang.String specifying the destination email ids for Bcc.
	 * @param subject_parm of type java.lang.String specifying the subject .
	 * @param message_parm of type java.lang.String specifying the message body.
	 * @param priority_parm of type java.lang.String specifying the priority of the email.
	 * The priority can be Normal or High more specifically, it indicates
	 * @param filePath of type java.lang.String specifying the file path of the attached file.
	 * @return boolean value true if the email with attachement is sent successfully.
	 */
	public boolean sendTextMailWithAttachment(String from_parm, String to_parm, String cc_parm, String bcc_parm,
			String subject_parm, String message_parm,String priority_parm,String filePath ) throws FileSizeMoreException;

}
