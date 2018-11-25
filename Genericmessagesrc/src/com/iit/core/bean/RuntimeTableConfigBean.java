/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : RuntimeTableConfigBean.java                                 *
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

import java.util.Date;

/**
 * @author Debadatta Mishra
 * 
 */
public class RuntimeTableConfigBean {
	private long sequence_no;
	private String eventCode;
	private String var1;
	private String var2;
	private String var3;
	private String var4;
	private java.sql.Date var5;
	private Date timeStamp;
	private String process_status;
	private long version;

	/**
	 * This is a significant variable based upon which, message will be sent .
	 * Here the constraintName is based upon the event code and version no
	 */
	private String constraintName = null;

	public RuntimeTableConfigBean() {
		super();
		// constraintName = new StringBuffer(eventCode).append("_").append(
		// new Long(version).toString()).toString();
	}

	public long getSequence_no() {
		return sequence_no;
	}

	public void setSequence_no(long sequence_no) {
		this.sequence_no = sequence_no;
	}

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public String getVar1() {
		return var1;
	}

	public void setVar1(String var1) {
		this.var1 = var1;
	}

	public String getVar2() {
		return var2;
	}

	public void setVar2(String var2) {
		this.var2 = var2;
	}

	public String getVar3() {
		return var3;
	}

	public void setVar3(String var3) {
		this.var3 = var3;
	}

	public String getVar4() {
		return var4;
	}

	public void setVar4(String var4) {
		this.var4 = var4;
	}

	public java.sql.Date getVar5() {
		return var5;
	}

	public void setVar5(java.sql.Date var5) {
		this.var5 = var5;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getProcess_status() {
		return process_status;
	}

	public void setProcess_status(String process_status) {
		this.process_status = process_status;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public String getConstraintName() {
		return constraintName;
	}

	public void setConstraintName(String eventCodeParm, long versionParm) {
		// this.constraintName = constraintName;
		this.constraintName = new StringBuffer(eventCodeParm).append("_")
				.append(new Long(versionParm).toString()).toString();
	}

}
