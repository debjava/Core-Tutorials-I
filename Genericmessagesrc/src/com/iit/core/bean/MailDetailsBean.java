/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : MailDetailsBean.java                                 	 	 *
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
public class MailDetailsBean {
	private String eventCode;
	private long version_no;
	private String to_name;
	private String to_id;
	private String from_name;
	private String cc_;
	private String bcc_;
	private String subject;
	private int priority;

	/**
	 * This is a significant variable based upon which, message will be sent .
	 * Here the constraintName is based upon the event code and version no
	 */
	private String constraintName = null;

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public long getVersion_no() {
		return version_no;
	}

	public void setVersion_no(long version_no) {
		this.version_no = version_no;
	}

	public String getTo_name() {
		return to_name;
	}

	public void setTo_name(String to_name) {
		this.to_name = to_name;
	}

	public String getTo_id() {
		return to_id;
	}

	public void setTo_id(String to_id) {
		this.to_id = to_id;
	}

	public String getFrom_name() {
		return from_name;
	}

	public void setFrom_name(String from_name) {
		this.from_name = from_name;
	}

	public String getCc_() {
		return cc_;
	}

	public void setCc_(String cc_) {
		this.cc_ = cc_;
	}

	public String getBcc_() {
		return bcc_;
	}

	public void setBcc_(String bcc_) {
		this.bcc_ = bcc_;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getConstraintName() {
		return constraintName;
	}

	public void setConstraintName(String eventCodeParm, long versionParm) {
		this.constraintName = new StringBuffer(eventCodeParm).append("_")
				.append(new Long(versionParm).toString()).toString();
	}
}
