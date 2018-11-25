

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import java.util.Random;
import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.*;
public class Main extends Thread{
	public static int z=0;
	public static String[] s=new String[100];
	public static String[] str1=new String[100];
	public static String[] str5=new String[100];
	public static int MAX_LIMIT;
	public static int m,k,k1;
	public static void main(String[] args) throws Exception{
		try
		{
				Element element=null;
				//String name;
				Main m=new Main();
				NodeList nodelist1,nodelist3,nodelist4;
				NodeList nodelist2;
				String name;
				
				int k=0;
				String[] s=new String[100];
				//while(k<args.length)
				//{
				File xmlfile = new File("E:\\Masroor\\JavaWrkSpaces\\domparse-1\\ce1_1.ce");
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				Document doc = db.parse(xmlfile);
				element=doc.getDocumentElement();
				name=element.getNodeName();
				System.out.println("<"+name+">");
				nodelist1=element.getElementsByTagName("RRSEventMDList");
				for(int i=0;i<nodelist1.getLength();i++)
				{
					System.out.println("<"+nodelist1.item(i).getNodeName()+">");
					nodelist2=nodelist1.item(i).getChildNodes();
				    for(int j=0;j<nodelist2.getLength();j++)
					{	
							s[z]=nodelist2.item(j).getTextContent();
							System.out.println(s[z]);
							z++;
							
					}
				    nodelist3=element.getElementsByTagName("Data");
				
					//System.out.println();
				 // for(int j=0;j<nodelist3.getLength();j++)
					//{
						//System.out.println("<"+nl1.item(i).getNodeName()+">");
						//nodelist2=nodelist1.item(i).getChildNodes();
					    //for(int j=0;j<nodelist2.getLength();j++)
						//{	
								//str1[k1]=nodelist3.item(j).getTextContent();
								//System.out.println(s[k1]);
								//k1++;
								
						//}
				   
					
					//}
			    	
				 // k++;
				}
				
				/*try{
				new Thread().sleep(100);
				}catch(Exception e){
					
				}
				MAX_LIMIT=z;*/
				/*System.out.println("no of elements="+MAX_LIMIT);
				for(int i=0;i<z;i++)
					System.out.println(s[i]);*/
				
				//m.sleep(1000);
								
			/*Random random=new Random();
			int j=random.nextInt(MAX_LIMIT);*/
			//System.out.println("some="+j);
				   
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
	}

	/**
	 * @param i
	 */
	private static void sleep(int i) {
		// TODO Auto-generated method stub
		
	}
	
}

