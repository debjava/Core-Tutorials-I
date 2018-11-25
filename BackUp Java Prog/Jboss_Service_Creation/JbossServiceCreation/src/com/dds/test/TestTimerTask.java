package com.dds.test;

import java.util.TimerTask;

public class TestTimerTask extends TimerTask 
{

	@Override
	public void run() 
	{
		System.out.println("****************************************************");
		System.out.println("######### Receiving the HeartBeat Request ##########");
		System.out.println("****************************************************");
	}

}
