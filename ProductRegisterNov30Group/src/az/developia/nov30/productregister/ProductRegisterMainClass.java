package az.developia.nov30.productregister;

import java.io.IOException;

import az.developia.nov30.productregister.connection.JDBCConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ProductRegisterMainClass extends Application{
	public static void main(String[] args) {
		launch(args);
		JDBCConnection.connect();
	}

	@Override
	public void start(Stage stage)  {
		try {
			AnchorPane pane  = FXMLLoader.load(getClass().getClassLoader().getResource("az/developia/nov30/productregister/view/product.fxml"));
			Scene scene = new Scene(pane);
			stage.setScene(scene);
			stage.setTitle("Product Register App Nov30 Group");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	
}
