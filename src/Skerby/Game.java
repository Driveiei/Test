/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Skerby;

import javax.swing.JFrame;

/**
 *
 * @author WIN10PRO
 */
public class Game {
    
    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;
    
    public static void main(String[] args) {
        JFrame window = new JFrame("Skerby Game");
        window.setSize(WIDTH, HEIGHT);
        window.setLocationRelativeTo(null);
        window.add(new GamePanel());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);
    }
    
}
