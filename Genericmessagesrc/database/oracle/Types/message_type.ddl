/*******************************************************************************************************
* Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.								*
* IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.				*
* The Program or any portion thereof may not be reproduced in any form whatsoever except			*
* as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd.			*
*														*
* File Name                   : messages_type.ddl							*
* Author                      : Shrinath								*
* Creation Date               : 12-Nov-2007									*
* Description                 : This funciton for msg alert
*                               
* Modification History        :											*
*   Version No.|   Date       | Modified by        |       Brief description of change				*
*  --------------------------------------------------------------------------------------------------		*
*    0.1       |19-nov-07    |Srinath        |removed message_runtime_table field				*
*  --------------------------------------------------------------------------------------------------		*
******************************************************************************************************/

DROP TYPE messages_type;
DROP TYPE messages_alert_type;
DROP TYPE mesg_to_batch_table;
DROP TYPE mesg_to_batch_type;
DROP TYPE batch_table;
DROP TYPE batch_type
/
CREATE OR REPLACE TYPE messages_alert_type AS OBJECT
					(
						EVENT_ID	                NUMBER(10 )			
					,	EVENT_CODE	                VARCHAR2(20 CHAR)		
					,	VERSION	                        NUMBER(10 )		
					,	EXTERNAL_SYSTEM	                VARCHAR2(50 CHAR)		
					,	DESCRIPTION	                VARCHAR2(255 CHAR)		
					,	FUNCTION_NAME	                VARCHAR2(255 CHAR)		
					,	FUNCTION_TYPE	                VARCHAR2(8 CHAR)		
					,	MESSAGE_TYPE	                VARCHAR2(1 CHAR)		
					,	TEMPLATE_NAME	                VARCHAR2(255 CHAR)		
					,	TEMPLATE_PATH	                VARCHAR2(255 CHAR)		
					,	FILE_ATTACHEMENT	        VARCHAR2(1CHAR)		
					,	ATTACHMENT_TYPE	                VARCHAR2(10 CHAR)			
					,	ATTACHEMENT_PATH	        VARCHAR2(255 CHAR)		
					,	DB_SERVER_PORT	                VARCHAR2(4 CHAR)			
					,	DB_SERVER_IP                    VARCHAR2(50 CHAR)		
					,	DB_NAME	                        VARCHAR2(50 CHAR)		
					,	DB_USERNAME                     VARCHAR2(50 CHAR)		
					,	DB_USER_PWD                     VARCHAR2(50 CHAR)		
					,	DB_SID	                        VARCHAR2(50 CHAR)		
					,	DELIVERY_FREQUENCY	        VARCHAR2(1 CHAR)
 					,	CELL_NO                         VARCHAR2(15 CHAR)
					,	TO_NAME                         VARCHAR2(40 CHAR)
					,	TO_ID                           VARCHAR2(1000 CHAR)
					,	FROM_NAME                       VARCHAR2(40 CHAR)
					,	CC_                             VARCHAR2(1000 CHAR)
					,	BCC_                            VARCHAR2(1000 CHAR)
					,	SUBJECT                         VARCHAR2(256 CHAR)
					,	PRIORITY                        NUMBER (1)
					 ,	CREATED_BY	    VARCHAR2(10 CHAR)
					 ,	CREATED_ON	    DATE
					 ,	LAST_UPDATED_BY	    VARCHAR2(10 CHAR)
					 ,	LAST_UPDATED_ON     DATE
					 ,	AUTHORIZED_BY	    VARCHAR2(10 CHAR)
					 ,	AUTHORIZATION_DATE  DATE
					 ,	STATUS		    VARCHAR2(1 CHAR)		

					 );
/
CREATE OR REPLACE TYPE messages_type AS TABLE OF messages_alert_type;
/

CREATE OR REPLACE TYPE mesg_to_batch_type AS OBJECT
					(
						division_id	VARCHAR2(10 CHAR)
					,	VERSION         NUMBER
					,	EOD_CODE        VARCHAR2(4 CHAR)
					,	BATCH_ID        VARCHAR2(10 CHAR)
					,	SUCESS          VARCHAR2(1 CHAR)
					,	FAILURE         VARCHAR2(1 CHAR)
					,	STATUS          VARCHAR2(1 CHAR)
					);
/
CREATE OR REPLACE TYPE mesg_to_batch_table AS TABLE OF mesg_to_batch_type;
/
CREATE OR REPLACE TYPE batch_type AS OBJECT
					(
					 	BATCH_ID     VARCHAR2(10 CHAR)
					,	BATCH_NAME   VARCHAR2(20 CHAR)
					);
/
CREATE OR REPLACE TYPE batch_table AS TABLE OF batch_type;
/