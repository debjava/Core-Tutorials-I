/*
 * Created on Feb 26, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.vps.dds.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 * @author PIKU
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DataFromConfig 
{
	 Document document = null;
	 SAXReader saxreader = null;
	 Element rootElement = null;
	 ArrayList dbInfoList = new ArrayList();
	 
	 public Document getDocument(String filePath)
	    {
	        try
	        {
	            saxreader = new SAXReader();
	            document = saxreader.read(filePath);
	            return document;
	        }
	        catch (DocumentException e)
	        {
	            
	            e.printStackTrace();
	        }	        
	       return null;
	    }
	 public Element getRootElement(Document document)
	    {
	        Element rootElement = document.getRootElement();
	        return rootElement ;
	    }
	 
	 public void getNodes11(Element element)
	    {
	        

	        for ( int i = 0, size = element.nodeCount(); i < size; i++ )
	        {
	            Node node = element.node(i);

	            
	        }
	    }
	 public void getElementsName(Element element)
	    {
	 		System.out.println("Total Node : "+element.nodeCount());
	        for ( int i = 0, size = element.nodeCount(); i < size; i++ )
	        {
	            Node node = element.node(i);
	            
	            //System.out.println(element.getName()+"============="+node.getText());
	            dbInfoList.add(node.getText());
	            
	        }
	    }
	 public ArrayList getData()
	 {
	 	return dbInfoList; 	              
	 }
	 
	 public static void main(String[] args)
	 {
	 		ArrayList dbInfoList = new ArrayList();
	 	 	String filePath = "E:/Works/HibernateProj_V1/config/database11.xml" ;
	 	 	DataFromConfig td = new DataFromConfig();
	        Document doc = td.getDocument(filePath);
	        Element element = td.getRootElement(doc);
	        System.out.println(" Document Name : "+doc.getName());
	        System.out.println(" Root Element : "+element.getName());
	        List list1 = element.elements();
	        Element element1 = td.getRootElement(doc);
	        System.out.println(" Total Elements  : "+list1.size());
	        for ( Iterator i = element1.elementIterator(); i.hasNext(); ) 
	        {
	            Element element2 = (Element) i.next();

	            if(element2.getName().equalsIgnoreCase("Database"))
	            {
	                List list3 = element2.elements();
	                System.out.println(" Element field size : "+list3.size());
	                for(Iterator itr1 = element2.elementIterator(); itr1.hasNext();)
	                {
	                    Element element3 = (Element) itr1.next();
	                    td.getElementsName(element3);
	                }

	            }
	        }
	        
	        ArrayList al = td.getData();
	        for(int i=0;i<al.size();i++)
	        {
	        	DbInfo dbInfo = new DbInfo();
	        	dbInfo.setDriverName((String)al.get(1));
	        	dbInfo.setDbURL((String)al.get(2));
	        	dbInfo.setDbUserName((String)al.get(3));
	        	dbInfo.setDbPassword((String)al.get(4));
	        	dbInfoList.add(dbInfo);
	        	System.out.println("!!!!!!   "+al.get(i));
	        }
	 }
	

}
