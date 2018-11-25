/*
 * Created on Jan 15, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package test;

/**
 * @author PIKU
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Employee 
{
	Long id ;
	String name;
	String emailId;
	String designation;
	int age;
	int salary;
	

	/**
	 * @return Returns the age.
	 */
	public int getAge() 
	{
		return age;
	}
	/**
	 * @param age The age to set.
	 */
	public void setAge(int age) 
	{
		this.age = age;
	}
	/**
	 * @return Returns the designation.
	 */
	public String getDesignation() {
		return designation;
	}
	/**
	 * @param designation The designation to set.
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	/**
	 * @return Returns the emailId.
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId The emailId to set.
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * @return Returns the id.
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id The id to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return Returns the salary.
	 */
	public int getSalary() {
		return salary;
	}
	/**
	 * @param salary The salary to set.
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}
}
