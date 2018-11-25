package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FileCopy 
{
	FileInputStream fin;
	FileOutputStream fout;
	FileChannel fichan;
	FileChannel fochan;
	
	
	public FileCopy()
	{
		
	}
	
//	private void fileCopy(String filePath)
//	{
//		try
//		{
//			fin = new FileInputStream(filePath);
//			System.out.println("FilePath :::"+filePath);
//			fichan = fin.getChannel();
//			
//			int size = (int)fichan.size();//(int)fin.read();
//			byte[] buffer = new byte[size];
//			for(int i=0;i<buffer.length;i++)
//			{
//				System.out.println("Value ::: "+buffer[i]);
//			}
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//	}
	
	public void parseFile(String Path)
	{
		try
		{
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = builderFactory.newDocumentBuilder();
			Document doc = parser.parse(Path);
			Element element = doc.getDocumentElement();
			String nodeName = element.getNodeName();
			System.out.println("Node Name :: "+nodeName);

			NodeList nodeList1 = element.getElementsByTagName("OfficeAdrs");
			int nodelistsize = nodeList1.getLength();
			System.out.println("OfficeAdrs node list size ::: "+nodelistsize);
			
			for(int i=0;i<nodelistsize;i++)
			{
				Node node1 = nodeList1.item(i);
				System.out.println("Node name ::: "+node1.getNodeName());
				NodeList nodeList2 = node1.getChildNodes();
				System.out.println("nodeList2 size ::: "+nodeList2.getLength());
				Element element2 = (Element)node1;
				NodeList nodeList3 = element2.getElementsByTagName("Name");
				Node node4 = nodeList3.item(0);
				System.out.println(" **** "+node4.getTextContent());
				
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
//	public void copyFile(String path)
//	{
//		fileCopy(path);
//	}
	
	public static void main(String[] args) 
	{
		FileCopy fCopy = new FileCopy();
		//fCopy.copyFile("D:/RamaXML/Test.xml");
		fCopy.parseFile("D:/RamaXML/Test.xml");
		
	}

}
