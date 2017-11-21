/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Skerby;

import java.awt.Graphics2D;

/**
 *
 * @author WIN10PRO
 */
public class GameStateManeger {
    
    private Level1 level1;
    
    public GameStateManeger(){
        level1 = new Level1(this);
    }
    
    public void render(Graphics2D g2d){
        level1.render(g2d);
    }
}
