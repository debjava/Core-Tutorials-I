/*
 * Created on Feb 2, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package test;

import org.hibernate.Session;

/**
 * @author PIKU
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Manager
{
    Session session = null;
    
    public void storeData(Obj1 obj)
    {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
        
    }
    
    public static void main(String args[])
    {
        Obj1 obj = new Obj1();
        obj.setName("Rama");
        new Manager().storeData(obj);
    }

}
