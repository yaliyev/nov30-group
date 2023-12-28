package az.developia.nov30.studentregister.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import az.developia.nov30.studentregister.connection.DatabaseConnection;
import az.developia.nov30.studentregister.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StudentRepository {

	private Connection conn;
	
	public void addStudent(Student student) {
		
		conn = DatabaseConnection.connect();
		
		if(conn != null) {
			try {

//				Statement statement2 = conn.createStatement();
//				
//				statement2.execute("INSERT INTO studentsapp_students (name,surname,university,education_field,course) VALUES ("+ student.getName() +","+ student.getSurname() +","+ student.getUniversity() +","+ student.getEducationField() +","+ student.getCourse() +") ");
				
				
				PreparedStatement statement = conn.prepareStatement("INSERT INTO studentsapp_students (name,surname,university,education_field,course,passed_exam) VALUES (?,?,?,?,?,?) ");
				
				statement.setString(1, student.getName());
				statement.setString(2, student.getSurname());
				statement.setString(3, student.getUniversity());
				statement.setString(4,student.getEducationField());
				statement.setInt(5, student.getCourse());
				statement.setString(6, student.getPassedExam());
				
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
	
	public ObservableList<Student> getStudents() {
		
		ObservableList<Student> list = FXCollections.observableArrayList();
		
		conn = DatabaseConnection.connect();
		
		try {
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM studentsapp_students");
			
			ResultSet studentsRS = statement.executeQuery();
			
			System.out.println("Students have been read");
			
			while(studentsRS.next()) {
				
				Student student = new Student(); // bosh bir student yaradilir ki,gelecekde resultsetdeki
				                                 // data bir bir studentin propertylerine set edile bilinsin
				student.setId(studentsRS.getInt("id"));
				student.setName(studentsRS.getString("name"));
				student.setSurname(studentsRS.getString("surname"));
				student.setUniversity(studentsRS.getString("university"));
				student.setEducationField(studentsRS.getString("education_field"));
				student.setCourse(studentsRS.getInt("course"));
				student.setPassedExam(studentsRS.getString("passed_exam"));
				
				list.add(student);
				
			}
			
			studentsRS.close();
			statement.close();
			conn.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public void updateStatus(Integer whereINeedToChangeStudentId,String status) {
		conn = DatabaseConnection.connect();
		
		try {
			PreparedStatement statement = conn.prepareStatement("UPDATE studentsapp_students SET passed_exam = ? WHERE id = ?");
			
			statement.setString(1, status);
			statement.setInt(2, whereINeedToChangeStudentId);
			
			statement.executeUpdate();
			
			System.out.println("Student has been updated");
			
			statement.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void deleteStudent(Integer whereINeedToDeleteStudentId) {
		conn = DatabaseConnection.connect();
		
		try {
			PreparedStatement statement = conn.prepareStatement("DELETE FROM studentsapp_students  WHERE id = ?");
			
			statement.setInt(1, whereINeedToDeleteStudentId);
			
			statement.executeUpdate();
			
			System.out.println("Student has been deleted");
			
			statement.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void deleteAllStudents() {
		conn = DatabaseConnection.connect();
		
		try {
			PreparedStatement statement = conn.prepareStatement("TRUNCATE studentsapp_students");
			
			
			statement.executeUpdate();
			
			System.out.println("All students have been deleted");
			
			statement.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
