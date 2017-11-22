package Skerby;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
