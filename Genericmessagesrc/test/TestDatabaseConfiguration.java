import java.util.Properties;

import org.apache.log4j.Logger;

import com.iit.core.bean.DatabaseConfigBean;
import com.iit.core.config.DatabaseConfiguration;

public class TestDatabaseConfiguration 
{
	protected static Logger logger = Logger.getLogger( TestDatabaseConfiguration.class );
	public static void main(String[] args) 
	{

		DatabaseConfigBean dbConfBean = new DatabaseConfigBean();
//		dbConfBean.setDbName("oracle");
//		dbConfBean.setDbUserName("basepmdev");
//		dbConfBean.setDbPassword("basepmdev");
//		dbConfBean.setDbServerIP("idealweb02");
//		dbConfBean.setDbServerPort("1521");
//		dbConfBean.setDbSID("invent");

		dbConfBean.setDbName("oracle");
		dbConfBean.setDbUserName("dmcheck");
		dbConfBean.setDbPassword("dmcheck");
		dbConfBean.setDbServerIP("idealdb01");
		dbConfBean.setDbServerPort("1521");
		dbConfBean.setDbSID("ideal");

		Properties prop = new Properties();
		prop.put("DATABASENAME", dbConfBean.getDbName());//Mandatory
		prop.put("USERNAME", dbConfBean.getDbUserName());//Mandatory
		prop.put("PASSWORD", dbConfBean.getEncryptedPWD());
		prop.put("DATABASE_SERVER_PORT", "1521");//Mandatory
		prop.put("DATABASE_SERVER_IP", dbConfBean.getDbServerIP());//Mandatory
		prop.put("DATABASE_SID", dbConfBean.getDbSID());//Mandatory
		DatabaseConfiguration.storeConfigDetails( prop );

		logger.info("Database config file created successfully ...");
	}
}
