package com.iit.core.logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;

import com.iit.core.util.FileUtil;

/**
 * <p align="justified">
 * This is the significant class for the implementation of logger for the
 * application <b>ProcessMate</b> application. This class is a wrapper over the
 * <a href="http://logging.apache.org/log4j/docs/index.html">Apache Log4j</a> .
 * This Logger class has been customized according to the needs and requirements
 * for the specific application <b>ProcessMate</b>.This class provides all the
 * common methods used for debugging and logging the messages in the file system
 * as well in the console. A specific config file has been provided based upon
 * which all the logging messages will be captured in the file system as well as
 * in the console. If the logging messages are stored in the file system, the
 * files will be rotated in the mid night of evryday so that all the error and
 * other messages can be monitored . The purpose is for smooth ruuning of the
 * application and to satisfy the clients. End users can monitor the log files
 * and relevent information can be retrieved.The end user can also contact with
 * the support team for this application by the help of the log files.
 * 
 * </p>
 * 
 * <p align="justified">
 * From the view point of development, the use of the class is given below. This
 * class contains the following methods.
 * <ul>
 * <li>info(Object message), for logging the messages of type information
 * <li>info(Object message,Throwable throwable) , for logging the messages
 * along with the specific exception
 * <li>warn(Object message), for logging the messages of type warning
 * <li>warn(Object message,Throwable throwable) , for logging the messages
 * along with the specific exception
 * <li>fatal(Object message), for logging the messages of type fatal
 * <li>fatal(Object message,Throwable throwable) , for logging the messages
 * along with the specific exception
 * <li>debug(Object message), for logging the messages of type debug
 * <li>debug(Object message,Throwable throwable) , for logging the messages
 * along with the specific exception
 * <li>error(Object message), for logging the messages of type error
 * <li>error(Object message,Throwable throwable) , for logging the messages
 * along with the specific exception
 * </ul>
 * </p>
 * <p align="justified">
 * It should be used in the following manner. <br>
 * <code>import com.pm.logger;</code> <br>
 * <code> Logger logger = Logger.getLogger(Test.class);</code> <br>
 * <code>public void show()</code> <br>
 * <code>{</code> <br>
 * <code>&nbsp;&nbsp;&nbsp;&nbsp;logger.debug("A message for debugging");</code>
 * <br>
 * <code>}</code>
 * </p>
 * <p align="justified">
 * <b>How to use in the existing code</b> <br>
 * Please do not change any other code, simply replace the import statement
 * <i>org.apache.log4j.Logger</i> by <code>com.pm.Logger</code> . There is no
 * need change anything in the code. Modify the applicationlog.properties or
 * leave it for default setting.
 * </p>
 * 
 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
 * 
 */
public class Logger implements Loggable {
	/**
	 * String varaiable to store the cannonical class name
	 */
	private String displayClassName = null;

	/**
	 * String varaible to specify the path of the applicationlog.properties.
	 */
	private String applicationPropertyFilePath = null;

	/**
	 * Object of type org.apache.log4j.FileAppender
	 */
	private FileAppender fileAppender = null;

	/**
	 * Object of type org.apache.log4j.ConsoleAppender
	 */
	private ConsoleAppender consoleAppender = null;

	/**
	 * Object of type org.apache.log4j.DailyRollingFileAppender
	 */
	DailyRollingFileAppender dailyAppender = null;

	/**
	 * Object of type java.io.InputStream
	 */
	private InputStream inStream = null;

	/**
	 * Logger object of type org.apache.log4j.Logger
	 */
	protected static org.apache.log4j.Logger apacheLogger = null;

	/**
	 * Logger object of type com.pm.logger.Logger
	 */
	private static Logger pmLogger = null;

	/**
	 * Object of type org.apache.log4j.PatternLayout
	 */
	private PatternLayout patternLayOut = null;

	/**
	 * Object of type {@link java.util.Properties}
	 */
	private Properties applicationLogProperties = null;

	/**
	 * Default Constructor, It can not be instantiated from outside the defined
	 * package. It is only meant for internal representation. It accepts the
	 * parameter of type java.lang.String.
	 * 
	 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
	 */
	protected Logger(String className) {
		super();
		displayClassName = className;
		apacheLogger = PMLogFactory.getLogger(className);
		init();
	}

	/**
	 * Default Constructor, It can not be instantiated from outside the defined
	 * package. It is only meant for internal representation. It accepts the
	 * parameter of type java.lang.Class.
	 * 
	 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
	 */
	protected Logger(Class clazzName) {
		super();
		displayClassName = clazzName.toString();
		apacheLogger = PMLogFactory.getLogger(clazzName);
		init();
	}

	/**
	 * <p align="justified">
	 * This method is used to obtain an object of type com.pm.logger.Logger by
	 * passing a parameter of the class name as a String.
	 * </p>
	 * 
	 * @param className
	 *            of type java.lang.String
	 * @return an object of type com.pm.logger.Logger
	 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
	 */
	public static Logger getLogger(String className) {
		pmLogger = new Logger(className);
		return pmLogger;
	}

	/**
	 * <p align="justified">
	 * This method is used to obtain an object of type com.pm.logger.Logger by
	 * passing a parameter of the class name as java.lang.Class.
	 * </p>
	 * 
	 * @param className
	 *            of type java.lang.String
	 * @return an object of type com.pm.logger.Logger
	 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
	 */
	public static Logger getLogger(Class clazzName) {
		pmLogger = new Logger(clazzName);
		return pmLogger;
	}

	/**
	 * <p align="justified">
	 * This class is used to intiatialize some objects and to initialize the
	 * logger config file.
	 * </p>
	 * 
	 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
	 */
	private void init() {
//		applicationPropertyFilePath = LoggerUtility.getApplnLogPropFilePath();
//		System.out.println("NULLLLLLLLLL====="+applicationPropertyFilePath);
		try {
//			inStream = new FileInputStream(applicationPropertyFilePath);
			applicationLogProperties = new Properties();
			applicationLogProperties = LoggerUtility.getDefaultLogProperties();
//			applicationLogProperties.load(inStream);
			patternLayOut = new PatternLayout(LoggerConstants.PATTERN_LAYOUT);
			consoleAppender = new ConsoleAppender(patternLayOut);
			
			
			
			
//			String actualFilepath = LoggerUtility
//					.getActualFilePath(applicationLogProperties);
			
			
			
			
			
			
			
			
			
			
			String rollingTimeSchedule = applicationLogProperties.getProperty(
					LoggerConstants.TIME_ROTATION).trim();
			String rollerBackupFileName = LoggerUtility
					.getBackupLogFileName(applicationLogProperties);
			if (rollerBackupFileName == null
					|| rollerBackupFileName.equals(LoggerConstants.BLANK)) {
				/*
				 * If the backup file name is absent, the default file name will
				 * be considered.
				 */
				rollerBackupFileName = LoggerConstants.DEFAULT_ROLLER_FILE_NAME;
			}
			String rollerBackupFilepath = LoggerUtility
					.getLogFilepath(applicationLogProperties)
					+ File.separator + rollerBackupFileName;
			String consoleAppenderProp = applicationLogProperties.getProperty(
					LoggerConstants.CONSOLE_APPENDER).trim();
			String fileAppenderProp = applicationLogProperties.getProperty(
					LoggerConstants.FILE_APPENDER).trim();
			if (consoleAppenderProp != null
					&& consoleAppenderProp
							.equalsIgnoreCase(LoggerConstants.VALUE_ON)) {
				apacheLogger.addAppender(consoleAppender);
			}
			if (fileAppenderProp != null
					&& fileAppenderProp
							.equalsIgnoreCase(LoggerConstants.VALUE_ON)) {
				/*
				 * Creating a object for FileAppender provided file appender in
				 * the config file should be on.
				 */
				
//				String actualFilepath = applicationLogProperties
//				.getProperty(LoggerConstants.LOG_FILE_PATH)
//				+ File.separator
//				+ applicationLogProperties
//						.getProperty(LoggerConstants.LOG_FILE_NAME);
				
				
				String actualFilepath = FileUtil.LOG_PATH+ File.separator
				+ applicationLogProperties
				.getProperty(LoggerConstants.LOG_FILE_NAME);
				
//				System.out.println("actualFilePath==========="+actualFilepath);
				
				
//				String actualFilepath = FileUtil.LOG_PATH
//						+ File.separator
//						+ applicationLogProperties
//								.getProperty(LoggerConstants.LOG_FILE_NAME);
				
//				System.out.println("actualFilePath==========="+actualFilepath);
				
				
				fileAppender = new FileAppender(patternLayOut, actualFilepath,
						true);
				/*
				 * Creating a object for DailyRollingFileAppender
				 */
				dailyAppender = new DailyRollingFileAppender(patternLayOut,
						rollerBackupFilepath, rollingTimeSchedule);
				apacheLogger.addAppender(fileAppender);
				apacheLogger.addAppender(dailyAppender);
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pm.logger.Loggable#info(java.lang.Object)
	 */
	public void info(Object message) {
		info(message, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pm.logger.Loggable#info(java.lang.Object, java.lang.Throwable)
	 */
	public void info(Object message, Throwable throwable) {
		try {
//			applicationLogProperties.load(inStream);
			String infoProp = applicationLogProperties.getProperty(
					LoggerConstants.APPLN_LEVEL_INFO).trim();

			if (infoProp != null
					&& infoProp.equalsIgnoreCase(LoggerConstants.VALUE_ON)) {
				apacheLogger.info(
						"[" + displayClassName + "]" + "  " + message,
						throwable);
			} else {
				// do nothing
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pm.logger.Loggable#debug(java.lang.Object)
	 */
	public void debug(Object message) {
		debug(message, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pm.logger.Loggable#debug(java.lang.Object, java.lang.Throwable)
	 */
	public void debug(Object message, Throwable throwable) {
		try {
//			applicationLogProperties.load(inStream);
			String debugProp = applicationLogProperties.getProperty(
					LoggerConstants.APPLN_LEVEL_DEBUG).trim();
			if (debugProp != null
					&& debugProp.equalsIgnoreCase(LoggerConstants.VALUE_ON)) {
				apacheLogger.debug("[" + displayClassName + "]" + "  "
						+ message, throwable);
			} else {
				// do nothing
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pm.logger.Loggable#error(java.lang.Object)
	 */
	public void error(Object message) {
		error(message, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pm.logger.Loggable#error(java.lang.Object, java.lang.Throwable)
	 */
	public void error(Object message, Throwable throwable) {
		try {
//			applicationLogProperties.load(inStream);
			String errorProp = applicationLogProperties.getProperty(
					LoggerConstants.APPLN_LEVEL_ERROR);
			if (errorProp != null
					&& errorProp.equalsIgnoreCase(LoggerConstants.VALUE_ON)) {
				apacheLogger.error("[" + displayClassName + "]" + "  "
						+ message, throwable);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pm.logger.Loggable#warn(java.lang.Object)
	 */
	public void warn(Object message) {
		warn(message, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pm.logger.Loggable#warn(java.lang.Object, java.lang.Throwable)
	 */
	public void warn(Object message, Throwable throwable) {
		try {
//			applicationLogProperties.load(inStream);
			String warnProp = applicationLogProperties.getProperty(
					LoggerConstants.APPLN_LEVEL_WARN).trim();
			if (warnProp != null
					&& warnProp.equalsIgnoreCase(LoggerConstants.VALUE_ON)) {
				apacheLogger.warn(
						"[" + displayClassName + "]" + "  " + message,
						throwable);
			} else {
				// do nothing
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pm.logger.Loggable#fatal(java.lang.Object)
	 */
	public void fatal(Object message) {
		fatal(message, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pm.logger.Loggable#fatal(java.lang.Object, java.lang.Throwable)
	 */
	public void fatal(Object message, Throwable throwable) {
		try {
			applicationLogProperties.load(inStream);
			String fatalProp = applicationLogProperties.getProperty(
					LoggerConstants.APPLN_LEVEL_FATAL).trim();
			if (fatalProp != null
					&& fatalProp.equalsIgnoreCase(LoggerConstants.VALUE_ON)) {
				apacheLogger.fatal("[" + displayClassName + "]" + "  "
						+ message, throwable);

			} else {
				// do nothing
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pm.logger.Loggable#isDebugEnabaled()
	 */
	public boolean isDebugEnabaled() {
		boolean isDebugEnable = false;
		try {
			applicationLogProperties.load(inStream);
			String debugProp = applicationLogProperties.getProperty(
					LoggerConstants.APPLN_LEVEL_DEBUG).trim();
			if (debugProp != null
					&& debugProp.equalsIgnoreCase(LoggerConstants.VALUE_ON)) {
				isDebugEnable = apacheLogger.isDebugEnabled();
			} else {
				isDebugEnable = apacheLogger.isDebugEnabled();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDebugEnable;
	}

}
