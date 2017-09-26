package com.cg.orb.dbutil;

import java.io.FileReader;
	import java.io.IOException;
	import java.sql.*;
	import java.util.Properties;
	public class DBUtil 
	{
		public static Connection getConnection() throws IOException, SQLException
		{
			Connection conn=null;
			Properties prop=readInfo();
			String url=prop.getProperty("url");
			String userName=prop.getProperty("userName");
			String password=prop.getProperty("password");
			conn=DriverManager.getConnection(url,userName,password);
			return conn;
			
		}
		private static Properties readInfo() throws IOException
		{
			Properties p= new Properties();
			FileReader fr= new FileReader("dbInfo.properties");
			p.load(fr);
			
			return p;

		}
		
		}
		
	


