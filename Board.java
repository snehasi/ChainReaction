package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import javax.swing.event.CellEditorListener;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape3D;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Board implements Initializable
{
	
	@FXML  
	AnchorPane pane;
	
	int n=2;
	ArrayList<Player> p=new ArrayList<Player>();
	
	static Cell cell[][]=new Cell[9][6];
	int x=137;
	int y=97;
	int size=55;
	
	
	
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
	
	
	
	
	
	
	@Override
	public void initialize(URL url, ResourceBundle resource) 
	{		
		
		Player z=new Player();
		z.name="1";
		z.color=Color.RED;
		p.add(z);
		
		z=new Player();
		z.name="2";
		z.color=Color.BLUE;
		p.add(z);
		
		System.out.println(p.get(0));
		System.out.println(p.get(1));
		
		
        for (int i = 0; i < 9; i++) 
        {
            for(int j=0;j<6;j++)
            {
            	Rectangle r=new Rectangle();
            	r.setLayoutX(x);
            	r.setLayoutY(y);
            	r.setWidth(size);
            	r.setHeight(size);
            	
            	r.setFill(Color.BLACK);
            	r.setStroke(p.get(0).color);
            	
            	Cell c=new Cell();
            	c.x=x;
            	c.y=y;
            	c.r=i;
            	c.c=j;
            	c.rec=r;
            	c.cmass=c.get_Cmass();
            	Group g=new Group();
            	rotate(g);
            	
            	//MakeSphere(g,Color.RED,x+22.5,y+22.5);
            	//MakeSphere(g,Color.RED,x+10,y);
            	//MakeSphere(g,Color.RED,x+5,y+10);
            	  
            	r.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
        			@Override
        			public void handle(MouseEvent e)
        			{
        				
        				int j=(int)Math.floor((e.getSceneX()-137)/55);
        				int i=(int)Math.floor((e.getSceneY()-97)/55);
        				//System.out.println(i+" "+j);
        				
        				if(cell[i][j].count==0 || cell[i][j].player==p.get(0))
        					{
        					//System.out.println(p.get(0));
        					add(i,j,p.get(0));
        					//System.out.println("CHANGE IN ADD");
        					changeColor();
        					}
        				}
        		});
            	c.g=g;
            	cell[i][j]=c;
            	pane.getChildren().add(r);
            	pane.getChildren().add(g);
            	x=x+size;
            }
            x=137;
            y=y+size;
        }
       // System.out.println("hello");
	}
	public void changeColor()
	{
		System.out.println(p.get(0)+"changeincolor");
		Player pl=p.remove(0);
		p.add(pl);
		/*if(p.size()==1)
		{
			System.out.println("player "+p.get(0).name+" wins");
			System.exit(0);
		}*/
		for (int i = 0; i < 9; i++) 
        {
            for(int j=0;j<6;j++)
            {
            	Cell c=cell[i][j];
            	c.rec.setStroke(p.get(0).color);
            }
        }
		
	}
	public Sphere MakeSphere(double x,double y,Color c) 
	{
		//System.out.println(c+"MakeSPhere");		
		PhongMaterial phong = new PhongMaterial();
	    phong.setDiffuseColor(c);
	    phong.setSpecularColor(c);
	    
	    Sphere sphere = new Sphere(10f);
	    sphere.setMaterial(phong);
	    sphere.setTranslateX(x);
	    sphere.setTranslateY(y);
	    
	    return sphere;
	    
	    //sphere.setTranslateZ(z);

	    
	    //pane.getChildren().add(sphere);	 
	    }
	
        
	
	public void rotate(Group root)
	{
		Rotate rotate=new Rotate();
		root.getTransforms().add(rotate);
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
	}
	
	public void add(int i,int j,Player player)
	{		
		System.out.println("ADD");
		
		double x=(j*55)+137+(55/2);
		double y=(i*55)+97+(55/2);
		
		int m=cell[i][j].cmass;
		cell[i][j].count+=1;
		int c=cell[i][j].count;
		cell[i][j].color=player.color;
		cell[i][j].player=player;
		
		if(c==2)
		{
			x+=10;
		}
		else if(c==3)
		{
			y-=10;
			x+=5;
		}
		else if(c==4)
		{
			y+=10;
			x+=5;
		}
		Sphere sphere = MakeSphere(x,y,player.color);
		cell[i][j].g.getChildren().add(sphere);
		player.count+=1;
		if(c==m)
		{
			System.out.println("explode");
			explode(i,j);
		}
		
	}
	
	public void explode(int i,int j)
	{
		//System.out.println("size "+cell[i][j].g.getChildren().size());
		int i1[]=new int[4];
		int j1[]=new int[4];
		
		int c=cell[i][j].cmass;
		
		i1[0]=i-1;
		i1[1]=i;
		i1[2]=i+1;
		i1[3]=i;

		j1[0]=j;
		j1[1]=j+1;
		j1[2]=j;
		j1[3]=j-1;
		
		for(int k=0;k<4;k++)
		{
			//System.out.println(i1[k]+" "+j1[k]);
			if((i1[k]>=0 && i1[k]<=8) && (j1[k]>=0 && j1[k]<=5))
			{
				//System.out.println("SIZE "+cell[i][j].g.getChildren().size());
				cell[i][j].g.getChildren().remove(0);
				cell[i][j].count-=1;
				Line l=new Line(cell[i][j].x+22.5,cell[i][j].y+22.5,cell[i1[k]][j1[k]].x+22.5,cell[i1[k]][j1[k]].y+22.5);
				//Line l=new Line(cell[i][j].x+22.5,cell[i][j].y+22.5,cell[i-1][j].x+22.5,cell[i-1][j].y+22.5);
				//l.setStroke(Color.BLUE);
				//pane.getChildren().add(l);
				
				
				Sphere s = MakeSphere(cell[i][j].x+22.5,cell[i][j].y+22.5,cell[i][j].color);
				int a=i1[k];
				int b =j1[k];
				
				pane.getChildren().add(s);
				
				PathTransition transition=new PathTransition();
				
				transition.setNode(s);
				transition.setDuration(Duration.seconds(0.5));
				transition.setPath(l);
				transition.setCycleCount(1);
				transition.setOnFinished(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) 
					{
						pane.getChildren().remove(pane.getChildren().lastIndexOf(s));
						//cell[i1[k]][j1[k]].g.getChildren().add(sp[k]);
						//System.out.println("hel");
						if(cell[a][b].count>0)
						{
						cell[i][j].player.count+=cell[a][b].count;
						cell[a][b].player.count-=cell[a][b].count;
						System.out.println(p.size()+"+"+cell[a][b].player.count+" "+cell[i][j].player.count);
						System.out.println("+"+cell[a][b].player.color+" "+cell[i][j].player.color);
						
						if(cell[a][b].player.count==0)
						{
							p.remove(cell[a][b].player);
						}
						System.out.println(p.size()+"-");
						
						System.out.println("SIZE *"+cell[a][b].g.getChildren().size()+" "+a+" "+b);
						for(int d=0;d<cell[a][b].g.getChildren().size();d++)
						{
							Sphere s=(Sphere) cell[a][b].g.getChildren().get(d);
							PhongMaterial phong = new PhongMaterial();
						    phong.setDiffuseColor(cell[i][j].color);
						    phong.setSpecularColor(cell[i][j].color);
							s.setMaterial(phong);
						}
						}
						add(a,b,cell[i][j].player);
						//System.out.print("Explode "+cell[i][j].player.color);
						
						/*if(cell[i][j].count==0)
							{
							changeColor();
							}*/
					}
				});
				transition.play();	
				/*if(cell[i][j].g.getChildren().size()==0)
				{
				System.out.println("CHANGE");
				changeColor();
				}*/
			}
		}
		cell[i][j].count=0;
	}
	//back to menu page
		public void backtomain() throws IOException {
			Stage primaryStage=Main.getstage();
			//bo.start(pr);
			Parent loader =FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
			Scene scene=new Scene(loader);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
	        primaryStage.show();
		}
		//go to settings
		public void gotosettingsfromgrid1() throws IOException {
			Stage primaryStage=Main.getstage();
			//bo.start(pr);
			Parent loader =FXMLLoader.load(getClass().getResource("/application/Settings.fxml"));
			Scene scene=new Scene(loader);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
	        primaryStage.show();
		}
		//go to new game
		public void gotonewgamefromgrid1() throws IOException {
			Stage primaryStage=Main.getstage();
			//bo.start(pr);
			Parent loader =FXMLLoader.load(getClass().getResource("/application/Grid1.fxml"));
			Scene scene=new Scene(loader);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
	        primaryStage.show();
		}
}