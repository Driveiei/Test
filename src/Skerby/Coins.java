package Skerby;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Coins {
	
	private Image coinsImg = new ImageIcon("Images/Items/coinsL.png").getImage();

	private double x;
	private double y;
	
	public Coins(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public void render(Graphics2D g2d){
        g2d.drawImage(coinsImg, (int)x, (int)y, null);
    }
    
    public Rectangle getCoinsBounds(){
        return new Rectangle((int)x, (int)y, 32, 32);
    }
}
