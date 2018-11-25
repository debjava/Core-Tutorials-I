package com.dds.db.beans;

public class TableFieldInfoBean 
{
	private transient String dbTableName;
	private transient String dbFieldName;
	private transient String dbFieldType;
	private transient boolean dbFieldPrimarykey;
	/**
	 * @return Returns the dbFieldName.
	 */
	public String getDbFieldName() {
		return dbFieldName;
	}
	/**
	 * @param dbFieldName The dbFieldName to set.
	 */
	public void setDbFieldName(String dbFieldName) {
		this.dbFieldName = dbFieldName;
	}
	/**
	 * @return Returns the dbFieldPrimarykey.
	 */
	public boolean isDbFieldPrimarykey() {
		return dbFieldPrimarykey;
	}
	/**
	 * @param dbFieldPrimarykey The dbFieldPrimarykey to set.
	 */
	public void setDbFieldPrimarykey(boolean dbFieldPrimarykey) {
		this.dbFieldPrimarykey = dbFieldPrimarykey;
	}
	/**
	 * @return Returns the dbFieldType.
	 */
	public String getDbFieldType() {
		return dbFieldType;
	}
	/**
	 * @param dbFieldType The dbFieldType to set.
	 */
	public void setDbFieldType(String dbFieldType) {
		this.dbFieldType = dbFieldType;
	}
	/**
	 * @return Returns the dbTableName.
	 */
	public String getDbTableName() {
		return dbTableName;
	}
	/**
	 * @param dbTableName The dbTableName to set.
	 */
	public void setDbTableName(String dbTableName) {
		this.dbTableName = dbTableName;
	}

}
