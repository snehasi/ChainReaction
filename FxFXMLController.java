package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class FxFXMLController 
{
	@FXML
	// The reference of inputText will be injected by the FXML loader
	private TextField inputText;
	
	// The reference of outputText will be injected by the FXML loader
	@FXML
	private TextArea outputText;
	
	// location and resources will be automatically injected by the FXML loader	
	@FXML
	private URL location;
	
	@FXML
	private ResourceBundle resources;
	
	// Add a public no-args constructor
	public FxFXMLController() 
	{
	}
	
	@FXML
	private Rectangle getIntersectedRect(MouseEvent me) {
		// TODO Auto-generated method stub
		Node n = me.getPickResult().getIntersectedNode();
        return (n instanceof Rectangle) ? (Rectangle) n : null;
		//return null;
	}
	
	private void addEventHandler(AnchorPane r2, Node node) {
	    // TODO Auto-generated method stub
	         node.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent me) -> {
	                if(me.getButton().equals(MouseButton.SECONDARY)) {
	                    r2.getChildren().remove(node);
	                }
	            });}
	@FXML
    private AnchorPane r ;
	
	@FXML
    private Rectangle rec ;
	
	@FXML
	private void initialize() 
	{	
		r.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent me)->{
		 if(((MouseEvent) me).getButton().equals(MouseButton.PRIMARY)) {
           Rectangle rec = getIntersectedRect(me);
           if (rec != null) {
               Circle circle = new Circle(rec.getX()+25, rec.getY()+25, 9, Color.RED);
               addEventHandler(r, circle);
               r.getChildren().add(circle);
           }
       }
	});
	}
	
	@FXML
	private void printOutput() 
	{
		outputText.setText(inputText.getText());
	}
}