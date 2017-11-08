package application;

import javafx.scene.paint.Color;


import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Board extends Application {
	static int m;
	static int n;
	protected String color;
	//private int[][] arr;
	public ArrayList<Rectangle> x =  new ArrayList<Rectangle>();
	public Board(int m,int n,String color, ArrayList<Rectangle> x) {
		this.n =n;
		this.m=m;
		this.color=color;
		this.x=x;
	}
	@Override
	public void start(Stage primaryStage) throws IOException
	{
		Parent loader =FXMLLoader.load(getClass().getResource("/Grid1.fxml"));
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
class Rectangle extends Board{
	private static int x;
	private static int y;
	boolean filled; //returns false when empty
	String cellcol=null; //cell color
	int count;
	
	public Rectangle(int m, int n, String color, ArrayList<Rectangle> cells,int  x,int y, boolean filled,int count,String cellcol) {
		super(m, n, color, cells);
		// TODO Auto-generated constructor stub
		this.x=x;
		this.y=y;
		this.filled=filled;
		this.count=count;
		this.cellcol=cellcol;
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		
	}
	public static int getcriticalmass() {
		int criticalmass = 4;
		if((x==0 & y==0)||(x==m & y==0)||(x==0 & y==n)||(x==m & y==n)) {
			criticalmass=2;
		}
		else if((x==0 & y!=0)||(x==m & y!=0)||(x==0 & y!=n)||(x==m & y!=n)) {
			criticalmass=3;
		}
		return criticalmass;
	}
	//fill method
		public static void fill(Rectangle x, String playerscolor) {
			if(x.filled!=true) {
				//put ball in this rectangle(coordinates of Rectangle known)
				x.cellcol = playerscolor;
			}
			else {
				if(x.cellcol.equals(playerscolor)) { //same color
					
				}
			}
		}

	
}

	
	
	
