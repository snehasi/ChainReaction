package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController {
	
	private Main main;
	private Grid1 bo;
	public static Stage yyy;
	
//	Stage thisStage;
//
//	public void setStage (Stage stage){
//	    thisStage = stage;
//	}
	//small grid
	@FXML void gotoscreen2() throws IOException {
		Stage primaryStage=Main.getstage();
		//bo.start(pr);
		Parent loader =FXMLLoader.load(getClass().getResource("/application/Grid1.fxml"));
		Scene scene=new Scene(loader);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
        primaryStage.show();
        yyy=primaryStage;
	}
	public static Stage getstageofgrid1() {
		return yyy;
	}
	//big grid
	@FXML void gotoscreen3() throws IOException {
		Stage primaryStage=Main.getstage();
		//bo.start(pr);
		Parent loader =FXMLLoader.load(getClass().getResource("/application/Grid2.fxml"));
		Scene scene=new Scene(loader);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
        primaryStage.show();
	}
	//settings
	@FXML void gotoscreen21() throws IOException {
		Stage primaryStage=Main.getstage();
		//bo.start(pr);
		Parent loader =FXMLLoader.load(getClass().getResource("/application/Settings.fxml"));
		Scene scene=new Scene(loader);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
        primaryStage.show();
	}
	//resume button
	public void savestate() throws IOException {
		Stage primaryStage=Grid1.getstageee();
		//Scene pp=bo.getscene();
		
		Parent loader =FXMLLoader.load(getClass().getResource("/application/Grid1.fxml"));
		Scene pp=new Scene(loader);
		pp.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(pp);
		primaryStage.sizeToScene();
        primaryStage.show();
	}

}
