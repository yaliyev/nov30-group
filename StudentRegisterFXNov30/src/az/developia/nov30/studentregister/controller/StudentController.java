package az.developia.nov30.studentregister.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import az.developia.nov30.studentregister.model.EducationField;
import az.developia.nov30.studentregister.model.Student;
import az.developia.nov30.studentregister.repository.EducationFieldRepository;
import az.developia.nov30.studentregister.repository.StudentRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class StudentController implements Initializable {

	@FXML
	private TextField nameTextField;

	@FXML
	private TextField surnameTextField;

	@FXML
	private TextField universityTextField;

	@FXML
	private ComboBox<EducationField> educationFieldComboBox;

	@FXML
	private TextField courseTextField;
	
	@FXML
	private TextField searchTextField;

	// CTRL + SHIFT + O
	@FXML
	private Button addStudentButton;

	@FXML
	private Button editStudentButton;

	@FXML
	private Button deleteStudentButton;

	@FXML
	private Button changeStatusButton;

	@FXML
	private Button addEducationFieldButton;

	@FXML
	private Button deleteEducationFieldButton;

	@FXML
	private Button resetFormButton;

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
	
	@FXML
	private RadioButton allSelectedRadioButton;
	
	@FXML
	private RadioButton studentsWhoPassedExamRadioButton;
	
	@FXML
	private RadioButton studentsWhoNotPassedExamRadioButton;

	private final StudentRepository studentRepository = new StudentRepository();

	private final EducationFieldRepository educationFieldRepository = new EducationFieldRepository();
	
	@FXML
	private void passedExamRadioButtonClicked(ActionEvent event) {
		RadioButton clickedRadioButton = (RadioButton) event.getTarget();
		if(clickedRadioButton.getText().equals("Hamısı")) {
			loadStudents();
		}else if(clickedRadioButton.getText().equals("İmtahandan keçənlər")) {
			searchStudents("Keçib");
		}else {
			searchStudents("Keçməyib");
		}
	}

	@FXML
	private void addEducationFieldButtonClicked(ActionEvent event) {
		String educationFieldName = JOptionPane.showInputDialog("İxtisas adını daxil edin");

		if (educationFieldName != null) {
			educationFieldRepository.addEducationField(new EducationField(educationFieldName));
			;

			loadEducationFields();
		}

	}

	@FXML
	private void deleteEducationFieldButtonClicked(ActionEvent event) {
		EducationField selectedEducationField = educationFieldComboBox.getSelectionModel().getSelectedItem();

		if (allSelectedCheckBox.isSelected()) {
			int result = JOptionPane.showConfirmDialog(null,
					"Həqiqətən də bütün ixtisasları silmək istəyirsiniz?", "Təsdiqlə",
					JOptionPane.YES_NO_OPTION);

			if (result == 0) {
				educationFieldRepository.deleteAllEducationFields();
				loadEducationFields();
			}
		} else {
			if (selectedEducationField != null) {
				int result = JOptionPane.showConfirmDialog(null,
						"Həqiqətən də " + selectedEducationField + " adında olan ixtisası silmək istəyirsiniz?",
						"Təsdiqlə", JOptionPane.YES_NO_OPTION);

				if (result == 0) {
					educationFieldRepository.deleteEducationField(selectedEducationField.toString());
					loadEducationFields();
				}
			}
		}

	}

	@FXML
	private void changeStatusButtonClicked(ActionEvent event) {
		Student selectedStudent = studentsTableView.getSelectionModel().getSelectedItem();

		if (selectedStudent != null) {
			System.out.println(selectedStudent);
			if (selectedStudent.getPassedExam().equals("Keçməyib")) {
				selectedStudent.setPassedExam("Keçib");
			} else {
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
		EducationField educationField = educationFieldComboBox.getValue();
		String courseString = courseTextField.getText(); // getText() -> string
		Integer course = 0;
		if (courseString.isBlank() == false) {
			course = Integer.parseInt(courseString);
		}

		if (name.trim().length() > 0 && surname.trim().length() > 0 && university.trim().length() > 0
				&& educationField.toString().length() > 0 && course > 0) {
			Student student = new Student(name, surname, university, educationField, course);
			studentRepository.addStudent(student);
			warningsLabel.setText("Hələki heç nə yoxdur");
			loadStudents();
			resetForm();
		} else {
			warningsLabel.setText("Daxil edilən tələbə məlumatları formata uyğun deyil");
		}

	}

	@FXML
	private void editStudentButtonClicked(ActionEvent event) {

		Student selectedStudent = studentsTableView.getSelectionModel().getSelectedItem();

		String name = nameTextField.getText();
		String surname = surnameTextField.getText();
		String university = universityTextField.getText();
		EducationField educationField = educationFieldComboBox.getValue();
		String courseString = courseTextField.getText(); // getText() -> string
		Integer course = 0;

		if (!courseString.isBlank()) {
			course = Integer.parseInt(courseString);
		}
		if (name.trim().length() > 0 && surname.trim().length() > 0 && university.trim().length() > 0
				&& educationField.toString().trim().length() > 0 && course > 0) {

			Student student = new Student(name, surname, university, educationField, course);

			studentRepository.updateStudent(selectedStudent.getId(), student);
			warningsLabel.setText("Hələki heç nə yoxdur");
			loadStudents();
			resetForm();
		} else {
			warningsLabel.setText("Daxil edilən tələbə məlumatları formata uyğun deyil");
		}
	}

	@FXML
	private void deleteStudentButtonClicked(ActionEvent event) {
		Student selectedStudent = studentsTableView.getSelectionModel().getSelectedItem();

		if (allSelectedCheckBox.isSelected()) {
			int result = JOptionPane.showConfirmDialog(null, "Həqiqətən də bütün  tələbələrin silinməsinə razısınızmı?",
					"Təsdiqlə", JOptionPane.YES_NO_OPTION);
			if (result == 0) {
				studentRepository.deleteAllStudents();
				loadStudents();
			}
		} else {
			if (selectedStudent != null) {
				int result = JOptionPane
						.showConfirmDialog(null,
								"Həqiqətən də " + selectedStudent.getName() + " " + selectedStudent.getSurname()
										+ " adında olan tələbəni silmək istəyirsiniz?",
								"Təsdiqlə", JOptionPane.YES_NO_OPTION);
				if (result == 0) {
					studentRepository.deleteStudent(selectedStudent.getId());
					loadStudents();
				}
			}
		}
		resetForm();

	}
	
	@FXML
	private void searchTextFieldKeyReleased(KeyEvent event) {
		searchStudents(searchTextField.getText());
	}

	@FXML
	private void resetFormButtonClicked(ActionEvent event) {
		resetForm();
	}

	@FXML
	private void studentsTableViewMouseClicked(MouseEvent event) {
		Student selectedStudent = studentsTableView.getSelectionModel().getSelectedItem();

		if (selectedStudent != null) {
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

	public void loadEducationFields() {
		educationFieldComboBox.setItems(educationFieldRepository.getAllEducationFields());
	}

	public void searchStudents(String search) {
		studentsTableView.setItems(studentRepository.searchStudents(search));
	}
	
	public void resetForm() {
		nameTextField.setText("");
		surnameTextField.setText("");
		universityTextField.setText("");
		educationFieldComboBox.setValue(null);
		courseTextField.setText("");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		educationFieldComboBox.getItems().add("IT");
//		educationFieldComboBox.getItems().add("Tibb");
//		educationFieldComboBox.getItems().add("Mühasibatlıq");
//		educationFieldComboBox.getItems().add("Hüquq");
//		educationFieldComboBox.getItems().add("Neft qaz mühəndisliyi");

		idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
		universityColumn.setCellValueFactory(new PropertyValueFactory<>("university"));
		educationFieldColumn.setCellValueFactory(new PropertyValueFactory<>("educationField"));
		courseColumn.setCellValueFactory(new PropertyValueFactory<>("course"));
		passedExamColumn.setCellValueFactory(new PropertyValueFactory<>("passedExam"));

		loadStudents();

		loadEducationFields();

	}

}
