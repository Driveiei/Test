package Skerby;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Block {
	
	private Image blockImg = new ImageIcon("Images\\StateLV1\\floortwo.png").getImage();
    
    private int x;
    private int y;
    
    public Block(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void render(Graphics2D g2d){
        g2d.drawImage(blockImg, x, y, null);
        g2d.draw(getBlockBounds());
    }
    
    public Rectangle getBlockBounds(){
        return new Rectangle(x, y, 32, 32);
    }
}
