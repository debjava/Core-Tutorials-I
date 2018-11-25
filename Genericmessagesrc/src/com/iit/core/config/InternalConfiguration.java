/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : InternalConfiguration.java                                  *
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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import com.iit.core.common.Common;
import com.iit.core.util.FileUtil;

/**
 * @author Debadatta Mishra
 * 
 */
public class InternalConfiguration {
	// private static String currentDirPath = null;

	private InternalConfiguration() {
		super();
	}

	// static
	// {
	// currentDirPath = FileUtil.getConfigDirectory();
	// }

	public static final void storeConfigDetails(
			final Properties configProperties, final String dirPath) {

		String commentString = "It is an autogenrated file meant for internal configuration";
		FileUtil.storeFileDetails(dirPath, Common.INTERNAL_CONFIG_FILENAME,
				configProperties, commentString);

		// FileOutputStream outStream = null;
		// try
		// {
		// FileUtil.checkNCreateDirs( dirPath );
		// outStream = new FileOutputStream(
		// dirPath+"/"+Common.INTERNAL_CONFIG_FILENAME );
		// String commentString = "It is an autogenrated file meant for internal
		// configuration";
		// configProperties.storeToXML( outStream, commentString );
		// }
		// catch( Exception e )
		// {
		// e.printStackTrace();
		// }
		// finally
		// {
		// try
		// {
		// outStream.close();
		// }
		// catch( Exception e )
		// {
		// e.printStackTrace();
		// }
		// }
	}

	public static final void storeConfigDetails(
			final Properties configProperties) {
		String commentString = "It is an autogenrated file meant for internal configuration";
		FileUtil.storeFileDetails(Common.INTERNAL_CONFIG_FILENAME,
				configProperties, commentString);

		// FileOutputStream outStream = null;
		// try
		// {
		// FileUtil.checkNCreateDirs( currentDirPath );
		// outStream = new FileOutputStream(
		// currentDirPath+"/"+Common.INTERNAL_CONFIG_FILENAME );
		// String commentString = "It is an autogenrated file meant for internal
		// configuration";
		// configProperties.storeToXML( outStream, commentString );
		// }
		// catch( Exception e )
		// {
		// e.printStackTrace();
		// }
		// finally
		// {
		// try
		// {
		// outStream.close();
		// }
		// catch( Exception e )
		// {
		// e.printStackTrace();
		// }
		// }

	}

	public static final Properties getConfigDetails(final String filePath) {
		String fileName = filePath.substring(filePath.lastIndexOf("/") + 1,
				filePath.length());
		return FileUtil.getFileDetails(filePath.substring(0, filePath
				.lastIndexOf(fileName) - 1), filePath.substring(filePath
				.lastIndexOf("/") + 1, filePath.length()));

		// Properties configProperties = new Properties();
		// FileInputStream inStream = null ;
		// try
		// {
		// inStream = new FileInputStream(
		// filePath+"/"+Common.INTERNAL_CONFIG_FILENAME );
		// configProperties.loadFromXML( inStream );
		// }
		// catch( Exception e )
		// {
		// e.printStackTrace();
		// }
		// finally
		// {
		// try
		// {
		// inStream.close();
		// }
		// catch( Exception e )
		// {
		// e.printStackTrace();
		// }
		// }
		// return configProperties;
	}

	public static final Properties getConfigDetails() {
		return FileUtil.getFileDetails(Common.INTERNAL_CONFIG_FILENAME);

		// Properties configProperties = new Properties();
		// FileInputStream inStream = null ;
		// try
		// {
		// inStream = new FileInputStream(
		// currentDirPath+"/"+Common.INTERNAL_CONFIG_FILENAME );
		// configProperties.loadFromXML( inStream );
		//		}
		//		catch( Exception e )
		//		{
		//		e.printStackTrace();
		//		}
		//		return configProperties;
	}
}
