/*
 * Created on Feb 20, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
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
public class XmlReader
{

    public static void main( String[] args)
    {
        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance("com.rrs.corona");
            FileInputStream fin = new FileInputStream("E:/Workarea/Createparser_V2/xmlFile/contact.xml");
            Unmarshaller unmarshall = jaxbContext.createUnmarshaller();
            AddressBook adrsBook = (AddressBook) unmarshall.unmarshal(fin);
            List contactList = adrsBook.getContact();
          
            for(int i=0;i<contactList.size();i++)
            {
                Contact contact = (Contact)contactList.get(i);
                System.out.println(" Name ====  "+contact.getName());
                System.out.println(" Email =====  "+contact.getEmail());
                if(contact.getName().equals("PIKU"))
                {
                    // for updating
                    contact.setEmail("ppppppp@rediff.com");
                    //adrsBook.getContact().remove(i); // for deleting
                }
            }
            
            // for removing a contact
            
            ObjectFactory objectFactory = new ObjectFactory();
            
            AddressBook adrsBook1 = objectFactory.createAddressBook(); // main node
            
            Contact contact = objectFactory.createContact(); // second child node
            
            adrsBook1.getContact().add(contact); 
            
            //final JAXBContext jaxbContext1 = JAXBContext.newInstance("com.rrs.corona");
            final FileOutputStream fout = new FileOutputStream("E:/Workarea/Createparser_V2/xmlFile/contact111.xml");
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
