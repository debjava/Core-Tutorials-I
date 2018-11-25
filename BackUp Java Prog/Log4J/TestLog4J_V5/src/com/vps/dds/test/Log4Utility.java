/*
 * Created on Jan 30, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.vps.dds.test;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

/**
 * @author PIKU
 *@version 1.0.1
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Log4Utility
{
    Logger logger = null;
    FileAppender appender = null;
    SimpleLayout layout = null;
    
    public Logger getLogger1(String className,String filePath)
    {
        logger = Logger.getLogger(className);
        layout = new SimpleLayout();
        try
        {
            appender = new FileAppender(layout,filePath,false);
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        logger.addAppender(appender);
        
        return logger ;
        
        
    }

}
