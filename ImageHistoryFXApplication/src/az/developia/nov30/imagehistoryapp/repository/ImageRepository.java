package az.developia.nov30.imagehistoryapp.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import az.developia.nov30.imagehistoryapp.connection.JDBCConnection;
import az.developia.nov30.imagehistoryapp.model.ImageModel;

public class ImageRepository {
	
	private Connection conn;
	
  public void insertImage(ImageModel image) {
	   conn = JDBCConnection.connect();
	   
	   try {
		String query  = "INSERT images (path,insert_date,times_used) VALUES ('"+image.getPath()+"','"+Date.valueOf(image.getInsertDate())+"',"+image.getTimesUsed()+")";
		
		
		   
		Statement statement = conn.createStatement();
		statement.execute(query);
		System.out.println("INSERT: Image");
		
		statement.close();
		conn.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   
  }
}
