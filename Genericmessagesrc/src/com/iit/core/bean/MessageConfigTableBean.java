/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : MessageConfigTableBean.java                                 *
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
package com.iit.core.bean;

/**
 * @author Debadatta Mishra
 *
 */
public class MessageConfigTableBean 
{
	private int eventId;
	private String eventCode;
	private long version;
	private String external_system;
	private String description;
	private String function_name;
	private String function_type;
	private String message_type;
	private String template_name;
	private String template_path;
	private String file_attachement;
	private String attachment_type;
	private String attachement_path;
	private String db_server_port;
	private String db_server_ip;
	private String db_name;
	private String db_username;
	private String db_user_pwd;
	private String db_sid;
	private String delivery_frequency;

	/**
	 * This is a significant variable based upon which,
	 * message will be sent . Here the constraintName is based
	 * upon the event code and version no
	 */
	private String constraintName = null;

//	private String dbUrl;

	public String getDbUrl() 
	{
		String databaseUrl = new StringBuffer("jdbc:oracle:thin:@").append(db_server_ip)
		.append(":").append(db_server_port).append(":").append(db_sid)
		.toString();
		return databaseUrl;
	}

//	public void setDbUrl(String dbUrl) {
//	this.dbUrl = dbUrl;
//	}

	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEventCode() {
		return eventCode;
	}
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	public String getExternal_system() {
		return external_system;
	}
	public void setExternal_system(String external_system) {
		this.external_system = external_system;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFunction_name() {
		return function_name;
	}
	public void setFunction_name(String function_name) {
		this.function_name = function_name;
	}
	public String getFunction_type() {
		return function_type;
	}
	public void setFunction_type(String function_type) {
		this.function_type = function_type;
	}
	public String getMessage_type() {
		return message_type;
	}
	public void setMessage_type(String message_type) {
		this.message_type = message_type;
	}
	public String getTemplate_name() {
		return template_name;
	}
	public void setTemplate_name(String template_name) {
		this.template_name = template_name;
	}
	public String getTemplate_path() {
		return template_path;
	}
	public void setTemplate_path(String template_path) {
		this.template_path = template_path;
	}
	public String getFile_attachement() {
		return file_attachement;
	}
	public void setFile_attachement(String file_attachement) {
		this.file_attachement = file_attachement;
	}
	public String getAttachment_type() {
		return attachment_type;
	}
	public void setAttachment_type(String attachment_type) {
		this.attachment_type = attachment_type;
	}
	public String getAttachement_path() {
		return attachement_path;
	}
	public void setAttachement_path(String attachement_path) {
		this.attachement_path = attachement_path;
	}
	public String getDb_server_port() {
		return db_server_port;
	}
	public void setDb_server_port(String db_server_port) {
		this.db_server_port = db_server_port;
	}
	public String getDb_server_ip() {
		return db_server_ip;
	}
	public void setDb_server_ip(String db_server_ip) {
		this.db_server_ip = db_server_ip;
	}
	public String getDb_name() {
		return db_name;
	}
	public void setDb_name(String db_name) {
		this.db_name = db_name;
	}
	public String getDb_username() {
		return db_username;
	}
	public void setDb_username(String db_username) {
		this.db_username = db_username;
	}
	public String getDb_user_pwd() {
		return db_user_pwd;
	}
	public void setDb_user_pwd(String db_user_pwd) {
		this.db_user_pwd = db_user_pwd;
	}
	public String getDb_sid() {
		return db_sid;
	}
	public void setDb_sid(String db_sid) {
		this.db_sid = db_sid;
	}
	public String getDelivery_frequency() {
		return delivery_frequency;
	}
	public void setDelivery_frequency(String delivery_frequency) {
		this.delivery_frequency = delivery_frequency;
	}

	public String getConstraintName() 
	{
		return constraintName;
	}

	public void setConstraintName(String eventCodeParm , long versionParm) 
	{
		this.constraintName = new StringBuffer(eventCodeParm).append("_").append(
				new Long(versionParm).toString()).toString();
	}
}
