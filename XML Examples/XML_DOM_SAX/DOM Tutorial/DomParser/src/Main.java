/*
 * Created on Apr 15, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.*;



public class Main 
{
	static public void main(String args[])
	{
		try
		{
				System.out.println("Inside Main");
				int cnt1,cnt2;
				
				String name="";
				String value;
								
				NodeList nl1 = null;
				NodeList nl2 = null;
				
				Node node1 = null;
				Node node2 = null;
				
				Element ele=null;
				Element ele2=null;
				
				File xmlfile = new File("d:\\first.xml");
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				Document doc = db.parse(xmlfile);
				
				ele=doc.getDocumentElement();
				name=ele.getNodeName();
				System.out.println(name);
				nl1=ele.getChildNodes();
				
				node1=ele.getFirstChild();
				System.out.println(node1.getNodeName());
				node1=ele.getFirstChild();
				name=node1.getNodeName();
				//System.out.println(name);
						
				
		}
		catch(ParserConfigurationException e)
		{
		 e.printStackTrace();
		}
		catch (DOMException e) 
		{
			e.printStackTrace();
		}
		catch(SAXException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		/*catch (RuntimeException rte) 
		{
			rte.printStackTrace();
		}*/
		
	}
}
