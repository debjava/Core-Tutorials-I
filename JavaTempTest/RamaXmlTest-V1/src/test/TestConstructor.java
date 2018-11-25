package test;

public class TestConstructor 
{
	
	public TestConstructor(String name)
	{
		this(name,"xyz");
	}
	
	public TestConstructor(String Name,String Value)
	{
		System.out.println(" Name ::: "+Name+"   Value ::: "+Value);
	}
	public static void main(String[] args) 
	{
		new TestConstructor("Rama");
	}

}
