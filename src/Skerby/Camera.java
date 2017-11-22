package Skerby;

public class Camera {
	
	private double x;
	private double y;
	
	public Camera(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public void update(Player p){
		x = -p.getX() + Game.WIDTH/5;
		if (x <= -5300){
			x = -5300;
		}
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}

}
