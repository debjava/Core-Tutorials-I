/*
 * Created on Feb 1, 2006
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
    PersistenceBroker broker = null;
    public void storeData(Object obj)
    {
       try
       {
           broker = PersistenceBrokerFactory.defaultPersistenceBroker();
           broker.beginTransaction();
           broker.store(obj);
           broker.commitTransaction();
       }
       catch(PersistenceBrokerException pbe)
       {
           pbe.printStackTrace();
           broker.abortTransaction();
       }
       catch(Exception e)
       {
           e.printStackTrace();
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
        obj.setName("Rama");
        mgr.storeData(obj);
    }
}
