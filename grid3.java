package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class grid3 extends Application
{

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		AnchorPane pane=new AnchorPane();
		Separator s=new Separator();
		Text t=new Text();
		ImageView iv=new ImageView();
		Button b=new Button();
		MenuButton mb=new MenuButton();
		MenuItem m1=new MenuItem();
		MenuItem m2=new MenuItem();
		
		pane.setStyle("-fx-background-color: #000000;");
		pane.setPrefHeight(619.0);
		pane.setPrefWidth(603.0);
		Scene scene=new Scene(pane);
		
		//<Separator layoutY="65.0" prefHeight="11.0" prefWidth="603.0" style="-fx-background-color: #002359;" />
		s.setLayoutY(65.0);
		s.setPrefHeight(11.0);
		s.setPrefWidth(603.0);
		s.setStyle("-fx-background-color: #002359");
		pane.getChildren().add(s);
		
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
        primaryStage.show();
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	
}
