/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : MessageConfigBean.java                                 	 *
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
package com.iit.core.bean;

import java.util.Properties;

/**
 * @author Debadatta Mishra
 *
 */
public class MessageConfigBean 
{
	private String smtpHostName = null;
	private String smsGatewayNo = null;
	
	public MessageConfigBean( Properties prop )
	{
		super();
		smtpHostName = prop.getProperty("mail.smtp.host");
		smsGatewayNo = prop.getProperty("SMS_GATEWAY");
	}

	public String getSmtpHostName() {
		return smtpHostName;
	}

	public void setSmtpHostName(String smtpHostName) {
		this.smtpHostName = smtpHostName;
	}

	public String getSmsGatewayNo() {
		return smsGatewayNo;
	}

	public void setSmsGatewayNo(String smsGatewayNo) {
		this.smsGatewayNo = smsGatewayNo;
	}
}
