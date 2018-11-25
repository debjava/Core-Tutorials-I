
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
    public void storeData()
    {
        
        try
        {
            broker = PersistenceBrokerFactory.defaultPersistenceBroker();
            broker.beginTransaction();
            
            Obj1 obj = new Obj1();
            obj.setDesgn("Engineer");
            obj.setName("RAMA");
            
            broker.store(obj);
            broker.commitTransaction();
            
        }
        catch(PersistenceBrokerException pbe)
        {
            pbe.printStackTrace();
        }
        finally
        {
            if(broker != null)
             broker.close();
        }
        
    }

    public static void main(String[] args)
    {
    }
}
