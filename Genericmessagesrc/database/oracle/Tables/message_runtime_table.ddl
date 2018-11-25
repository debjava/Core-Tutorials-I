/*******************************************************************************************************
* Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.								*
* IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.				*
* The Program or any portion thereof may not be reproduced in any form whatsoever except			*
* as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd.			*
*														*
* File Name                   : MESSAGE_RUNTIME_TABLE.ddl							*
* Author                      : Shrinath								*
* Creation Date               : 12-Nov-2007									*
* Description                 : This funciton for msg alert
*                               
* Modification History        :											*
*   Version No.|   Date       | Modified by        |       Brief description of change				*
*  --------------------------------------------------------------------------------------------------		*
*  --------------------------------------------------------------------------------------------------		*
******************************************************************************************************/


DROP TABLE MESSAGE_RUNTIME_TABLE
/
CREATE TABLE MESSAGE_RUNTIME_TABLE 
				( 
					SEQ_NO          NUMBER (10)    NOT NULL 
				 ,	EVENT_CODE      VARCHAR2 (10)  NOT NULL 
				 ,	VERSION         NUMBER (10)    NOT NULL 
				 ,	VAR1            VARCHAR2 (255) 
				 ,	VAR2            VARCHAR2 (255) 
				 ,	VAR3            VARCHAR2 (255) 
				 ,	VAR4            VARCHAR2 (255) 
				 ,	VAR5            DATE 
				 ,	TIME_STAMP      DATE 
				 ,	PROCESS_STATUS  CHAR (1)
				  )
/