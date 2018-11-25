package com.iit.core.ui;


import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.sql.Date;
import java.sql.DriverManager;


import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

public class  MailDAO {
	
	public static boolean passMailValues( MailBean mailBean ){
		boolean returnType = true;
		
		OracleConnection oraConRef = null;
		Connection con = null;
		OracleCallableStatement ocs = null;
		
		StructDescriptor stdesc;
		ArrayDescriptor arrdescType;
		try{
			String dbURL = "";
			String userName = "";
			String passward = "";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@idealdb01:1521:ideal", "dmqa", "dmqa");
			oraConRef = (OracleConnection) con;//DescriptorUtility.getOracleConnection(con);
		}
		catch (SQLException sq)
		{
	       System.out.println("Could not obtain OracleConnection");
	    } 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			// Make the object from the bean class

			Object [] p1recobj ={
					new Integer(1)
					,mailBean.getEventCode()
					,new Integer(1)
					,mailBean.getExternalSystem()
					,mailBean.getDescription()
					,mailBean.getFunctionName()
					,mailBean.getFunctionType()
					,""
					,mailBean.getTemplateName()
					,mailBean.getTemplatePath()
					,""
					,mailBean.getAttachType()
					,mailBean.getAttachPath()
					,mailBean.getDbDBServerPort()
					,mailBean.getDbDBServerIP()
					,mailBean.getDbDBName()
					,mailBean.getDbDBUserName()
					,mailBean.getDbDBUserPWD()
					,mailBean.getDbDBSID()
					,mailBean.getDbDeliveryFreq()
					,new Integer(1)
					,""
					,""
					,""
					,""
					,null
					,null
					,"Y"
					,mailBean.getSmsCellNo()
					,mailBean.getEmailName()
					,mailBean.getEmailTo()
					,mailBean.getEmailFromName()
					,mailBean.getEmailCC()
					,mailBean.getEmailBCC()
					,mailBean.getEmailSubject()
					,mailBean.getEmailPriority()
					 };
					
//			 Create Descriptors for OracleTypes
			stdesc = StructDescriptor.createDescriptor("MESSAGES_ALERT_TYPE", oraConRef);
			arrdescType = ArrayDescriptor.createDescriptor("MESSAGES_TYPE", oraConRef);
			
			// Set up the struct object
			STRUCT p1struct = new STRUCT(stdesc, oraConRef, p1recobj);
			Object[] p1arrobj = new Object[] { p1struct };

			// Set up the array object
			ARRAY arrBatchType = new ARRAY(arrdescType, oraConRef, p1arrobj);

			// Prepare the OracleCallableStatement
			ocs = (OracleCallableStatement) oraConRef
			.prepareCall("{ call message_alert.pr_message_alert(?,?,?,?)}");

			// Bind inputs and register outputs
//			ocs.registerOutParameter(1, OracleTypes.NUMERIC);
			ocs.setARRAY(1,arrBatchType);
			ocs.registerOutParameter(2, OracleTypes.VARCHAR);
			ocs.registerOutParameter(3, OracleTypes.VARCHAR);
			ocs.registerOutParameter(4, OracleTypes.VARCHAR);
			
			
			// Execute the procedure
			ocs.execute();
			oraConRef.commit();
			con.close();
			// Log the result
//			res = ocs.getInt(1);
			
			
			/*if (res == 0) {
				con.rollback();
//				if (ocs.getString(3) != null)
//					throw new DMException(ocs.getString(4),ocs.getString(5));
//				else
//					throw new DMException(IErrorCodes.DIVISION_INSERT_ERROR,"Procedure Failed to Insert");
			}
*/
			/*// Return the result to the BatchAction
			if (res == 1) {
				oraConRef.commit();
				returnType = true;
				con.close();
			} else {
				oraConRef.rollback();
				returnType = false;
				con.close();
			}*/
			
			return returnType;
		} catch (SQLException t) {
			t.printStackTrace();
			//logger.info("Exception in insertBatch : " + t);
		//	throw new DMException(IErrorCodes.DIVISION_INSERT_ERROR,"Failed to Insert Record for Division", t);
		} catch(RuntimeException re) {
			//throw new DMException(IErrorCodes.DIVISION_TYPECONVERSION_ERROR ,"Exception while creating Object Array");
		} finally{
			//SQLUtils.ensureClosed(ocs,con,oraConRef);  //closing connection
			
		} 
	
	  
		return returnType;
	}
	
}
