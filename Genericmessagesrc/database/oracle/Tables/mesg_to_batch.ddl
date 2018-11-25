/*******************************************************************************************************
* Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.								*
* IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.				*
* The Program or any portion thereof may not be reproduced in any form whatsoever except			*
* as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd.			*
*														*
* File Name                   : MESG_TO_BATCH.ddl								*
* Author                      : Karunakaran.P									*
* Creation Date               : 30-Dec-2007									*
* Description                 : This funciton for msg alert
*                               
* Modification History        :											*
*   Version No.|   Date       | Modified by        |       Brief description of change				*
*  --------------------------------------------------------------------------------------------------		*
*  --------------------------------------------------------------------------------------------------		*
******************************************************************************************************/

DROP TABLE MESG_TO_BATCH
/
CREATE TABLE MESG_TO_BATCH
			(
			   DIVISION_ID VARCHAR2(10) 
			,  VERSION     NUMBER
			,  EOD_CODE    VARCHAR2(4)
			,  BATCH_ID    VARCHAR2(10)
			,  SUCESS      VARCHAR2(1)
			,  FAILURE     VARCHAR2(1)
			,  STATUS      VARCHAR2(1)
			,  CONSTRAINT mesg_to_batch_prk PRIMARY KEY (DIVISION_ID,VERSION,EOD_CODE)
			);