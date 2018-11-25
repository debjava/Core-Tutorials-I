/*
 * Created on Jan 15, 2006
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
	public void storeData(String name,String email,String desgn,int age,int sal)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
		session.beginTransaction() ;
		
		Employee emp = new Employee();
		emp.setName(name);
		emp.setAge(age);
		emp.setDesignation(desgn);
		emp.setEmailId(email);
		emp.setSalary(sal);
		session.save(emp) ;
		
		session.getTransaction().commit();
		
	}

	public static void main(String[] args) 
	{
		Manager mgr = new Manager() ;
		mgr.storeData("Rama","rama@rr.com","Engineer",24,34567);
		
	}
}
