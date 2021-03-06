package Skerby;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Level1 {
	
    private Image arrowLeft = new ImageIcon("Images/StateLV1/arrowLeft.png").getImage();
    private Image arrowRight = new ImageIcon("Images/StateLV1/arrowRight.png").getImage();
    private Image arrowUp = new ImageIcon("Images/StateLV1/arrowUp.png").getImage();
    private Image spacebar = new ImageIcon("Images/StateLV1/spacebar.png").getImage();
    private Image z = new ImageIcon("Images/StateLV1/z.png").getImage();
    
    private GameStateManager gsm;
    private Block b;
    
    static ArrayList<Block> blockList = new ArrayList<>();
    
    public Level1(GameStateManager gsm){
        this.gsm = gsm;
    }
    
    public void render(Graphics2D g2d){
        g2d.setColor(Color.black);
        g2d.setFont(new Font("Fluo_Gums", Font.BOLD, 20));
        g2d.drawImage(arrowLeft, 30, 350, null);
        g2d.drawImage(arrowRight, 80, 350, null);
        g2d.drawString("Left / Right", 125, 373);
        g2d.drawImage(arrowUp, 30, 300, null);
        g2d.drawString("or", 70, 322);
        g2d.drawImage(spacebar, 105, 300, null);
        g2d.drawString("Jump", 150, 325);
        g2d.drawImage(z, 30, 250, null);
        g2d.drawString("Attack", 90, 275);
        
        
//        for (int i = 0; i < blockList.size(); i++){
//            b = blockList.get(i);
//            b.render(g2d,i);
//        }

    }
    
    public void addBlock(Block b){
        blockList.add(b);
    }

}
