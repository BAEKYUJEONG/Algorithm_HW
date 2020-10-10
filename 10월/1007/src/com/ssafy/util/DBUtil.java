package com.ssafy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {

    public static Connection getConnection(){
      Connection conn=null;
      try {
		  Context ctx = new InitialContext();
		  DataSource dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql");
		  conn = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
      return conn;
    }//getConnection
    
    public static void close(AutoCloseable ac) {
    	try {
			if(ac != null)ac.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }//close
	
}



