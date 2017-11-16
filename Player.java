package application;

import java.io.IOException;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Player 
{
	String name;
	Color c;
	Boolean vibration;
	int count;
	Board x;
	@FXML
	private ColorPicker colorPick;
	//public Color c;
	//color -- colorPick , soundeffect, vibration
	public void getcolorfromplaysettings() {
		colorPick.setOnAction(new EventHandler() {
		    public void handle(Event t) {
		        c = colorPick.getValue();
		        
		    }

			
		});
		System.out.println(c);
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
