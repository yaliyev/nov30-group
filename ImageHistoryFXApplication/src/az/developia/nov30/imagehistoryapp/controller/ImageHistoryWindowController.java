package az.developia.nov30.imagehistoryapp.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import az.developia.nov30.imagehistoryapp.ImageHistoryFXApplicationClass;
import az.developia.nov30.imagehistoryapp.model.ImageModel;
import az.developia.nov30.imagehistoryapp.repository.ImageRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ImageHistoryWindowController implements Initializable{
	
	public static Stage historyTableStageGlobal = null; 

	@FXML
    private TableColumn<ImageModel, Integer> idCol;

    @FXML
    private TableColumn<ImageModel, LocalDate> insertDateCol;

    @FXML
    private TableColumn<ImageModel, String> pathCol;

    @FXML
    private TableColumn<ImageModel, Integer> timesUsedCol;
    
    @FXML
    private TableView<ImageModel> imagesTableView;
    
    @FXML
    private Button backButton;
    
    @FXML
    private Button deleteButton;
    
    private ImageRepository imageRepository  = new ImageRepository();
    
    @FXML
    private void backButtonClicked(ActionEvent event) {
    	historyTableStageGlobal.hide();
    	ImageHistoryFXApplicationClass.globalMainStage.show();
    }
    
    @FXML
    private void deleteButtonClicked(ActionEvent event) {
      ImageModel selectedImage = imagesTableView.getSelectionModel().getSelectedItem();
      
      imageRepository.deleteImage(selectedImage.getId());
      
      loadImages();
      
      
    }
    
    private void loadImages() {
    	imagesTableView.setItems(imageRepository.findAllImages());
    }
    
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadImages();
		
		idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		pathCol.setCellValueFactory(new PropertyValueFactory<>("path"));
		insertDateCol.setCellValueFactory(new PropertyValueFactory<>("insertDate"));
		timesUsedCol.setCellValueFactory(new PropertyValueFactory<>("timesUsed"));
	}

}
