package application;

import java.io.Serializable;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell implements Serializable 
{
	Group g;
	Rectangle rec;
	int cmass;
	int count; //
	Player player; //
	int r; 
	int c; 
	int x;
	int y;
	Color color; //
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
}
class frame implements Serializable {
	public frame(String color, int count) {
		// TODO Auto-generated constructor stub
		this.count=count;
		this.color=color;
	}
	Player player=new Player();
	Cell obj = new Cell();
	int count=obj.getcount();
	String color = player.getcolorasstring();
	//count and color attributes
	
}