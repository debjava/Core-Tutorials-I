/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : SchedulerTask.java                                 	 	 *
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

import java.sql.Connection;
import java.util.List;
import java.util.TimerTask;

import com.iit.core.action.ActionProcessor;
import com.iit.core.bean.DatabaseConfigBean;
import org.apache.log4j.Logger;
import com.iit.core.util.DatabaseUtil;

/**
 * @author Debadatta Mishra
 * 
 */
public class SchedulerTask extends TimerTask {

	/** Object List */
	List objectList = null;

	/** DB User Name */
	private String dbUserName = null;

	/** URL of the DB */
	private String dbURL = null;

	/** Password of the Database */
	private String dbPWD = null;

	/** Connection object */
	private Connection conn = null;

	/** Logger object corresponding to this class */
	protected static Logger logger = Logger.getLogger(SchedulerTask.class);

	public SchedulerTask() {
		super();
	}

	/**
	 * Obtains the connection and stores it as a class level object
	 * 
	 * @param obj
	 *            Holds the datbaseconfigbean obtained from the property file
	 */
	public SchedulerTask(Object obj) {
		super();
		try {
			objectList = (List) obj;

			for (int i = 0, n = objectList.size(); i < n; i++) {
				Object tempObject = objectList.get(i);
				if (tempObject instanceof DatabaseConfigBean) {
					DatabaseConfigBean dbConfBean = (DatabaseConfigBean) tempObject;
					dbUserName = dbConfBean.getDbUserName();
					dbURL = dbConfBean.getDbURL();
					dbPWD = dbConfBean.getDbPassword();
					logger.info("Internal dbUserName: " + dbUserName);
					logger.info("Internal dbURL:" + dbURL);
					logger.info("Internal dbPWD:" + dbPWD);
				}
			}
			// Obtain the connetion using DB connection
			conn = DatabaseUtil.getDbConnection(dbUserName, dbPWD, dbURL);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Run method of the Thread which calls ActionProcessor for processing
	 * (non-Javadoc)
	 * 
	 * @see java.util.TimerTask#run()
	 */
	public void run() {
		System.out.println("************** RUNNING **************");
		logger.info("************** RUNNING **************");
		ActionProcessor actionProcessor = ActionProcessor.getInstance();
		actionProcessor.processAction(conn, dbUserName, dbPWD, dbURL);
	}
}
