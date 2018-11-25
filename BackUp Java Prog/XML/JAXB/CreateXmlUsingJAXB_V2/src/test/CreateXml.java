/*
 * Created on Feb 20, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

import com.rrs.corona.AddressBook;
import com.rrs.corona.Contact;
import com.rrs.corona.ObjectFactory;

/**
 * @author PIKU
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CreateXml
{
    public void writeToXML(ObjectFactory objectFactory,AddressBook adrsBook)
    {
        try
        {
            Contact contact = objectFactory.createContact(); // second child node
            contact.setName("PIKU");
            contact.setEmail("lilu.mishra@ddsoft.com");
            adrsBook.getContact().add(contact);
            
            final JAXBContext jaxbContext = JAXBContext.newInstance("com.rrs.corona");
            final FileOutputStream fout = new FileOutputStream("E:/Workarea/CreateXmlUsingJAXB_V2/new.xml");
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
            marshaller.marshal(adrsBook,fout);
            fout.close();
        } 
        
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void readAndWriteXML(ObjectFactory objectFactory)
    {
        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance("com.rrs.corona");
            FileInputStream fin = new FileInputStream("E:/Workarea/CreateXmlUsingJAXB_V2/new.xml");
            Unmarshaller unmarshall = jaxbContext.createUnmarshaller();
            AddressBook adrsBook = (AddressBook) unmarshall.unmarshal(fin);
            
            Contact contact = objectFactory.createContact(); // second child node
            contact.setName("Arzoo");
            contact.setEmail("Arzoo.mishra@ddsoft.com");
            adrsBook.getContact().add(contact);
            final FileOutputStream fout = new FileOutputStream("E:/Workarea/CreateXmlUsingJAXB_V2/new.xml");
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
            marshaller.marshal(adrsBook,fout);
            fout.close();
        } 
        
        catch (Exception e)
        {
            e.printStackTrace();
        } 
    }

    public static void main( String[] args)
    {
        CreateXml newXml = new CreateXml();
        try
        {
            ObjectFactory objectFactory = new ObjectFactory();
            AddressBook adrsBook = objectFactory.createAddressBook(); // main node
            File xmlFile = new File("E:/Workarea/CreateXmlUsingJAXB_V2/new.xml");
            if(!xmlFile.exists())
            {                
                newXml.writeToXML(objectFactory,adrsBook);
            }
            else
            {                
                newXml.readAndWriteXML(objectFactory); // updating to an already existing xml file
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
