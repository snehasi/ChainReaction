package application;

import java.io.Serializable;

import javafx.scene.paint.Color;

public class Player implements Serializable
{
	String name;
	SettingsController cx;
	Color color;//=cx.getcolorfromplaysettings();
	//Boolean vibration;
	int count;
	//Board x;
	public String getcolorasstring() {
		return color.toString();
	}
	public String getnamefromplayerlist() {
		return name;
	}
	public Player() {
		this.color=color;
		this.name=name;
	}
	
}