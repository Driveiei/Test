package Skerby;

import java.awt.Graphics2D;
import java.util.ArrayList;


public class BlockManager {
	static ArrayList<Block> blocksList = new ArrayList<>();
    private Block blocks;
    private int x;
    private int y;
    private int column;
    private int roll;
    private final int boxSize = 32;
    
    public BlockManager(int x , int y ,int column ,int roll){
    	this.x = x;
    	this.y = y;
    	this.column = column;
    	this.roll = roll;
        for (int i = x; i < x + (roll*boxSize); i+=boxSize){
            for (int j = y; j < y + (column*boxSize); j+=boxSize){
                addBlock(new Block(i,j));
            }
        }
    }
    
    public void render(Graphics2D g2d){
        for (int i = 0; i < blocksList.size(); i++){
            blocks = blocksList.get(i);
            blocks.render(g2d);
        }
    }
    
    public void addBlock(Block b){
        blocksList.add(b);
    }
    
    public static ArrayList<Block> getBlocksBounds(){
        return blocksList;
    }
    
}
