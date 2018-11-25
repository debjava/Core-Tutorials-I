/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : DailyScheduler.java                                 	 	 *
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

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Timer;

import org.apache.log4j.Logger;

import com.iit.core.bean.DatabaseConfigBean;
import com.iit.core.bean.InternalConfigBean;
import com.iit.core.bean.MessageConfigBean;
import com.iit.core.bean.SchedulerConfigBean;
import com.iit.core.config.DatabaseConfiguration;
import com.iit.core.config.MessageConfiguration;
import com.iit.core.config.SchedulerConfiguration;

/**
 * @author Debadatta Mishra
 *
 */
public class DailyScheduler implements Scheduler {

	/**
	 * Logger for logging the messages
	 */
	protected static Logger logger = Logger.getLogger(DailyScheduler.class);

	/** Database configuration bean loaded from the properties file */
	private DatabaseConfigBean dbConfigBean = null;

	/**
	 * Object of type {@link MessageConfigBean}
	 */
	private MessageConfigBean msgConfigBean = null;

	/**
	 * Object of type {@link InternalConfigBean}
	 */
	private InternalConfigBean internalConfigBean = null;

	/**
	 * Object of type {@link Timer}
	 */
	public static Timer dailyTimer = null;

	/**
	 * Object of type {@link Properties} for configuration
	 */
	Properties configProp = null;

	/**
	 * Object of type {@link Properties} for database configuration
	 */
	Properties dbConfigProp = null;

	/**
	 * Object of type {@link Properties} for message configuration
	 */
	Properties msgConfigProp = null;

	Properties internalConfigProp = null;

	public static Scheduler getInstance() {
		dailyTimer = new Timer();
		return InstanceHolder.scheduler;
	}

	private static class InstanceHolder {
		private static final Scheduler scheduler = new DailyScheduler();
	}

	/**
	 * Default Constructor
	 */
	public DailyScheduler() {
		super();
		try {
			configProp = SchedulerConfiguration.getConfigDetails();
			dbConfigProp = DatabaseConfiguration.getConfigDetails();
			msgConfigProp = MessageConfiguration.getConfigDetails();
			// internalConfigProp = InternalConfiguration.getConfigDetails();

			dbConfigBean = new DatabaseConfigBean(dbConfigProp);
			msgConfigBean = new MessageConfigBean(msgConfigProp);

		} catch (NullPointerException npe) {
			logger.fatal("Fatal exception in DailyScheduler constructor");
			logger.error("Exception details is given\n", npe);
			//			npe.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iit.core.scheduler.Scheduler#startScheduler(java.lang.Object)
	 */
	public void startScheduler(Object beanObject) {
		try {
			logger.info("Initiliazing the processes");
			// First load all the classes in the JVM
			Thread.sleep(5000);
			logger.info("Initialization successful...");
			List objectList = new LinkedList();
			objectList.add(dbConfigBean);
			SchedulerConfigBean schedulerConfigBean = new SchedulerConfigBean(
					configProp);
			dailyTimer.schedule(new SchedulerTask(objectList),
					schedulerConfigBean.getDelayTime(), schedulerConfigBean
							.getPeriodicTime());

		} catch (Exception e) {
			logger.fatal("Fatal error occured in starting the scheduler");
			logger.error("Exception details====", e);
			//			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iit.core.scheduler.Scheduler#stopScheduler()
	 */
	public void stopScheduler() {
		dailyTimer.cancel();
	}
}
