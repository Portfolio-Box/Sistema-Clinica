package ar.com.clinicamedica.dbconection;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbConection {
	private static Connection con = null;
	private static String url;
	private static String usr;
	private static String pwd;
	
	public static Connection getConection() {
		try {
			if (con == null) {
				String driver = "com.mysql.jdbc.Driver"; 
				Class.forName(driver);
				
				try {
					con = createConnection();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Conectado a la DB");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}
	
	private static Connection createConnection() throws Exception {
	  
		final String path = "properties/mysql-properties.xml";
	    Properties prop = new Properties();
	    FileInputStream fis = new FileInputStream(path);
	    prop.loadFromXML(fis);
	    url = prop.getProperty("url");
	    usr = prop.getProperty("user");
	    pwd = prop.getProperty("pass");
	    return DriverManager.getConnection(url, usr, pwd);
	  }
	
	
}
