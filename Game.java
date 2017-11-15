package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Game extends Application {

	static Board x;
	int n=2;
	public static void main(String[] args) 
	{
		ArrayList<Player> p=new ArrayList<Player>();
		x=new Board();
		x.clr=Color.BLUE;
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//primaryStage=Grid1.getstage();
		Parent loader =FXMLLoader.load(getClass().getResource("/application/Grid1.fxml"));
		Scene scene=new Scene(loader);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
        primaryStage.show();
        
        for(int i=1;i<=n;i++)
        {
        	
        }
	}

}
