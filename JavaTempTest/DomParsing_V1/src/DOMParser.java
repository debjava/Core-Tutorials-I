import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParser 
{
	public static void main(String[] args) 
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try 
		{
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document dom = db.parse("D:/JavaTempTest/DomParsing_V1/XMLFiles/Person.xml");
			Element docEle = dom.getDocumentElement();
			
			//get a nodelist of <employee> elements
			NodeList nl = docEle.getElementsByTagName("Employee");
			if(nl != null && nl.getLength() > 0) {
				for(int i = 0 ; i < nl.getLength();i++) 
				{
					Element el = (Element)nl.item(i);
					System.out.println("Element Name ::: "+el.getNodeName());
					System.out.println("Node Type ::: "+el.getNodeValue());
					Node node2 = (Node)el.getFirstChild();
					System.out.println("Node Name ::: "+node2.getNodeValue());
				}
			}
		}
		catch(ParserConfigurationException pce) 
		{
			pce.printStackTrace();
		}
		catch(SAXException se) 
		{
			se.printStackTrace();
		}
		catch(IOException ioe) 
		{
			ioe.printStackTrace();
		}
		
	}

}
