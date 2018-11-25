package com.iit.core.logger;

/**
 * <p align="justified">
 * This interface contains several methods
 * that are used for logging the different
 * kinds of messages in the application.
 * The class com.pm.logger.Logger implements
 * this interface. The basic methods present
 * in this interface are as follows.
 * <ul>
 * <li><code>info()</code>
 * <li><code>debug()</code>
 * <li><code>warn()</code>
 * <li><code>fatal()</code>
 * <li><code>error()</code>
 * </ul>
 * <br>
 * Overloaded methods have been provided for
 * extra use.
 * </p>
 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
 *
 */
public interface Loggable {
	//~~For the methods info
	/**
	 * This method is used for displaying any information.
	 * @param message of type {@link java.lang.Object}
	 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
	 */
	public void info(Object message);

	/**
	 * Overloaded method for displaying information.
	 * @param message of type {@link java.lang.Object}
	 * @param throwable of type {@link java.lang.Throwable}
	 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
	 */
	public void info(Object message, Throwable throwable);

	//~~ For the methods debug
	/**Method used for debugging the application
	 * @param message of type {@link java.lang.Object}
	 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
	 */
	public void debug(Object message);

	/**
	 * Overloaded method for debugging the application.
	 * @param message of type {@link java.lang.Object}
	 * @param throwable of type {@link java.lang.Throwable}
	 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
	 */
	public void debug(Object message, Throwable throwable);

	//~~ For the methods warn
	/**
	 * Method used to log the warning messages.
	 * @param message of type {@link java.lang.Object}
	 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
	 */
	public void warn(Object message);

	/**
	 * Overloaded method to log the warning messages.
	 * @param message of type {@link java.lang.Object}
	 * @param throwable of type {@link java.lang.Throwable}
	 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
	 */
	public void warn(Object message, Throwable throwable);

	//~~ for the methods fatal
	/**
	 * Method used to log the fatal messages
	 * @param message of type {@link java.lang.Object}
	 */
	public void fatal(Object message);

	/**
	 * Overloaded method used to log the fatal messages.
	 * @param message of type {@link java.lang.Object}
	 * @param throwable of type {@link java.lang.Throwable}
	 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
	 */
	public void fatal(Object message, Throwable throwable);

	//~~ For the methods error
	/**
	 * Method used to log all the errors
	 * @param message of type {@link java.lang.Object}
	 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
	 */
	public void error(Object mesage);

	/**Overloaded methods to log all the errors.
	 * @param message of type {@link java.lang.Object}
	 * @param throwable of type {@link java.lang.Throwable}
	 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
	 */
	public void error(Object message, Throwable throwable);

	/**Method used to return a boolean value
	 * if the debug is enabled.
	 * @return a boolean value
	 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
	 */
	public boolean isDebugEnabaled();

}
