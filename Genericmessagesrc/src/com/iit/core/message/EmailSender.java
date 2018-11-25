/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : EmailSender.java                                 			 *
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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.apache.log4j.Logger;

import com.iit.core.common.Common;

/**
 * <p align="justified">
 * This class is a wrapper over the Java Mail API from SUN and Common-email from
 * Apache. Basically it builds over the Java Mail API with the aim of presenting
 * a simplified API which is easy for developers who are not mail experts to use.
 * It is a compact component with a small number of classes and interfaces. This 
 * is the only class which may be modified if the underlying Mail API gets changed.
 * The example of how to use it given below. This is a final class and all methods
 * are also final.This class can not be instantiated outside, only the underlying 
 * framework will create it. It has been made for future use. 
 * <p>
 *  <br><code>String mailPropertyFilepath = "D:/processmate/resources/mail.properties" ;</code>
 *  <br><code>String msgBody = "Hi, This is a test email";</code>
 * 	<br><code> EmailSender mailSender = new EmailSender( mailPropertyFilePath );</code>
 *  <br><code> mailSender.sendTextEmailTOList("support@idealinvent.com",emailIdList,"insuranceID+Insurance",msgBody);</code>
 * </p>
 * </p>
 * @author <b><font face="Verdana">Debadatta Mishra</font></b>
 *
 */
public final class EmailSender 
{
	/**
	 * Object for java.util.Properties.
	 */
	private transient Properties mailProperties = new Properties();
	/**
	 * Object reference for java.io.InputStream.
	 */
	private transient InputStream fileInputStream = null;
	/**
	 * Object for Email.
	 * @see org.apache.commons.mail.Email
	 */
	private transient Email email = null;
	/**
	 * Object for Multipart email.
	 * This object is used for sending emails with attachment.
	 * @see org.apache.commons.mail.MultiPartEmail
	 */
	private transient MultiPartEmail multiEmail = null;
	/**
	 * String object for refering the file path
	 * for properties file.
	 */
	private transient String mailPropFilePath = null;
	
	protected static Logger logger = Logger.getLogger(EmailSender.class);
	
	/**
	 * Default Constructor
	 */
	protected EmailSender()
	{
		super();
	}
	
	/**
	 * Parameterized constructor which accepts the path of the
	 * mail.properties file as an input parameter.
	 * @param mailPropFilePath of type java.lang.String 
	 * specifying the path of the mail.properties file.
	 */
	protected EmailSender( final String mailPropFilePath )
	{//After getting the mail.properties file,
		//it initializes all the actual values from
		//properties file.
		super();
		try
		{
			if( mailPropFilePath == null )
				throw new NullPointerException("File Path is null");
			this.mailPropFilePath = mailPropFilePath;
			mailProperties = getMailProperties( mailPropFilePath );
			initializeMail(mailProperties);
		}
		catch( NullPointerException npe )
		{
			npe.printStackTrace();
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
	}
	
	/**<p align="justified">
	 * This method is used to obtain a properties object 
	 * which contains the values defined in the mail.properties.
	 * </p>
	 * @param filePath_parm of type String refering the file path
	 * for the mail.properties.
	 * @return an object of type java.util.Properties.
	 */
	private Properties getMailProperties(final String filePath_parm) {
		Properties mailProp = new Properties();
		try {
			fileInputStream = new FileInputStream(filePath_parm);
			mailProp.load(fileInputStream);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mailProp;
	}
	
	/**
	 * <p align="justified">
	 * This method is used to initialize the email object.
	 * It initializes the host name and debug messages.
	 * </p>
	 * @param mailProperties_parm of type java.util.Properties
	 */
	private void initializeMail( final Properties mailProperties_parm )
	{
		try
		{
			email = new SimpleEmail();
			multiEmail = new MultiPartEmail();
			email.setHostName( mailProperties_parm.getProperty( Common.MAIL_SMTP_HOST ).trim() );
			email.setDebug( Boolean.valueOf(mailProperties_parm.getProperty( Common.MAIL_DEBUG ).trim() ).booleanValue() );
			multiEmail.setHostName( mailProperties_parm.getProperty( Common.MAIL_SMTP_HOST ).trim() );
			multiEmail.setDebug( Boolean.valueOf(mailProperties_parm.getProperty( Common.MAIL_DEBUG ).trim() ).booleanValue() );
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * <p align="justified">
	 * This method is used to send the emails to only <b>TO</b> .
	 * This method is flexible for sending the list of email ids.
	 * <p>
	 * @param from_parm of type java.lang.String specifying the name of the sender.
	 * @param toMails_List_parm of type java.util.List specifying the list of
	 * destination email ids.
	 * @param subject_parm of type java.lang.String specifying the subject of the email.
	 * @param msgBody_parm of type java.lang.String specifying the message body to be sent.
	 * @return a boolean value true if the email is
	 * successfully sent, otherwise it returns false.
	 */
	protected final boolean sendTextEmailTOList( final String from_parm , final List toMails_List_parm , 
			final String subject_parm ,final String msgBody_parm )
	{
		boolean sentFlag = false;
		String emailId = null ;
		try
		{
			firstLoop: for( int i = 0 ; i < toMails_List_parm.size() ; i++ )
			{
				if( i == (toMails_List_parm.size()-1) )
				{
					email.setFrom( from_parm );
					emailId = ( (String)toMails_List_parm.get( i ) ).trim();
					email.addTo( emailId );
					email.setSubject( subject_parm );
					email.setMsg( msgBody_parm );
					email.send();
					sentFlag = true;
					emailId = null;
				}
				else
				{
					emailId = ( (String)toMails_List_parm.get( i ) ).trim();
					email.addTo( emailId );
					emailId = null;
					continue firstLoop;
				}
			}
		}	
		catch( NullPointerException npe )
		{
			sentFlag = false;
			throw npe;
		}
		catch( EmailException ee )
		{
			sentFlag = false;
			ee.printStackTrace();
		}
		catch( Exception e )
		{
			sentFlag = false;
			e.printStackTrace();
		}
		return sentFlag;
	}
	
	/**
	 * <p align="justified">
	 * This method is used to send email to only one destination email id.
	 * </p>
	 * @param from_parm of type java.lang.String specifying the name of the sender.
	 * @param toMails_parm of type java.lang.String specifying the destination email id.
	 * @param subject_parm of type java.lang.String specifying the subject of the email.
	 * @param msgBody_parm of type java.lang.String specifying the messages to be sent.
	 * @return a boolean value true if the email is sent successfully,
	 * otherwise it returns false.
	 */
	protected final boolean sendTextEmailTO( final String from_parm , final String toMails_parm , 
			final String subject_parm ,final String msgBody_parm )
	{
		boolean sentFlag = false;
		try
		{
			email.setFrom( from_parm );
			email.addTo( toMails_parm );
			email.setSubject( subject_parm );
			email.setMsg( msgBody_parm );
			email.send();
			sentFlag = true;

		}
		catch( NullPointerException npe )
		{
			sentFlag = false;
			throw npe;
		}
		catch( EmailException ee )
		{
			sentFlag = false;
			ee.printStackTrace();
		}
		catch( Exception e )
		{
			sentFlag = false;
			e.printStackTrace();
		}
		return sentFlag;
	}
	
	/**
	 * This method is used to send the external email by passing the several
	 * mandatory parameters. This method returns a boolean value true if the
	 * email is sent successfully to the destination, otherwise returns false.
	 * This is the significant method called the class <code>EmailSender</code>.
	 * The mandatory parameters for this method are given below.
	 * <ol>
	 *  <li> <code>From</code> which refers to the from message of the email.
	 *  <li> <code>To</code> which refers to the list of destination email ids
	 *  of destination type <b>TO</b>.
	 *  <li> <code>Cc</code> which refers to the list of destination email ids
	 *  of destination type <b>Cc</b>.
	 *  <li> <code>Bcc</code> which refers to the list of destination email ids
	 *  of destination type <b>Bcc</b>.
	 *  <li> <code>Subject</code> which refers to the Subject of the email.
	 *  <li> <code>Message</code> which refers to the message contents of the email
	 * </ol>
	 * @param from_parm of type java.lang.String refering the From message 
	 * of the email id.
	 * @param toMails_parm of type java.util.List refering the list of email
	 *  ids for To destination type.
	 * @param ccMails_parm of type java.util.List refering the list of email
	 *  ids for Cc destination type.
	 * @param bccMails_parm of type java.util.List refering the list of email 
	 * ids for Bcc destination type.
	 * @param subject_parm of type java.lang.String refering the subject of the email.
	 * @param msgBody_parm of type java.lang.String refering the message contents.
	 * @return a boolean value true if the mail is sent sucessfully otherwise false.
	 */
	protected final boolean sendPlainTextEmail(final String from_parm , final List toMails_parm ,
			final List ccMails_parm, final List bccMails_parm,final String subject_parm ,final String msgBody_parm)
	{
		boolean sentFlag = false;
		try
		{
			email = getEmail( toMails_parm, ccMails_parm, bccMails_parm, email );
			email.setFrom(from_parm);
			email.setSubject( subject_parm );
			email.setMsg( msgBody_parm );
			email.send();
			sentFlag = true;
		}
		catch( NullPointerException npe )
		{
			sentFlag = false;
			throw npe;
		}
		catch( EmailException ee )
		{
			sentFlag = false;
			ee.printStackTrace();
		}
		catch( Exception e )
		{
			sentFlag = false;
			e.printStackTrace();
		}
		
		return sentFlag;
	}
	
	/**
	 * <p align="justified">
	 * This method is used to send the external email with attachment of files
	 * by passing the several mandatory parameters. 
	 * This method returns a boolean value true if the
	 * email is sent successfully to the destination, otherwise returns false.
	 * This is the significant method called the class <code>EmailSender</code>.
	 * </p>
	 * <p>
	 * The mandatory parameters for this method are given below.
	 * <ol>
	 *  <li> <code>From</code> which refers to the from message of the email.
	 *  <li> <code>To</code> which refers to the list of destination email ids
	 *  of destination type <b>TO</b>.
	 *  <li> <code>Cc</code> which refers to the list of destination email ids
	 *  of destination type <b>Cc</b>.
	 *  <li> <code>Bcc</code> which refers to the list of destination email ids
	 *  of destination type <b>Bcc</b>.
	 *  <li> <code>Subject</code> which refers to the Subject of the email.
	 *  <li> <code>Message</code> which refers to the message contents of the email
	 *  <li> <code>Attachment file path</code> which refers to the attachment of the file path
	 * </ol>
	 * </p>
	 * @param from_parm of type java.lang.String refering the incoming email id.
	 * @param toMails_parm of type java.lang.String refering to the <b> To </b> destination email id
	 * @param ccMails_parm of type java.lang.String refering to the <b> Cc </b> destination email id.
	 * @param bccMails_parm of type java.lang.String refering to the <b> Bcc </b> destination email id.
	 * @param subject_parm of type java.lang.String refering the subject of the email.
	 * @param msgBody_parm of type java.lang.string refering the message contents of the email.
	 * @param filePath of type java.lang.String specifying the path of the 
	 * attached file.
	 * @return a boolean value true otherwise false.
	 */
	protected final boolean sendPlainTextEmailWithAttachment(
			final String from_parm, final List toMails_parm,
			final List ccMails_parm, final List bccMails_parm,
			final String subject_parm, final String msgBody_parm,
			String filePath)
	{
		logger.info("=================== Coming to EmailSender : sendPlainTextEmailWithAttachment() ================= ");
		boolean sentFlag = false;
		try
		{
			EmailAttachment attachment = new EmailAttachment();
			attachment.setPath( filePath );
			attachment.setDisposition( EmailAttachment.ATTACHMENT );
			
			multiEmail = getEmail( toMails_parm, ccMails_parm, bccMails_parm, multiEmail );
			multiEmail.setFrom(from_parm);
			multiEmail.setSubject( subject_parm );
			multiEmail.setMsg( msgBody_parm );
			multiEmail.attach( attachment );
			multiEmail.send();
			sentFlag = true;
		}
		catch( NullPointerException npe )
		{
			sentFlag = false;
			throw npe;
		}
		catch( EmailException ee )
		{
			sentFlag = false;
			ee.printStackTrace();
		}
		catch( Exception e )
		{
			sentFlag = false;
			e.printStackTrace();
		}
		
		return sentFlag;
	}

	
	/**
	 * <p align="justified">
	 * This method is used to obtain an object of type
	 * org.apache.commons.mail.Email. This Email object
	 * contains the required email ids with their appropriate
	 * destination type ie To,Cc,Bcc.
	 * </p>
	 * @param toList_parm of type java.util.List specifying
	 * the list of email ids for To.
	 * @param ccList_parm of type java.util.List specifying
	 * the list of email ids for Cc. 
	 * @param bccList_parm of type java.util.List specifying
	 * the list of email ids for Bcc.
	 * @param email_parm of type org.apache.commons.mail.Email
	 * @see org.apache.commons.mail.Email
	 * @return an Object of type org.apache.commons.mail.Email
	 */
	private final Email getEmail( List toList_parm , List ccList_parm , List bccList_parm , Email email_parm )
	{
		try
		{
			if( toList_parm.size() > 0 )
			{
				email_parm = getPopulatedEmail( email_parm, toList_parm, Common.MAIL_TO );
			}
			if( ccList_parm.size() > 0 )
			{
				email_parm = getPopulatedEmail( email_parm, ccList_parm, Common.MAIL_CC );
			}
			if( bccList_parm.size() > 0 )
			{
				email_parm = getPopulatedEmail( email_parm, bccList_parm, Common.MAIL_BCC );
			}
		}
		catch( Exception ee )
		{
			ee.printStackTrace();
		}
		return email_parm;
	}
	
	
	/**
	 * <p align="justified">
	 *	 
	 * This method is used to obtain an object of type
	 * org.apache.commons.mail.MultiPartEmail. This Email object
	 * contains the required email ids with their appropriate
	 * destination type ie To,Cc,Bcc and above all the file path
	 * of the attached file.
	 * 
	 * </p>
	 * @param toList_parm of type java.util.List specifying
	 * the list of email ids for To.
	 * @param ccList_parm of type java.util.List specifying
	 * the list of email ids for Cc. 
	 * @param bccList_parm of type java.util.List specifying
	 * the list of email ids for Bcc.
	 * @param email_parm of type org.apache.commons.mail.MultiPartEmail
	 * @see org.apache.commons.mail.MultiPartEmail
	 * @return an Object of type org.apache.commons.mail.MultiPartEmail
	 */
	private final MultiPartEmail getEmail( List toList_parm , List ccList_parm , List bccList_parm , MultiPartEmail email_parm )
	{
		try
		{
			if( toList_parm.size() > 0 )
			{
				email_parm = getPopulatedEmail( email_parm, toList_parm, Common.MAIL_TO );
			}
			if( ccList_parm.size() > 0 )
			{
				email_parm = getPopulatedEmail( email_parm, ccList_parm, Common.MAIL_CC );
			}
			if( bccList_parm.size() > 0 )
			{
				email_parm = getPopulatedEmail( email_parm, bccList_parm, Common.MAIL_BCC );
			}
		}
		catch( Exception ee )
		{
			ee.printStackTrace();
		}
		return email_parm;
	}

	
	/**
	 * <p align="justified">
	 * This method is used to populate the Email object
	 * with the list of email ids with their appropriate
	 * destination type ie To,Cc,Bcc etc. The destination
	 * type may contain one or more than one email ids
	 * separated by comma(,). This is a final method and
	 * returns the same Email object populated with email
	 * ids.
	 * </p>
	 * @param email_parm of type org.apache.commons.mail.Email
	 * @param emailIdList_parm of type java.util.List specifying the list of email ids.
	 * @param destnName_parm of type String specifying the destination type ie To,Cc,Bcc
	 * @return an object of type Email.
	 * @see org.apache.commons.mail.Email
	 */
	private final Email getPopulatedEmail( Email email_parm , List emailIdList_parm , String destnName_parm )
	{
		if( destnName_parm == null )
			throw new NullPointerException( Common.ERR_EMAIL_DESTN_NULL );
		if( email_parm == null )
			throw new NullPointerException( Common.ERR_EMAIL_OBJ_NULL );
		try
		{
			firstLoop : for( int i = 0 ; i < emailIdList_parm.size() ; i++ )
			{
				if( destnName_parm.equalsIgnoreCase( Common.MAIL_TO ) )
				{
					email_parm.addTo( (String) emailIdList_parm.get( i ) );
					continue firstLoop;
				}
				if( destnName_parm.equalsIgnoreCase( Common.MAIL_CC ) )
				{
					email_parm.addCc( (String) emailIdList_parm.get( i ) );
					continue firstLoop;
				}
				if( destnName_parm.equalsIgnoreCase( Common.MAIL_BCC ) )
				{
					email_parm.addBcc( (String) emailIdList_parm.get( i ) );
					continue firstLoop;
				}
			}
		}
		catch( NullPointerException npe )
		{
			npe.printStackTrace();
		}
		catch( EmailException ee )
		{
			ee.printStackTrace();
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return email_parm;
	}
	
	
	/**
	 * <p align="justified">
	 * 
	 * This method is used to populate the MultiPartEmail object
	 * with the list of email ids with their appropriate
	 * destination type ie To,Cc,Bcc etc. The destination
	 * type may contain one or more than one email ids
	 * separated by comma(,). This is a final method and
	 * returns the same Email object populated with email
	 * ids. This method is only used for multipart email with
	 * file attachment facility.
	 * 
	 * </p>
	 * @param email_parm of type org.apache.commons.mail.Email
	 * @param emailIdList_parm of type java.util.List specifying the list of email ids.
	 * @param destnName_parm of type String specifying the destination type ie To,Cc,Bcc
	 * @return an object of type org.apache.commons.mail.MultiPartEmail
	 * @see org.apache.commons.mail.MultiPartEmail
	 */
	private final MultiPartEmail getPopulatedEmail( MultiPartEmail email_parm , List emailIdList_parm , String destnName_parm )
	{
		if( destnName_parm == null )
			throw new NullPointerException( Common.ERR_EMAIL_DESTN_NULL );
		if( email_parm == null )
			throw new NullPointerException( Common.ERR_EMAIL_OBJ_NULL );
		try
		{
			firstLoop : for( int i = 0 ; i < emailIdList_parm.size() ; i++ )
			{
				if( destnName_parm.equalsIgnoreCase( Common.MAIL_TO ) )
				{
					email_parm.addTo( (String) emailIdList_parm.get( i ) );
					continue firstLoop;
				}
				if( destnName_parm.equalsIgnoreCase( Common.MAIL_CC ) )
				{
					email_parm.addCc( (String) emailIdList_parm.get( i ) );
					continue firstLoop;
				}
				if( destnName_parm.equalsIgnoreCase( Common.MAIL_BCC ) )
				{
					email_parm.addBcc( (String) emailIdList_parm.get( i ) );
					continue firstLoop;
				}
			}
		}
		catch( NullPointerException npe )
		{
			npe.printStackTrace();
		}
		catch( EmailException ee )
		{
			ee.printStackTrace();
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return email_parm;
	}





}
