package dao;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DaoFactory {
	
	private static final String DRIVER_PROPERTY = "driver";
	private static final String USER_PROPERTY = "user";
	private static final String PASS_PROPERTY ="pass";
	private static final String URL_PROPERTY = "url"; 

	
	private String driver,user,pass,url;
	private Connection connection ;
	
	
	
	private DaoFactory(String propertyFilePath){
		
		Properties properties = new Properties();
		
		try{
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream propertyStream = classLoader.getResourceAsStream(propertyFilePath);
			properties.load(propertyStream);
			driver = properties.getProperty(DRIVER_PROPERTY);
			user = properties.getProperty(USER_PROPERTY);
			pass = properties.getProperty(PASS_PROPERTY);
			url = properties.getProperty(URL_PROPERTY);
			
			
			Class.forName(driver);
			connection = DriverManager.getConnection(url,user,pass);
			
			
			
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static DaoFactory getInstance(String propertyFilePath){
		return new DaoFactory(propertyFilePath);
	}
	
	public Connection getConnection (){
		return this.connection;
	}
	
	public DaoOfferImplementation getDaoOfferInstance(){
		return new DaoOfferImplementation(this);
	}
	

}
