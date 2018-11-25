
package com.rrs.corona.solutionsacceleratorstudio.plugin;
/**
 * @author Debadatta Mishra
 */
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import com.rrs.corona.Sas.DataSourceList;
import com.rrs.corona.Sas.FieldList;
import com.rrs.corona.Sas.Sas;
import com.rrs.corona.Sas.TableList;
import com.rrs.corona.common.CommonConstants;
//import com.rrs.corona.solutionsacceleratorstudio.SASConstants;

public class DsReader 
{
	//String dataSourceFilePath = SASConstants.DATASOURCE_FILEPATH;
	//String dataSourceFilename = SASConstants.DATASOURCE_FILENAME;
	//String jaxBContext = SASConstants.SASJAXB_CONTEXT;
	String dataSourceFilePath = "D:/main/dataSource";
	//String dataSourceFilename = SASConstants.DATASOURCE_FILENAME;
	String dataSourceFilename = "D:/main/dataSource/dsInfo.xml";
	//String jaxBContext = SASConstants.SASJAXB_CONTEXT;
	String jaxBContext = "com.rrs.corona.Sas";
	ArrayList dataSourceNames = new ArrayList();
	ArrayList dataSourceTableNames = null;
	ArrayList dataSourcetableFieldsInfo = null;
	
	public ArrayList getDataSourceNames()
	{
		try
		{
			JAXBContext jaxbCtx = JAXBContext.newInstance(jaxBContext);
			Unmarshaller unmarshal = jaxbCtx.createUnmarshaller();
			Sas sas = (Sas)unmarshal.unmarshal(new FileInputStream(dataSourceFilename));
			List dataSourceList =  sas.getDataSource();
			
			for(int i=0;i<dataSourceList.size();i++)
			{
				DataSourceList dataSource = (DataSourceList) dataSourceList.get(i);
				String currentDsName = dataSource.getDataSourceName();
				dataSourceNames.add(currentDsName);
			}
			
			return dataSourceNames ;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return dataSourceNames;
	}
	
	public Sas getSas()
	{
		try
		{
			JAXBContext jaxbCtx = JAXBContext.newInstance(jaxBContext);
			Unmarshaller unmarshal = jaxbCtx.createUnmarshaller();
			Sas sas = (Sas)unmarshal.unmarshal(new FileInputStream(dataSourceFilename));// temporary hardcoding
			
			return sas;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList getTotalTableNamesOfOneDS(String dsName)
	{
		dataSourceTableNames = new ArrayList();
		try
		{
			JAXBContext jaxbCtx = JAXBContext.newInstance(jaxBContext);
			Unmarshaller unmarshal = jaxbCtx.createUnmarshaller();
			Sas sas = (Sas)unmarshal.unmarshal(new FileInputStream(dataSourceFilename));
			List dataSourceList =  sas.getDataSource();
			
			for(int i=0;i<dataSourceList.size();i++)
			{
				DataSourceList dataSource = (DataSourceList) dataSourceList.get(i);
				String tempDsName = dataSource.getDataSourceName();
				if(tempDsName.equals(dsName))
				{
					List tableList = dataSource.getTable();
					for(int j=0;j<tableList.size();j++)
					{
						TableList tab = (TableList)tableList.get(j);
						String tabname = tab.getTableName();
						DsTableInfo tabInfo = new DsTableInfo();
						tabInfo.setDsTableName(tabname);
						dataSourceTableNames.add(tabInfo);
					}	
				}
			}
			return dataSourceTableNames ;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList getTotalFieldNamesFromOneTab(String dsName,String TableName)
	{
		dataSourcetableFieldsInfo = new ArrayList();
		try
		{
			JAXBContext jaxbCtx = JAXBContext.newInstance(jaxBContext);
			Unmarshaller unmarshal = jaxbCtx.createUnmarshaller();
			Sas sas = (Sas)unmarshal.unmarshal(new FileInputStream(dataSourceFilename));
			List dataSourceList =  sas.getDataSource();
			
			for(int i=0;i<dataSourceList.size();i++)
			{
				DataSourceList dataSource = (DataSourceList) dataSourceList.get(i);
				String tempDsName = dataSource.getDataSourceName();
				if(tempDsName.equals(dsName))
				{
					List tableList = dataSource.getTable();
					for(int j=0;j<tableList.size();j++)
					{
						TableList tab = (TableList)tableList.get(j);
						String tabname = tab.getTableName();
						if(tabname.equals(TableName))
						{
							List fieldList = tab.getField();
							for(int k=0;k<fieldList.size();k++)
							{
								FieldList field = (FieldList)fieldList.get(k);
								DsFieldInfo dsfieldInfo = new DsFieldInfo();
								dsfieldInfo.setDsFieldName(field.getFieldName());
								dsfieldInfo.setDsFieldType(field.getFieldType());
								dataSourcetableFieldsInfo.add(dsfieldInfo);
							}
						}
					}	
				}
				else
				{
					// do nothing
				}
			}
			return dataSourcetableFieldsInfo;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null ;
	}
	
}
