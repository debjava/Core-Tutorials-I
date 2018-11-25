/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : DataCollector.java                                 	 	 *
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
package com.iit.core.util;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.iit.core.loader.AbstractLoadderFactory;
import org.apache.log4j.Logger;
import com.iit.core.msg.data.MessageData;

/**
 * This class is used to obtain the data by loading the class name provide by
 * the client at runtime.
 * 
 * @author <a href="mailTo:debadatta.m@idealinvent.com?subject=problem in
 *         DataCollector in mail module">Debadatta Mishra</a>
 * 
 */
public class DataCollector {
	/**
	 * Logger for logging the error messages.
	 */
	protected static Logger logger = Logger.getLogger(DataCollector.class);

	/**
	 * This method is used to obtain the Map by loading the class name
	 * dynamically.
	 * 
	 * @param className
	 *            of type String indicating the class name which comes from the
	 *            database table.
	 * @param varList
	 *            of type {@link List} containing the vars from the runtime
	 *            table
	 * @param conn
	 *            of type {@link Connection}
	 * @return a Map containing the data.
	 */
	public static Map getDataMap(String className, List varList, Connection conn) {
		Map dataMap = new HashMap();
		try {
			Object obj = AbstractLoadderFactory.getInstance()
					.getLoadedClassObject(className);
			logger.debug("In Data Collector========>>>" + obj);
			MessageData msgData = (MessageData) obj;
			dataMap = (Map) msgData.getDataMap(varList, conn);
		} catch (Exception e) {
			logger.error("Unexpected error occured.");
			logger.error("Error details=====", e);
			e.printStackTrace();
		}
		return dataMap;
	}
}
