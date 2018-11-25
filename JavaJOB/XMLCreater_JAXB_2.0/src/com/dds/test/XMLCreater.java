package com.dds.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

import com.rrs.corona.EmpInfo;
import com.rrs.corona.EmpType;
import com.rrs.corona.ObjectFactory;

public class XMLCreater 
{
	private transient JAXBContext jaxbContext = null;
	private transient FileOutputStream fout = null;
	private transient ObjectFactory objectFactory = null;
	private transient FileInputStream fin = null;
	private String filePath = null;
		
	public XMLCreater(final String filePath)
	{
		try
		{
			jaxbContext = JAXBContext.newInstance("com.rrs.corona");
			this.filePath = filePath;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * Method to write to the xml file for the first time
	 */
	public void createXML()
	{
		try
		{
			fout = new FileOutputStream(filePath);
			objectFactory = new ObjectFactory();
			EmpInfo empInfo = objectFactory.createEmpInfo();
			for(int i=0;i<6;i++)
			{
				EmpType empType = objectFactory.createEmpType();
				empType.setAdrs("Bangalore"+i);
				empType.setDesgn("Engineer"+i);
				empType.setName("Deba"+i);
				empInfo.getInfo().add(empType);
			}
			writeToXML(empInfo , jaxbContext , fout);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to update the xml file
	 * @param filePath
	 */
	public void updateXML(final String filePath)
	{
		try
		{
			fin = new FileInputStream(filePath);
			Unmarshaller unmarshall = jaxbContext.createUnmarshaller();
			EmpInfo empInfo = (EmpInfo)unmarshall.unmarshal(fin);
			List empTypeList = empInfo.getInfo();
			EmpType empType = null;
			for(int i=0 ; i<empTypeList.size() ; i++)
			{
				empType = (EmpType)empTypeList.get(i);
				if(empType.getAdrs().equals("Bangalore2"))
				{
					empType.setAdrs("Karnataka");
				}
			}
			objectFactory = new ObjectFactory();
//			EmpInfo empInfo1 = objectFactory.createEmpInfo();
//			empInfo1.getInfo().add(empType);
			fout = new FileOutputStream(filePath);
			writeToXML(empInfo , jaxbContext , fout);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Method used to delete a particular node
	 * @param filePath
	 */
	public void deleteXML(final String filePath)
	{
		try
		{
			fin = new FileInputStream(filePath);
			Unmarshaller unmarshall = jaxbContext.createUnmarshaller();
			EmpInfo empInfo = (EmpInfo)unmarshall.unmarshal(fin);
			List empTypeList = empInfo.getInfo();
			EmpType empType = null;
			for(int i=0 ; i<empTypeList.size() ; i++)
			{
				empType = (EmpType)empTypeList.get(i);
				if(empType.getAdrs().equals("Bangalore4"))
				{
					empType.setAdrs("Karnataka");
					empInfo.getInfo().remove(i);
				}
			}
			objectFactory = new ObjectFactory();
//			EmpInfo empInfo1 = objectFactory.createEmpInfo();
//			empInfo1.getInfo().add(empType);
			fout = new FileOutputStream(filePath);
			writeToXML(empInfo , jaxbContext , fout);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to populate the data to the xml file
	 * @param object
	 * @param jaxbContext
	 * @param fout
	 */
	private void writeToXML(final Object object , final JAXBContext jaxbContext , final FileOutputStream fout )
	{
		try 
		{
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
			EmpInfo empInfo = (EmpInfo)object;
			marshaller.marshal(empInfo,fout);
			fout.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) 
	{
		XMLCreater creater = new XMLCreater("F:/TestData/XMLJAXB_V1/test.xml");
		creater.createXML();
//		creater.updateXML("F:/TestData/XMLJAXB_V1/test.xml");
		creater.deleteXML("F:/TestData/XMLJAXB_V1/test.xml");
	}
	
}
