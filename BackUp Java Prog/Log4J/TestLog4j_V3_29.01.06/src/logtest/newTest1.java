/*
 * Created on Jan 29, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package logtest;

import org.apache.log4j.Appender;
import org.apache.log4j.Logger;

/**
 * @author PIKU
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class newTest1
{
    
   static Logger log1 = new logUtility().logUse("newTest1.class","E:/Works/TestLog4j_V3/pp.log");
    
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
        
    }
}
