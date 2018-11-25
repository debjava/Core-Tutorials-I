/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : MessageData.java                                 	 	 *
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
package com.iit.core.msg.data;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * This is the generic interface which will be provided to the end
 * developers so that they will provide implementation for this 
 * interface so as to collect the data from the external system.
 * 
 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
 *
 */
public interface MessageData 
{
	/**
	 * This method is used to obtain the map which contains data
	 * filled in by the user.
	 * 
	 * @param varDataList of type {@link List}
	 * @param connection of type {@link Connection}
	 * @return a Map of data
	 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
	 */
	public Map getDataMap( List varDataList , Connection connection );
}
