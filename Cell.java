package application;

import java.io.Serializable;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell implements Serializable 
{
	Group g;
	//Rectangle rec;
	int cmass;
	int count; //
	Player player; //
	int r; 
	int c; 
	int x;
	int y;
	String color; //
	int explode; 
	
	public int get_Cmass()
	{
		if((r==0 || r==8) && (c==0 || c==5))
		{
			return 2;
		}
		else if(r==0 || r==8 || c==0 || c==5)
		{
			return 3;
		}
		else
		{
			return 4;
		}
	}
	public int getcount() {
		return count;
	}
	public String getcolorasstring() {
		return color.toString();
	}
	
	public Color getcolor() {
		Color c=Color.valueOf(color);
		return c;
	}
	public void setcolor(Color c) {
		color=c.toString();
	}
}
class frame implements Serializable {
	String name;
	int i;
	int j;
	int q;
	
	//Player player=new Player();
	
	//String color;// = obj.getcolorasstring();
	public String getname() {
		return name;
	}
	public int getq() {
		return q;
	}
	public int geti() {
		return i;
	}
	public int getj() {
		return j;
	}
	//count and color attributes
	
}