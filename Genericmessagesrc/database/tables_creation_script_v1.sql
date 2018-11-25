/* Table dropping scripts */

DROP TABLE MESSAGE_CONFIGURATION_TABLE;
DROP TABLE MESSAGE_RUNTIME_TABLE;
DROP TABLE EMAIL_ADDRESS_CONFIGURATION;
DROP TABLE SMS_ADDRESS_CONFIGURATION;

/* Table creation script for generic message configuration table */

CREATE TABLE MESSAGE_CONFIGURATION_TABLE
(
		EVENT_ID		NUMBER(10) NOT NULL,
		EVENT_CODE		VARCHAR2(20) NOT NULL,
		VERSION			NUMBER(10) NOT NULL,
		EXTERNAL_SYSTEM		VARCHAR2(50),
		DESCRIPTION		VARCHAR2(255),
		FUNCTION_NAME		VARCHAR2(255),
		FUNCTION_TYPE		VARCHAR2(8),
		MESSAGE_TYPE		VARCHAR2(1),
		TEMPLATE_NAME		VARCHAR2(255),
		TEMPLATE_PATH		VARCHAR2(255),
		FILE_ATTACHEMENT	VARCHAR2(1),
		ATTACHMENT_TYPE		VARCHAR2(10),
		ATTACHEMENT_PATH	VARCHAR2(255),
		DB_SERVER_PORT		VARCHAR2(4),
		DB_SERVER_IP		VARCHAR2(50),
		DB_NAME			VARCHAR2(50),
		DB_USERNAME		VARCHAR2(50),
		DB_USER_PWD		VARCHAR2(50),
		DB_SID			VARCHAR2(50),
		DELIVERY_FREQUENCY	VARCHAR2(1) NOT NULL
);


/* Table creation script MESSAGE_RUNTIME_TABLE */
CREATE TABLE MESSAGE_RUNTIME_TABLE 
(
		SEQ_NO		NUMBER(10) NOT NULL,
		EVENT_CODE	VARCHAR2(10) NOT NULL,
		VERSION		NUMBER(10) NOT NULL,
		VAR1		VARCHAR2(255),
		VAR2		VARCHAR2(255),
		VAR3		VARCHAR2(255),
		VAR4		VARCHAR2(255),
		VAR5		DATE,
		TIME_STAMP	DATE,
		PROCESS_STATUS	CHAR(1)
		
);

/* Table creation script EMAIL_ADDRESS_CONFIGURATION */

CREATE TABLE EMAIL_ADDRESS_CONFIGURATION
(
		
		EVENT_CODE	VARCHAR2(10) NOT NULL,
		VERSION_NO	NUMBER(10) NOT NULL,
		NAME		VARCHAR2(40) NOT NULL,
		TO_ID		VARCHAR2(256),
		FROM_NAME	VARCHAR2(40),
		TO_		CHAR(1),
		CC_		CHAR(1),
		BCC_		CHAR(1),
		SUBJECT		VARCHAR2(256),
		PRIORITY	NUMBER(2)
);


/* The following script is the modified version */
CREATE TABLE EMAIL_ADDRESS_CONFIGURATION
(
		
		EVENT_CODE	VARCHAR2(10 CHAR) NOT NULL,
		VERSION_NO	NUMBER(10) NOT NULL,
		TO_NAME		VARCHAR2(40 CHAR) NOT NULL,
		TO_ID		VARCHAR2(1000 CHAR),
		FROM_NAME	VARCHAR2(40 CHAR),
		CC_		VARCHAR2(1000 CHAR),
		BCC_		VARCHAR2(1000 CHAR),
		SUBJECT		VARCHAR2(255 CHAR),
		PRIORITY	NUMBER(2)
);





/* Table creation script SMS_ADDRESS_CONFIGURATION */

CREATE TABLE SMS_ADDRESS_CONFIGURATION
(
		EVENT_CODE	VARCHAR2(10) NOT NULL,
		VERSION_NO	NUMBER(10) NOT NULL,
		TO_NAME		VARCHAR2(40) ,
		FROM_NAME	VARCHAR2(40) ,
		CELL_NO		VARCHAR2(15)
);


COMMIT;




	