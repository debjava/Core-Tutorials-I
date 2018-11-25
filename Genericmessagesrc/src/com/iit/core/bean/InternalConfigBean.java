/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : InternalConfigBean.java                                 	 *
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
public class InternalConfigBean 
{
	private String invokerName = null;
	private String invokerType = null;
	private String messageType = null;
	
	public InternalConfigBean( Properties prop )
	{
		super();
		invokerName = prop.getProperty("INVOKER_NAME");
		invokerType = prop.getProperty("INVOKER_TYPE");
		messageType = prop.getProperty("MESSAGE_TYPE"); 
	}

	public String getInvokerName() {
		return invokerName;
	}

	public void setInvokerName(String invokerName) {
		this.invokerName = invokerName;
	}

	public String getInvokerType() {
		return invokerType;
	}

	public void setInvokerType(String invokerType) {
		this.invokerType = invokerType;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
}
