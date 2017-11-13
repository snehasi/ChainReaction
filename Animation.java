package application;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Line;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animation extends Application {

	Text status;
	@Override
	public void start(Stage primaryStage) 
	{
			status=new Text();
			
			//status.setText("hello");
			status.setTranslateX(500);
			status.setTranslateY(100);
			status.setTranslateZ(100);
			status.setFill(Color.BLACK);
			status.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					status.setText("X = "+e.getX()+"Y = "+e.getY());
				}
			});
			Pane pane=new Pane();
			pane.getChildren().add(status);
			Rotate rotate1 = new Rotate(360, 0, 0, 0, Rotate.Z_AXIS);
		 	Group root = new Group();
		 	Group g1=new Group();
		 	Group g2=new Group();
		 	pane.getChildren().add(root);
		 	pane.getChildren().add(g1);
		 	pane.getChildren().add(g2);
	        Scene scene = new Scene(pane, 600, 400);
	        primaryStage.setScene(scene);

	        /*root.setTranslateX(300);
	        root.setTranslateY(200);*/
	        root.setTranslateX(150);
	        root.setTranslateY(100);
	        //root.getTransforms().add(rotate1);
		   
		    MakeSphere(root,Color.RED,0,0,0);
		    MakeSphere(root,Color.RED,50,50,50);
		    MakeSphere(root,Color.RED,50,50,-45);
	        
	        Rotate rotate=new Rotate();
		    RotateTransition rt=new RotateTransition(Duration.seconds(5),root);
		    rt.setFromAngle(0);
		    rt.setToAngle(360);
		    rt.setRate(2);
		    rotate.setPivotX(0);
		    rotate.setPivotY(0);
		    rotate.setPivotZ(0);
		    rt.setCycleCount(Timeline.INDEFINITE);
		    rt.setDelay(Duration.ZERO);
		    rt.setInterpolator(Interpolator.LINEAR);
            rt.play();
		    
            Sphere sphere=(Sphere) root.getChildren().remove(0);
            g1.getChildren().add(sphere);
		    /*1.rotate 
		    2.rotate transition
		    3.setpivot-rotate
		    4. rotatetrans-> group*/
            
            Line line=new Line();
	        line.setStartX(100); 
	        line.setStartY(10); 
	        line.setEndX(10); 
	        line.setEndY(150);
	        
	        pane.getChildren().add(line);
		   
	        
	        sphere.setTranslateX(50);
	        sphere.setTranslateY(50);
	        sphere.setTranslateZ(50);
	        PathTransition transition=new PathTransition();
		    transition.setNode(sphere);
		    transition.setDuration(Duration.seconds(2));
		    transition.setPath(line);
		    transition.setCycleCount(1);
		    transition.play();
		    primaryStage.setScene(scene);
		    primaryStage.show();
		    
		    
			/*PhongMaterial phong = new PhongMaterial();
			phong.setDiffuseColor(Color.RED);
			phong.setSpecularColor(Color.RED);
	    
			Sphere sphere = new Sphere(50);
			sphere.setMaterial(phong);
			Group root=new Group();
			root.getChildren().add(sphere);
	        Scene scene = new Scene(root,300,400);
	        
		  
	        Line line=new Line();
	        line.setStartX(100); 
	        line.setStartY(10); 
	        line.setEndX(10); 
	        line.setEndY(150);
	        root.getChildren().add(line);
		    root.setTranslateX(150);
	        root.setTranslateY(100);
	        sphere.setTranslateX(50);
	        sphere.setTranslateY(50);
	        sphere.setTranslateZ(50);
	        PathTransition transition=new PathTransition();
		    transition.setNode(sphere);
		    transition.setDuration(Duration.seconds(2));
		    transition.setPath(line);
		    transition.setCycleCount(1);
		    transition.play();
		   
		    primaryStage.setScene(scene);
		    primaryStage.show();*/
		    
	}
	
	private void MakeSphere(Group root,Color c,double x,double y,double z) 
	{
	    PhongMaterial phong = new PhongMaterial();
	    phong.setDiffuseColor(c);
	    phong.setSpecularColor(Color.RED);
	    
	    Sphere sphere = new Sphere(50);
	    sphere.setMaterial(phong);
	    sphere.setTranslateX(z);
	    sphere.setTranslateY(y);
	    sphere.setTranslateZ(z);

	    root.getChildren().add(sphere);
	 }
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
class	HelloEvent	implements	EventHandler<MouseEvent>	
{		
	@Override
	public void handle(MouseEvent event) 
	{
		
	}	
}