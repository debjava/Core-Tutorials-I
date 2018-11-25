/*
 * Created on Jan 15, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package test;


import org.apache.ojb.broker.PersistenceBroker;
import org.apache.ojb.broker.PersistenceBrokerException;
import org.apache.ojb.broker.PersistenceBrokerFactory;

/**
 * @author PIKU
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Manager 
{
	PersistenceBroker broker = null ;
	
	public void storeData(String name)
	{
		 try {
				 broker = PersistenceBrokerFactory.defaultPersistenceBroker() ;
				 broker.beginTransaction();
				 Employee emp = new Employee() ;
				 
				 
				 emp.setName(name);
				 
				 
				 broker.store(emp);
				 broker.commitTransaction();
		 	} 
		  catch (PersistenceBrokerException e) 
		  {
			
			e.printStackTrace();
			
			System.out.println(" Some Error ");
		}
		  finally
		  {
		  	broker.close();
		  }
		
	}

	public static void main(String[] args) 
	{
		Manager mgr = new Manager();
		mgr.storeData("RAMA");
		mgr.storeData("piku");
		mgr.storeData("lilu");
		mgr.storeData("arzoo");
		mgr.storeData("xxxxx");
	}
}
