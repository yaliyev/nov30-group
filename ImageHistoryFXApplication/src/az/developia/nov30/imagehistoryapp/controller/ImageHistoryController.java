package az.developia.nov30.imagehistoryapp.controller;

import java.io.File;

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
	private void chooseImageButtonClicked(ActionEvent event) {
		FileChooser chooser = new FileChooser();
		File selectedFile = chooser.showOpenDialog(null);
	
		Image image = new Image(selectedFile.getAbsolutePath());
		appImage.setImage(image);
	}

}
