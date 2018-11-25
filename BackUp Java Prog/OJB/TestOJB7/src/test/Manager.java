/*
 * Created on Jan 20, 2006
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
    
    public String storeObj1InTab1(String name)
    {
        broker = PersistenceBrokerFactory.defaultPersistenceBroker();
        broker.beginTransaction();
        try
        {
            Obj1 obj = new Obj1();
            
            obj.setName(name);
            broker.store(obj);
            broker.commitTransaction();
            System.out.println("Saving the Object1.............................");
            
            return obj.getId();
        }
        catch(PersistenceBrokerException pbe)
        {
            pbe.printStackTrace() ;
            broker.abortTransaction();
        }
        finally
        {
            if(broker!=null)
                broker.close();
        }
        
        return null;
    }
    
    public void storeObj2InTab2(String fkey,String adrs,String desgn)
    {
        try
        {
        broker = PersistenceBrokerFactory.defaultPersistenceBroker();
        broker.beginTransaction();
        
        Obj2 obj = new Obj2();
        obj.setAddress(adrs);
        obj.setDesgn(desgn);
        obj.setFkNo(fkey);
        
        broker.store(obj);
        broker.commitTransaction();
        System.out.println("Saving the Object2.............................");
        }
        catch(PersistenceBrokerException pbe)
        {
            pbe.printStackTrace();
            broker.abortTransaction();
        }
        finally
        {
            if(broker!= null)
                broker.close();
        }
        
    }

    public static void main(String[] args)
    {
        Manager mgr = new Manager();
        for(int i=0;i<1000;i++)
        {
            String id1 = mgr.storeObj1InTab1("Rama");
            mgr.storeObj2InTab2(id1,"Bangalore","Engineer");
        }
    }
}
