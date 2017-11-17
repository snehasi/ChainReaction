package application;
	
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Settings extends Application 
{
	ArrayList<Player> p=new ArrayList<Player>();
	Stage x=new Stage();
	
	@Override
	public void start(Stage primaryStage) throws IOException
	{
		Parent loader =FXMLLoader.load(getClass().getResource("/application/Settings.fxml"));
		Scene scene=new Scene(loader);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
        primaryStage.show();
        x=primaryStage;
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	public Stage yy;
	
	private Main maincont;
	@FXML
	private ColorPicker colorPick1;
	@FXML
	private ColorPicker colorPick2;
	@FXML
	private ColorPicker colorPick3;
	@FXML
	private ColorPicker colorPick4;
	@FXML
	private ColorPicker colorPick5;
	@FXML
	private ColorPicker colorPick6;
	@FXML
	private ColorPicker colorPick7;
	@FXML
	private ColorPicker colorPick8;

	//public Color c;
	//color -- colorPick , soundeffect, vibration
	Color c;
	public Color getcolorfromplaysettings() {
		
		colorPick1.setOnAction(new EventHandler() {
		    public void handle(Event t) {
		        c = colorPick1.getValue();
		        System.out.println(c);
				
		    }
		});
		colorPick2.setOnAction(new EventHandler() {
		    public void handle(Event t) {
		        c = colorPick2.getValue();
		        System.out.println(c);
				
		    }
		});
		colorPick3.setOnAction(new EventHandler() {
		    public void handle(Event t) {
		        c = colorPick3.getValue();
		        System.out.println(c);
				
		    }
		});
		colorPick4.setOnAction(new EventHandler() {
		    public void handle(Event t) {
		        c = colorPick4.getValue();
		        System.out.println(c);
				
		    }
		});
		colorPick5.setOnAction(new EventHandler() {
		    public void handle(Event t) {
		        c = colorPick5.getValue();
		        System.out.println(c);
				
		    }
		});
		colorPick6.setOnAction(new EventHandler() {
		    public void handle(Event t) {
		        c = colorPick6.getValue();
		        System.out.println(c);
				
		    }
		});
		colorPick7.setOnAction(new EventHandler() {
		    public void handle(Event t) {
		        c = colorPick7.getValue();
		        System.out.println(c);
				
		    }
		});
		colorPick8.setOnAction(new EventHandler() {
		    public void handle(Event t) {
		        c = colorPick8.getValue();
		        System.out.println(c);
				
		    }
		});
		return c;
		
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
	
}