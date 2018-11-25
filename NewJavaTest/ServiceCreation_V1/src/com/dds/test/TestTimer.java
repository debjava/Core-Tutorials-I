package com.dds.test;

import java.util.TimerTask;

public class TestTimer extends TimerTask
{

    @Override
    public void run() 
    {
	System.out.println("***************************************************");
	System.out.println("******************* Service Running ***************");
	System.out.println("***************************************************");
    }

}
