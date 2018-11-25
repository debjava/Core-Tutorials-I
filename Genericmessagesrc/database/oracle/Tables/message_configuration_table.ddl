/*******************************************************************************************************
* Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.								*
* IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.				*
* The Program or any portion thereof may not be reproduced in any form whatsoever except			*
* as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd.			*
*														*
* File Name                   : MESSAGE_CONFIGURATION_TABLE.ddl							*
* Author                      : Shrinath								*
* Creation Date               : 12-Nov-2007									*
* Description                 : This funciton for msg alert
*                               
* Modification History        :											*
*   Version No.|   Date       | Modified by        |       Brief description of change				*
*  --------------------------------------------------------------------------------------------------		*
*  --------------------------------------------------------------------------------------------------		*
******************************************************************************************************/

DROP TABLE MESSAGE_CONFIGURATION_TABLE
/
CREATE TABLE MESSAGE_CONFIGURATION_TABLE 
				( 
				  	EVENT_ID            NUMBER (10)   NOT NULL 
				 ,	EVENT_CODE          VARCHAR2 (20)  NOT NULL 
				 ,	VERSION             NUMBER (10)   NOT NULL 
				 ,	EXTERNAL_SYSTEM     VARCHAR2 (50) 
				 ,	DESCRIPTION         VARCHAR2 (255) 
				 ,	FUNCTION_NAME       VARCHAR2 (255) 
				 ,	FUNCTION_TYPE       VARCHAR2 (8) 
				 ,	MESSAGE_TYPE        VARCHAR2 (1) 
				 ,	TEMPLATE_NAME       VARCHAR2 (255) 
				 ,	TEMPLATE_PATH       VARCHAR2 (255) 
				 ,	FILE_ATTACHEMENT    VARCHAR2 (1)
				 ,	ATTACHMENT_TYPE     VARCHAR2 (10) 
				 ,	ATTACHEMENT_PATH    VARCHAR2 (255) 
				 ,	DB_SERVER_PORT      VARCHAR2 (4) 
				 ,	DB_SERVER_IP        VARCHAR2 (50) 
				 ,	DB_NAME             VARCHAR2 (50) 
				 ,	DB_USERNAME         VARCHAR2 (50) 
				 ,	DB_USER_PWD         VARCHAR2 (50) 
				 ,	DB_SID              VARCHAR2 (50) 
				 ,	DELIVERY_FREQUENCY  VARCHAR2 (1)  NOT NULL
				 ,	CREATED_BY	    VARCHAR2(10 CHAR)
				 ,	CREATED_ON	    DATE
				 ,	LAST_UPDATED_BY	    VARCHAR2(10 CHAR)
				 ,	LAST_UPDATED_ON     DATE
				 ,	AUTHORIZED_BY	    VARCHAR2(10 CHAR)
				 ,	AUTHORIZATION_DATE  DATE
				 ,	STATUS		    VARCHAR2(1 CHAR)		
				  )
/