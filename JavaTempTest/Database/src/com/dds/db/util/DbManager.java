package com.dds.db.util;

import java.sql.Connection;
import java.util.ArrayList;

import com.dds.db.beans.DbConBeans;

/**
 * An Interface for database utility
 * @author PIKU
 *
 */
public interface DbManager 
{
	public boolean checkOracleDbConnection(final String dbUrl,final String dbUser,final String dbPwd);
	public boolean checkOracleDbConnection(final DbConBeans dbBeans);
	public ArrayList getDatabaseTables(final Connection connection);
	public ArrayList getDatabaseTables(final String dbUrl,final String dbUser,final String dbPwd);
	public ArrayList getDatabaseTables(final DbConBeans dbBeans);
	public ArrayList getDbTableFieldInfo(final Connection connection);
	public Connection getOracleDbConnection(final String dbUrl,final String dbUser,final String dbPwd);
	public Connection getOracleDbConnection(final DbConBeans dbBeans);

}
