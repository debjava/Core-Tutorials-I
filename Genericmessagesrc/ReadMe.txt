				GenericMessageModule
				====================

What is it ?
------------

The application name is "GenericMessage" framework.
It provides java based api to send automated mail
and SMS based upon certain criteria. The objective
of this application is that it can be places anywhere
to provide message notification to the end user.

The Latest Version
------------------

Details of the latest version can be found from the
CVS repository

This application has been developped in java1.4 version to provide
the application portability in the higher version of jdk.

Documentation
-------------

Documentation relating to the api can  be found from the
docs directory.
All the Functional and Design specifications may be found
from the documents folder of the application.

Right now ther is no proper document for this application.
In the next release, it is expected to be added to the
document folder.

Project Structure
-----------------

The following describes the detailed description of the project
structure and its relevent files and directories.

GenericMessageModule/
		   .
		   ................. src/*.java
		   .
		   ................. test/*.java
		   .
		   ................. bin/*.class and .properties
		   .
		   ................. images/*.gif
		   .
		   ................. lib/*.jar
		   .
		   ................. configuration/all configuration files
		   .
		   ................. documents/
		   .
		   .........................../ FunctionalSpecification/*.doc
		   .
		   .........................../ DesignSpecification/*.doc
		   .
		   ................. database/*.sql
		   .
		   ................. gnericmessage.xml
		   .
		   ................. build.properties

Description for src directory
-----------------------------

This directory contains all the generic message api related java files.
If new files are added, it should be mentioned here for future development.

The following describes the package structure and the corresponding files

Package Name					File Name
------------					---------

com.iit.core.msg.data.				MessageData.java
com.iit.core.logger.				PMLogFactory.java
com.iit.core.logger.				LoggerUtility.java
com.iit.core.logger.				Logger.java
com.iit.core.logger.				Loggable.java
com.iit.core.logger.				LoggerConstants.java
com.iit.core.message.				FileSizeMoreException.java
com.iit.core.message.				Mailable.java
com.iit.core.message.				ExternalMailer.java
com.iit.core.message				EmailSender.java
com.iit.core.db					SQLProcessor.java
com.iit.core.db					MessageDAO.java
com.iit.core.db					AbstractDAOFactory.java
com.iit.core.db					OracleDAOFactory.java
com.iit.core.db					OracleMessageDAOImpl.java
com.iit.core.common				Common.java
com.iit.core.common				CommonDBConstant.java
com.iit.core.config				SchedulerConfiguration.java
com.iit.core.config				MessageConfiguration.java
com.iit.core.config				DatabaseConfiguration.java
com.iit.core.config				InternalConfiguration.java
com.iit.core.util				DatabaseUtil.java
com.iit.core.util				FileUtil.java
com.iit.core.util				Security.java
com.iit.core.util				DataCollector.java
com.iit.core.bean				SchedulerConfigBean.java
com.iit.core.bean				DatabaseConfigBean.java
com.iit.core.bean				MessageConfigBean.java
com.iit.core.bean				InternalConfigBean.java
com.iit.core.bean				RuntimeTableConfigBean.java
com.iit.core.bean				MailDetailsBean.java
com.iit.core.bean				CellularAddressDetailsBean.java
com.iit.core.bean				MessageConfigTableBean.java
com.iit.core.scheduler				Scheduler.java
com.iit.core.scheduler				DailyScheduler.java
com.iit.core.scheduler				SchedulerTask.java
com.iit.core.loader				JarClassLoader.java
com.iit.core.loader				JarResources.java
com.iit.core.loader				AbstractClassLoader.java
com.iit.core.loader				AbstractLoadderFactory.java
com.iit.core.loader				Loaddable.java
com.iit.core.loader				SampleLoader.java
com.iit.core.data				TemplateData.java
com.iit.core.action				ActionProcessor.java
com.iit.core.ui					UIImages.java
com.iit.core.ui					Mail.java
com.iit.core.ui					ChildSMS.java
com.iit.core.ui					ChildEmail.java
com.iit.core.ui					ChildDBConfig.java
com.iit.core.ui					MailDAO.java
com.iit.core.ui					MailChild.java
com.iit.core.ui					MailBean.java

All the above java files will be explained in the document relating to
design and implementaion.


Description for test directory
-----------------------------

This directory is only meant for unit testing. So far no testing
framework like JUnit has been implemented. Only minimal unit testing
classes have been written to test the functionality.

This directory contain the following java files.

TestSchedulerConfiguration.java
TestScheduler.java
TestDatabaseConfiguration.java
TestMessageConfiguration.java
RoughTesting.java
StopScheduler.java
TestLoader.java

Description for images directory
-----------------------------

This directory contain all the images used in the user interface
development of the application. New images if required should be
added to this directory and README.txt file should be updated.

clear.jpg
mail.gif
mailto.gif
mobile.gif
SaveandClose.jpg


Description for lib directory
-----------------------------

This directory contains all the required third party
java library(.jar) for the developement. New .jar files
if required should be added and README.txt files should be
updated accordingly.

It contains the following jar files

activation.jar
classes12.jar
commons-email-1.0.jar
dsn.jar
imap.jar
log4j.jar
mail.jar
mailapi.jar
pop3.jar
smtp.jar
velocity-1.5.jar
velocity-dep-1.5.jar
ojdbc14.jar
commons-dbcp-1.2.2.jar
commons-beanutils.jar
commons-collections.jar
commons-pool-1.2.jar
javassist.jar
messagedataimpl.jar
xml-apis.jar
ant.jar
xercesImpl.jar

Some of the .jar files have to removed and it should out of the
CVS sync.


Description for bin directory
-----------------------------

This directory contains all the compiled java classes and the required
.properties file.


Description for configuration directory
---------------------------------------

This directory contains all the required configuration files for this
application. If any changes are required in the configuration files,
please maintain the changelog.log file.

applicationlog.properties
mail.properties
run.bat
ui.bat


Description for document directory
----------------------------------

This directory contains all the documents for this application.
This directory has been divided into two major directory as
"FunctionalSpecification" and DesignSpecification" to store
the documents related to the mentioned directory.


Description for database directory
-----------------------------------

This directory contains all the scripts for the 
database related stuffs specific to this application.
It contains all the table creation, drop and insert
script and others related database objects.


Description for genericmessage.xml file
---------------------------------------

This is the application building script which builds the 
entire application and prepares the following directories.

	* docs for java docs of the api
	* genericmessage_dist for third party distribution

To run the build script , open the command prompt and go to
the directory and write ant -f genericmessage.xml.

There is an alternative way also to run the build script.
There is one extra file called build.xml file provided here.
To run it, open the command prompt and go to
the directory and write ant .

Description for build.properties file
---------------------------------------

This file contains the list of .jar files used to create
the coremessageapi.jar. In future, this file may be out of
CVS sync.


Known isues in GenericMessage application
-----------------------------------------

The followings are the known issues found in the first
version of the application.

	*. There is no proper validation in all the UI screens
	

	*. All the config files have to be encrypted but here only 
	   passwords have been encrypted.

	*. All the application specific jar files are not signed jar
	   files, after obtaining the security certificate, jar files
	   will be signed up.

	



