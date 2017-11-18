package application;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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

public class Board implements Initializable, Serializable
{
	Main main=new Main();
	@FXML  
	AnchorPane pane;
		
	int num=2;
	int n,m,size;
	ArrayList<Player> p=new ArrayList<Player>();
	
	
	static Cell cell[][];
	Rectangle rec[][];
	
	int x=137;
	int y=97;
	
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
	@FXML
	private Button undo;
	
	 ///// serialising and deserialising
	static ArrayList<frame> forser = new ArrayList<frame>();
	public static void serialize(frame f) throws IOException
	{
		ObjectOutputStream out = null;
		
		try {
			out= new ObjectOutputStream(new FileOutputStream("//Users//snehasi//eclipse-workspace//finalv2//src//playlist.txt//"));
			System.out.println(f.geti()+" "+f.getj());
			//for(frame s: f)
			    out.writeObject(f);
		}
		catch(Exception ex)
		{
			System.out.print(ex.getMessage());
		}
		finally {
			out.close();
		}
	}
	
	
	public static frame deserialize() throws FileNotFoundException, IOException, ClassNotFoundException {
		frame f = null ;
		ObjectInputStream innn=null;
		
		try {
			
			innn=new ObjectInputStream(new FileInputStream("//Users//snehasi//eclipse-workspace//finalv2//src//playlist.txt//"));
			f = (frame)innn.readObject();
			//forser.add(s1);
			
			return f;
		}
		catch(EOFException a)
		{
			
		}
		finally {
			innn.close();
		}
		return f;
	}
	
	///

	
	@Override
	public void initialize(URL url, ResourceBundle resource) 
	{		
		System.out.println(Main.gr.substring(0,Main.gr.indexOf('x')));
		System.out.println(Main.gr.substring(Main.gr.indexOf('x')+1));
		num=Main.num.charAt(0)-48;
		n=Integer.valueOf(Main.gr.substring(0,Main.gr.indexOf('x')));
		m=Integer.valueOf(Main.gr.substring(Main.gr.indexOf('x')+1));
		cell=new Cell[n][m];
		frame f2 = new frame();
		rec=new Rectangle[n][m];
		System.out.println(n+" "+m+" "+size);
		if(n==15)
		{
			size=35;
		}
		else
			size=55;
		
		System.out.println(num+"^^");
		for(int i=0;i<num;i++)
		{
			System.out.println(i);
			p.add(Settings.p.get(i));
		}
		
        for (int i = 0; i <n; i++) 
        {
            for(int j=0;j<m;j++)
            {
            	Rectangle r=new Rectangle();
            	r.setLayoutX(x);
            	r.setLayoutY(y);
            	r.setWidth(size);
            	r.setHeight(size);
            	
            	r.setFill(Color.TRANSPARENT);
            	r.setStroke(p.get(0).getcolor());
            	
            	Cell c=new Cell();
            
            	c.x=x;
            	c.y=y;
            	c.r=i;
            	f2.i=i;//  	
            	c.c=j;
            	f2.j=j;//
            	//c.rec=r;
            	frame f = f2;
            	rec[i][j]=r;
            	c.cmass=c.get_Cmass();
            	Group g=new Group();
            	/*g.prefHeight(size);
            	g.prefWidth(size);
            	g.setTranslateX(x);
            	g.setTranslateY(y);*/
            
            	rotate(g);
            	
            	////
            	
            	
            	
            	////
            	r.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
        			@Override
        			public void handle(MouseEvent e)
        			{
        				
        				int j=(int)Math.floor((e.getSceneX()-137)/size);
        				int i=(int)Math.floor((e.getSceneY()-97)/size);
        				System.out.println(i+" "+j);
        				
        				if(cell[i][j].count==0 || cell[i][j].player==p.get(0))
        					{
        					//System.out.println(p.get(0));
        					/////
        					try {
								serialize(f);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
//        					forser.get(0).setplayer(p.get(0));
//        					forser.get(0).setq(0);
//        					forser.get(0).seti(i);
//        					forser.get(0).setj(j);
        					f2.seti(i);
        					f2.setj(j);
        					f2.setq(0);
        					f2.setplayer(p.get(0));
        					explode(f2);
        					try {
								frame f1 = deserialize();
								System.out.println(f1);
							} catch (ClassNotFoundException | IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
        					//System.out.println("CHANGE IN ADD");
        					//when i call set on finished in transition then the control comes back here 
        					//and then goes back to tansition thats why color is changing again.
        					/*System.out.println(p.get(0)+"changeincolor    ");
        					Player pl=p.remove(0);
        					p.add(pl);
        					for (int l = 0; l < 9; l++) 
        			        {
        			            for(int o=0;o<6;o++)
        			            {
        			            	Cell c=cell[l][o];
        			            	rec[l][o].setStroke(p.get(0).color);
        			            	System.out.print(p.get(0).color);
        			            }
        			        }  */
        					//to show game over as soon as only one player is left
        					if(p.size()==1)
        						dialog(); // function to show alert box
        					
        					}
        				}
        		});
            	c.g=g;
            	cell[i][j]=c;
            	pane.getChildren().add(g);
            	pane.getChildren().add(r);
            	
            	x=x+size;					
            }
            x=137;
            y=y+size;
        }
       // System.out.println("hello");
        //System.out.println("Enter name of the arraylist");
        undo.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e)
			{
				try {
					frame f1=deserialize();
					System.out.println("hi"+f1.geti()+""+f2.geti()+" "+f2.getj()+" "+f1.getj());
					f2.seti( f1.geti());
					f2.setj(f1.getj());
					f2.setq(f1.getq());
					f2.setplayer(f1.getplayer());
					//explode(f2);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
    	
        
	}
	
	public void changeColor()
	{
		System.out.println(p.get(0)+"changeincolor");
		Player pl=p.remove(0);
		p.add(pl);
		for (int i = 0; i < n; i++) 
        {
            for(int j=0;j<m;j++)
            {
            	Cell c=cell[i][j];
            	rec[i][j].setStroke(p.get(0).getcolor());
            }
        }
	}
	public Sphere MakeSphere(double x,double y,Color c) 
	{
		//System.out.println(c+"MakeSPhere");		
		PhongMaterial phong = new PhongMaterial();
	    phong.setDiffuseColor(c);
	    phong.setSpecularColor(c);
	    
	    Sphere sphere = new Sphere(7f);
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
	public void explode(frame f)
	{	int i=f.geti();
		int j=f.getj();
		int q=f.getq();
		Player player=f.getplayer();
		System.out.println("ADD");
		
		double x=(j*size)+137+(size/2);
		double y=(i*size)+97+(size/2);
		
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
		Sphere sphere = MakeSphere(x,y,player.getcolor());
		cell[i][j].g.getChildren().add(sphere);
		player.count+=1;
		
		if(c==m)
		{
			int i1[]=new int[4];
			int j1[]=new int[4];
			
			
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
				if((i1[k]>=0 && i1[k]<=n) && (j1[k]>=0 && j1[k]<=m))
				{
					cell[i][j].g.getChildren().remove(0);
					Line l=new Line(cell[i][j].x+22.5,cell[i][j].y+22.5,cell[i1[k]][j1[k]].x+22.5,cell[i1[k]][j1[k]].y+22.5);
									
					Sphere s = MakeSphere(cell[i][j].x+22.5,cell[i][j].y+22.5,cell[i][j].getcolor());
					int a=i1[k];
					int b =j1[k];
					int d=k;
					pane.getChildren().add(s);
					
					
					if(cell[a][b].count>0)
					{
					cell[i][j].player.count+=cell[a][b].count;
					cell[a][b].player.count-=cell[a][b].count;
					System.out.println(p.size()+" + "+cell[a][b].player.count+" "+cell[i][j].player.count+" + "+cell[a][b].player.color+" "+cell[i][j].player.color);
					}
					if(cell[a][b].player!=null && cell[a][b].player.count==0)
					{
						int o=0;
						while(p.get(o)!=cell[a][b].player)
								o++;
						p.remove(o);
					}
					System.out.println(p.size( )+"-^^^^^^^^^^^^^^^^^^^");
					
					PathTransition transition=new PathTransition();
					transition.setNode(s);
					transition.setDuration(Duration.seconds(0.5));
					transition.setPath(l);
					transition.setCycleCount(1);
					transition.play();
					transition.setOnFinished(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent event) 
						{
							pane.getChildren().remove(pane.getChildren().lastIndexOf(s));
							System.out.println("SIZE *"+cell[a][b].g.getChildren().size()+" "+a+" "+b);
							for(int d=0;d<cell[a][b].g.getChildren().size();d++)
							{
								Sphere s=(Sphere) cell[a][b].g.getChildren().get(d);
								PhongMaterial phong = new PhongMaterial();
							    phong.setDiffuseColor(cell[i][j].getcolor());
							    phong.setSpecularColor(cell[i][j].getcolor());
								s.setMaterial(phong);
							}
							f.seti(a);
							f.setj(b);
							f.setplayer(cell[i][j].player);
							f.setq(q-1-d);
							explode(f);
							//cell[i][j].explode+=1;
							//System.out.println("Explode---"+cell[i][j].player.color+" "+p.size());
						}
					/*if(cell[i][j].g.getChildren().size()==0)
					{
					System.out.println("CHANGE");
					changeColor();
					}*/
				});
				}
	 	}
			cell[i][j].count=0;
		}
		
		if(q==0)
			{
			System.out.println("---------------------------------------");
			changeColor();
			}
	}
	
	public void dialog()
	{
		if(p.size()==1)
		{
			ButtonType b1=new ButtonType("Go to Main Menu");
			ButtonType b2=new ButtonType("New Game");
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setHeaderText("Congratulations!");
			alert.setTitle("Game Over");
			alert.getButtonTypes().setAll(b1,b2);
			alert.showAndWait();
			
			if(alert.getResult()==b1)
			{
				try 
				{
					backtomain();
				} 
				catch (IOException ex) 
				{
					ex.printStackTrace();
				}
			}
			else if(alert.getResult()==b2)
			{
				Stage primaryStage =new Stage();	        						
				Parent loader = null;
				try {
					loader = FXMLLoader.load(getClass().getResource("/application/Grid1.fxml"));
				} catch (IOException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				Scene scene=new Scene(loader);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.sizeToScene();
		        primaryStage.show();
			}
		}
	}
	//call undo
		public void  callundo() throws FileNotFoundException, ClassNotFoundException, IOException {
			frame f1 = deserialize();
			
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