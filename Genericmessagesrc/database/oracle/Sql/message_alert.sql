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
*    0.1       |19-nov-07    |Srinath        |removed message_runtime_table insertion				*
*    0.2       |19-nov-07    |karunakaran.p  |added fn_find_message_alert function				*
*    0.3       |19-nov-07    |Shrinath       |added Pr_Message_Alert_mod function				*
*  --------------------------------------------------------------------------------------------------		*
******************************************************************************************************/

CREATE OR REPLACE PACKAGE BODY Message_Alert
AS
PROCEDURE       Pr_Message_Alert
                (
                       p_messages_data         IN  messages_type
                ,       p_out                   OUT  NUMBER
                ,      p_err_code              IN OUT VARCHAR2
                ,      p_err_message           IN OUT VARCHAR2
                )
IS
	l_seq NUMBER;
  BEGIN
                FOR each_data IN p_messages_data.FIRST..p_messages_data.LAST
                LOOP
			SELECT SQ_EVENT_ID.NEXTVAL INTO l_seq FROM DUAL;
                        INSERT INTO MESSAGE_CONFIGURATION_TABLE
                                        (
                                        EVENT_ID
                                        ,EVENT_CODE
                                        ,VERSION
                                        ,EXTERNAL_SYSTEM
                                        ,DESCRIPTION
                                        ,FUNCTION_NAME
                                        ,FUNCTION_TYPE
                                        ,MESSAGE_TYPE
                                        ,TEMPLATE_NAME
                                        ,TEMPLATE_PATH
                                        ,FILE_ATTACHEMENT
                                        ,ATTACHMENT_TYPE
                                        ,ATTACHEMENT_PATH
                                        ,DB_SERVER_PORT
                                        ,DB_SERVER_IP
                                        ,DB_NAME
                                        ,DB_USERNAME
                                        ,DB_USER_PWD
                                        ,DB_SID
                                        ,DELIVERY_FREQUENCY
					 ,	CREATED_BY	     
					 ,	CREATED_ON	     
					 ,	LAST_UPDATED_BY	    
					 ,	LAST_UPDATED_ON  
					 ,	AUTHORIZED_BY	     
					 ,	AUTHORIZATION_DATE   					 
					 ,	STATUS		    	
                                        )
                        VALUES
                                        (
                                               l_seq -- p_messages_data(each_data).EVENT_ID
                                        ,       p_messages_data(each_data).EVENT_CODE
                                        ,       p_messages_data(each_data).VERSION
                                        ,       p_messages_data(each_data).EXTERNAL_SYSTEM
                                        ,       p_messages_data(each_data).DESCRIPTION
                                        ,       p_messages_data(each_data).FUNCTION_NAME
                                        ,       p_messages_data(each_data).FUNCTION_TYPE
                                        ,       p_messages_data(each_data).MESSAGE_TYPE
                                        ,       p_messages_data(each_data).TEMPLATE_NAME
                                        ,       p_messages_data(each_data).TEMPLATE_PATH
                                        ,       p_messages_data(each_data).FILE_ATTACHEMENT
                                        ,       p_messages_data(each_data).ATTACHMENT_TYPE
                                        ,       p_messages_data(each_data).ATTACHEMENT_PATH
                                        ,       p_messages_data(each_data).DB_SERVER_PORT
                                        ,       p_messages_data(each_data).DB_SERVER_IP
                                        ,       p_messages_data(each_data).DB_NAME
                                        ,       p_messages_data(each_data).DB_USERNAME
                                        ,      p_messages_data(each_data).DB_USER_PWD
                                        ,      p_messages_data(each_data).DB_SID
                                         ,     p_messages_data(each_data).DELIVERY_FREQUENCY
                                         ,     p_messages_data(each_data).CREATED_BY
 					,       TO_DATE(TO_CHAR(p_messages_data(each_data).created_on ,'DD-MON-YYYY')||' '||TO_CHAR(SYSDATE,'HH24:MI:SS'),'DD-MON-YYYY HH24:MI:SS')		--,p_group_batch_data(1).created_on      
                                        ,      p_messages_data(each_data).LAST_UPDATED_BY
					,	p_messages_data(each_data).LAST_UPDATED_ON
  					 ,     p_messages_data(each_data).AUTHORIZED_BY	     
					 ,     p_messages_data(each_data).AUTHORIZATION_DATE   					 
                                         ,     'A'
                                         );


                    INSERT INTO SMS_ADDRESS_CONFIGURATION
                                        (
                                          EVENT_CODE
                                         ,VERSION_NO
                                         ,TO_NAME
                                         ,FROM_NAME
                                         ,CELL_NO
                                           )
                        VALUES
                                        (
                                                p_messages_data(each_data).EVENT_CODE
                                        ,       p_messages_data(each_data).VERSION
                                        ,       p_messages_data(each_data).TO_NAME
                                        ,       p_messages_data(each_data).FROM_NAME
                                        ,       p_messages_data(each_data).CELL_NO
                                         );


                       INSERT INTO EMAIL_ADDRESS_CONFIGURATION
                                        (
                                          EVENT_CODE
                                         ,VERSION_NO
                                         ,TO_NAME
                                         ,TO_ID
                                         ,FROM_NAME
                                         ,CC_
                                         ,BCC_
                                         ,SUBJECT
                                         ,PRIORITY
                                        )
                        VALUES
                                        (
                                                p_messages_data(each_data).EVENT_CODE
                                        ,       p_messages_data(each_data).VERSION
                                        ,       p_messages_data(each_data).TO_NAME
                                        ,       p_messages_data(each_data).TO_ID
                                        ,       p_messages_data(each_data).FROM_NAME
                                        ,       p_messages_data(each_data).CC_
                                        ,       p_messages_data(each_data).BCC_
                                        ,       p_messages_data(each_data).SUBJECT
                                        ,       p_messages_data(each_data).PRIORITY
                                         );


                END LOOP;
COMMIT;
p_out := 1;


EXCEPTION
WHEN OTHERS THEN
        p_err_code              := 'ERRGD003';
        p_err_message   := 'Failed to insert the record '||SQLERRM;
        p_out           := 0;
END ;

FUNCTION Fn_Find_Message_Alert
			(
				p_event_code IN VARCHAR2
			,	p_messages_data   OUT  messages_type
			,	p_err_code IN OUT VARCHAR2
			,	p_err_message IN OUT VARCHAR2
			)
RETURN NUMBER
IS
	CURSOR c_message(c_event_code IN VARCHAR2)
	IS
		SELECT a.*,b.cell_no, c.to_name,c.to_id,c.from_name,c.cc_,c.bcc_,c.subject,c.priority
		FROM message_configuration_table a,SMS_ADDRESS_CONFIGURATION b,EMAIL_ADDRESS_CONFIGURATION c
		WHERE a.event_code = NVL(c_event_code,a.event_code)
		AND a.version  = (SELECT MAX(e.version) FROM MESSAGE_CONFIGURATION_TABLE e
				    WHERE e.event_code = a.event_code)
		AND a.event_code = b.event_code
		AND a.event_code = c.event_code
 		AND a.version  = b.version_no
		AND a.version   = c.version_no
		AND a.status = 'A';

		i NUMBER := 0;

BEGIN
	p_messages_data := messages_type();
	FOR each_data IN c_message(p_event_code)
	LOOP
		i := i + 1;
		p_messages_data.EXTEND;
		p_messages_data(i) := messages_alert_type
						(
							each_data.event_id
						,	each_data.event_code
						,	each_data.version
						,	each_data.external_system
						,	each_data.description
						,	each_data.function_name
						,	each_data.function_type
						,	each_data.message_type
						,	each_data.template_name
						,	each_data.template_path
						,	each_data.file_attachement
						,	each_data.attachment_type
						,	each_data.attachement_path
						,	each_data.db_server_port
						,	each_data.db_server_ip
						,	each_data.db_name
						,	each_data.db_username
						,	each_data.db_user_pwd
						,	each_data.db_sid
						,	each_data.delivery_frequency
 						,	each_data.cell_no
						,	each_data.to_name
						,	each_data.to_id
						,	each_data.from_name
						,	each_data.cc_
						,	each_data.bcc_
						,	each_data.subject
						,	each_data.priority
						,	each_data.created_by	     
						,	each_data.created_on	     
						,	each_data.last_updated_by	    
						,	each_data.last_updated_on 
						,	each_data.authorized_by	     
						,	each_data.authorization_date   					 
						,	each_data.status		    	
						);

	END LOOP;

	p_err_code := 'MSG-ALT-DET-001';
	p_err_message := 'Records successfully found';
	RETURN 1;

 EXCEPTION
 WHEN NO_DATA_FOUND
 THEN
	  p_err_code := 'ERR-MSG-DET-002';
	  p_err_message := 'No Records found';
	  RETURN 0;
 WHEN OTHERS
 THEN
	  p_err_code := 'ERR-MSG-DET-003';
	  p_err_message := 'Error in finding message alerts'||SQLERRM;
	  RETURN 0;
 END Fn_Find_Message_Alert;

FUNCTION Fn_insert_runtime
			(
		    p_event_code  IN VARCHAR2
        	    ,p_var1            IN  DATE                               -- Bussiness Date
                ,p_timestamp   IN  DATE
				,p_division IN VARCHAR2
                ,p_err_code IN OUT VARCHAR2
		    ,p_err_message IN OUT VARCHAR2
			)
RETURN BOOLEAN
IS
	CURSOR c_div(c_division IN VARCHAR2)
  IS
 SELECT SEQUENCE_NO,DIVISION_ID
 FROM DMTB_EOD_PROCESSING_STATUS
 WHERE division_id = NVL(c_division,division_id);

 l_version NUMBER;

BEGIN

BEGIN
	SELECT MAX(VERSION)
	INTO   l_version
	FROM   MESSAGE_RUNTIME_TABLE
      WHERE  EVENT_CODE = p_event_code ;

    	IF  l_version IS NULL
    	THEN
    		 l_version:=1;
    	ELSE
    		 l_version:= l_version+1;
    	END IF;

END;


 FOR each_data IN c_div(p_division)
 LOOP

                        INSERT INTO MESSAGE_RUNTIME_TABLE
                                        (
                                          SEQ_NO
                                         ,EVENT_CODE
                                         ,VERSION
                                         ,VAR1
                                         ,VAR2
                                         ,VAR3
                                         ,VAR4
                                         ,VAR5
                                         ,TIME_STAMP
                                         ,PROCESS_STATUS
                                        )
                        VALUES
                                        (
                                        each_data.SEQUENCE_NO
                                   ,    p_event_code
                                   ,    l_version
                                   ,    p_var1
                                   ,    each_data.DIVISION_ID
                                   ,    NULL
                                   ,   NULL
                                   ,    NULL
                                   ,    p_timestamp
                                   ,    'U'
                                   );


               DBMS_OUTPUT.PUT_LINE ('Succeeded Insert');
          END LOOP;
 RETURN TRUE;
     EXCEPTION
     WHEN OTHERS THEN
          p_err_code          := 'ERR-EOD-PBP-001';
          p_err_message       := 'Not able to Insert'|| SQLERRM;
          RETURN FALSE;
     END;


     PROCEDURE       Pr_Message_Alert_mod
                (
                       p_messages_data         IN  messages_type
                ,      p_out                   OUT  NUMBER
                ,      p_err_code              IN OUT VARCHAR2
                ,      p_err_message           IN OUT VARCHAR2
                )
IS
	l_seq NUMBER;
	l_version NUMBER;

BEGIN

                FOR each_data IN p_messages_data.FIRST..p_messages_data.LAST
                LOOP
			SELECT SQ_EVENT_ID.NEXTVAL INTO l_seq FROM DUAL;

      BEGIN
	SELECT MAX(VERSION)
	INTO   l_version
	FROM   MESSAGE_CONFIGURATION_TABLE
      WHERE  EVENT_CODE = p_messages_data(each_data).EVENT_CODE ;

    	IF  l_version IS NULL
    	THEN
    		 l_version:=1;
    	ELSE
    		 l_version:= l_version+1;
    	END IF;

END;


                        INSERT INTO MESSAGE_CONFIGURATION_TABLE
                                        (
                                        EVENT_ID
                                        ,EVENT_CODE
                                        ,VERSION
                                        ,EXTERNAL_SYSTEM
                                        ,DESCRIPTION
                                        ,FUNCTION_NAME
                                        ,FUNCTION_TYPE
                                        ,MESSAGE_TYPE
                                        ,TEMPLATE_NAME
                                        ,TEMPLATE_PATH
                                        ,FILE_ATTACHEMENT
                                        ,ATTACHMENT_TYPE
                                        ,ATTACHEMENT_PATH
                                        ,DB_SERVER_PORT
                                        ,DB_SERVER_IP
                                        ,DB_NAME
                                        ,DB_USERNAME
                                        ,DB_USER_PWD
                                        ,DB_SID
                                        ,DELIVERY_FREQUENCY
					 ,	CREATED_BY	     
					 ,	CREATED_ON	     
					 ,	LAST_UPDATED_BY	    
					 ,	LAST_UPDATED_ON 
					 ,	AUTHORIZED_BY
					 ,	AUTHORIZATION_DATE
					 ,	STATUS		    	
                                        )
                        VALUES
                                        (
                                               l_seq -- p_messages_data(each_data).EVENT_ID
                                        ,       p_messages_data(each_data).EVENT_CODE
                                        ,       l_version
                                        ,       p_messages_data(each_data).EXTERNAL_SYSTEM
                                        ,       p_messages_data(each_data).DESCRIPTION
                                        ,       p_messages_data(each_data).FUNCTION_NAME
                                        ,       p_messages_data(each_data).FUNCTION_TYPE
                                        ,       p_messages_data(each_data).MESSAGE_TYPE
                                        ,       p_messages_data(each_data).TEMPLATE_NAME
                                        ,       p_messages_data(each_data).TEMPLATE_PATH
                                        ,       p_messages_data(each_data).FILE_ATTACHEMENT
                                        ,       p_messages_data(each_data).ATTACHMENT_TYPE
                                        ,       p_messages_data(each_data).ATTACHEMENT_PATH
                                        ,       p_messages_data(each_data).DB_SERVER_PORT
                                        ,       p_messages_data(each_data).DB_SERVER_IP
                                        ,       p_messages_data(each_data).DB_NAME
                                        ,       p_messages_data(each_data).DB_USERNAME
                                        ,      p_messages_data(each_data).DB_USER_PWD
                                        ,      p_messages_data(each_data).DB_SID
                                         ,     p_messages_data(each_data).DELIVERY_FREQUENCY
                                         ,     p_messages_data(each_data).CREATED_BY
					 --,	p_messages_data(each_data).CREATED_ON
                                        ,     TO_DATE(TO_CHAR(p_messages_data(each_data).CREATED_ON,'DD-MON-YYYY')||' '||TO_CHAR(SYSDATE,'HH24:MI:SS'),'DD-MON-YYYY HH24:MI:SS')
                                         ,     p_messages_data(each_data).LAST_UPDATED_BY
					-- ,	p_messages_data(each_data).LAST_UPDATED_ON
                                         ,     TO_DATE(TO_CHAR(p_messages_data(each_data).LAST_UPDATED_ON,'DD-MON-YYYY')||' '||TO_CHAR(SYSDATE,'HH24:MI:SS'),'DD-MON-YYYY HH24:MI:SS')
					 ,	p_messages_data(each_data).AUTHORIZED_BY	     
					 ,	p_messages_data(each_data).AUTHORIZATION_DATE   					 
                                         ,     'A'
                                         );


                    INSERT INTO SMS_ADDRESS_CONFIGURATION
                                        (
                                          EVENT_CODE
                                         ,VERSION_NO
                                         ,TO_NAME
                                         ,FROM_NAME
                                         ,CELL_NO
                                           )
                        VALUES
                                        (
                                                p_messages_data(each_data).EVENT_CODE
                                        ,       l_version
                                        ,       p_messages_data(each_data).TO_NAME
                                        ,       p_messages_data(each_data).FROM_NAME
                                        ,       p_messages_data(each_data).CELL_NO
                                         );


                       INSERT INTO EMAIL_ADDRESS_CONFIGURATION
                                        (
                                          EVENT_CODE
                                         ,VERSION_NO
                                         ,TO_NAME
                                         ,TO_ID
                                         ,FROM_NAME
                                         ,CC_
                                         ,BCC_
                                         ,SUBJECT
                                         ,PRIORITY
                                        )
                        VALUES
                                        (
                                                p_messages_data(each_data).EVENT_CODE
                                         ,       l_version
                                        ,       p_messages_data(each_data).TO_NAME
                                        ,       p_messages_data(each_data).TO_ID
                                        ,       p_messages_data(each_data).FROM_NAME
                                        ,       p_messages_data(each_data).CC_
                                        ,       p_messages_data(each_data).BCC_
                                        ,       p_messages_data(each_data).SUBJECT
                                        ,       p_messages_data(each_data).PRIORITY
                                         );


                END LOOP;
COMMIT;
p_out := 1;


EXCEPTION
WHEN OTHERS THEN
        p_err_code              := 'ERRGD003';
        p_err_message   := 'Failed to insert the record '||SQLERRM;
        p_out           := 0;
END ;

PROCEDURE       Pr_Message_batch
                (
                        p_messages         IN  mesg_to_batch_table
                ,       p_out                   OUT  NUMBER
                ,      p_err_code              IN OUT VARCHAR2
                ,      p_err_message           IN OUT VARCHAR2
                )
IS

  BEGIN
                FOR each_one IN p_messages.FIRST..p_messages.Last

                LOOP

                        INSERT INTO MESG_TO_BATCH
                                        (
                                       DIVISION_ID
                                       ,VERSION
                                       ,EOD_CODE
                                       ,BATCH_ID
                                       ,SUCESS
                                       ,FAILURE
                                       ,STATUS
                                        )
                        VALUES
                                        (
                                                p_messages(each_one).DIVISION_ID
                                        ,       p_messages(each_one).VERSION
                                        ,       'EOD'--p_messages(each_one).EOD_CODE
                                        ,       p_messages(each_one).BATCH_ID
                                        ,       p_messages(each_one).SUCESS
                                        ,       p_messages(each_one).FAILURE
                                        ,       p_messages(each_one).STATUS

                                         );



                END LOOP;
COMMIT;
p_out := 1;


EXCEPTION
WHEN OTHERS THEN
        p_err_code              := 'ERRGD003';
        p_err_message   := 'Failed TO INSERT the RECORD '||SQLERRM;
        p_out           := 0;
END ;

/*FUNCTION fn_get_batches 
		 (
			p_div 		IN 	VARCHAR2 
		  ,	p_batch	        OUT	batch_table 
		  ,	p_err_code 	IN OUT 	VARCHAR2 
		  ,     p_err_message   IN OUT 	VARCHAR2
		 )
RETURN NUMBER
IS

   --l_batchtype		DMTM_BATCH_MASTER%ROWTYPE;
  i				NUMBER := 0;
  l_batch_tb	            batch_table := batch_table();


CURSOR c_batch ( l_div VARCHAR2)
IS
	SELECT 	batch_id,batch_name
	FROM 	DMTM_BATCH_MASTER a
	WHERE 	division_id = l_div
	AND	a.version_no = (SELECT MAX(b.version_no) FROM DMTM_BATCH_MASTER b
				WHERE b.batch_id = a.batch_id)
	AND	a.status = 'A';	

BEGIN



	FOR l_batch  IN  c_batch(p_div)
	LOOP
	     	i:=i+1;
    		l_batch_tb.extend;
		l_batch_tb(i) := batch_type (
						   l_batch.BATCH_ID
					     ,	   l_batch.BATCH_NAME
				             );


	END LOOP;

  IF i = 0
  THEN
      p_err_code := 'ERRGD004';
      p_err_message := 'This division does NOT have batches';
            RETURN 0;
  END IF;
  p_batch := l_batch_tb;

	RETURN 1;

EXCEPTION
WHEN OTHERS
THEN
	p_err_code := 'ERRGD003';
	p_err_message := 'Unable TO find batch_id FOR that Branch'||SQLERRM;
	RETURN 0;
END fn_get_batches;*/

FUNCTION fn_show_version
			(
				p_event_code IN VARCHAR2
			,	p_version_no IN NUMBER
			,	p_messages_data   OUT  messages_type
			,	p_last_version OUT VARCHAR2
			,	p_err_code IN OUT VARCHAR2
			,	p_err_message IN OUT VARCHAR2
			)
RETURN NUMBER
IS

		i NUMBER := 0;

l_to_name VARCHAR2(160);
l_to_id VARCHAR2(4000);
l_cc_ VARCHAR2(4000);
l_bcc_ VARCHAR2(4000);
l_subject VARCHAR2(1020);
l_priority  NUMBER(2);
l_from_name VARCHAR2(40);
l_cell_no VARCHAR2(15);
l_version_no NUMBER;
l_message_configure MESSAGE_CONFIGURATION_TABLE%ROWTYPE;

BEGIN
	IF p_event_code IS NULL OR p_version_no IS NULL
	THEN
		p_err_code 	:= 'ERR-DIV_SHOW-001';
		p_err_message 	:= 'Mandatory parameters are NULL';
		RETURN 0;
	END IF;
 
	BEGIN
		SELECT a.*
		INTO l_message_configure
		FROM MESSAGE_CONFIGURATION_TABLE a
		WHERE a.event_code = p_event_code
		AND a.version  = p_version_no
		AND a.status = 'A';
 
		SELECT b.cell_no, c.to_name,c.to_id,c.from_name,c.cc_,c.bcc_,c.subject,c.priority
		INTO l_cell_no,l_to_name,l_to_id,l_from_name,l_cc_,l_bcc_,l_subject,l_priority
		FROM MESSAGE_CONFIGURATION_TABLE a,SMS_ADDRESS_CONFIGURATION b,EMAIL_ADDRESS_CONFIGURATION c
		WHERE a.event_code = p_event_code
		AND a.version  = p_version_no
		AND a.event_code = b.event_code
		AND a.event_code = c.event_code
 		AND a.version  = b.version_no
		AND a.version   = c.version_no
		AND status = 'A';
 
		SELECT  MAX(version)
		INTO l_version_no
		FROM MESSAGE_CONFIGURATION_TABLE a
		WHERE a.event_code = p_event_code
 		AND a.status = 'A';
 
		IF p_version_no <> l_version_no
		THEN
			p_last_version := 'N';
		ELSE
			p_last_version := 'Y';
		END IF;

	EXCEPTION
	WHEN OTHERS
	THEN
		p_err_code 	:= 'ERR-DIV_SHOW-002';
		p_err_message 	:= 'Error IN finding the previous version'||SQLERRM;
		RETURN 0;
	END;

		p_messages_data := messages_type();

		p_messages_data.EXTEND;
		p_messages_data(1) := messages_alert_type
						(
							l_message_configure.event_id
						,	l_message_configure.event_code
						,	l_message_configure.version
						,	l_message_configure.external_system
						,	l_message_configure.description
						,	l_message_configure.function_name
						,	l_message_configure.function_type
						,	l_message_configure.message_type
						,	l_message_configure.template_name
						,	l_message_configure.template_path
						,	l_message_configure.file_attachement
						,	l_message_configure.attachment_type
						,	l_message_configure.attachement_path
						,	l_message_configure.db_server_port
						,	l_message_configure.db_server_ip
						,	l_message_configure.db_name
						,	l_message_configure.db_username
						,	l_message_configure.db_user_pwd
						,	l_message_configure.db_sid
						,	l_message_configure.delivery_frequency
 						,	l_cell_no
						,	l_to_name
						,	l_to_id
						,	l_from_name
						,	l_cc_
						,	l_bcc_
						,	l_subject
						,	l_priority
						,	l_message_configure.created_by
						,	l_message_configure.created_on
						,	l_message_configure.last_updated_by
						,	l_message_configure.last_updated_on
						,	l_message_configure.authorized_by
						,	l_message_configure.authorization_date
						,	l_message_configure.status
						);


 	RETURN 1;

EXCEPTION
 WHEN OTHERS
 THEN
	  p_err_code := 'ERR-MSG-DET-003';
	  p_err_message := 'Error IN finding the version '||SQLERRM;
	  RETURN 0;
 END fn_show_version;

END;
/
