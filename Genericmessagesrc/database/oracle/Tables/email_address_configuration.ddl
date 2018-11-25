/*******************************************************************************************************
* Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.								*
* IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.				*
* The Program or any portion thereof may not be reproduced in any form whatsoever except			*
* as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd.			*
*														*
* File Name                   : EMAIL_ADDRESS_CONFIGURATION.sql								*
* Author                      : Shrinath								*
* Creation Date               : 12-Nov-2007									*
* Description                 : This funciton for msg alert
*                               
* Modification History        :											*
*   Version No.|   Date       | Modified by        |       Brief description of change				*
*  --------------------------------------------------------------------------------------------------		*
*    0.1       |17-DEC-07     |Karunakaran.P       |added not null in from name column				*
*  --------------------------------------------------------------------------------------------------		*
******************************************************************************************************/

DROP TABLE EMAIL_ADDRESS_CONFIGURATION 
/
CREATE TABLE EMAIL_ADDRESS_CONFIGURATION 
				( 
					EVENT_CODE  VARCHAR2 (40)  NOT NULL 
				 ,	VERSION_NO  NUMBER   (10)    NOT NULL 
				 ,	TO_NAME     VARCHAR2 (160) NOT NULL 
				 ,	TO_ID       VARCHAR2 (4000) NOT NULL
				 ,	FROM_NAME   VARCHAR2 (160) NOT NULL
				 ,	CC_         VARCHAR2 (4000) 
				 ,	BCC_        VARCHAR2 (4000) 
				 ,	SUBJECT     VARCHAR2 (1020) 
				 ,	PRIORITY    NUMBER   (2)
				  )
/