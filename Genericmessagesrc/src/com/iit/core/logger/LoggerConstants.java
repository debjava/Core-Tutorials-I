package com.iit.core.logger;

/**
 * <p align="justified">
 * This interface is used to maintain all the constants used in the logger API
 * and thereby to eliminate all the hard coding used thereof.
 * </p>
 * 
 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
 * 
 */
public interface LoggerConstants {
	/**
	 * String variable used to indicate the current application name
	 */
	String APPLN_NAME = "DM";

	/**
	 * String variable to indicate the backup file name
	 */
	String DEFAULT_BACKUP_NAME = "DM_BACKUP.log";

	/**
	 * String variable to indicate the Log directory
	 */
	String DEFAULT_LOG = "Logs";

	/**
	 * String variable to indicate the file name of the logger config.
	 */
	String LOG_PROP_FILE_NAME = "applicationlog.properties";

	/**
	 * String varaible to indicate the file separator for window and unix.
	 */
	String FILE_SEPARATOR = "/";

	/**
	 * A String variable used to indicate the pattern for the layout of the
	 * logging messages in the log file. The followings are some of the pattern
	 * indicated below.
	 */
	// "%d{dd MMM yyyy HH:mm:ss} %-5p [%t]: %m%n"; //Original
	// "%d{dd MMM yyyy HH:mm:ss} %-5p [%t]: %m%n";// Second case
	// " %d{dd MMM yyyy HH:mm:ss} [%t] [%p] %c{1} - %m%n";//Third case
	// "%-4r [%t] %-5p %c %x - %m%n"
	// String PATTERN_LAYOUT = "%-4r [%t%M] %-5p %c %x - %m%n";
	// "%d{dd MMM yyyy HH:mm:ss} [%M]==> %c %F %t %m %n"; Good
	// "%d{dd MMM yyyy HH:mm:ss} [%p]==> %c %F %m %n";
	String PATTERN_LAYOUT = "%d{dd MMM yyyy HH:mm:ss} %-5p [%t]: %m%n";

	/**
	 * String variable to indicate on
	 */
	String VALUE_ON = "on";

	/**
	 * String variable to indicate off
	 */
	String VALUE_OFF = "off";

	/**
	 * String varaible to indicate true
	 */
	String VALUE_TRUE = "true";

	/**
	 * String variable to indicate false
	 */
	String VALUE_FALSE = "false";

	/**
	 * String variable to indicate blank
	 */
	String BLANK = "";

	/**
	 * String variable to indicate the Rotate_Time_Schedule from the config file
	 */
	String TIME_ROTATION = "Rotate_Time_Schedule";

	/**
	 * String varaible to indicate Backup_Log_File_Name from the config file
	 */
	String BACKUP_LOG_FILE_NAME = "Backup_Log_File_Name";

	/**
	 * String varaible for the default backup log file name.
	 */
	String DEFAULT_ROLLER_FILE_NAME = "rollerbackup.log";

	/**
	 * String variable to indicate ConsoleLogAppender from the config file
	 */
	String CONSOLE_APPENDER = "ConsoleLogAppender";

	/**
	 * String variable to indicate FileLogAppender from the config file
	 */
	String FILE_APPENDER = "FileLogAppender";

	/**
	 * String variable to indicate Application_Level_Info from the config file
	 */
	String APPLN_LEVEL_INFO = "Application_Level_Info";

	/**
	 * String variable to indicate Application_Level_Debug from the config file
	 */
	String APPLN_LEVEL_DEBUG = "Application_Level_Debug";

	/**
	 * String variable to indicate Application_Level_Fatal from the config file
	 */
	String APPLN_LEVEL_FATAL = "Application_Level_Fatal";

	/**
	 * String variable to indicate Application_Level_Warn from the config file
	 */
	String APPLN_LEVEL_WARN = "Application_Level_Warn";

	/**
	 * String variable to indicate Application_Level_Error from the config file
	 */
	String APPLN_LEVEL_ERROR = "Application_Level_Error";

	/**
	 * String variable to indicate the Log File path
	 */
	String LOG_FILE_PATH = "Log_File_Path";

	/**
	 * String varaible to indicate the Log File name
	 */
	String LOG_FILE_NAME = "Log_File_Name";
}
