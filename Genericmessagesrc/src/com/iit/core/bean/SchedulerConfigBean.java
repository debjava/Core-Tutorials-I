/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : SchedulerConfigBean.java                                 	 *
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
public class SchedulerConfigBean {
	private int delayTime = 0;
	private int periodicTime = 0;

	public SchedulerConfigBean(Properties prop) {
		super();
		delayTime = Integer.parseInt(prop.getProperty("delay"));
		periodicTime = Integer.parseInt(prop.getProperty("period"));
	}

	public int getDelayTime() {
		return delayTime;
	}

	public void setDelayTime(int delayTime) {
		this.delayTime = delayTime;
	}

	public int getPeriodicTime() {
		return periodicTime;
	}

	public void setPeriodicTime(int periodicTime) {
		this.periodicTime = periodicTime;
	}

}
