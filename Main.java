package application;
	
import java.io.IOException;

import javax.print.DocFlavor.URL;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	static Stage xx = new Stage();
	int n=2;
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
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static Stage yyy;
	

	@FXML
	Button grid1;
	@FXML
	Button grid2;
	int r,c;
	//small grid
	@FXML void gotoscreen2() throws IOException 
	{
		grid1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				r=9;
				c=6;
				System.out.println(n+" "+r+" "+c);
			}
		});
		grid2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				r=15;
				c=10;
				System.out.println(n+" "+r+" "+c);
			}
		});
		
		Grid1 g=new Grid1(n,r,c);
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
	@FXML
	public MenuButton menu;
	@FXML
	private MenuItem two;
	@FXML
	private MenuItem three;
	@FXML
	private MenuItem four;
	@FXML
	private MenuItem five;
	@FXML
	private MenuItem six;
	@FXML
	private MenuItem seven;
	@FXML
	private MenuItem eight;
	@FXML
	public void getNumPlayer() {	
		three.setOnAction(new EventHandler() {
			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				System.out.println("Option 2 selected");
				menu.setText(three.getText());
				n=3;
			}
		});
		two.setOnAction(new EventHandler() {
			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				System.out.println("Option 2 selected");
				menu.setText(two.getText());
				n=2;
			}
		});
		four.setOnAction(new EventHandler() {
			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				System.out.println("Option 2 selected");
				menu.setText(four.getText());
				n=4;
			}
		});
		five.setOnAction(new EventHandler() {
			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				System.out.println("Option 2 selected");
				menu.setText(five.getText());
				n=5;
			}
		});
		six.setOnAction(new EventHandler() {
			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				System.out.println("Option 2 selected");
				menu.setText(six.getText());
				n=6;
			}
		});
		seven.setOnAction(new EventHandler() {
			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				System.out.println("Option 2 selected");
				menu.setText(seven.getText());
				n=7;
			}
		});
		eight.setOnAction(new EventHandler() {
			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				System.out.println("Option 2 selected");
				menu.setText(eight.getText());
				n=8;
			}
		});
			
	}
	
	public static Stage getstageofgrid1() {
		return yyy;
	}
	//big grid
	
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
