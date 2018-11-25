/*
 * Created on Jan 21, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dds.test.orm.test;

import org.apache.ojb.broker.PersistenceBroker;
import org.apache.ojb.broker.PersistenceBrokerException;
import org.apache.ojb.broker.PersistenceBrokerFactory;
import org.apache.ojb.broker.query.Criteria;
import org.apache.ojb.broker.query.QueryByCriteria;
import org.apache.ojb.broker.query.QueryFactory;

/**
 * @author PIKU
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Manager
{
    PersistenceBroker broker = null;
    public String storeData(String fName,String lName)
    {
        try
        {
            broker = PersistenceBrokerFactory.defaultPersistenceBroker();
            broker.beginTransaction();
            
            Obj1 obj = new Obj1();
            obj.setFirstName(fName);
            obj.setLastName(lName);
            System.out.println("-----------------------------------------------------");
            
            broker.store(obj);
            broker.commitTransaction();
            
            return obj.getId();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            broker.abortTransaction();
        }
        finally
        {
            if(broker != null)
                broker.close();
        }
        
        return null;
    }
  
    
    public void updateData(String id,String lastName)
    {
        broker = PersistenceBrokerFactory.defaultPersistenceBroker();
        broker.beginTransaction();
        
        Obj1 obj1 = new Obj1();
        Criteria crit = new Criteria();
        crit.addEqualTo("id",id);
        QueryByCriteria query = QueryFactory.newQuery(Obj1.class,crit);
        
        try
        {
            broker = PersistenceBrokerFactory.defaultPersistenceBroker();
            broker.beginTransaction();
            
            Obj1 obj2 = new Obj1();  
            obj2.setId(id);
            obj2.setLastName(lastName);
            
            broker.store(obj2);
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
        Manager mgr = new Manager();
        String id2 = mgr.storeData("PIKU","Mishra");
        mgr.updateData(id2,"Dash");
        
    }
}
