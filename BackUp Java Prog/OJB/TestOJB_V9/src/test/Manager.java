/*
 * Created on Jan 24, 2006
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
        finally
        {
            if(broker != null)
                broker.close();
        }
        
    }

    public static void main(String[] args)
    {
        Manager mgr = new Manager();
        Intermediate io = new Intermediate();
        Object obj1 = io.getObj();
        mgr.storeData(obj1);
    }
}
