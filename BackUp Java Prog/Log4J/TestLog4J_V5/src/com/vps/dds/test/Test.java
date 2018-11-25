/*
 * Created on Jan 30, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.vps.dds.test;

import org.apache.log4j.Logger;

/**
 * @author PIKU
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Test
{
    static Logger log1= new Log4Utility().getLogger1("Test.class","F:/works/TestLog4J_V5/log1.log");

    public static void main(String[] args)
    {
        log1.info("Hi");
        
    }
}
