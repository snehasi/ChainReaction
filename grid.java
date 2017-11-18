package application;
//sneha sinha, shubhi jain, playing board 
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class grid extends Application {
    int wid = 5;
    int len = 5;

    @Override
    public void start(Stage primaryStage) {

    		primaryStage.setTitle("Chain Reaction");
        Group g = new Group();

        for( int i=0; i < wid; i++) {
            for( int j=0; j < len; j++) {

                Rectangle rectangle = new Rectangle(600/wid, 600/len);
                rectangle.setStroke(Color.WHITE);
                rectangle.setFill(Color.BLACK);

                rectangle.setTranslateX(i * 600/wid);
                rectangle.setTranslateY(j * 600/len);
                
                g.getChildren().add(rectangle);  

            }
        }
        Scene scene = new Scene(g, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}