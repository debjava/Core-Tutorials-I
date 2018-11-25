package com.dds.test;

import java.util.Timer;
import java.util.TimerTask;

import org.jboss.system.ServiceMBeanSupport;

public class TestService extends  ServiceMBeanSupport implements TestServiceMBean
{
	private transient Timer timer = null ;
	public void startService() throws Exception 
	{
		// you have to implement your business logic here
		System.out.println("****************** Starting the Service ***************");
		timer = new Timer();
		TimerTask task = new TestTimerTask();
		timer.schedule(task,10,2000);
	}

	public void stopService() 
	{
		System.out.println("****************** Service Stopped *********************");
		timer.cancel();
	}


}

