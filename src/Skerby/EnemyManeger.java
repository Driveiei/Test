/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Skerby;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author WIN10PRO
 */
public class EnemyManeger {
    
    private Enemy enemy;
    
    static ArrayList<Enemy> enemyList = new ArrayList<>();
    
    public EnemyManeger(){
        addEnemy(new Enemy(1200, 140));
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
