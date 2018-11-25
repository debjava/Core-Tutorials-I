/*
 * Created on Feb 5, 2006
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
import org.dom4j.io.SAXReader;

/**
 * @author PIKU
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TestDom
{
    Document document = null ;
    SAXReader saxreader = null ;
    Element element = null;
    
    public Document getDocument(String filePath)
    {
        try
        {
            saxreader = new SAXReader();
            document = saxreader.read(filePath);
        } 
        catch (DocumentException de)
        {
            
            de.printStackTrace();
        }
        
        return document;
        
    }
    
    public Element getrootElement(Document doc)
    {
        element = document.getRootElement();
        
        return element ;
    }
    
    public void nodeNamesnValues(Element element)
    {
        for ( int i = 0, size = element.nodeCount(); i < size; i++ )
        {
            Node node = element.node(i);
            //System.out.println("&&&&&&  :  "+node.getName());
            System.out.println(element.getName()+"============="+node.getText());
            
        }
    }
    public void getElementsName(Element element)
    {
        for ( int i = 0, size = element.nodeCount(); i < size; i++ )
        {
            Node node = element.node(i);
            //System.out.println("&&&&&&  :  "+node.getName());
            System.out.println(element.getName()+"============="+node.getText());
            
        }
    }

    public static void main(String[] args)
    {
        TestDom td = new TestDom();
        String filepath ="E:/Works/TestDom4J_V2/PETS.xml";
        Document doc = td.getDocument(filepath);
        System.out.println("Document Name : "+doc.getName());
        Element element1 = td.getrootElement(doc);
        System.out.println(" Root Element : "+element1.getName());
        //td.nodeNamesnValues(element1);
        List list1 = element1.elements();
        System.out.println(" Total No of Elements : "+list1.size());
        for ( Iterator i = element1.elementIterator(); i.hasNext(); ) 
        {
            Element element2 = (Element) i.next();
            td.getElementsName(element2);
            //System.out.println("Elements Name : "+element2.getName());
            if(element2.getName().equalsIgnoreCase("fields"))
            {
                List list3 = element2.elements();
                System.out.println(" Element field size : "+list3.size());
                for(Iterator itr1 = element2.elementIterator(); itr1.hasNext();)
                {
                    Element element3 = (Element) itr1.next();
                    td.getElementsName(element3);
                }
                //td.getElementsName(element2);
            }
        }
        
        
    }
}
