/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Skerby;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author WIN10PRO
 */
public class Enemy {
    
    private Image enemyR = new ImageIcon("Images\\Enemy\\EnemyR.png").getImage();
    private Image enemyL = new ImageIcon("Images\\Enemy\\EnemyL.png").getImage();
    
    private double x;
    private double y;
    
    private boolean left;
    private boolean right;
    
    private double speedX = 3;
    
    public Enemy(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public void render(Graphics2D g2d){
        if (right){
            g2d.drawImage(enemyR, (int)x, (int)y, null);
        }
        if (left){
            g2d.drawImage(enemyL, (int)x, (int)y, null);
        }
    }
    
    public void update(){
        x += speedX;
        if (x > 1250) {
            left = true;
            right = false;
            speedX = -3;
        }
        if (x < 1200) {
            right = true;
            left = false;
            speedX = 3;
        }
    }
    
    public int getX(){
        return (int)x;
    }
    
    public Rectangle getEnemyBounds(){
        return new Rectangle((int)x, (int)y, 64, 64);
    }
    
}
