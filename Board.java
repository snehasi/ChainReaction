package application;

import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

import javax.swing.event.CellEditorListener;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Board implements Initializable
{
	
	@FXML 
	AnchorPane pane;
	 
	Cell cell[][]=new Cell[9][6];
	int x=137;
	int y=97;
	int size=55;
	
	@Override
	public void initialize(URL url, ResourceBundle resource) 
	{		
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
            	r.setStroke(Color.RED);
            	
            	Cell c=new Cell();
            	c.x=x;
            	c.y=y;
            	c.r=i;
            	c.c=j;
            	c.cmass=c.get_Cmass();
            	Group g=new Group();
            	
            	
            	//g.setTranslateX(x);
            	//g.setTranslateY(y);
            	rotate(g);
            	
            	//MakeSphere(g,Color.RED,x+22.5,y+22.5);
            	//MakeSphere(g,Color.RED,x+10,y);
            	//MakeSphere(g,Color.RED,x+5,y+10);
            	r.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
        			@Override
        			public void handle(MouseEvent e)
        			{
        				add(g,Color.RED,e.getSceneX(),e.getSceneY());
        				System.out.println("hello");
        				System.out.println("X = "+e.getSceneX()+" Y = "+e.getSceneY());
        				System.out.println(x+" "+y);
        			}
        		});
            	c.color=Color.RED;
            	c.g=g;
            	cell[i][j]=c;
            	pane.getChildren().add(r);
            	pane.getChildren().add(g);
            	x=x+size;
            	
            }
            x=137;
            y=y+size;
        }
        System.out.println("hello");
	}
	public Sphere MakeSphere(Color c,double x,double y) 
	{
				
		PhongMaterial phong = new PhongMaterial();
	    phong.setDiffuseColor(c);
	    phong.setSpecularColor(Color.RED);
	    
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
	
	public void add(Group root,Color color,double x,double y)
	{
		
		int j=(int)Math.floor((x-137)/55);
		int i=(int)Math.floor((y-97)/55);
		System.out.println(x+" "+y+" "+i+" "+j);
		x=(j*55)+137+(55/2);
		y=(i*55)+97+(55/2);
		
		int m=cell[i][j].cmass;
		cell[i][j].count+=1;
		int c=cell[i][j].count;
		
		if(c==2)
		{
			color=Color.RED;
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
		Sphere sphere = MakeSphere(color,x,y);
		root.getChildren().add(sphere);
		if(c==m)
		{
			System.out.println("explode");
			explode(i,j);
		}
	}
	public void explode(int i,int j)
	{
		
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
		Sphere sp[]=new Sphere[4];
		
		
		
		
		
		for(int k=0;k<4;k++)
		{
			System.out.println(i1[k]+" "+j1[k]);
			if((i1[k]>=0 && i1[k]<=8) && (j1[k]>=0 && j1[k]<=5))
			{
				cell[i][j].g.getChildren().remove(0);
				
				Line l=new Line(cell[i][j].x+22.5,cell[i][j].y+22.5,cell[i1[k]][j1[k]].x+22.5,cell[i1[k]][j1[k]].y+22.5);
				//Line l=new Line(cell[i][j].x+22.5,cell[i][j].y+22.5,cell[i-1][j].x+22.5,cell[i-1][j].y+22.5);
				l.setStroke(Color.BLUE);
				//pane.getChildren().add(l);
				
				
				sp[k] = MakeSphere(Color.RED,cell[i][j].x+22.5,cell[i][j].y+22.5);
				
				
				pane.getChildren().add(sp[k]);
				PathTransition transition=new PathTransition();
				transition.setNode(sp[k]);
				transition.setDuration(Duration.seconds(0.5));
				transition.setPath(l);
				transition.setCycleCount(1);
				transition.play();
				
				//pane.getChildren().remove(pane.getChildren().lastIndexOf(sp[k]));
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
				cell[i1[k]][j1[k]].g.getChildren().add(sp[k]);
				add(cell[i1[k]][j1[k]].g,cell[i1[k]][j1[k]].color,cell[i1[k]][j1[k]].x,cell[i1[k]][j1[k]].y);
			
				//
				//
			}
		}
		
		/*for(int k=0;k<4;k++)
		{
			System.out.println(i1[k]+" "+j1[k]);
			if((i1[k]>=0 && i1[k]<=8) && (j1[k]>=0 && j1[k]<=5))
			{
				}
		}*/
		cell[i][j].count=0;
	}
	
	
}

