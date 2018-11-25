/*
 * Created on Jan 29, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package logtest;

import org.apache.log4j.Appender;
import org.apache.log4j.Logger;


public class newTest1
{
    
   static Logger log1 = new logUtility().logUse("newTest1.class","D:/JavaTempTest/TestLog4j/xyz.log");
   
   static Logger log2 = new logUtility().logUseHtml("newTest1.class","D:/JavaTempTest/TestLog4j/abc.html");
    
    public int addNos(int a , int b)
    {
        log1.info("Hi ................");
        log1.info("*************** "+(a+b));
        return a+b;
    }

    public static void main(String[] args)
    {
        newTest1 nt = new newTest1();
        int result = nt.addNos(5,8);
        log1.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%   ======  "+result);
        log1.warn("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        log1.debug("````````````````````````````````");
        log1.fatal(" I am fatal..........");
        String sr= "dsfgdgd";
        log1.info(sr);
        
        log2.info("Only for html................");
        
    }
}
