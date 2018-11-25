import java.io.FileInputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.rama.test.AddressBook;
import com.rama.test.Contact;
import com.rama.test.OfficeContactType;
import com.rama.test.ProjectInfo;



public class Parser 
{
	public static void main(String[] args) 
	{
		 try
	        {
	            JAXBContext jaxbContext = JAXBContext.newInstance("com.rama.test");
	            FileInputStream fin = new FileInputStream("D:/JavaTempTest/RamaXMLCreater_V2/XMLFILE/rama.xml");
	            Unmarshaller unmarshall = jaxbContext.createUnmarshaller();
	            
	            AddressBook adrsBook = (AddressBook) unmarshall.unmarshal(fin);
	            List contactList = adrsBook.getContact();
//	          
//	            for(int i=0;i<contactList.size();i++)
//	            {
//	                Contact contact = (Contact)contactList.get(i);
//	                System.out.println(" Name ====  "+contact.getName());
//	                System.out.println(" Email =====  "+contact.getEmail());
//	                
//	                List OfficeContactInfo = contact.getOfficialContact();
//	                for(int j=0;j<OfficeContactInfo.size();j++)
//	                {
//	                	OfficeContactType offContact = (OfficeContactType) OfficeContactInfo.get(j);
//	                	System.out.println(" For Officla Contact == official Mail ::: "+offContact.getOfficeEmail());
//	                	System.out.println(" Office Name ::: "+offContact.getOfficeName());
//	                	
//	                	ProjectInfo projInfo = (ProjectInfo) offContact.getProject();
//	                	
//	                	System.out.println("Project Name ::: "+projInfo.getProjectName());
//	                	System.out.println("Project Client Name ::: "+projInfo.getClientName());
//	                	
//	                	
//	                }
//	                
//	            }
		
	        }
		 
		 	catch(Exception e)
		 	{
		 		e.printStackTrace();
		 	}
		
	}	 	

}
