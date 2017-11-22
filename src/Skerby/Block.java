package Skerby;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Block {
	
	private Image blockUp = new ImageIcon("Images/StateLV1/FloorUp.png").getImage();
	private Image blockDown = new ImageIcon("Images/StateLV1/FloorDown.png").getImage();
	private Image blockLeft = new ImageIcon("Images/StateLV1/FloorLeft.png").getImage();
	private Image blockRight = new ImageIcon("Images/StateLV1/FloorRight.png").getImage();
	private Image blockTopRight = new ImageIcon("Images/StateLV1/FloorTopRight.png").getImage();
	private Image blockTopLeft = new ImageIcon("Images/StateLV1/FloorTopLeft.png").getImage();
	private Image blockDownRight = new ImageIcon("Images/StateLV1/FloorDownRight.png").getImage();
	private Image blockDownLeft = new ImageIcon("Images/StateLV1/FloorDownLeft.png").getImage();
	private Image blockInside = new ImageIcon("Images/StateLV1/FloorInside.png").getImage();
    
    private int x;
    private int y;
    
    public Block(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void render(Graphics2D g2d,int i){
//    	if(i < 150){
//    		g2d.drawImage(blockUp, x, y, null);
//    	}else if(i < 159) {
//    		g2d.drawImage(blockRight, x, y, null);
//    	} else if(i < 160) {
//    		g2d.drawImage(blockTopRight, x, y, null);
//    	} else if(i < 166) {
//    		g2d.drawImage(blockUp, x, y, null);
//    	} else if(i < 167) {
//    		g2d.drawImage(blockTopLeft, x, y, null);
//    	}else if(i < 170) {
//    		g2d.drawImage(blockUp, x, y, null);
//    	}else if(i < 171) {
//    		g2d.drawImage(blockTopRight, x, y, null);
//    	}else if(i < 172) {
//    		g2d.drawImage(blockTopLeft, x, y, null);
//    	}else if(i == 177) {
//    		g2d.drawImage(blockTopRight, x, y, null);
//    	}else if(i == 178) {
//    		g2d.drawImage(blockTopLeft, x, y, null);
//    	}else if(i == 186) {
//    		g2d.drawImage(blockTopRight, x, y, null);
//    	}else {
        g2d.drawImage(blockUp, x, y, null);
    	//}// g2d.draw(getBlockBounds());
    }
    
    public Rectangle getBlockBounds(){
        return new Rectangle(x, y, 45, 45);
    }

}
