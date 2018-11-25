package com.iit.core.logger;

/**
 * <p align="justified">
 * This class is based upon the factory design which dynamically returns an
 * object of type org.apache.log4j.Logger. The primary objective is that in case
 * there is a change in the underlying logging API , only this particular class
 * will be changed so that rest will not be affected. This class can neither be
 * instantiated nor be used in the outside world. It is only used inside the
 * developped framework for Logging.
 * </p>
 * 
 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
 * 
 */
public abstract class PMLogFactory {
	/**
	 * Object of type org.apache.log4j.Logger
	 */
	private static org.apache.log4j.Logger logger = null;

	/**
	 * Default Constructor
	 */
	protected PMLogFactory() {
		super();
	}

	/**
	 * <p align="justified">
	 * This method is used to obtain an object of type
	 * <code>org.apache.log4j.Logger</code>. This method accepts the
	 * parameter of type Class.
	 * </p>
	 * 
	 * @param clazzName
	 *            of type {@link Class}
	 * @return an object of type org.apache.log4j.Logger
	 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
	 */
	protected static org.apache.log4j.Logger getLogger(Class clazzName) {
		logger = org.apache.log4j.Logger.getLogger(clazzName);
		return logger;
	}

	/**
	 * <p align="justified">
	 * This method is used to obtain an object of type
	 * <code>org.apache.log4j.Logger</code>. This method accepts the
	 * parameter of type java.lang.String.
	 * </p>
	 * 
	 * @param className
	 *            of type {@link String}
	 * @return an object of type org.apache.log4j.Logger
	 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
	 */
	protected static org.apache.log4j.Logger getLogger(String className) {
		logger = org.apache.log4j.Logger.getLogger(className);
		return logger;
	}

}
