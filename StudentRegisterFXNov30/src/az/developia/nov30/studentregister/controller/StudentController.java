package az.developia.nov30.studentregister.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import az.developia.nov30.studentregister.model.Student;
import az.developia.nov30.studentregister.repository.StudentRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class StudentController implements Initializable {

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
	private Button deleteStudentButton;
	
	@FXML
	private Button changeStatusButton;

	@FXML
	private Label warningsLabel;
	
	@FXML
	private CheckBox allSelectedCheckBox;
	
	@FXML
	private TableView<Student> studentsTableView;

	@FXML
	private TableColumn<Student, Integer> idColumn;

	@FXML
	private TableColumn<Student, String> nameColumn;

	@FXML
	private TableColumn<Student, String> passedExamColumn;

	@FXML
	private TableColumn<Student, String> surnameColumn;

	@FXML
	private TableColumn<Student, String> universityColumn;
	
	@FXML
	private TableColumn<Student, Integer> courseColumn;
	
	@FXML
	private TableColumn<Student, String> educationFieldColumn;

	private final StudentRepository studentRepository = new StudentRepository();
	
	@FXML
	private void changeStatusButtonClicked(ActionEvent event) {
		Student selectedStudent = studentsTableView.getSelectionModel().getSelectedItem();
		
		if(selectedStudent != null) {
			System.out.println(selectedStudent);
			if(selectedStudent.getPassedExam().equals("Keçməyib")) {
				selectedStudent.setPassedExam("Keçib");
			}else {
				selectedStudent.setPassedExam("Keçməyib");
			}
			studentRepository.updateStatus(selectedStudent.getId(), selectedStudent.getPassedExam());
			loadStudents();
		}
		
	}

	@FXML
	private void addStudentButtonClicked(ActionEvent event) {
		String name = nameTextField.getText();
		String surname = surnameTextField.getText();
		String university = universityTextField.getText();
		String educationField = educationFieldComboBox.getValue();
		String courseString = courseTextField.getText(); // getText() -> string
		Integer course = 0;
		if (courseString.isBlank() == false) {
			course = Integer.parseInt(courseString);
		}

		if (name.trim().length() > 0 && surname.trim().length() > 0 && university.trim().length() > 0
				&& educationField.trim().length() > 0 && course > 0) {
			Student student = new Student(name, surname, university, educationField, course);
			studentRepository.addStudent(student);
			warningsLabel.setText("Hələki heç nə yoxdur");
			loadStudents();
		} else {
			warningsLabel.setText("Daxil edilən tələbə məlumatları formata uyğun deyil");
		}

	}
	
	@FXML
	private void deleteStudentButtonClicked(ActionEvent event) {
		Student selectedStudent = studentsTableView.getSelectionModel().getSelectedItem();
		
		if(allSelectedCheckBox.isSelected()) {
			int result = JOptionPane.showConfirmDialog(null,"Həqiqətən də bütün  tələbələrin silinməsinə razısınızmı?"
       				,"Təsdiqlə",JOptionPane.YES_NO_OPTION);
			if(result == 0) {
				studentRepository.deleteAllStudents();
				loadStudents();
			}
		}else {
			if(selectedStudent != null) {
	       		int result = JOptionPane.showConfirmDialog(null,"Həqiqətən də "+selectedStudent.getName() + " " + selectedStudent.getSurname() + " adında olan tələbəni silmək istəyirsiniz?"
	       				,"Təsdiqlə",JOptionPane.YES_NO_OPTION);
	       		if(result == 0) {
	    			studentRepository.deleteStudent(selectedStudent.getId());
	    			loadStudents();
	       		}
			}
		}
		
		
	}
	
	@FXML
	private void studentsTableViewMouseClicked(MouseEvent event) {
		Student selectedStudent = studentsTableView.getSelectionModel().getSelectedItem();
		
		if(selectedStudent != null) {
			 nameTextField.setText(selectedStudent.getName());
			 surnameTextField.setText(selectedStudent.getSurname());
			 universityTextField.setText(selectedStudent.getUniversity());
			 educationFieldComboBox.setValue(selectedStudent.getEducationField());
			 courseTextField.setText(selectedStudent.getCourse().toString()); 
		}
		
	}
	
	public void loadStudents() {
		studentsTableView.setItems(studentRepository.getStudents());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		educationFieldComboBox.getItems().add("IT");
		educationFieldComboBox.getItems().add("Tibb");
		educationFieldComboBox.getItems().add("Mühasibatlıq");
		educationFieldComboBox.getItems().add("Hüquq");
		educationFieldComboBox.getItems().add("Neft qaz mühəndisliyi");

		idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
		universityColumn.setCellValueFactory(new PropertyValueFactory<>("university"));
		educationFieldColumn.setCellValueFactory(new PropertyValueFactory<>("educationField"));
		courseColumn.setCellValueFactory(new PropertyValueFactory<>("course"));
		passedExamColumn.setCellValueFactory(new PropertyValueFactory<>("passedExam"));
		
		loadStudents();

	}

}
