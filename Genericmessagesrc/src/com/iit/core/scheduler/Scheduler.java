/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : Scheduler.java                                 	 	 	 *
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
package com.iit.core.scheduler;

/**
 * @author Debadatta Mishra
 *
 */
public interface Scheduler {
	/**
	 * This method is used to start the Thread for continuous
	 * scheduling.
	 * @param beanObject of type Object
	 */
	public void startScheduler(Object beanObject);

	/**
	 * This method is used to stop the thread from the scheduling.
	 */
	public void stopScheduler();
}
