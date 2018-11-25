/*******************************************************************************************************
* Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.								*
* IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.				*
* The Program or any portion thereof may not be reproduced in any form whatsoever except			*
* as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd.			*
*														*
* File Name                   : Message_Alert.sql								*
* Author                      : Shrinath								*
* Creation Date               : 12-Nov-2007									*
* Description                 : This funciton for msg alert
*                               
* Modification History        :											*
*   Version No.|   Date       | Modified by        |       Brief description of change				*
*  --------------------------------------------------------------------------------------------------		*
*    0.1       |19-nov-07    |karunakaran.p  |added fn_find_message_alert function				*
*    0.2       |19-nov-07    |Shrinath       |added Pr_Message_Alert_mod function				*
*  --------------------------------------------------------------------------------------------------		*
******************************************************************************************************/

CREATE OR REPLACE PACKAGE Message_Alert
AS
PROCEDURE       Pr_Message_Alert
                (
                       p_messages_data         IN  messages_type
                ,       p_out                   OUT  NUMBER
                ,      p_err_code              IN OUT VARCHAR2
                ,      p_err_message           IN OUT VARCHAR2
                );

FUNCTION Fn_Find_Message_Alert
			(
				p_event_code IN VARCHAR2
			,	p_messages_data   OUT  messages_type
			,	p_err_code IN OUT VARCHAR2
			,	p_err_message IN OUT VARCHAR2
			)
RETURN NUMBER;

FUNCTION  Fn_insert_runtime
			(
					p_event_code  IN VARCHAR2
        		,	p_var1            IN  DATE                               -- Bussiness Date
            ,	p_timestamp   IN  DATE
				,	p_division IN VARCHAR2
            ,	p_err_code IN OUT VARCHAR2
				,	p_err_message IN OUT VARCHAR2
			)
RETURN BOOLEAN;

 PROCEDURE  Pr_Message_Alert_mod
                (      p_messages_data         IN  messages_type
                ,      p_out                   OUT  NUMBER
                ,      p_err_code              IN OUT VARCHAR2
                ,      p_err_message           IN OUT VARCHAR2
                );

PROCEDURE       Pr_Message_batch
                (
                        p_messages         IN  mesg_to_batch_table
                ,       p_out                   OUT  NUMBER
                ,      p_err_code              IN OUT VARCHAR2
                ,      p_err_message           IN OUT VARCHAR2
                );

/*FUNCTION FN_GET_BATCHES
         (p_div 		IN 		VARCHAR2,
          p_batch	      OUT		batch_table,
          p_err_code 	IN OUT 	VARCHAR2,
	    p_err_message IN OUT 	VARCHAR2
         )
RETURN NUMBER;*/

FUNCTION Fn_Show_Version
			(
				p_event_code IN VARCHAR2
			,	p_version_no IN NUMBER
			,	p_messages_data   OUT  messages_type
			,	p_last_version OUT VARCHAR2
			,	p_err_code IN OUT VARCHAR2
			,	p_err_message IN OUT VARCHAR2
			)
RETURN NUMBER;

END Message_Alert;
/


