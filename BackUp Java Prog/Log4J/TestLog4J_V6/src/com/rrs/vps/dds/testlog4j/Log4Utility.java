/*
 * Created on Jan 31, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.rrs.vps.dds.testlog4j;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

/**
 * @author PIKU
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 * Modified By Debadatta Mishra on "Jan 31, 2006"
 */
public class Log4Utility
{
    Logger logger = null;
    FileAppender appender = null;
    SimpleLayout layout = null;
    
    public Logger getLog4logger(String className,String filePath)
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
            System.out.println(" Some Error Occured .............. ");
        }
        
        return logger;
        
    }
    

}
