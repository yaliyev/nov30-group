package az.developia.nov30.studentregister.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import az.developia.nov30.studentregister.connection.DatabaseConnection;
import az.developia.nov30.studentregister.model.EducationField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class EducationFieldRepository {
 
	private Connection conn;
	
	
	public void addEducationField(EducationField educationField) {
		conn = DatabaseConnection.connect();
		
		try {
			PreparedStatement statement = conn.prepareStatement("INSERT INTO studentsapp_educationfields(education_field) VALUES (?)");
			
			statement.setString(1, educationField.getEducationField());
			
			statement.executeUpdate();
			
			System.out.println("Education field has been inserted");
			
			statement.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteEducationField(String educationField) {
		conn = DatabaseConnection.connect();
		
		try {
			PreparedStatement statement = conn.prepareStatement("DELETE FROM studentsapp_educationfields WHERE education_field = ?");
			
			statement.setString(1, educationField);
			
			statement.execute();
			
			System.out.println("Education field has been deleted");
			
			statement.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteAllEducationFields() {
		conn = DatabaseConnection.connect();
		
		try {
			PreparedStatement statement = conn.prepareStatement("TRUNCATE studentsapp_educationfields");
			
			statement.execute();
			
			System.out.println("All education fields have been deleted");
			
			statement.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ObservableList<EducationField> getAllEducationFields(){
		ObservableList<EducationField> list = FXCollections.observableArrayList();
		
		conn = DatabaseConnection.connect();
		
		try {
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM studentsapp_educationfields");
			
			ResultSet rs =  statement.executeQuery();
			
			while(rs.next()) {
				EducationField educationField = new EducationField(rs.getString("education_field"));
				
				list.add(educationField);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
