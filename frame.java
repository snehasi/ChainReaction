package application;

import java.io.Serializable;

//player,i,j,q
public class frame implements Serializable{
	Player player;
	int i;
	int j;
	int q;
	public Player getplayer() {
		return player;
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
	public void setplayer(Player p) {
		player=p;
	}
	public void setq(int q1) {
		q=q1;
	}
	public void seti(int i1) {
		i=i1;
	}
	public void setj(int j1) {
		j=j1;
	}
}
//class frame implements Serializable {
//	String name;
//	int i;
//	int j;
//	int q;
//	
//	//Player player=new Player();
//	
//	//String color;// = obj.getcolorasstring();
//	public String getname() {
//		return name;
//	}
//	public int getq() {
//		return q;
//	}
//	public int geti() {
//		return i;
//	}
//	public int getj() {
//		return j;
//	}
//	//count and color attributes
//	
//}