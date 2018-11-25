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
	
	public void storeData(String name,String email,String desgn,int age,Double sal)
	{
		 try {
				 broker = PersistenceBrokerFactory.defaultPersistenceBroker() ;
				 broker.beginTransaction();
				 Employee emp = new Employee() ;
				 
				 emp.setAge(age);
				 emp.setDesignation(desgn);
				 emp.setEmail(email);
				 emp.setName(name);
				 emp.setSalary(sal);
				 
				 broker.store(emp);
				 broker.commitTransaction();
		 	} 
		  catch (PersistenceBrokerException e) 
		  {
			
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) 
	{
		Manager mgr = new Manager();
		mgr.storeData("RAMA","rama@rr.com","Engineer",24,new Double(45678));
	}
}
