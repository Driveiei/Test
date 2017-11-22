package Skerby;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Player {
	
	private Image playerR = new ImageIcon("Images/Player/playerR.png").getImage();
    private Image playerJump = new ImageIcon("Images/Player/playerJump.png").getImage();
    private Image playerAtk = new ImageIcon("Images/Player/playerAtk.png").getImage();
//    private Image playerAtk2 = new ImageIcon("Images/Player/playerAtk2.png").getImage();
    
    private boolean attack;
    private boolean right;
    private boolean left;
    
    private boolean jumping = true;
    private double jumpSpeed = 6;
    private double currentJumpSpeed = jumpSpeed;
    
    private boolean falling = true;
    private double maxFallSpeed = 6;
    private double currentFallSpeed = 0.1;
   
    private double x;
    private double y;
    private int playerHP;
    
    private int score = 0;
    
    static ArrayList<Coins> cl = CoinsManager.getCoinsBounds();
    static ArrayList<Enemy> el = EnemyManager.getEnemyListBounds();
    //new
    static ArrayList<Block> bl = BlockManager.getBlocksBounds();
    private final int playerWidth = 64;
    private final int playerHeight = 64;

    private int count = 0;
    
    public Player(){
        x = 140;
        y = 200;
        playerHP = 100;
    }
    
    public void update(){
        if (right){
            x += 4;
        }
        if (left) {
            x -= 4;
        }
        if (jumping){
            y -= currentJumpSpeed;
            currentJumpSpeed -= 0.1;
            if (currentJumpSpeed <= 0){
                currentJumpSpeed = jumpSpeed;
                jumping = false;
                falling = true;
            }
        }
        if (falling){
            y += currentFallSpeed;
            if (currentFallSpeed < maxFallSpeed){
                currentFallSpeed += 0.15;
            }
        }
        if (!falling) {
            currentFallSpeed = 0.1;
        }
        if (x < 140) x = 140;
        if (x > 5900) x = 5900;
        //new
        if (y > 450) playerHP = 0;
//        if (y > 360) y = 360;
        if (y < 0) y = 0;
        colisionCoins();
        colisionEnemy();
        //new
        colisionBlocks();
    }
    
    public void render(Graphics2D g2d){
        if (jumping == true) {
            g2d.drawImage(playerJump, (int)x, (int)y, null);
        }else if (attack == true){
        	g2d.drawImage(playerAtk, (int)x, (int)y, null);
        }else {
            g2d.drawImage(playerR, (int)x, (int)y, null);
        }
      //add for test
      Graphics2D g3d = (Graphics2D) g2d;
      g3d.draw(getBoundsDown());
      g3d.draw(getBoundsRight());
      g3d.draw(getBoundsLeft());
      g3d.draw(getBoundsTop());

    }
    
    public int getX(){
        return (int)x;
    }
    
    public int getScore(){
        return score;
    }
    
    public int getPlayerHP(){
        return playerHP;
    }
    
    public boolean doubleJump(){
    	if(count <= 1 ){
    		falling = false;
    		return true;
    	}else{
    		return false;
    	}
    }
    
    public void keyPressed(KeyEvent k){
        int key = k.getKeyCode();
        if (key == KeyEvent.VK_LEFT){
           left = true;
        }
        if (key == KeyEvent.VK_RIGHT){
            right = true;
        }
        if ((key == KeyEvent.VK_SPACE || key == KeyEvent.VK_UP) && (canJump() || doubleJump()) ){
        	count++;
            jumping = true;
        }
        if (key == KeyEvent.VK_Z){
            attack = true;
        }
    }
    
    public void keyReleased(KeyEvent k){
        int key = k.getKeyCode();
        if (key == KeyEvent.VK_LEFT){
            left = false;
        }
        if (key == KeyEvent.VK_RIGHT){
            right = false;
        }
        if (key == KeyEvent.VK_SPACE || key == KeyEvent.VK_UP){

        }
        if (key == KeyEvent.VK_Z){
            attack = false;
        }
    }
    
    public boolean canJump(){
    	for(int i = 0; i<bl.size();i++){
    		if(getBoundsDown().intersects(bl.get(i).getBlockBounds())){
    			count = 0;
    			return true;
    		}
    	}
    	return false;
    }
    
    /*
    public Rectangle getPlayerBounds(){
        return new Rectangle((int)x, (int)y, 64, 64);
    } */
    
    //new
    public Rectangle getBoundsDown(){
    	return new Rectangle((int)x+5,(int)y+playerHeight,(int)playerWidth-16,(int)5);
    }
    
    public Rectangle getBoundsTop(){
    	return new Rectangle((int)x+11,(int)y+(playerHeight/5),(int)playerWidth-25,(int)5);
    }
    
    public Rectangle getBoundsRight(){
      	return new Rectangle((int)x+playerWidth-8,(int)y+(playerHeight/4),(int)5,(int)playerHeight-25);
    }
    
    public Rectangle getBoundsLeft(){
    	return new Rectangle((int)x-5,(int)y+(playerHeight/4),(int)5,(int)playerHeight-25);
    }
    
  //new
    public boolean coinOrNot(int i){
    	if(getBoundsDown().intersects(cl.get(i).getCoinsBounds())){
    		return true;
    	} else if(getBoundsTop().intersects(cl.get(i).getCoinsBounds())){
    		return true;
    	} else if(getBoundsRight().intersects(cl.get(i).getCoinsBounds())){
    		return true;
    	} else if(getBoundsLeft().intersects(cl.get(i).getCoinsBounds())){
    		return true;
    	} else {
    		return false;
    	}
    }

    
    public void colisionCoins(){
        for (int i = 0; i < cl.size(); i++){
 //           if (getPlayerBounds().intersects(cl.get(i).getCoinsBounds())){
        	//new
        	if (coinOrNot(i)){
        		cl.remove(i);
                score += 10;
            }
        }
    }
    
  //new
    public boolean enemyOrNot(int i){
    	if(getBoundsDown().intersects(el.get(i).getEnemyBounds())){
    		return true;
    	} else if(getBoundsTop().intersects(el.get(i).getEnemyBounds())){
    		return true;
    	} else if(getBoundsRight().intersects(el.get(i).getEnemyBounds())){
    		return true;
    	} else if(getBoundsLeft().intersects(el.get(i).getEnemyBounds())){
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public void colisionEnemy(){
        for (int i = 0; i < el.size(); i++){
//            if  (getPlayerBounds().intersects(el.get(i).getEnemyBounds())){
            //new
        	if (enemyOrNot(i)){	
            	if (attack){
                    el.remove(i);
                }else {
                    playerHP -= 1;
                }
            }
        }
    }
    
  //new
    public void colisionBlocks(){
        for (int i = 0; i < bl.size(); i++){
            if (getBoundsDown().intersects(bl.get(i).getBlockBounds())){
                currentFallSpeed = 0;
            	//y -= currentJumpSpeed;
            }
        }
        for (int i = 0; i < bl.size(); i++){
            if (getBoundsTop().intersects(bl.get(i).getBlockBounds())){
            	
            	y+=15;
            	//y += currentJumpSpeed;
            	//y += currentFallSpeed;
            	
            } 
        }
        for (int i = 0; i < bl.size(); i++){
            if (getBoundsLeft().intersects(bl.get(i).getBlockBounds())){
                x += 5;
            } 
        }
        for (int i = 0; i < bl.size(); i++){
            if (getBoundsRight().intersects(bl.get(i).getBlockBounds())){
                x -= 5;
            } 
        }
    }

}
