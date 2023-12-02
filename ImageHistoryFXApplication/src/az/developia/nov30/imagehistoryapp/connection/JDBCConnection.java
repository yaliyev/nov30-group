package az.developia.nov30.imagehistoryapp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
 // db_url,username,password
 private static final String URL = "jdbc:mysql://localhost/nov30_23";
 private static final String USERNAME = "root";
 private static final String PASSWORD = "1234";
 
 private static Connection conn;
 
 public static Connection connect() {
	 try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		
		System.out.println("Connected to database!!!");
		
		
		
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	 
	 return conn;
 }
 

}
