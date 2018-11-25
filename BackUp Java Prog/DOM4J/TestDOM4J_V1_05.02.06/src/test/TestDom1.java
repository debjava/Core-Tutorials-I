/*
 * Created on Feb 4, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package test;

import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.QName;
import org.dom4j.io.SAXReader;

/**
 * @author PIKU
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TestDom1
{
    Document document = null;
    SAXReader saxreader = null;
    Element rootElement = null;
    int c=0;
    
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
            // TODO Auto-generated catch block
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
        //System.out.println(" All Node and its Names ...............");
        //System.out.println(" Total Nodes ... : "+element.nodeCount());
        for ( int i = 0, size = element.nodeCount(); i < size; i++ )
        {
            Node node = element.node(i);
            //System.out.println("&&&&&&  :  "+node.getName());
            System.out.println(element.getName()+"============="+node.getText());
            
        }
    }


    public static void main(String[] args)
    {
        String filePath = "E:/Works/TestDOM4J_V1/sample.xml" ;
        TestDom1 td = new TestDom1();
        Document doc = td.getDocument(filePath);
        Element element = td.getRootElement(doc);
        System.out.println(" Document Nmae : "+doc.getName());
        System.out.println(" Root Element : "+element.getName());
        List list1 = element.elements();
        System.out.println(" Total Elements  : "+list1.size());
        for ( Iterator i = element.elementIterator("article"); i.hasNext(); ) 
        {
            Element element2 = (Element) i.next();
            System.out.println("Elements Name : "+element2.getName());
            System.out.println("Elements Attributes : "+element2.attributeCount());
            System.out.println("Attribute ID "+"________"+element2.attribute(0).getName()+"--- "+element2.attribute(0).getText());
            
            
            List list2 = element2.elements();
            System.out.println("****************************************************************");
            System.out.println(" Inside Elements " +list2.size());
            for ( Iterator itr = element2.elementIterator(); itr.hasNext(); ) 
            {
                Element element3 = (Element) itr.next();
                //System.out.println(" Inside Elements ****** : "+element3.getName());
                td.getNodes11(element3);
               
            }
            System.out.println("****************************************************************");
            
            
        }    
    }
}
