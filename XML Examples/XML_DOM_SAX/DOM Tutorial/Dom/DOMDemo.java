/*
 * Created on Apr 23, 2005
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

public class DOMDemo {
	public static void main(String args[]) throws Exception
	  {
	    DocumentBuilderFactory docFactory=DocumentBuilderFactory.newInstance();
	    DocumentBuilder docBuilder=docFactory.newDocumentBuilder();
	    Document doc=docBuilder.parse("phone.xml");
	    Element root=doc.getDocumentElement();
	    NodeList list=root.getChildNodes();
	     int n=list.getLength();
	    System.out.println(n);
	    //System.out.println("root node "+root.toString());
	    for(int i=0;i<n;i=i+2)
	    {
	    	//System.out.print(list.item(i));
	      Node node=list.item(i);
	      if(node.getNodeType()==3)
	      System.out.println("node name:"+node.getNodeValue());
	    }
	    System.out.print("Number of child nodes "+n);
	  }
}
