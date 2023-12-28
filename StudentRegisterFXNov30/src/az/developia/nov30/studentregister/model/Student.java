package az.developia.nov30.studentregister.model;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Student {
	
	private Integer id;
	
	private String name;
	
	
	private String surname;
	
	
	private String university;
	
	
	private String educationField; 
	
	
	private Integer course;
	
	private String passedExam;


	public Student() {
		
	}

	

	



	public Student(String name, String surname, String university, String educationField, Integer course) {
		this.name = name;
		this.surname = surname;
		this.university = university;
		this.educationField = educationField;
		this.course = course;
		this.passedExam = "Keçməyib";
	}



	




	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}







	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getUniversity() {
		return university;
	}


	public void setUniversity(String university) {
		this.university = university;
	}


	

	public String getEducationField() {
		return educationField;
	}

	public void setEducationField(String educationField) {
		this.educationField = educationField;
	}


    




	public String getPassedExam() {
		return passedExam;
	}







	public void setPassedExam(String passedExam) {
		this.passedExam = passedExam;
	}







	public Integer getCourse() {
		return course;
	}


	public void setCourse(Integer course) {
		this.course = course;
	}







	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", surname=" + surname + ", university=" + university
				+ ", educationField=" + educationField + ", course=" + course + ", passedExam=" + passedExam + "]";
	}


	
//	
	
}
