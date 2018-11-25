package com.dds.vps.test;

public abstract class Bextract 
{
	public void show() 
	{
	}
	public abstract void display();
	public abstract int sum(int a,int b);
	

}

class Bnew extends Bextract
{

	@Override
	public void display() {
		System.out.println(" Hi............");
		
	}

	@Override
	public int sum(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}


