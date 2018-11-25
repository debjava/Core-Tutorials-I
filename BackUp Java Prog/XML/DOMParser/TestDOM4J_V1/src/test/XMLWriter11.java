/*
 * Created on Feb 20, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package test;

import java.io.FileWriter;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

/**
 * @author PIKU
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class XMLWriter11 
{
	public Document createDocument() 
	{
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement( "root" );

        Element author1 = root.addElement( "author" )
            .addAttribute( "name", "James" )
            .addAttribute( "location", "UK" )
            .addText( "James Strachan" );
        
        Element author2 = root.addElement( "author" )
            .addAttribute( "name", "Bob" )
            .addAttribute( "location", "US" )
            .addText( "Bob McWhirter" );

        return document;
    }



	public static void main(String[] args)
	{
		try
		{
			//FileWriter writer = new FileWriter("E:/Works/TestDOM4J_V1/new1.xml");
			//XMLWriter newXml = new XMLWriter("E:/Works/TestDOM4J_V1/new1.xml");
			XMLWriter11 newXml = new XMLWriter11();
			Document doc = newXml.createDocument();
//			XMLWriter writer = new XMLWriter(
//		            new FileWriter("E:/Works/TestDOM4J_V1/new1.xml"));
			XMLWriter writer = new XMLWriter(
		            new FileWriter("E:/Works/TestDOM4J_V1/new2.xml"));
			writer.write(doc);
			writer.close();

			//writer.write(doc);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//writer.w
		}
}
