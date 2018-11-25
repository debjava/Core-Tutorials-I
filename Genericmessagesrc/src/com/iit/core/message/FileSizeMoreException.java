/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : FileSizeMoreException.java                                  *
 * Author                      : Debadatta Mishra                                            *
 * Creation Date               : Feb 21, 2007                                                *
 * Modification History        : 												             *
 *																						     *
 *     Version No.               Date               Brief description of change              *
 *  ---------------------------------------------------------------------------------------  *
 *                       | 				    |				 								 *
 *                       |                  |											 	 *
 *  ---------------------------------------------------------------------------------------  *
 *********************************************************************************************/

package com.iit.core.message;

import com.iit.core.common.Common;

/**
 * <p align="justified">
 * This is an exception class which extends Exception class.
 * So far file attachment is concerned in the email utility,
 * it has been made a checked exception so that developer has
 * to handle it properly. This Exception will be thrown when
 * the attached file size exceeds one MB. 
 * </p>
 * @author <b><font face="Verdana">Debadatta Mishra</font></b>
 *
 */
public class FileSizeMoreException extends Exception 
{
	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Default Constructor
	 */
	public FileSizeMoreException()
	{
		super();
	}
	/**
	 * Parameterized Constructor.
	 * @param excptnMsg of type java.lang.String
	 */
	public FileSizeMoreException( String excptnMsg )
	{
		super( excptnMsg );
	}
	/**
	 * This method provides a proper error message
	 * for which this exception has been throw.
	 * @return an Error message.
	 */
	public String getErrorMessage()
	{
		return Common.ERR_ATTACHMENT_SIZE;
	}
}