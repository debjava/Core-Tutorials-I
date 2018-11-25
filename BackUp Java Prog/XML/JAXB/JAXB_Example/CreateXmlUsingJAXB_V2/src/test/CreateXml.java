/*
 * Created on Feb 20, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package test;

import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

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

    public static void main( String[] args)
    {
        try
        {
            ObjectFactory objectFactory = new ObjectFactory();
            
            AddressBook adrsBook = objectFactory.createAddressBook(); // main node
            
            Contact contact = objectFactory.createContact(); // second child node
            contact.setName("LILU Mishra");
            contact.setEmail("lilu.mishra@ddsoft.com");
            adrsBook.getContact().add(contact);
            
            final JAXBContext jaxbContext = JAXBContext.newInstance("com.rrs.corona");
            final FileOutputStream fout = new FileOutputStream("E:/Workarea/CreateXmlUsingJAXB_V2/new.xml");
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
            marshaller.marshal(adrsBook,fout);
            fout.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
