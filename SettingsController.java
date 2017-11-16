package application;

import java.io.IOException;

import com.sun.javafx.scene.control.skin.CustomColorDialog;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class SettingsController {
	public Stage yy;
	public PlayerSettings p;
	private MainController maincont;
	@FXML
	private Rectangle rect;
	@FXML void gotoplayersettings() throws IOException {
		Stage primaryStage=Main.getstage();
		//bo.start(pr);
		Parent loader =FXMLLoader.load(getClass().getResource("/application/playersettings.fxml"));
		Scene scene=new Scene(loader);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
        primaryStage.show();
        //yy =  primaryStage;
	}
	//back to main from settings
	public void backtomainfromsettings() throws IOException {
		Stage primaryStage=Main.getstage();
		//bo.start(pr);
		Parent loader =FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
		Scene scene=new Scene(loader);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		 
        primaryStage.show();
        
	}
	//back to grid 1 from settings 
	public void backtogrid1fromsettings() throws IOException {
		Stage primaryStage=maincont.getstageofgrid1();
		//bo.start(pr);
		Parent loader =FXMLLoader.load(getClass().getResource("/application/Grid1.fxml"));
		Scene scene=new Scene(loader);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("New Settings will be applied from new game!");

		alert.showAndWait();
		 
        primaryStage.show();
        
	}
	public void backtosettingsfromplaysettings() throws IOException {
		Stage primaryStage=Main.getstage();
		//bo.start(pr);
		Parent loader =FXMLLoader.load(getClass().getResource("/application/Settings.fxml"));
		Scene scene=new Scene(loader);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
        primaryStage.show();
	}
	//////
	@FXML
	private ColorPicker colorPick;
	//public Color c;
	//color -- colorPick , soundeffect, vibration
	Color c;
	public void getcolorfromplaysettings() {
		colorPick.setOnAction(new EventHandler() {
		    public void handle(Event t) {
		        c = colorPick.getValue();
		        
		    }

			
		});
		System.out.println(c);
	}
	
}
