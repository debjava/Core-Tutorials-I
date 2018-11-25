/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : SchedulerConfiguration.java                                 	 	 *
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
package com.iit.core.config;

import java.util.Properties;

import com.iit.core.common.Common;
import com.iit.core.util.FileUtil;

/**
 * @author Debadatta Mishra
 *
 */
public final class SchedulerConfiguration {

	private SchedulerConfiguration() {
		super();
	}

	/**
	 * This method is used to store the scheduler configuration details.
	 * @param configProperties of type {@link Properties}
	 * @param dirPath of type String indicating the directory path
	 */
	public static final void storeConfigDetails(
			final Properties configProperties, final String dirPath) {
		String commentString = "It is an autogenrated file meant for Scheduler configuration";
		FileUtil.storeFileDetails(dirPath, Common.SCHEDULER_CONFIG_FILENAME,
				configProperties, commentString);
	}

	/**
	 * This method is used to store the scheduler configuration details.
	 * @param configProperties of type {@link Properties}
	 */
	public static final void storeConfigDetails(
			final Properties configProperties) {
		String commentString = "It is an autogenrated file meant for Scheduler configuration";
		FileUtil.storeFileDetails(Common.SCHEDULER_CONFIG_FILENAME,
				configProperties, commentString);
	}

	/**
	 * This method is used to obtain the scheduler configuration details.
	 * @param filePath of type String indicating the file path
	 * @return a {@link Properties}
	 */
	public static final Properties getConfigDetails(final String filePath) {
		String fileName = filePath.substring(filePath.lastIndexOf("/") + 1,
				filePath.length());
		return FileUtil.getFileDetails(filePath.substring(0, filePath
				.lastIndexOf(fileName) - 1), filePath.substring(filePath
				.lastIndexOf("/") + 1, filePath.length()));
	}

	/**
	 * This method is used to obtain the scheduler configuration details.
	 * @return a {@link Properties}
	 */
	public static final Properties getConfigDetails() {
		return FileUtil.getFileDetails(Common.SCHEDULER_CONFIG_FILENAME);
	}
}
