/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : Loaddable.java                                 	 	 	 *
 * Author                      : Debadatta Mishra                                            *
 * Creation Date               : Sep 25, 2007                                                *
 * Modification History        :                											 *
 *																						     *
 *     Version No.               Date               Brief description of change              *
 *  ---------------------------------------------------------------------------------------  *
 *                       |      			|				 								 *
 *                       |                  |											 	 *
 *  ---------------------------------------------------------------------------------------  *
 *********************************************************************************************/
package com.iit.core.loader;

/**
 * This interface has only method.
 * This interface is only meant for loading the class name dynamically.
 * 
 * @author <a href="mailTo:debadatta.m@idealinvent.com?subject=problem in
 *         Loaddable in mail module">Debadatta Mishra</a>
 *
 */
public interface Loaddable 
{
	/**
	 * This method is used to obtain the instance of the class using class loader.
	 * @param className of type String
	 * @return an object
	 */
	public Object getLoadedClassObject( String className );

}
