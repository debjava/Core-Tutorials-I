/*******************************************************************************************************
* Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.								*
* IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.				*
* The Program or any portion thereof may not be reproduced in any form whatsoever except			*
* as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd.			*
*														*
* File Name                   : SMS_ADDRESS_CONFIGURATION.ddl							*
* Author                      : Shrinath								*
* Creation Date               : 12-Nov-2007									*
* Description                 : This funciton for msg alert
*                               
* Modification History        :											*
*   Version No.|   Date       | Modified by        |       Brief description of change				*
*  --------------------------------------------------------------------------------------------------		*
*  --------------------------------------------------------------------------------------------------		*
******************************************************************************************************/

DROP TABLE SMS_ADDRESS_CONFIGURATION
/
CREATE TABLE SMS_ADDRESS_CONFIGURATION ( 
					EVENT_CODE  VARCHAR2 (10)  NOT NULL 
				  ,	VERSION_NO  NUMBER (10)   NOT NULL 
				  ,	TO_NAME     VARCHAR2 (40) 
				  ,	FROM_NAME   VARCHAR2 (40) 
				  ,	CELL_NO     VARCHAR2 (15)
					)
/