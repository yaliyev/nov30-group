package az.developia.nov30.imagehistoryapp.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import az.developia.nov30.imagehistoryapp.model.ImageModel;
import az.developia.nov30.imagehistoryapp.repository.ImageRepository;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ImageHistoryWindowController implements Initializable{

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
    
    private ImageRepository imageRepository  = new ImageRepository();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		imagesTableView.setItems(imageRepository.findAllImages());
		
		idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		pathCol.setCellValueFactory(new PropertyValueFactory<>("path"));
		insertDateCol.setCellValueFactory(new PropertyValueFactory<>("insertDate"));
		timesUsedCol.setCellValueFactory(new PropertyValueFactory<>("timesUsed"));
	}

}
