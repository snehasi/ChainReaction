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
	static ArrayList<Player> p=new ArrayList<Player>();
	//ArrayList
	//Player one = new Player("",);
	
	public static ArrayList<Player> getarr()
	{
		return p;
	}
	
public Stage yy;
	
	private Main maincont;
	@FXML
	private Rectangle rect;
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
	public void getcolorfromplaysettings() {
		
		colorPick1.setOnAction(new EventHandler() {
		    public void handle(Event t) {
		        c = colorPick1.getValue();
		        p.get(0).setColor(c);
		        System.out.println(c);
		    }
		});
		colorPick2.setOnAction(new EventHandler() {
		    public void handle(Event t) {
		        c = colorPick2.getValue();
		        p.get(1).setColor(c);
		        System.out.println(c);
				
		    }
		});
		colorPick3.setOnAction(new EventHandler() {
		    public void handle(Event t) {
		        c = colorPick3.getValue();
		        p.get(2).setColor(c);
		        System.out.println(c);
					
		    }
		});
		colorPick4.setOnAction(new EventHandler() {
		    public void handle(Event t) {
		        c = colorPick4.getValue();
		        p.get(3).setColor(c);
		        System.out.println(c);
				
		    }
		});
		colorPick5.setOnAction(new EventHandler() {
		    public void handle(Event t) {
		        c = colorPick5.getValue();
		        p.get(4).setColor(c);
		        System.out.println(c);
				
		    }
		});
		colorPick6.setOnAction(new EventHandler() {
		    public void handle(Event t) {
		        c = colorPick6.getValue();
		        p.get(5).setColor(c);
		        System.out.println(c);
				
		    }
		});
		colorPick7.setOnAction(new EventHandler() {
		    public void handle(Event t) {
		        c = colorPick7.getValue();
		        p.get(6).setColor(c);
		        System.out.println(c);
				
		    }
		});
		colorPick8.setOnAction(new EventHandler() {
		    public void handle(Event t) {
		        c = colorPick8.getValue();
		        p.get(7).setColor(c);
		        System.out.println(c);
		    }
		});
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
	
	@Override
	public void start(Stage primaryStage) throws IOException
	{
		Parent loader =FXMLLoader.load(getClass().getResource("/application/Settings.fxml"));
		Scene scene=new Scene(loader);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
        primaryStage.show();
	}
	
	public static void main(String[] args) 
	{
//		Player two = new Player();
//		two.color=Color.BLUE;
//		two.name="2 Player Game";
//		
//		Player three = new Player();
//		three.color=Color.WHITE;
//		three.name="3 Player Game";
//		
//		Player four = new Player();
//		four.color=Color.YELLOW;
//		four.name="4 Player Game";
//		
//		Player five = new Player();
//		five.color=Color.PINK;
//		five.name="5 Player Game";
//		
//		Player six = new Player();
//		six.color=Color.ORANGE;
//		six.name="6 Player Game";
//		
//		Player seven = new Player();
//		seven.color=Color.GREEN;
//		seven.name="7 Player Game";
//		
//		Player eight = new Player();
//		eight.color=Color.BROWN;
//		eight.name="8 Player Game";
//		//p.addAll(one,two,three);
//		
//		//p.add(one);
//		p.add(two);
//		p.add(three);
//		p.add(four);
//		p.add(five);
//		p.add(six);
//		p.add(seven);
//		p.add(eight);
		
		launch(args);
	}
}
/*<ColorPicker fx:id="colorPick1" layoutX="447.0" layoutY="138.0" onAction="#getcolorfromplaysettings" onMouseDragReleased="#getcolorfromplaysettings" onMouseReleased="#getcolorfromplaysettings" onTouchPressed="#getcolorfromplaysettings" prefHeight="39.0" prefWidth="129.0" />
      <ColorPicker fx:id="colorPick2" layoutX="447.0" layoutY="196.0" onAction="#getcolorfromplaysettings" prefHeight="39.0" prefWidth="129.0" />
      <Button layoutX="14.0" layoutY="196.0" mnemonicParsing="false" prefHeight="39.0" prefWidth="414.0" style="-fx-background-color: #242526;" text="Player 2 Settings : Customization for Player 2" textFill="WHITE" />
      <ColorPicker fx:id="colorPick3" layoutX="447.0" layoutY="252.0" onAction="#getcolorfromplaysettings" prefHeight="39.0" prefWidth="129.0" />
      <Button layoutX="14.0" layoutY="252.0" mnemonicParsing="false" prefHeight="39.0" prefWidth="414.0" style="-fx-background-color: #242526;" text="Player 3 Settings : Customization for Player 3" textFill="WHITE" />
      <ColorPicker fx:id="colorPick4" layoutX="447.0" layoutY="309.0" onAction="#getcolorfromplaysettings" prefHeight="39.0" prefWidth="129.0" />
      <Button layoutX="14.0" layoutY="309.0" mnemonicParsing="false" prefHeight="39.0" prefWidth="414.0" style="-fx-background-color: #242526;" text="Player 4 Settings : Customization for Player 4" textFill="WHITE" />
      <ColorPicker fx:id="colorPick5" layoutX="447.0" layoutY="367.0" onAction="#getcolorfromplaysettings" prefHeight="39.0" prefWidth="129.0" />
      <Button layoutX="14.0" layoutY="367.0" mnemonicParsing="false" prefHeight="39.0" prefWidth="414.0" style="-fx-background-color: #242526;" text="Player 5 Settings : Customization for Player 5" textFill="WHITE" />
      <ColorPicker fx:id="colorPick6" layoutX="447.0" layoutY="424.0" onAction="#getcolorfromplaysettings" prefHeight="39.0" prefWidth="129.0" />
      <Button layoutX="14.0" layoutY="424.0" mnemonicParsing="false" prefHeight="39.0" prefWidth="414.0" style="-fx-background-color: #242526;" text="Player 6 Settings : Customization for Player 6" textFill="WHITE" />
      <ColorPicker fx:id="colorPick7" layoutX="447.0" layoutY="481.0" onAction="#getcolorfromplaysettings" prefHeight="39.0" prefWidth="129.0" />
      <Button layoutX="14.0" layoutY="481.0" mnemonicParsing="false" prefHeight="39.0" prefWidth="414.0" style="-fx-background-color: #242526;" text="Player 7 Settings : Customization for Player 7" textFill="WHITE" />
      <ColorPicker fx:id="colorPick8" layoutX="447.0" layoutY="535.0" onAction="#getcolorfromplaysettings" prefHeight="39.0" prefWidth="129.0" />
      <Button layoutX="14.0" layoutY="535.0" mnemonicParsing="false" prefHeight="39.0" prefWidth="414.0" style="-fx-background-color: #242526;" text="Player 8 Settings : Customization for Player 8" textFill="WHITE" />
  */