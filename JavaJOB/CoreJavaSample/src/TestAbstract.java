
abstract class TestAbstract 
{
	public int x;
	public int y=10;
	
	public TestAbstract()
	{
		System.out.println("I am in abstract class constructor");
	}
	public void show()
	{
		
	}
	public void display()
	{
		System.out.println("I am in Abstract display Method");
	}
	final public void show1()
	{
		System.out.println("I am in the final class....");
	}
	
}

class A extends TestAbstract
{
	public int k=9;
	public A()
	{
		System.out.println("I am in Subclass constructor");
	}
	public void show()
	{
		System.out.println("i am in subclass show() method");
	}
	
}