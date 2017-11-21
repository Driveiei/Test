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
public class CoinsManeger {
    
    static ArrayList<Coins> coinsList = new ArrayList<>();
    private Coins coins;
    
    public CoinsManeger(){
        for (int i = 0; i < 600; i+=70){
            addCoin(new Coins(300 + i, 390));
        }
    }
    
    public void render(Graphics2D g2d){
        for (int i = 0; i < coinsList.size(); i++){
            coins = coinsList.get(i);
            coins.render(g2d);
        }
    }
    
    public void addCoin(Coins c){
        coinsList.add(c);
    }
    
    public void removeCoin(Coins c){
        coinsList.remove(c);
    }
    
    public static ArrayList<Coins> getCoinsBounds(){
        return coinsList;
    }
    
}
