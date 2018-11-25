/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : AbstractLoadderFactory.java                                 *
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
package com.iit.core.loader;

import org.apache.log4j.Logger;

/**
 * This class is based upon the factory design pattern which dynamically obtains
 * a class using dynamic class loading.
 * 
 * @author Debadatta Mishra
 * 
 */
public class AbstractLoadderFactory implements Loaddable {
	/**
	 * Logger object for logging the messages.
	 */
	protected static Logger logger = Logger
			.getLogger(AbstractLoadderFactory.class);

	private AbstractLoadderFactory() {
		super();
	}

	/**
	 * This is a singleton implementation.
	 * 
	 * @return
	 */
	public static Loaddable getInstance() {
		return ClassHolder.loaderFactory;
	}

	private static class ClassHolder {
		private static final AbstractLoadderFactory loaderFactory = new AbstractLoadderFactory();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iit.core.loader.Loaddable#getLoadedClassObject(java.lang.String)
	 */
	public Object getLoadedClassObject(String className) {
		Object classObject = null;
		try {
			ClassPathLoader classPathLoader = ClassPathLoader.getInstance();
			classObject = classPathLoader.getLoadedClassObject(className);
		} catch (Exception e) {
			logger.fatal("Fatal error either in loading the class name "
					+ "or in creating the instance of the class");
			logger.fatal("Error logs====", e);
		}
		return classObject;
	}

}
