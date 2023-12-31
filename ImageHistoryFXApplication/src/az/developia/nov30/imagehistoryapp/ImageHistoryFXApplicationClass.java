package az.developia.nov30.imagehistoryapp;

import java.io.IOException;

import az.developia.nov30.imagehistoryapp.connection.JDBCConnection;
import az.developia.nov30.imagehistoryapp.repository.ImageRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ImageHistoryFXApplicationClass extends Application{

	public static Stage globalMainStage = null;
	
public static void main(String[] args) {
  	launch(args);
}

@Override
public void start(Stage stage) {
	try {
		
		AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("az/developia/nov30/imagehistoryapp/view/app.fxml"));
	    Scene scene = new Scene(pane);
	    stage.setScene(scene);
	    stage.setTitle("ImageHistory Application");
	    
	    globalMainStage = stage;
	    
	    stage.show();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
