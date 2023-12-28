package az.developia.nov30.studentregister.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import az.developia.nov30.studentregister.connection.DatabaseConnection;
import az.developia.nov30.studentregister.model.Student;

public class StudentRepository {

	private Connection conn;
	
	public void addStudent(Student student) {
		
		conn = DatabaseConnection.connect();
		
		if(conn != null) {
			try {

//				Statement statement2 = conn.createStatement();
//				
//				statement2.execute("INSERT INTO studentsapp_students (name,surname,university,education_field,course) VALUES ("+ student.getName() +","+ student.getSurname() +","+ student.getUniversity() +","+ student.getEducationField() +","+ student.getCourse() +") ");
				
				
				PreparedStatement statement = conn.prepareStatement("INSERT INTO studentsapp_students (name,surname,university,education_field,course) VALUES (?,?,?,?,?) ");
				
				statement.setString(1, student.getName());
				statement.setString(2, student.getSurname());
				statement.setString(3, student.getUniversity());
				statement.setString(4,student.getEducationField());
				statement.setInt(5, student.getCourse());
				
				statement.execute();
				
				System.out.println("Student has been added");
				
				statement.close();
				conn.close();
				
				
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
}
