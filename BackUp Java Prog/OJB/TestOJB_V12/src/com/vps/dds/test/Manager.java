/*
 * Created on Jan 30, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.vps.dds.test;

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
    PersistenceBroker broker = null; 
    public void storeDataInDatabase(Object obj)
    {
        try
        {
            broker = PersistenceBrokerFactory.defaultPersistenceBroker();
            broker.beginTransaction();
            broker.store(obj);
            broker.commitTransaction();
            System.out.println("Saving the Data In the Database ................................");
            System.out.println("****************************************************************");
        }
        catch(PersistenceBrokerException pbe)
        {
            pbe.printStackTrace();
            broker.abortTransaction();
        }
        finally
        {
            if(broker != null)
                broker.close();
        }
    }

    public static void main(String[] args)
    {
        Manager mgr = new Manager();
        Obj1 obj = new Obj1();
        obj.setName("Piku Mishra");
        mgr.storeDataInDatabase(obj);
        
    }
}
