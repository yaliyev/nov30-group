package az.developia.nov30.studentregister.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import az.developia.nov30.studentregister.model.Student;
import az.developia.nov30.studentregister.repository.StudentRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class StudentController implements Initializable{

	@FXML
	private TextField nameTextField;
	
	@FXML
	private TextField surnameTextField;
	
	@FXML
	private TextField universityTextField;
	
	@FXML
	private ComboBox<String> educationFieldComboBox;
	
	@FXML
	private TextField courseTextField;
	
	// CTRL + SHIFT + O
	@FXML
	private Button addStudentButton;
	
	@FXML
	private Label warningsLabel;
	
	private final StudentRepository studentRepository = new StudentRepository();
	
	@FXML
	private void addStudentButtonClicked(ActionEvent event) {
		String name = nameTextField.getText();
		String surname = surnameTextField.getText();
		String university = universityTextField.getText();
		String educationField = educationFieldComboBox.getValue();
		String courseString = courseTextField.getText(); // getText() -> string
		Integer course = 0;
	    if(courseString.isBlank() == false) {
	    	course = Integer.parseInt(courseString);
	    }
		
		if(name.trim().length() > 0 && surname.trim().length() > 0 && university.trim().length() > 0 && educationField.trim().length() > 0 &&  course > 0 ) {
			Student student = new Student(name, surname, university, educationField, course);
			studentRepository.addStudent(student);
			warningsLabel.setText("Hələki heç nə yoxdur");
		}else {
			warningsLabel.setText("Daxil edilən tələbə məlumatları formata uyğun deyil");
		}
		
		

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		educationFieldComboBox.getItems().add("IT");
		educationFieldComboBox.getItems().add("Tibb");
		educationFieldComboBox.getItems().add("Mühasibatlıq");
		educationFieldComboBox.getItems().add("Hüquq");
		educationFieldComboBox.getItems().add("Neft qaz mühəndisliyi");
		
	    System.out.println(studentRepository.getStudents());
		
	}
	
	
}
