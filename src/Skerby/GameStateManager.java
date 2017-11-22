package Skerby;

import java.awt.Graphics2D;

public class GameStateManager {
	
	private Level1 level1;
    
    public GameStateManager(){
        level1 = new Level1(this);
    }
    
    public void render(Graphics2D g2d){
        level1.render(g2d);
    }

}
