/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Skerby;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 *
 * @author WIN10PRO
 */
public class GamePanel extends JPanel implements ActionListener{
    
    //for loop game.
    private Timer time;
    
    //for import background.
    private Image background = new ImageIcon("Images\\Background\\bglevel1.png").getImage();
    
    //Create attribute of class for easy to use.
    private Player player;
    private Camera camera;
    private CoinsManeger cm;
    private EnemyManeger em;
    private GameStateManeger gsm;
    //add
    private BlockManager bm;
    private BlockManager bmTwo;
    private BlockManager floor;
    private BlockManager wall;

    
    public GamePanel(){
        setFocusable(true);
        player = new Player();
        camera = new Camera(0, 0);
        cm = new CoinsManeger();
      //add
        bm = new BlockManager(384,300,4,8);
        bmTwo = new BlockManager(800,268,6,6);
        floor = new BlockManager(0,428,1,40);
        wall = new BlockManager(0,12,15,1);

        
        em = new EnemyManeger();
        gsm = new GameStateManeger();
        addKeyListener(new KeyInput(player));
        time = new Timer(10, this);
        time.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(camera.getX(), camera.getY()); //start camera
        
        g2d.drawImage(background, 0, -30, null);
        gsm.render(g2d);
        player.render(g2d);
        em.render(g2d);
        cm.render(g2d);
      //add
        bm.render(g2d);
        bmTwo.render(g2d);
        
        g2d.translate(-camera.getX(), -camera.getY()); // end camera
        
        g2d.setColor(Color.black);
        g2d.setFont(new Font("Fluo_Gums", Font.BOLD, 20));
        g2d.drawString("Score : " + player.getScore(), 510, 30);
        
        g2d.drawString("PlayerHP", 0, 50);
        g2d.drawRect(0, 0, 500, 32);
        g2d.setColor(Color.GREEN);
        g2d.fillRect(0, 0, player.getPlayerHP()*5, 32);
        if (player.getPlayerHP() == 0){
            g2d.setColor(Color.red);
            g2d.setFont(new Font("Angsana New", Font.BOLD, 64));
            g2d.drawString("YOU DIE", 220, 240);
            time.stop();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
        camera.update(player);
        em.update();
        repaint();
    }
   
}
