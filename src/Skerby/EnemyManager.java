package Skerby;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class EnemyManager {
	
	static ArrayList<Enemy> enemyList = new ArrayList<>();
	
	private Enemy enemy;
	
	static ArrayList<Double> enemyX = new ArrayList<>();
	static ArrayList<Double> enemyY = new ArrayList<>();
	
	public EnemyManager(){
		enemyX.add(1200.0);
		enemyY.add(360.0);
		enemyX.add(2000.0);
		enemyY.add(360.0);
		init();
//       addEnemy(new Enemy(1200, 360));
//       addEnemy(new Enemy(2000, 360));
    }
	
	public void init(){
		for (int i = 0; i < enemyX.size(); i++){
			addEnemy(new Enemy(enemyX.get(i), enemyY.get(i)));
		}
	}
    
    public void render(Graphics2D g2d){
        for(int i = 0; i < enemyList.size(); i++){
            enemy = enemyList.get(i);
            enemy.render(g2d);
        }
    }
    
    public void update(){
        for (int i = 0; i < enemyList.size(); i++){
            enemy = enemyList.get(i);
            enemy.update();
        }
    }
    
    public void addEnemy(Enemy e){
        enemyList.add(e);
    }
    
    public void removeEnemy(Enemy e){
        enemyList.remove(e);
    }
    
    public static ArrayList<Enemy> getEnemyListBounds(){
        return enemyList;
    }

}
