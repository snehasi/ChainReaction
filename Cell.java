package application;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class Cell 
{
	Group g;
	Rectangle rec;
	int cmass;
	int count;
	int player;
	int r;
	int c;
	int x;
	int y;
	Color color;
	
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
}
