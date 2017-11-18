package application;

import java.io.Serializable;

import javafx.scene.paint.Color;

public class Player implements Serializable
{
	String name;
	SettingsController cx;
	//Color color;//=cx.getcolorfromplaysettings();
	String color;
	//Boolean vibration;
	int count;
	//Board x;
	public String getcolorasstring(Color colorr) {
		color=colorr.toString();
		return colorr.toString();
	}
	public String getnamefromplayerlist() {
		return name;
	}
	public Player() {
		this.color=color;
		this.name=name;
	}
	public Color getcolor() {
		Color c=Color.valueOf(color);
		return c;
	}
	public void setcolor(Color c) {
		color=c.toString();
	}
}
