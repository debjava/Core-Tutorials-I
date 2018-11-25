package com.dds.jmsser.test;

import java.util.Timer;
import java.util.TimerTask;

import org.jboss.system.ServiceMBeanSupport;

public class JMSService extends ServiceMBeanSupport implements JMSServiceMBean 
{
	Timer timer = null;
	
	public void startService()
	{
		TestReceiver recever = new TestReceiver();
		recever.receiver();
	}
	
	public void stopService()
	{
		System.out.println(" $$$$$$$$$$$$$$$$$$ Service Stopped $$$$$$$$$$$$$$$$$$");
	}

}