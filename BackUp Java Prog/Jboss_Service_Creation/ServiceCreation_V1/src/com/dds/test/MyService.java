package com.dds.test;

import java.util.Timer;
import java.util.TimerTask;

import org.jboss.system.ServiceMBeanSupport;

public class MyService extends ServiceMBeanSupport implements MyServiceMBean
{
    Timer timer = null;
    
    public void startService()
    {
	timer = new Timer();
	TimerTask timerTask = new TestTimer();
	timer.schedule(timerTask, 10,2000);
    }
    public void stopService()
    {
	System.out.println("*************** Service Stopped ***************");
	timer.cancel();
    }

}
