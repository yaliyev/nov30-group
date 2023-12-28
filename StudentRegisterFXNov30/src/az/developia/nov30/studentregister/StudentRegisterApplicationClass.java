package az.developia.nov30.studentregister;

import java.io.IOException;

import az.developia.nov30.studentregister.connection.DatabaseConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StudentRegisterApplicationClass extends Application{
  public static void main(String[] args) {
   launch(args);	
   DatabaseConnection.connect();
}

@Override
public void start(Stage stage1)  {
	 try {
		AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("az/developia/nov30/studentregister/view/studentregister.fxml"));
		Scene scene = new Scene(pane);
		
		stage1.setScene(scene);
		
		stage1.setTitle("Student Register App");
		stage1.setResizable(false);
		stage1.show();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
}
}
