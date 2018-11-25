/*
 * Created on Jan 18, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package test;

import org.apache.ojb.broker.PBFactoryException;
import org.apache.ojb.broker.PersistenceBroker;
import org.apache.ojb.broker.PersistenceBrokerException;
import org.apache.ojb.broker.PersistenceBrokerFactory;
import org.apache.ojb.broker.TransactionAbortedException;
import org.apache.ojb.broker.TransactionInProgressException;
import org.apache.ojb.broker.TransactionNotInProgressException;

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
			broker.beginTransaction() ;
			
			Obj1 obj = new Obj1();
			obj.setName(name) ;
			
			broker.store(obj) ;
			broker.commitTransaction() ;
		} catch (TransactionInProgressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransactionAbortedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransactionNotInProgressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PBFactoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PersistenceBrokerException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(broker==null)
			 broker.abortTransaction() ;	
			
		}
		finally
		{
			broker.close();
		}
	}
	public static void main(String[] args)
	{
		Manager mgr = new Manager() ;
		mgr.storeData("piku");
		mgr.storeData("lilu");
		mgr.storeData("arzoo");
	}

}
