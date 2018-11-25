/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : AbstractDAOFactory.java                                 	 *
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
package com.iit.core.db;

/**
 * @author Debadatta Mishra
 * 
 */
public abstract class AbstractDAOFactory {
	public static final int ORACLE = 1;

	public abstract MessageDAO getMessageDAO();

	/**
	 * Method to obtain an object of type {@link AbstractDAOFactory}
	 * 
	 * @param factory
	 *            of type int.
	 * @return
	 */
	public static AbstractDAOFactory getDAOFactory(int factory) {
		switch (factory) {
		case ORACLE:
			return new OracleDAOFactory();
		default:
			return null;
		}
	}

	/**
	 * @return an object of type {@link AbstractDAOFactory}
	 */
	public static AbstractDAOFactory getDefaultDAOFactory() {
		return new OracleDAOFactory();
	}

}
