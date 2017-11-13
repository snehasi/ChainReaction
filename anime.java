package application;



import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Line;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class anime extends Application
{
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		Pane pane=new Pane();
		/*pane.setLayoutX(20);
		pane.setLayoutY(20);*/
		pane.setPrefHeight(250);
		pane.setPrefWidth(500);
		Text text=new Text();
		text.setText("hello");
		text.setTranslateX(450);
		text.setTranslateY(250);
		text.setTranslateZ(250);
		pane.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e)
			{
				text.setText("X = "+e.getX()+" Y = "+e.getY()+" Z = "+e.getZ());
			}
		});
		/*Pane p=new Pane();
		p.setLayoutX(200);
		p.setLayoutY(200);
		Pane pp=new Pane();
		pp.getChildren().add(p);
		pp.getChildren().add(pane);*/
		
		Group root=new Group();
		MakeSphere(root,Color.BLUE,175,250);
	    MakeSphere(root,Color.BLACK,250,250);
	    MakeSphere(root,Color.BEIGE,212.5,200);
	    Line line=new Line(175,250,125,250);
	    Line line1=new Line(250,250,300,250);
	    Line line2=new Line(212.5,200,212.5,150);
	    Group a=new Group();
		Group a1=new Group();
		Group a2=new Group();
		Group a3=new Group();
		
		Sphere s=(Sphere) root.getChildren().get(0);
		Sphere s1=(Sphere) root.getChildren().get(1);
		Sphere s2=(Sphere) root.getChildren().get(2);

	    pane.getChildren().addAll(line,line1,line2);
	    
	    root.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e)
			{
				MakeSphere(root,Color.RED,212.5,300);
				Sphere s3=(Sphere) root.getChildren().get(3);
				Line line3=new Line(212.5,300,212.5,350);
				pane.getChildren().add(line3);
				
				PathTransition transition=new PathTransition();
			    transition.setNode(s);
			    transition.setDuration(Duration.seconds(1));
			    transition.setPath(line);
			    transition.setCycleCount(1);
			    transition.play();
			    
			    PathTransition transition1=new PathTransition();
			    transition1.setNode(s1);
			    transition1.setDuration(Duration.seconds(1));
			    transition1.setPath(line1);
			    transition1.setCycleCount(1);
			    transition1.play();
			    
			    PathTransition transition2=new PathTransition();
			    transition2.setNode(s2);
			    transition2.setDuration(Duration.seconds(1));
			    transition2.setPath(line2);
			    transition2.setCycleCount(1);
			    transition2.play();
			    
			    PathTransition transition3=new PathTransition();
			    transition3.setNode(s3);
			    transition3.setDuration(Duration.seconds(1));
			    transition3.setPath(line3);
			    transition3.setCycleCount(1);
			    transition3.play();
			    
			}
		});
		pane.getChildren().add(root);
		
		pane.getChildren().add(text);
		Scene scene=new Scene(pane,500,500);
		primaryStage.setScene(scene);
	    primaryStage.show();
	}
	
	private void MakeSphere(Group root,Color c,double x,double y) 
	{
	    PhongMaterial phong = new PhongMaterial();
	    phong.setDiffuseColor(c);
	    phong.setSpecularColor(Color.RED);
	    
	    Sphere sphere = new Sphere(50);
	    sphere.setMaterial(phong);
	    sphere.setTranslateX(x);
	    sphere.setTranslateY(y);
	  
	    root.getChildren().add(sphere);
	 }
	private Pane Split(Pane pane,Group root)
	{
		Pane p=new Pane();
		Group a=new Group();
		Group a1=new Group();
		Group a2=new Group();
		Group a3=new Group();
		
		return p;
	}
	
	public static void main(String args[])
	{
		launch(args);
	}
}
