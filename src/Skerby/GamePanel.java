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

public class GamePanel extends JPanel implements ActionListener{
	
	/*
	 * for loop game.
	 */
	private Timer time;
	
	/*
	 * import image background.
	 */
	private Image background = new ImageIcon("Images/Background/bglevel1.png").getImage();
	
	private Player player;
	private Camera camera;
	private CoinsManager cm;
	private EnemyManager em;
	private GameStateManager gsm;
	
	//new
	private BlockManager bm;
	private BlockManager bSq1;
	private BlockManager bSq2;
	private BlockManager bSq3;
	private BlockManager bSq4;
	private BlockManager bSq5;
	private BlockManager bSq6;
	private BlockManager bSq7;
	private BlockManager bSq8;
	private BlockManager bSq9;
	private BlockManager bSq10;
	private BlockManager bSq11;

	private BlockManager floor1;
	private BlockManager floor2;
	
	
	private BlockManager wall;
	private BlockManager roof;
	private BlockManager bSt1;
	private BlockManager bSt2;
	private BlockManager bSt3;
	private BlockManager bSt4;
	private BlockManager bSt5;
	private BlockManager bSt6;

	private BlockManager bHole;

	
	public GamePanel(){
		setFocusable(true);
		player = new Player();
		camera = new Camera(0, 0);
		cm = new CoinsManager();
		
		//new
		floor1 = new BlockManager(10, 405, 30, 1);
		floor2 = new BlockManager(1765, 405, 25, 1);
		roof = new BlockManager(10, 0, 150, 1);
		
		wall = new BlockManager(10, 0, 1, 10);
		bSq1 = new BlockManager(550, 135, 5, 1);
		bSq2 = new BlockManager(955, 225, 6, 1);
		bSq3 = new BlockManager(1360, 135, 2, 5);
		bSq4 = new BlockManager(1450, 180, 4, 2);
		bSq5 = new BlockManager(1900, 45, 1, 6);
		bSq6 = new BlockManager(1945, 270, 2, 1);
		bSq7 = new BlockManager(2170, 135, 5, 6);
		bSq8 = new BlockManager(2800, 180, 20, 1);
		bSq9 = new BlockManager(3970, 180, 2, 1);
		bSq10 = new BlockManager(5320, 270, 2, 1);
		bSq11 = new BlockManager(5635, 225, 2, 1);

		bSt1 = new BlockManager(550, 270, 3,5 ,"Stair"); // x,y,height,width
		bSt2 = new BlockManager(2395, 180, 5,1 ,"Stair"); // x,y,height,width
		bSt3 = new BlockManager(3610, 45, 4,1 ,"Stair"); // x,y,height,width
		bSt4 = new BlockManager(4330, 270, 4,15 ,"Stair"); // x,y,height,width

		bHole = new BlockManager(3070,405,30,5,5);

		
		em = new EnemyManager();
		gsm = new GameStateManager();
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
		
		//new
		bSt1.render(g2d);
		
		
		
		g2d.translate(-camera.getX(), -camera.getY()); //end camera
		
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Fluo_Gums", Font.BOLD, 20));
		g2d.drawString("Score : " + player.getScore(), 510, 30);
	
		g2d.drawString("PlayerHP", 0, 50);
		g2d.drawRect(0, 0, 500, 32);
		g2d.setColor(Color.decode("#404040"));
		g2d.fillRect(0, 0, 500, 32);
		g2d.setColor(Color.PINK);
		g2d.fillRect(0, 0, player.getPlayerHP()*5, 32);
		if (player.getPlayerHP() == 0){
			time.stop();
			g2d.setColor(Color.RED);
			g2d.setFont(new Font("Angsana New", Font.BOLD, 64));
			g2d.drawString("GAME OVER", 180, 240);
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
