/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : OracleDAOFactory.java                                 	 	 *
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
 * This is a factory class.
 * @author Debadatta Mishra
 *
 */
public class OracleDAOFactory extends AbstractDAOFactory {

	public OracleDAOFactory() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.iit.core.db.AbstractDAOFactory#getMessageDAO()
	 */
	public MessageDAO getMessageDAO() {
		return new OracleMessageDAOImpl();
	}

}
