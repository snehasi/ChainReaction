package application;

import java.io.IOException;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


public class Grid1 extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException
	{
		Parent loader =FXMLLoader.load(getClass().getResource("/application/Grid1.fxml"));
		Scene scene=new Scene(loader);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
        primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}


//public class Grid1 extends Application {
//	@Override
//	public void start(Stage primaryStage) throws IOException
//	{
//		Group loader = new Group();
//		//Parent loader =FXMLLoader.load(getClass().getResource("/Grid1.fxml"));
//		Scene scene=new Scene(loader);
//		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//		primaryStage.setScene(scene);
//		primaryStage.sizeToScene();
//		Rectangle r = null;
//	    for(int i=0;i<9;i++) {
//	        for(int j=0;j<6;j++) {
//
//	    r = new Rectangle(70*j,70*i,70,70);
//	    r.setStroke(Color.RED);
//	    loader.getChildren().add(r);
//	    }
//	    }
//	    scene.setRoot(loader);
//        primaryStage.show();
//        
//        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent me)->{
//            if(me.getButton().equals(MouseButton.PRIMARY)) {
//                Rectangle rect = getIntersectedRect(me);
//                if (rect != null) {
//                    Circle circle = new Circle(rect.getX()+35, rect.getY()+35, 10, Color.BLUE);
//                    addEventHandler(loader, circle);
//                    loader.getChildren().add(circle);
//                }
//            }
//        });
//	}
//	private Rectangle getIntersectedRect(MouseEvent me) {
//		// TODO Auto-generated method stub
//		Node n = me.getPickResult().getIntersectedNode();
//        return (n instanceof Rectangle) ? (Rectangle) n : null;
//		//return null;
//	}
//	private void addEventHandler(Group parent, Node node) {
//	    // TODO Auto-generated method stub
//	         node.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent me) -> {
//	                if(me.getButton().equals(MouseButton.SECONDARY)) {
//	                    parent.getChildren().remove(node);
//	                }
//	            });}
//	public static void main(String[] args) {
//		launch(args);
//	}
////	@FXML
////	 private void handleButtonAction(ActionEvent event) {
////	     // Button was clicked, do something...
////	     outputTextArea.appendText("Button Action\n");
////	 }
//}
