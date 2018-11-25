
package com.rrs.corona.solutionsacceleratorstudio.plugin;
/**
 * @author Debadatta Mishra
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import com.rrs.corona.Sas.DataSourceList;
import com.rrs.corona.Sas.FieldList;
import com.rrs.corona.Sas.ObjectFactory;
import com.rrs.corona.Sas.Sas;
import com.rrs.corona.Sas.TableList;
import com.rrs.corona.common.CommonConstants;
//import com.rrs.corona.solutionsacceleratorstudio.SASConstants;
import com.rrs.corona.solutionsacceleratorstudio.datasource.FieldInfo;
import com.rrs.corona.solutionsacceleratorstudio.datasource.TableInfo;

public class DsRename 
{
	/*String dataSourceFilePath = SASConstants.DATASOURCE_FILEPATH;
	String dataSourceFilename = SASConstants.DATASOURCE_FILENAME;
	String jaxBContext = SASConstants.SASJAXB_CONTEXT;*/
	String dataSourceFilePath = "D:/main/dataSource";
	//String dataSourceFilename = SASConstants.DATASOURCE_FILENAME;
	String dataSourceFilename = "D:/main/dataSource/dsInfo.xml";
	//String jaxBContext = SASConstants.SASJAXB_CONTEXT;
	String jaxBContext = "com.rrs.corona.Sas";
	
	public void renameDataSourcename(String oldDsName,String newDsName)
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
				if(currentDsName.equalsIgnoreCase(oldDsName))
				{
					ObjectFactory objectFactory = new ObjectFactory();
					dataSource.setDataSourceName(newDsName); // writing data source to the xml file
					populateDbInfo(objectFactory,sas,newDsName);
				}
				else
				{
					// do nothing
				}	
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void populateDbInfo(ObjectFactory objectFactory,Sas sas,String newDsName)
	{
		try
		{
			DataSourceList dataSourceList = objectFactory.createDataSourceList(); // to get first tag
			TableList tabList = objectFactory.createTableList(); // get a table tag
			FieldList fieldList = objectFactory.createFieldList(); // to get field tag
			final JAXBContext jaxbContext = JAXBContext.newInstance(jaxBContext);
			final FileOutputStream fileOutputStream = new FileOutputStream(dataSourceFilename);
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
