package com.rama.hp.test;

import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.rama.test.AddressBook;
import com.rama.test.Contact;
import com.rama.test.ObjectFactory;
import com.rama.test.OfficeContactType;

public class XMLCreater 
{
    public void writeToXML(ObjectFactory objectFactory,AddressBook adrsBook)
    {
        try
        {
            Contact contact = objectFactory.createContact(); // second child node
            contact.setName("RAMA");
            contact.setEmail("rama@hp.com");
            adrsBook.getContact().add(contact);
            final JAXBContext jaxbContext = JAXBContext.newInstance("com.rama.test");
            final FileOutputStream fout = new FileOutputStream("D:/JavaTempTest/RamaXMLCreater_V2/XMLFILE/Rama.xml");
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


}
