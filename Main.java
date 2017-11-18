package application;
	
import java.io.IOException;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.collections.FXCollections;
import java.lang.String;


public class Main extends Application implements Initializable {
	static Stage xx = new Stage();
	
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
	@FXML
	private ComboBox<String> playerr;
	ObservableList<String> options = 
		    FXCollections.observableArrayList(
		        "2 Player Game",
		        "3 Player Game",
		        "4 Player Game",
		        "5 Player Game",
		        "6 Player Game",
		        "7 Player Game",
		        "8 Player Game"
		    );
	
	
	

	
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
	
	
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void initialize(java.net.URL location, ResourceBundle resources) {
		playerr.setItems(options);// TODO Auto-generated method stub
		
	}
}
