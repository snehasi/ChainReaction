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
	static String num;
	@FXML
	private void combo(ActionEvent event)
	{
		num=playerr.getValue();
		playerr.setPromptText(num);
		System.out.println(num);
	}
	
	@FXML
	private ComboBox<String> grid;
	ObservableList<String> grids = 
		    FXCollections.observableArrayList(
		        "9x6",
		        "15x10"
		    );
	static String gr;
	
	@FXML
	private void comb(ActionEvent event)
	{
		gr=grid.getValue();
		grid.setPromptText(num);
		System.out.println(gr);
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
		
		
		Player one =new Player();
		one.setColor(Color.RED);
		one.name="1 Player Game";
		
		Player two = new Player();
		two.setColor(Color.BLUE);
		two.name="2 Player Game";
		
		Player three = new Player();
		three.setColor(Color.GREEN);
		three.name="3 Player Game";
		
		Player four = new Player();
		four.setColor(Color.YELLOW);
		four.name="4 Player Game";
		
		Player five = new Player();
		five.setColor(Color.WHITE);
		five.name="5 Player Game";
		
		Player six = new Player();
		six.setColor(Color.ORANGE);
		six.name="6 Player Game";
		
		Player seven = new Player();
		seven.setColor(Color.PURPLE);
		seven.name="7 Player Game";
		
		Player eight = new Player();
		eight.setColor(Color.BROWN);
		eight.name="8 Player Game";
		//p.addAll(one,two,three);
		
		Settings.p.add(one);
		Settings.p.add(two);
		Settings.p.add(three);
		Settings.p.add(four);
		Settings.p.add(five);
		Settings.p.add(six);
		Settings.p.add(seven);
		Settings.p.add(eight);
		
		playerr.setItems(options);
		grid.setItems(grids);
		// TODO Auto-generated method stub
	}
}