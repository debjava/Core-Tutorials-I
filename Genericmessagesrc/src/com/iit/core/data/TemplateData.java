/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : TemplateData.java                                 	 	 	 *
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
package com.iit.core.data;

import java.io.StringWriter;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

/**
 * @author <a href="mailTo:debadatta.m@idealinvent.com?subject=problem in
 *         TemplateData in mail module">Debadatta Mishra</a>
 *
 */
public class TemplateData {
	/**
	 * Logger for logging the messages.
	 */
	static Logger logger = Logger.getLogger(TemplateData.class);

	/**
	 * This method is used to return the string of data that will be
	 * sent as email.
	 * 
	 * @param templateFilePath of type String indicating the  filepath of the template
	 * @param templateName of type String indicating the file name of the template
	 * @param dataMap of type Map containing the data.
	 * @return a String 
	 */
	public static String getTemplateDataString(String templateFilePath,
			String templateName, Map dataMap) {
		String templateString = null;
		try {
			VelocityEngine velocityEngine = new VelocityEngine();
			/*
			 * This is required in this context because,
			 * we will get the path from the database and
			 * the path is fixed.
			 */
			velocityEngine.addProperty(
					VelocityEngine.FILE_RESOURCE_LOADER_PATH, templateFilePath);
			velocityEngine.init();

			VelocityContext context = new VelocityContext();
			context.put("dataMap", dataMap);
			Template template = velocityEngine.getTemplate(templateName);
			StringWriter stringWriter = new StringWriter();
			template.merge(context, stringWriter);
			templateString = stringWriter.toString();
			/*
			 *  use the output in the body of your emails
			 */
		} catch (Exception e) {
			logger.error("Error(Exception) =>" + e.getMessage());
			e.printStackTrace();
		}
		return templateString;
	}

}
