package ar.com.clinicamedica.validations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class LoginValidation {
	private String path = "properties/passwords.xml";
	private Properties prop;
	private FileInputStream fis;
	private String adminUser;
	private String adminPass;
	private String medicUser;
	private String medicPass;
	private String recepcionistUser;
	private String recepcionistPass;

	public LoginValidation() {
		this.prop = new Properties();

		try {
			this.fis = new FileInputStream(this.path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.prop.loadFromXML(fis);
		} catch (InvalidPropertiesFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.adminUser = prop.getProperty("adminuser");
		this.adminPass = prop.getProperty("adminpass");
		this.medicUser = prop.getProperty("medicuser");
		this.medicPass = prop.getProperty("medicpass");
		this.recepcionistUser = prop.getProperty("recepcionistuser");
		this.recepcionistPass = prop.getProperty("recepcionistpass");
		// TODO Auto-generated constructor stub
	}

	public boolean adminVal(String u, String p) {
		return (u.contentEquals(adminUser) && p.contentEquals(adminPass));
	}

	public boolean recepVal(String u, String p) {
		return (u.contentEquals(recepcionistUser) && p.contentEquals(recepcionistPass));
	}

	public boolean medVal(String u, String p) {
		return (u.contentEquals(medicUser) && p.contentEquals(medicPass));
	}

}
