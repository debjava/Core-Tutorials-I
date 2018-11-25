/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : ExternalMailer.java                                 		 *
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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.iit.core.common.Common;


/**
 * <p align="justified">
 * This is the actual implementation class for sending 
 * external mails. This class implements <code>sendTextMail()</code>
 * method of the com.pm.message.utility.Mailable interface. The following 
 * description provides how to use it.
 * <br>
 *  <br><code>String mailPropertyFilepath = "D:/processmate/resources/mail.properties" ;</code>
 *  <br><code>ExternalMailer extMailer = new ExternalMailer( mailPropertyFilepath ) ;</code>
 *  <br><code>extMailer.sendTextMail(from,To,Cc,Bcc,Subject,Message,Priority);</code>
 *  <br>
 *  <br>
 *  <br>
 *   As per the coding convention you can use it in the following manner
 *   <br>
 *  <br><code>String mailPropertyFilepath = "D:/processmate/resources/mail.properties" ;</code>
 *  <br><code>Mailable mailer = new ExternalMailer( mailPropertyFilepath ) ;</code>
 *  <br><code>mailer.sendTextMail(from,To,Cc,Bcc,Subject,Message,Priority);</code>
 * </p>
 * @see com.pm.message.utility.Mailable
 * @author <b><font face="Verdana">Debadatta Mishra</font></b>
 *
 */
public class ExternalMailer implements Mailable 
{
	/**
	 * Object of type com.pm.message.utility.EmailSender.
	 */
	private EmailSender emailSender = null;
	
	protected static Logger logger = Logger.getLogger(ExternalMailer.class);
	
	/**
	 * Default Constructor.
	 */
	public ExternalMailer()
	{
		super();
	}
	
	/**
	 * <p align="justified">
	 * This constructor takes the file path of the properties file.
	 * 
	 * <p>
	 * @param mailPropPath_parm of type java.lang.String specifying the path of the
	 * mail.properties.
	 */
	public ExternalMailer( final String mailPropPath_parm )
	{
		super();
		emailSender = new EmailSender( mailPropPath_parm );
	}

	/* (non-Javadoc)
	 * @see com.pm.message.utility.Mailable#sendTextMail(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public boolean sendTextMail( String from_parm, String to_parm, String cc_parm, 
			String bcc_parm, String subject_parm, String message_parm, String priority_parm ) 
	{
		boolean sentFlag = false;
		List toEmailIdList = new ArrayList();
		List ccEmailIdList = new ArrayList();
		List bccEmailIdList = new ArrayList();
		
		try
		{
			if( !(cc_parm == null || cc_parm.equals( Common.COMMON_DOUBLE_QUOTES ) || 0 == cc_parm.length() ) )
			{
				cc_parm = removeWhiteSpace( cc_parm );
				//If it contains more than one email id
				//put into list
				if( cc_parm.indexOf( Common.COMMON_COMMA ) > 0 )
				{
					ccEmailIdList = getMailIdList( cc_parm );
				}
				else
				{
					ccEmailIdList.add( cc_parm );
				}
			}
			if( !(bcc_parm == null || bcc_parm.equals( Common.COMMON_DOUBLE_QUOTES ) 
					|| 0 == bcc_parm.length() ) )
			{
				bcc_parm = removeWhiteSpace( bcc_parm );
				if( bcc_parm.indexOf( Common.COMMON_COMMA ) > 0 )
				{
					bccEmailIdList = getMailIdList( bcc_parm );
				}
				else
				{
					bccEmailIdList.add( bcc_parm );
				}
			}
			if( to_parm == null || to_parm.equals( Common.COMMON_DOUBLE_QUOTES ) ||
					0 == to_parm.length() ) 
				throw new NullPointerException( Common.ERR_INVLD_EMAIL_ID );
			
			if( from_parm == null || from_parm.equals( Common.COMMON_DOUBLE_QUOTES ) ||
					0 == from_parm.length() )
				throw new NullPointerException( Common.ERR_INVLD_FRM_ADRS );
			
			else
			{
				from_parm = removeWhiteSpace( from_parm );
				to_parm = removeWhiteSpace( to_parm );
				if( to_parm.indexOf( Common.COMMON_COMMA ) > 0 )
				{
					//It contains more than one email ids and it should be sent at a time
					toEmailIdList = getMailIdList( to_parm );
				}
				else
				{
					//It contains only one email id
					toEmailIdList.add( to_parm );
				}
				
				sentFlag = emailSender.sendPlainTextEmail( from_parm, toEmailIdList , 
						ccEmailIdList, bccEmailIdList, subject_parm, message_parm );
			}
		}
		catch( NullPointerException npe )
		{
			sentFlag = false;
			npe.printStackTrace();
		}
		catch( Exception e )
		{
			sentFlag = false;
			e.printStackTrace();
		}
		return sentFlag ;
	}
	
	/* (non-Javadoc)
	 * @see com.pm.mail.utility.Mailable#sendTextMailWithAttachment(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public boolean sendTextMailWithAttachment( String from_parm, String to_parm,
			String cc_parm, String bcc_parm, String subject_parm,
			String message_parm, String priority_parm, String attachmentFilePath ) throws FileSizeMoreException
	{
		logger.debug("**************Coming to sendTextMailWithAttachment() method *****************");
		logger.debug("attchmentFilepath :::::::::: "+attachmentFilePath );
		boolean sentFlag = false;
		List toEmailIdList = new ArrayList();
		List ccEmailIdList = new ArrayList();
		List bccEmailIdList = new ArrayList();
		
		try
		{
			//check for file size of the attached file
			if( !( checkFileSize( attachmentFilePath ) ) )
				throw new FileSizeMoreException( Common.ERR_FILE_SIZE );
			
			if (!(cc_parm == null
					|| cc_parm.equals(Common.COMMON_DOUBLE_QUOTES) || 0 == cc_parm
					.length()))
			{
				cc_parm = removeWhiteSpace( cc_parm );
				//If it contains more than one email id
				//put into list
				if( cc_parm.indexOf( Common.COMMON_COMMA ) > 0 )
				{
					ccEmailIdList = getMailIdList( cc_parm );
				}
				else
				{
					ccEmailIdList.add( cc_parm );
				}
			}
			if (!(bcc_parm == null
					|| bcc_parm.equals(Common.COMMON_DOUBLE_QUOTES) || 0 == bcc_parm
					.length()))
			{
				bcc_parm = removeWhiteSpace( bcc_parm );
				if( bcc_parm.indexOf( Common.COMMON_COMMA ) > 0 )
				{
					bccEmailIdList = getMailIdList( bcc_parm );
				}
				else
				{
					bccEmailIdList.add( bcc_parm );
				}
			}
			if (to_parm == null
					|| to_parm.equals(Common.COMMON_DOUBLE_QUOTES)
					|| 0 == to_parm.length())
				throw new NullPointerException(
						Common.ERR_INVLD_EMAIL_ID);
			
			if (from_parm == null
					|| from_parm.equals(Common.COMMON_DOUBLE_QUOTES)
					|| 0 == from_parm.length())
				throw new NullPointerException(
						Common.ERR_INVLD_FRM_ADRS);
			
			else
			{
				from_parm = removeWhiteSpace( from_parm );
				to_parm = removeWhiteSpace( to_parm );
				if( to_parm.indexOf( Common.COMMON_COMMA ) > 0 )
				{
					//It contains more than one email ids and it should be sent at a time
					toEmailIdList = getMailIdList( to_parm );
				}
				else
				{
					//It contains only one email id
					toEmailIdList.add( to_parm );
				}
				
				if( attachmentFilePath != null )
				{
					sentFlag = emailSender.sendPlainTextEmailWithAttachment(from_parm,
							toEmailIdList, ccEmailIdList, bccEmailIdList,
							subject_parm, message_parm, attachmentFilePath);
					
				}
				
			}
		}
		catch( NullPointerException npe )
		{
			sentFlag = false;
			npe.printStackTrace();
		}
		catch( FileSizeMoreException fsme )
		{
			sentFlag = false;
			fsme.printStackTrace();
			throw fsme;
		}
		catch( Exception e )
		{
			sentFlag = false;
			e.printStackTrace();
		}
		return sentFlag ;
	}
	
	/**
	 * <p align="justified">
	 * This is a utility and a generic method which removes all the
	 * occurances of blank spaces or white spaces in a
	 * String.
	 * </p>
	 * @param str_parm of type String.
	 * @return a java.lang.String
	 */
	private String removeWhiteSpace( String str_parm )
	{
		try
		{
			if( str_parm == null )
				throw new NullPointerException(Common.ERR_BLANK_PARAMETER);
			if( str_parm.indexOf( Common.BLANK_SPACE ) > 0 )
			{
				str_parm = removeWhiteSpace( new StringBuffer( str_parm ).
						deleteCharAt( str_parm.indexOf( Common.BLANK_SPACE ) ).toString().trim() );
			}
			else
			{
				//do nothing
			}
		}
		catch( NullPointerException npe )
		{
			npe.printStackTrace();
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return str_parm;
	}
	
	/**
	 * <p align="justified">
	 * This is a utility and a generic method that accepts
	 * a String which contains a list of email ids separated
	 * by comma(,) and extracts all the email ids and store in 
	 * a list.
	 * </p>
	 * @param to_parm of type java.lang.String
	 * @return a java.util.List
	 */
	private List getMailIdList( final String to_parm )
	{
		List toMailingList = new ArrayList();
		try
		{
//			The following hardcoding is not in CommonConstant, there is a reason for this.
			String[] tempArray = to_parm.split("[,;]");
			for( int i = 0 ; i < tempArray.length ; i++ )
			{
				if ((tempArray[i].toLowerCase().trim() == null)
						|| (tempArray[i].toLowerCase().trim().equals( Common.COMMON_DOUBLE_QUOTES ))
						|| (tempArray[i].toLowerCase().trim().equals( Common.BLANK_SPACE )))
				{
					//do nothing
				}
				else
				{
					toMailingList.add( tempArray[i].toLowerCase().trim() );
				}
			}
		}
		catch( NullPointerException npe )
		{
			throw npe;
		}
		return toMailingList;
	}
	
	/**
	 * <p align="justified">
	 * 
	 * This is a generic method which returns true if the file
	 * size is less than one MB otherwise it returns false.
	 * 
	 * </p>
	 * 
	 * @param attachmentFilePath
	 * @return true if the file size is less than one MB.
	 */
	private boolean checkFileSize( String attachmentFilePath )
	{
		boolean checkFlag = false;
		try
		{
			if( attachmentFilePath == null )
				throw new NullPointerException( Common.ERR_FILEPATH_NULL );
			File attachedFile = new File( attachmentFilePath );
			if( attachedFile == null )
				throw new FileNotFoundException( Common.ERR_FILE_NOT_FOUND );
			if( !( attachedFile.exists() ) )
				throw new FileNotFoundException( Common.ERR_FILE_NOT_FOUND );
			
			double fileSize = attachedFile.length();
			if( 1024 > ( fileSize/2048 ) )
			{
				checkFlag = true ;
			}
			else
			{
				checkFlag = false;
			}
		}
		catch( NullPointerException npe )
		{
			checkFlag = false;
			npe.printStackTrace();
		}
		catch( FileNotFoundException fnfe )
		{
			checkFlag = false;
			fnfe.printStackTrace();
		}
		catch( Exception e )
		{
			checkFlag = false;
			e.printStackTrace();
		}
		return checkFlag;
	}
	

}
