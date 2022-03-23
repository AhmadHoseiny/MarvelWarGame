package model.world;
import java.awt.Point ;
public class Cover {
	private int currentHP ;
	private Point location ;
	public Cover(int x , int y){
		this.location = new Point(x,y) ;
		this.currentHP = (int) (Math.random()*(1000-100)+100) ;
	}
	public int getCurrentHP() {
		return currentHP;
	}
	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}
	public Point getLocation() {
		return location;
	}
	
}
