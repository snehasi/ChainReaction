package application;
	
import java.io.IOException;

import javax.print.DocFlavor.URL;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	static Stage xx = new Stage();
	@Override
	public void start(Stage primaryStage) throws IOException
	{
		Parent loader =FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
		Scene scene=new Scene(loader);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
        primaryStage.show();
        xx=primaryStage;
        
	}
	public static Stage getstage()
	{
		return xx;
	}
	
//	@Override
//	public void start(Stage stage) throws Exception {
//	    java.net.URL location = getClass().getResource("/application/Main.fxml");
//	    FXMLLoader fxmlLoader = new FXMLLoader();
//	    fxmlLoader.setLocation(location);
//	    fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
//	    Parent root = (Parent) fxmlLoader.load(location.openStream());
//	    Scene scene = new Scene(root);
//	    stage.setScene(scene);
//	    MainController mainController = fxmlLoader.getController();
//	    mainController.setStage(stage);
//	    mainController.gotoscreen2();
//	}
//	
	public static void main(String[] args) {
		launch(args);
	}
}