package az.developia.nov30.imagehistoryapp.controller;

import java.io.File;
import java.time.LocalDate;

import az.developia.nov30.imagehistoryapp.model.ImageModel;
import az.developia.nov30.imagehistoryapp.repository.ImageRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class ImageHistoryController {

	@FXML
	private ImageView appImage;

	@FXML
	private Button chooseImageButton;
	
	@FXML
	private Button historyButton;
	
	private final ImageRepository imageRepository = new ImageRepository();

	@FXML
	private void chooseImageButtonClicked(ActionEvent event) {
		FileChooser chooser = new FileChooser();
		File selectedFile = chooser.showOpenDialog(null);
	
		Image image = new Image(selectedFile.getAbsolutePath());
		appImage.setImage(image);
		
		ImageModel repositoryImage = new ImageModel();
		System.out.println(image.getUrl().toString());
		String pathUrl = image.getUrl().toString();
		
		pathUrl = pathUrl.replace("\\", "\\\\");
		
		repositoryImage.setPath(pathUrl);
		repositoryImage.setInsertDate(LocalDate.now());
		repositoryImage.setTimesUsed(1);
		
		
		imageRepository.insertImage(repositoryImage);
		
	}
	
	@FXML
	private void historyButtonClicked(ActionEvent event) {
		
	}

}
