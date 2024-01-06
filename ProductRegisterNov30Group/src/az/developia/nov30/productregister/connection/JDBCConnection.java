package az.developia.nov30.productregister.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
 private static final String URL = "jdbc:mysql://localhost/nov30_23";
 private static final String USERNAME = "root";
 private static final String PASSWORD = "1234";
 private static Connection conn;
 
 public static Connection  connect() {
	 try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	try {
		conn =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
		System.out.println("Connected successfully!");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	 
	 return conn;
 }
 

 
}
