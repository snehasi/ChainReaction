package application;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animation extends Application {

	
	@Override
	public void start(Stage primaryStage) 
	{
			Rotate rotate1 = new Rotate(360, 0, 0, 0, Rotate.Z_AXIS);
		 	Group root = new Group();
	        Scene scene = new Scene(root, 600, 400);
	        primaryStage.setScene(scene);

	        root.setTranslateX(300);
	        root.setTranslateY(200);
	        root.getTransforms().add(rotate1);
		   
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
            rt.play();
		    /*
		    1.rotate 
		    2.rotate transition
		    3.setpivot-rotate
		    4. rotatetrans-> group*/
		    primaryStage.setScene(scene);
		    primaryStage.show();
		    
		    
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