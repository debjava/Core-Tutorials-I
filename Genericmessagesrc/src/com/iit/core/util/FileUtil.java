/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : FileUtil.java                                 	 	 		 *
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

import com.iit.core.common.Common;

/**
 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
 *
 */
public class FileUtil {
	private static String configDirPath = null;
	private static Properties confProp = new Properties();

	//~~ Directories specific to application
	public static String APPLN_HOME = null;
	public static String CONFIG_PATH = null;
	public static String LOG_PATH = null;
	public static String EXTERNAL_JAR_PATH = null;

	private FileUtil() {
		super();
	}

	static {
		APPLN_HOME = getHomeDirectory();//It is always mandatory
		//		LOG_PATH = APPLN_HOME+File.separator+"logs";
		//		createDirs(LOG_PATH); 
		configDirPath = APPLN_HOME + File.separator + Common.CONFIG_NAME;//FileUtil.getConfigDirectory();
		initDefault();
	}

	/**
	 * Method to obtain the mail property file path
	 * @return a String
	 */
	public static String getMailPropertyFilePath() {
		return configDirPath + File.separator + "mail.properties";
	}

	/**
	 * Default method to initialize
	 */
	private static void initDefault() {
		setDefaultPath();
	}

	/**
	 * Method to initialize
	 */
	private static void intialize() {
		/*
		 * Read the application specific configuration file
		 * from the path. This file is present inside the
		 * bin directory.
		 */
		InputStream confStream = null;
		try {
			confStream = FileUtil.class.getClassLoader().getResourceAsStream(
					"applnConfig.properties");
			confProp.load(confStream);
			setAllDirs(confProp);

		} catch (NullPointerException npe) {
			npe.printStackTrace();
			//			logger.error("Error in creating the file or directory");
			setDefaultPath();
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
			setDefaultPath();
		} catch (Exception e) {
			e.printStackTrace();
			e.printStackTrace();
		} finally {
			try {
				if (confStream != null)
					confStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * method to set the default path
	 */
	private static void setDefaultPath() {
		configDirPath = APPLN_HOME + File.separator + Common.CONFIG_NAME;
		CONFIG_PATH = configDirPath;
		createDirs(CONFIG_PATH);
		LOG_PATH = APPLN_HOME + File.separator + "logs";
		createDirs(LOG_PATH);
	}

	/**
	 * Method to set all the directories.
	 * @param prop of type Properties
	 */
	private static void setAllDirs(Properties prop) {
		String dirName = null;

		dirName = prop.getProperty("CONFIG_PATH");
		CONFIG_PATH = (dirName == null || dirName.equals("")) ? APPLN_HOME
				+ File.separator + Common.CONFIG_NAME : dirName
				+ File.separator + Common.CONFIG_NAME;

		createDirs(CONFIG_PATH);
		/*
		 * File path for logs
		 */
		dirName = prop.getProperty("LOG_PATH");
		LOG_PATH = (dirName == null || dirName.equals("")) ? APPLN_HOME
				+ File.separator + "logs" : dirName;
		createDirs(LOG_PATH);
	}

	/**
	 * Method to obtain the home directory
	 * @return a String
	 */
	private static String getHomeDirectory() {
		String homeDir = null;
		//		File currentFile = new File(Common.BLANK);
		//		homeDir = new StringBuffer(currentFile.getAbsolutePath()).toString();
		homeDir = System.getProperty("user.dir");
		return homeDir;
	}

	/**
	 * Method to store the file details
	 * @param fileName of type String indicating the file name
	 * @param properties of type {@link Properties}
	 * @param commentString of type String for comments
	 */
	public static void storeFileDetails(String fileName, Properties properties,
			String commentString) {
		FileOutputStream outStream = null;
		try {
			checkNCreateDirs(CONFIG_PATH);
			outStream = new FileOutputStream(CONFIG_PATH + File.separator
					+ fileName);
			//			logger.debug("Complete file Name==="+(CONFIG_PATH+File.separator+fileName));
			//get the filter of the file
			if (getFileExtension(fileName).equalsIgnoreCase("xml"))
				properties.storeToXML(outStream, commentString);
			else if (getFileExtension(fileName).equalsIgnoreCase("properties"))
				properties.store(outStream, commentString);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				outStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Method to store the file details.
	 * @param directoryName of type String directory name
	 * @param fileName of type String indicating the file name
	 * @param properties of type {@link Properties}
	 * @param commentString of type String indicating the comments
	 */
	public static void storeFileDetails(String directoryName, String fileName,
			Properties properties, String commentString) {
		FileOutputStream outStream = null;
		try {

			if (directoryName.endsWith("/"))
				directoryName = directoryName.substring(0, directoryName
						.lastIndexOf("/"));

			checkNCreateDirs(directoryName);
			outStream = new FileOutputStream(directoryName + File.separator
					+ fileName);
			if (getFileExtension(fileName).equalsIgnoreCase("xml"))
				properties.storeToXML(outStream, commentString);
			else if (getFileExtension(fileName).equalsIgnoreCase("properties"))
				properties.store(outStream, commentString);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				outStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Method to get the file details.
	 * @param fileName of type String indicating the file name
	 * @return
	 */
	public static final Properties getFileDetails(String fileName) {
		Properties configProperties = new Properties();
		FileInputStream inStream = null;
		try {
			inStream = new FileInputStream(CONFIG_PATH + "/" + fileName);
			if (getFileExtension(fileName).equalsIgnoreCase("xml"))
				configProperties.loadFromXML(inStream);
			else if (getFileExtension(fileName).equalsIgnoreCase("properties"))
				configProperties.load(inStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return configProperties;
	}

	/**
	 * Method to get the file details.
	 * @param dirName of type String indicating the directory name
	 * @param fileName of type String indicating the file name.
	 * @return a {@link Properties}
	 */
	public static final Properties getFileDetails(final String dirName,
			String fileName) {
		Properties configProperties = new Properties();
		FileInputStream inStream = null;
		try {
			inStream = new FileInputStream(dirName + File.separator + fileName);
			if (getFileExtension(fileName).equalsIgnoreCase("xml"))
				configProperties.loadFromXML(inStream);
			else if (getFileExtension(fileName).equalsIgnoreCase("properties"))
				configProperties.load(inStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return configProperties;
	}

	/**
	 * Method to create the directory.
	 * @param dirName of type string indicating the directory name
	 */
	private static void createDirs(String dirName) {
		File tempFile = new File(dirName);
		if (!(tempFile.exists()))
			tempFile.mkdirs();
	}

	/**
	 * A validating method to check and create the directory.
	 * @param dirName of type String indicating the directory name.
	 */
	public static void checkNCreateDirs(String dirName) {
		if (dirName == null || dirName.equals(""))
			dirName = configDirPath;

		if (dirName.endsWith("/"))
			dirName = dirName.substring(0, dirName.lastIndexOf("/"));

		File tempFile = new File(dirName);
		if (!(tempFile.exists()))
			tempFile.mkdirs();
	}

	/**
	 * Method to obtain the file extension.
	 * @param fileName of type String indicating the file name
	 * @return
	 */
	private static String getFileExtension(String fileName) {
		return fileName.substring(fileName.indexOf(".") + 1, fileName.length());
	}

	/**
	 * Method used to get the list of files.
	 * @param dirName of type String indicating the directory name.
	 * @return
	 */
	public static String getFilesList(String dirName) {
		File file = new File(dirName);
		String[] strFile = file.list();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strFile.length; i++) {
			String fileName = strFile[i];
			sb.append(dirName + "/" + fileName).append(";");
		}
		return sb.toString();
	}

}
