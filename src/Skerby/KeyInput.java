/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Skerby;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author WIN10PRO
 */
public class KeyInput extends KeyAdapter{
    
    private Player p;
    
    public KeyInput(Player p){
        this.p = p;
    }
    
    public void keyPressed(KeyEvent k){
        p.keyPressed(k);
    }
    
    public void keyReleased(KeyEvent k){
        p.keyReleased(k);
    }
    
}
