/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : InterfaceAction.java                                        *
 * Author                      : Nurali.v                                               	 *
 * Creation Date               : 23-Oct-2007                                                 *
 * Description                 : This class implement MessageData interface					 *
 *								 Provide impl for getDataMap for EOD status report     	 	 *
 * Modification History        :                                                             *
 *																						     *
 *     Version No.               Date               Brief description of change              *
 *  ---------------------------------------------------------------------------------------  *
 *                       |                  |											     *
 *                       |                  |											     *
 *  ---------------------------------------------------------------------------------------  *
 *********************************************************************************************/

package com.core.test.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.STRUCT;

import com.iit.core.msg.data.MessageData;

public class MessageDataImpl implements MessageData {

	public Map getDataMap(List lstParam, Connection conn) {

		print("In MessageDataImpl.getDataMap() ...");

		print("lstData =>" + lstParam);
//		print("eodDate =>" + lstParam.get(4));
//		print("divisionCode =>" + lstParam.get(0));

//		print("conn =>" + conn);

		Map resultMap = null;
		List lstTemp = null;

		OracleConnection oracleConn = null;
		OracleCallableStatement ocs = null;

		int retCode;

		try{
			// connect to DB
			oracleConn = (OracleConnection)conn;

			// db proc call
			ocs = (OracleCallableStatement)oracleConn.prepareCall
			("{? = call dmpk_mail_util.fn_eod_batch_status(?,?,?,?,?,?,?,?,?)}");

			ocs.registerOutParameter(1, OracleTypes.NUMERIC);

			// set list param
			ocs.setDate(2, (Date)lstParam.get(4));		// EOD date
			ocs.setString(3, (String)lstParam.get(0));	// division code
			ocs.setString(4, (String)lstParam.get(1));
			ocs.setString(5, (String)lstParam.get(2));
			ocs.setString(6, (String)lstParam.get(3));

			ocs.registerOutParameter(7, OracleTypes.ARRAY, "EOC_STATUS_TYPE_TB");
			ocs.registerOutParameter(8, OracleTypes.ARRAY, "DM_BATCH_DETAILS_TYPE_TB");

			ocs.registerOutParameter(9, OracleTypes.VARCHAR);
			ocs.registerOutParameter(10, OracleTypes.VARCHAR);

			// excecute proc call
			ocs.execute();

			retCode = ocs.getInt(1);

			print("retCode =>" + retCode);
			print("Err Code =>" + ocs.getString(9));
			print("Err Msg  =>" + ocs.getString(10));

			if(retCode==0){
				print("DB procedure call failed");
				return null;
			}else{
				resultMap = new HashMap();

				ARRAY recArr = null;
				Object[] recObjArr = null;

				recArr = ocs.getARRAY(7);
				recObjArr = (Object[])recArr.getArray();
				lstTemp = makeEodStatusList(recObjArr);
				resultMap.put("eodStatusList", lstTemp);

				recArr = ocs.getARRAY(8);
				recObjArr = (Object[])recArr.getArray();
				lstTemp = makeBatchDetailList(recObjArr);
				resultMap.put("batchDetailsList", lstTemp);
			}

		}catch(Exception e){
			print("Error(Exception) msg =>" + e.getMessage());
//			e.printStackTrace();
		}finally{
			ensureClose(conn, ocs, oracleConn);
		}

		return resultMap;
	}// getDataMap() over

	/**
	 * Make util.list from given oracle batch detail table
	 * @param recObjArr
	 * @return
	 * @throws Exception
	 */
	private List makeBatchDetailList(Object[] recObjArr)throws Exception {
		List lstBatch = null;
		Map recordMap = null;
		STRUCT recStruct = null;
		Object[] attr = null;

		try{

			lstBatch = new ArrayList();
			print("BatchDetails.size =>" + recObjArr.length);

			// process batch details record, outer table type
			for(int i=0; i<recObjArr.length; i++){

				recStruct = (STRUCT)recObjArr[i];

				if(recStruct != null){
					attr = recStruct.getAttributes();

					recordMap = new HashMap();

					recordMap.put("DIVISION_ID", attr[0]);
					recordMap.put("EOD_STATUS", attr[1]);
					recordMap.put("STOPPED_BATCH", attr[2]);
					recordMap.put("STOPPED_BATCH_CODE", attr[3]);
					recordMap.put("RAN_BY", attr[5]);
					recordMap.put("RAN_ON", attr[6]);

//					print("Rec " + i + " =>" + recordMap);

					// make child list
					ARRAY recChildArr = (ARRAY)attr[4];
					Object[] recChildObjArr = (Object[])recChildArr.getArray();
					recordMap.put("FAILED_BATCH_LIST", makeBatchLogList(recChildObjArr));

					lstBatch.add(recordMap);

				}
			}
		}catch(Exception e){
			print("Error(Exception) msg =>" + e.getMessage());
			throw e;
		}
		return lstBatch;
	}// makeBatchDetailList() over

	/**
	 * Make util.list from given oracle eod status table
	 * @param recObjArr
	 * @return
	 * @throws Exception
	 */
	private List makeEodStatusList(Object[] recObjArr)throws Exception {
		List lstEodStatus = null;
		Map recordMap = null;
		STRUCT recStruct = null;
		Object[] attr = null;

		try{

			lstEodStatus = new ArrayList();
			print("EodStatus.size =>" + recObjArr.length);

			// process batch details record, outer table type
			for(int i=0; i<recObjArr.length; i++){

				recStruct = (STRUCT)recObjArr[i];

				if(recStruct != null){
					attr = recStruct.getAttributes();

					recordMap = new HashMap();

					recordMap.put("DIVISION_ID", attr[0]);
					recordMap.put("EOD_STATUS", attr[1]);
					recordMap.put("EOD_STAGE", attr[2]);
					recordMap.put("RAN_ON", attr[3]);

//					print("rec =>" + recordMap);

					lstEodStatus.add(recordMap);

				}
			}
		}catch(Exception e){
			print("Error(Exception) msg =>" + e.getMessage());
			throw e;
		}

		return lstEodStatus;
	}// makeSuccessBatchList() over

	/**
	 * Make util.list from given oracle batch log table
	 * @param batchObjArr
	 * @return
	 * @throws Exception
	 */
	private List makeBatchLogList(Object[] batchObjArr)throws Exception {
		List lstResult = null;
		Map batchMap = null;

		STRUCT recStruct = null;
		Object[] attr = null;

//		print("child.size =>" + batchObjArr.length);

		try{
			lstResult = new ArrayList();

			for(int i=0; i<batchObjArr.length; i++){

				recStruct = (STRUCT)batchObjArr[i];

				if(recStruct != null){
					attr = recStruct.getAttributes();

					batchMap = new HashMap();

					batchMap.put("BATCH_ID", attr[0]);
					batchMap.put("BATCH_NAME", attr[1]);
//					batchMap.put("ERR_CODE", attr[2]);
					batchMap.put("ERR_DESC", attr[2]);

					lstResult.add(batchMap);

//					print("\tcRec " + i + " =>" + batchMap);
				}
			}
		}catch(Exception e){
			print("Error(Exception) msg =>" + e.getMessage());
			throw e;
		}

		return lstResult;
	}// makeBatchLogList() over
	
	/**
	 * Release resource given as input param 
	 * @param conn
	 * @param ocs
	 * @param oracleConn
	 */
	private static void ensureClose(Connection conn, OracleCallableStatement ocs, OracleConnection oracleConn) {
		if (ocs != null) {
			try {
				ocs.close();
				ocs = null;
			} catch (SQLException e) {
				// SWALLOW.
			}
		}

		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				// Swallow.
			}
		}

		oracleConn = null;
	}//ensureClose() over

	/**
	 * wrapper for System.out.println
	 * @param strOut
	 */
	public static void print(String strOut){
		System.out.println("" + strOut);
		System.out.flush();
	}

}// MessageDataImpl class over
