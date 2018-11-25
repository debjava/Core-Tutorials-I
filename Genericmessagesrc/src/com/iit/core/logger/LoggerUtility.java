package com.iit.core.logger;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;


/**
 * <p align="justified">
 * This class is used to provide the common utilities to achieve the common
 * functionlity used in the custom application logger API.
 * </p>
 * 
 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
 * 
 */
public class LoggerUtility {
	/**
	 * Default Constructor
	 */
	protected LoggerUtility() {
		super();
	}

	/**
	 * <p align="justified">
	 * This class is used to obtain the actual path present in the properties
	 * file.It will check wheather the directory specified is present or not. If
	 * it is not present, it will create the new directory and will fetch that
	 * path.
	 * </p>
	 * 
	 * @param applicationLogProperties
	 *            of type {@link java.util.Properties}
	 * @return a file path of type {@link java.lang.String}
	 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
	 */
	public static String getActualFilePath(Properties applicationLogProperties) {
		String actualFilePath = null;
		String logFileName = null;
		String logFilePath = null;
		String tempLogFilePath = applicationLogProperties
				.getProperty(LoggerConstants.LOG_FILE_PATH);
		try {
			/*
			 * Validation for Log File Name in the properties
			 * file.If the file name is not present, it will take
			 * the default setting.
			 * 
			 */
			if (applicationLogProperties
					.getProperty(LoggerConstants.LOG_FILE_NAME) == null
					|| (applicationLogProperties
							.getProperty(LoggerConstants.LOG_FILE_NAME)).trim()
							.equals("")) {
				logFileName = LoggerConstants.APPLN_NAME + ".log";
			} else {
				logFileName = applicationLogProperties.getProperty(
						LoggerConstants.LOG_FILE_NAME).trim();
			}
			/*
			 * Validation for Log File Path.
			 * If the log file path is not present
			 * in the applicationlog.properties file,
			 * it will take the default setting.
			 */
			if (tempLogFilePath == null) {
				/*
				 * Get the default log file path 
				 */
				logFilePath = getDefaultLogFilepath();
			} else if (tempLogFilePath.equals(LoggerConstants.BLANK)) {
				/*
				 * Get the default log file path
				 */
				logFilePath = getDefaultLogFilepath();
			} else if (!(tempLogFilePath.contains(":"))) {
				/*
				 * Since the name , you have given is not
				 * valid or approrpriate.
				 */
				logFilePath = getDefaultLogFilepath();
			} else {
				logFilePath = applicationLogProperties.getProperty(
						LoggerConstants.LOG_FILE_PATH).trim();
			}

			// check wheather any directory exists or not
			actualFilePath = checkAndGetLogFilePath(logFilePath
					+ File.separator + logFileName);

		} catch (NullPointerException npe) {
			npe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return actualFilePath;
	}

	/**
	 * <p align="justified">
	 * This method is used to obtain the path of the log directory where log
	 * files will be generated.
	 * </p>
	 * 
	 * @param applicationLogProperties
	 *            of type java.util.Properties
	 * @return a file path of the log directory
	 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
	 */
	public static String getLogFilepath(Properties applicationLogProperties) {
		String logFilePath = null;
		String logDirName = null;
		String logFileName = null;
		String tempLogDirName = applicationLogProperties
				.getProperty(LoggerConstants.LOG_FILE_PATH);
		try {
			if (tempLogDirName == null) {
				logDirName = getDefaultLogFilepath();
			} else if (tempLogDirName.trim().equals("")) {
				logDirName = getDefaultLogFilepath();
			} else if (!(tempLogDirName.contains(":"))) {
				logDirName = getDefaultLogFilepath();
			} else {
				logDirName = applicationLogProperties
						.getProperty(LoggerConstants.LOG_FILE_PATH);
			}
			if (applicationLogProperties
					.getProperty(LoggerConstants.LOG_FILE_NAME) == null) {
				logFileName = LoggerConstants.LOG_FILE_NAME;
			} else if (applicationLogProperties.getProperty(
					LoggerConstants.LOG_FILE_NAME).trim().equals("")) {
				logFileName = LoggerConstants.LOG_FILE_NAME;
			}

			else {
				// check wheather any directory exists or not
			}
			logFilePath = checkAndGetLogFilePath(logDirName.trim());
		} catch (NullPointerException npe) {
			/*
			 * Handle the exception properly
			 */
			npe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return logFilePath;
	}

	/**
	 * <p align="justified">
	 * This method is used to check wheather the specified directory is present
	 * or not. If not present, it will create a new one and will fetch the path
	 * of that directory.
	 * </p>
	 * 
	 * @param filePath
	 *            of type {@link java.lang.String}
	 * @return file Path of type String.
	 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
	 */
	private static String checkAndGetLogFilePath(String filePath) {
		String logFilePath = null;
		try {
			String tempString = filePath.substring(0, filePath
					.lastIndexOf(LoggerConstants.FILE_SEPARATOR));
			File file = new File(tempString);
			if (!(file.exists())) {
				file.mkdirs();
			} else {
				// do nothing
			}
			logFilePath = filePath;
		} catch (IndexOutOfBoundsException ie) {
			ie.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return logFilePath;
	}

	/**<p align="justified">
	 * This method is used to obtain the file path
	 * of the <b>applicationlog.properties</b>.
	 * </p>
	 * <p align="justified">
	 * <i>
	 * <font color="RED">
	 * It should be noted that the concerned property file
	 * for logger should inside the config directory of the
	 * current directory of the application, otherwise it
	 * will throw <code>NullPointerException</code>
	 * </font>
	 * </i>
	 * </p>
	 * @return a String indicating the file path of 
	 * the applicationlog.properties
	 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
	 */
	public static String getApplnLogPropFilePath() {
		String filePath = null;
		/*
		 * First check the file in the current directory
		 * path, if it is found , obtain the path.
		 */
		try {
			File file = new File(new File("").getAbsolutePath()
					+ "/config/applicationlog.properties");
			if (file.exists()) 
			{
				filePath = file.getAbsolutePath();
			}
			else 
			{
				throw new NullPointerException(
						"The applicationlog.properties file is not present inside the config directory");
			}
		} catch (NullPointerException npe) {
			npe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filePath;
	}
	
	public static Properties getDefaultLogProperties()
	{
		Properties logProperties = new Properties();
		InputStream logInputStream = null;
		try
		{
			logInputStream = LoggerUtility.class.getClassLoader()
			.getResourceAsStream("applicationlog.properties");
			
			logProperties.load( logInputStream );
			
//			System.out.println("============"+logProperties);
			
			
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if( logInputStream != null )
					logInputStream.close();
			}
			catch( Exception e )
			{
				e.printStackTrace();
			}
		}
		return logProperties;
	}

	/**<p align="justified">
	 * This method is used to obtain the
	 * default log file path.
	 * </p>
	 * @return a String indicating the path
	 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
	 */
	private static String getDefaultLogFilepath() {
		String defaultFilepath = null;
		try {
			File currentDir = new File("");
			defaultFilepath = currentDir.getAbsolutePath() + "/"
					+ LoggerConstants.DEFAULT_LOG;

		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return defaultFilepath;
	}

	/**<p align="justified">
	 * This method is used to obtain the
	 * backup file name.If the backup file
	 * is not present in the properties file,
	 * it will take the default setting.
	 * </p>
	 * @param applicationLogProperties
	 * @return a String indicating the 
	 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
	 */
	public static String getBackupLogFileName(
			Properties applicationLogProperties) {
		String backupFileName = null;
		try {
			if (applicationLogProperties
					.getProperty(LoggerConstants.BACKUP_LOG_FILE_NAME) == null) {
				backupFileName = LoggerConstants.DEFAULT_BACKUP_NAME;
			} else if (applicationLogProperties.getProperty(
					LoggerConstants.BACKUP_LOG_FILE_NAME).trim().equals("")) {
				backupFileName = LoggerConstants.DEFAULT_BACKUP_NAME;
			} else {
				backupFileName = applicationLogProperties
						.getProperty(LoggerConstants.BACKUP_LOG_FILE_NAME);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return backupFileName;
	}

}
