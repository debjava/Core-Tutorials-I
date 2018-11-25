
package com.rrs.corona.solutionsacceleratorstudio.plugin;
/**
 * @author Debadatta Mishra
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import com.rrs.corona.Sas.DataSourceList;
import com.rrs.corona.Sas.FieldList;
import com.rrs.corona.Sas.ObjectFactory;
import com.rrs.corona.Sas.Sas;
import com.rrs.corona.Sas.TableList;
//import com.rrs.corona.solutionsacceleratorstudio.SASConstants;
import com.rrs.corona.solutionsacceleratorstudio.datasource.DatabaseManager;
import com.rrs.corona.solutionsacceleratorstudio.datasource.DbmsInfo;
import com.rrs.corona.solutionsacceleratorstudio.datasource.FieldInfo;
import com.rrs.corona.solutionsacceleratorstudio.datasource.TableInfo;
//import com.rrs.corona.common.CommonConstants;
//import com.rrs.corona.solutionsacceleratorstudio.SASConstants;

public class DataWriter 
{
	DatabaseManager dbManager = new DatabaseManager();
	//String dataSourceFilePath = SASConstants.DATASOURCE_FILEPATH;
	String dataSourceFilePath = "D:/main/dataSource";
	//String dataSourceFilename = SASConstants.DATASOURCE_FILENAME;
	String dataSourceFilename = "D:/main/dataSource/dsInfo.xml";
	//String jaxBContext = SASConstants.SASJAXB_CONTEXT;
	String jaxBContext = "com.rrs.corona.Sas";
	
	public void writeToXmlFile(Connection connection,DbmsInfo dbInfo)
	{
		try 
		{
			new File(dataSourceFilePath).mkdirs();
			ObjectFactory objectFactory = new ObjectFactory();
			Sas sas = objectFactory.createSas();
			populateDbInfoToFile(connection,dbInfo,objectFactory,sas);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	public void readAndwrite(Connection connection,DbmsInfo dbInfo)
	{
		try 
		{
			final JAXBContext jaxbContext = JAXBContext.newInstance(jaxBContext);
			Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
			Sas sas = (Sas)unMarshaller.unmarshal(new FileInputStream(dataSourceFilename));
			ObjectFactory objectFactory = new ObjectFactory();
			populateDbInfoToFile(connection,dbInfo,objectFactory,sas);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void populateDbInfoToFile(Connection connection,DbmsInfo dbInfo,ObjectFactory objectFactory,Sas sas)
	{
		try
		{
			DataSourceList dataSourceList = objectFactory.createDataSourceList(); // to get first tag
			dataSourceList.setDataSourceName(dbInfo.getDataSourceName()); // writing data source to the xml file
			dataSourceList.setURL(dbInfo.getDbUrl());
			dataSourceList.setUserName(dbInfo.getDbUser());
			dataSourceList.setPassword(dbInfo.getDbPassword());
			dataSourceList.setSelectedDataSource("true");
			ArrayList tableNamesList = dbManager.getAllTableNames(connection);
			
			for(int i=0;i<tableNamesList.size();i++)
			{
				TableList tabList = objectFactory.createTableList(); // get a table tag
				Object obj = (Object)tableNamesList.get(i);
				TableInfo ti1 = (TableInfo)obj ;			
				String TableName = ti1.getTableName();
				tabList.setTableName(TableName);
				tabList.setHideTable("true");
				ArrayList fieldInfoList = dbManager.getEachTableInfo(connection,TableName);
				
				for(Iterator iter = fieldInfoList.iterator(); iter.hasNext();)
				{
					FieldList fieldList = objectFactory.createFieldList(); // to get field tag
					Object obj1 = (Object)iter.next();
					FieldInfo fild = (FieldInfo)obj1;
					fieldList.setFieldName(fild.getFieldName());
					fieldList.setFieldType(fild.getFieldType());
					fieldList.setHideField("true");
					tabList.getField().add(fieldList);
				}
				dataSourceList.getTable().add(tabList);
			}	
			sas.getDataSource().add(dataSourceList);
			
			final JAXBContext jaxbContext = JAXBContext.newInstance(jaxBContext);			
			final FileOutputStream fileOutputStream = new FileOutputStream(dataSourceFilename ); // temporary hardcoding for writing to a file
			final Marshaller marshaller = jaxbContext.createMarshaller( );
			marshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
			marshaller.marshal( sas, fileOutputStream );
			fileOutputStream.close( );
		}
		catch(Exception e)
		{
			
		}
	}
	
}
