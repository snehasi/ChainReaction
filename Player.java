package application;

import java.io.Serializable;

import javafx.scene.paint.Color;

public class Player implements Serializable
{
	String name;
	SettingsController cx;
	String color;//=cx.getcolorfromplaysettings();
	//Boolean vibration;
	int count;
	//Board x;
	public String getcolorasstring() {
		return color.toString();
	}
	public String getnamefromplayerlist() {
		return name;
	}
	public Color getcolor() {
		Color c= Color.valueOf(color);
		return c;
	}
	public void setColor(Color c)
	{
		color=c.toString();
	}
	
}