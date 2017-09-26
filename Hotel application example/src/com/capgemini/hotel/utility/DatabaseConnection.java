package com.capgemini.hotel.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
	
	
	private static Connection con;
	public static Connection getConnection()
	{
		if(con==null)
		{
			Properties prop=new Properties();
			
		String url;
		String username;
		String pwd;
		String driver;
		try {
			FileInputStream fis=new FileInputStream("./resources/jdbc.properties");
			prop.load(fis);
			url=prop.getProperty("url");
			username=prop.getProperty("username");
			pwd=prop.getProperty("pwd");
			driver=prop.getProperty("driver");
			Class.forName(driver);
			con=DriverManager.getConnection(url,username ,pwd);
			System.out.println("Connect with database");
			
		} catch (ClassNotFoundException | SQLException e)
		{
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return con;
		

	}


}
