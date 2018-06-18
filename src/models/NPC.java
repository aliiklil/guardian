package models;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.tiled.TiledMap;

import main.Game;
import main.Main;
import manager.CharacterManager;
import util.CollisionBox;
import pathfinding.Node;
import pathfinding.AStar;

public class NPC extends Character {

	private float screenRelativeX;
	private float screenRelativeY;
	
	private Circle aggressionCircle;
	private int aggressionCircleRadius = 320;
	
	private boolean isGoingToPlayer = false;
	private boolean pathCalculationNeeded = false;
	
	private List<Node> path;
	
	private Player player = CharacterManager.getPlayer();
	
	private float lastPlayerCenterXTile;
	private float lastPlayerCenterYTile;
	
	private int notWalkableLayerIndex;
	private TiledMap tiledMap;
	private ArrayList<NPC> npcList;
	
	private boolean goUp;
	private boolean goDown;
	private boolean goLeft;
	private boolean goRight;
	
	private boolean goUpLeft;
	private boolean goUpRight;
	private boolean goDownLeft;
	private boolean goDownRight;

	public NPC(float relativeToMapX, float relativeToMapY, int currentHealth, int maxHealth, String spriteSheetPath) throws SlickException {

		super(relativeToMapX, relativeToMapY, spriteSheetPath);
		
		super.setCollisionBox(new CollisionBox(super.getRelativeToMapX() + 6, super.getRelativeToMapY() + 10, super.getSpriteSize()/2 - 12, super.getSpriteSize()/2 - 12));
		super.setHitBox(new CollisionBox(super.getRelativeToMapX(), super.getRelativeToMapY() - 10, super.getSpriteSize()/2, super.getSpriteSize()/2));
		
		super.setBar(new Bar(Game.getCurrentMap().getX() + relativeToMapX - 16, Game.getCurrentMap().getY() + relativeToMapY - 32, 64, 5, 1, currentHealth, maxHealth, Color.red));

		this.screenRelativeX = Game.getCurrentMap().getX() + super.getRelativeToMapX() - super.getSpriteSize() / 4;
		this.screenRelativeY = Game.getCurrentMap().getY() + super.getRelativeToMapY()  - super.getSpriteSize() / 2;
		
		aggressionCircle = new Circle(super.getCenterX(), super.getCenterY(), aggressionCircleRadius);
		
		lastPlayerCenterXTile = player.getCenterXTile();
		lastPlayerCenterYTile = player.getCenterYTile();
		
		notWalkableLayerIndex = Game.getCurrentMap().getTiledMap().getLayerIndex("NotWalkable");
		tiledMap = Game.getCurrentMap().getTiledMap();
		npcList = CharacterManager.getNpcList();
		
		goUp = false;
		goDown = false;
		goLeft = false;
		goRight = false;
		
		goUpLeft = false;
		goUpRight = false;
		goDownLeft = false;
		goDownRight = false;
		
	}

	public void update() throws SlickException {
		
		super.update();
		
		screenRelativeX = (int) Game.getCurrentMap().getX() + super.getRelativeToMapX() - super.getSpriteSize() / 4;		
		screenRelativeY = (int) Game.getCurrentMap().getY() + super.getRelativeToMapY()  - super.getSpriteSize() / 2;

		super.getBar().setX(screenRelativeX);
		super.getBar().setY(screenRelativeY);
		
		super.getCollisionBox().setX(super.getRelativeToMapX() + 6);
		super.getCollisionBox().setY(super.getRelativeToMapY() + 10);
		
		super.getHitBox().setX(super.getRelativeToMapX());
		super.getHitBox().setY(super.getRelativeToMapY() - 10);
		
		if(isAlive()) {
			updateAttackPlayer();
		}
         		
	}
	
	public void updateAttackPlayer() {
				
		if(!isGoingToPlayer && aggressionCircle.contains(player.getCenterX(), player.getCenterY())) {
			
			isGoingToPlayer = true;
			pathCalculationNeeded = true;
						
		}
		
		if(isGoingToPlayer && (player.getCenterXTile() != lastPlayerCenterXTile || player.getCenterYTile() != lastPlayerCenterYTile)) {
			pathCalculationNeeded = true;
			lastPlayerCenterXTile = player.getCenterXTile();
			lastPlayerCenterYTile = player.getCenterYTile();
		}
		
		if(pathCalculationNeeded) {
			path = findPath();
			pathCalculationNeeded = false;
			
			for(Node node : path) {
				System.out.println(node.toString());
			}
			
			path.remove(0);
		}
		
		if(isGoingToPlayer && !path.isEmpty() && path != null && (goUpLeft || goUpRight || goDownLeft || goDownRight || goUp || goDown || goLeft || goRight)) {
		
			if(super.getCenterY() != super.getCenterYTile() * 32 + 16 && super.getCenterYTile() * 32 + 13 < super.getCenterY() && super.getCenterY() < super.getCenterYTile() * 32 + 19) {
				super.setCenterY(super.getCenterYTile() * 32 + 16);
			}
			
			if(super.getCenterX() != super.getCenterXTile() * 32 + 16 && super.getCenterXTile() * 32 + 13 < super.getCenterX() && super.getCenterX() < super.getCenterXTile() * 32 + 19) {
				super.setCenterX(super.getCenterXTile() * 32 + 16);
			}
		
		}
		
		if(isGoingToPlayer && !path.isEmpty() && path != null && super.getCenterYTile() == path.get(0).getRow() && super.getCenterXTile() == path.get(0).getCol() && (super.getCenterX()+16) % 32 == 0 && (super.getCenterY()+16) % 32 == 0) {
			path.remove(0);
			
			goUp = false;
			goDown = false;
			goLeft = false;
			goRight = false;
			
			goUpLeft = false;
			goUpRight = false;
			goDownLeft = false;
			goDownRight = false;
		}
		
		if(isGoingToPlayer && !path.isEmpty() && path != null) {

			if(goUp || (super.getCenterYTile() > path.get(0).getRow() && super.getCenterXTile() == path.get(0).getCol() && !isUpCollision())) {		
				super.setRelativeToMapY(super.getRelativeToMapY() - super.getMovementSpeed());
				super.setCurrentAnimation(super.getGoUpAnimation());
				goUp = true;
				goDown = false;
				goLeft = false;
				goRight = false;
				
				goUpLeft = false;
				goUpRight = false;
				goDownLeft = false;
				goDownRight = false;
			}
			
			if(goDown || (super.getCenterYTile() < path.get(0).getRow() && super.getCenterXTile() == path.get(0).getCol() && !isDownCollision())) {	
				super.setRelativeToMapY(super.getRelativeToMapY() + super.getMovementSpeed());
				super.setCurrentAnimation(super.getGoDownAnimation());
				goUp = false;
				goDown = true;
				goLeft = false;
				goRight = false;
				
				goUpLeft = false;
				goUpRight = false;
				goDownLeft = false;
				goDownRight = false;
			}
						
			if(goLeft || (super.getCenterXTile() > path.get(0).getCol() && super.getCenterYTile() == path.get(0).getRow() && !isLeftCollision())) {	
				super.setRelativeToMapX(super.getRelativeToMapX() - super.getMovementSpeed());
				super.setCurrentAnimation(super.getGoLeftAnimation());
				goUp = false;
				goDown = false;
				goLeft = true;
				goRight = false;
				
				goUpLeft = false;
				goUpRight = false;
				goDownLeft = false;
				goDownRight = false;
			}
			
			if(goRight || (super.getCenterXTile() < path.get(0).getCol() && super.getCenterYTile() == path.get(0).getRow() && !isRightCollision())) {	
				super.setRelativeToMapX(super.getRelativeToMapX() + super.getMovementSpeed());
				super.setCurrentAnimation(super.getGoRightAnimation());
				goUp = false;
				goDown = false;
				goLeft = false;
				goRight = true;
				
				goUpLeft = false;
				goUpRight = false;
				goDownLeft = false;
				goDownRight = false;
			}
			
			
			if(goUpLeft || (super.getCenterYTile() > path.get(0).getRow() && super.getCenterXTile() > path.get(0).getCol() && !isUpCollision() && !isLeftCollision())) {		
				super.setRelativeToMapY(super.getRelativeToMapY() - super.getDiagonalMovementSpeed());
				super.setRelativeToMapX(super.getRelativeToMapX() - super.getDiagonalMovementSpeed());
				super.setCurrentAnimation(super.getGoLeftAnimation());
				goUp = false;
				goDown = false;
				goLeft = false;
				goRight = false;
				
				goUpLeft = true;
				goUpRight = false;
				goDownLeft = false;
				goDownRight = false;
			}
			
			if(goUpRight || (super.getCenterYTile() > path.get(0).getRow() && super.getCenterXTile() < path.get(0).getCol() && !isUpCollision() && !isRightCollision())) {		
				super.setRelativeToMapY(super.getRelativeToMapY() - super.getDiagonalMovementSpeed());
				super.setRelativeToMapX(super.getRelativeToMapX() + super.getDiagonalMovementSpeed());
				super.setCurrentAnimation(super.getGoRightAnimation());
				goUp = false;
				goDown = false;
				goLeft = false;
				goRight = false;
				
				goUpLeft = false;
				goUpRight = true;
				goDownLeft = false;
				goDownRight = false;
			}
			
			if(goDownLeft || (super.getCenterYTile() < path.get(0).getRow() && super.getCenterXTile() > path.get(0).getCol() && !isDownCollision() && !isLeftCollision())) {		
				super.setRelativeToMapY(super.getRelativeToMapY() + super.getDiagonalMovementSpeed());
				super.setRelativeToMapX(super.getRelativeToMapX() - super.getDiagonalMovementSpeed());
				super.setCurrentAnimation(super.getGoLeftAnimation());
				goUp = false;
				goDown = false;
				goLeft = false;
				goRight = false;
				
				goUpLeft = false;
				goUpRight = false;
				goDownLeft = true;
				goDownRight = false;
			}
			
			if(goDownRight || (super.getCenterYTile() < path.get(0).getRow() && super.getCenterXTile() < path.get(0).getCol() && !isDownCollision() && !isRightCollision())) {		
				super.setRelativeToMapY(super.getRelativeToMapY() + super.getDiagonalMovementSpeed());
				super.setRelativeToMapX(super.getRelativeToMapX() + super.getDiagonalMovementSpeed());
				super.setCurrentAnimation(super.getGoRightAnimation());
				goUp = false;
				goDown = false;
				goLeft = false;
				goRight = false;
				
				goUpLeft = false;
				goUpRight = false;
				goDownLeft = false;
				goDownRight = true;
			}
						
		}
		
		if(path.size() == 0) {
			
			if(super.getCurrentAnimation() == super.getGoUpAnimation()) {
				super.setCurrentAnimation(super.getLookUpAnimation());
			}
			
			if(super.getCurrentAnimation() == super.getGoDownAnimation()) {
				super.setCurrentAnimation(super.getLookDownAnimation());
			}
			
			if(super.getCurrentAnimation() == super.getGoLeftAnimation()) {
				super.setCurrentAnimation(super.getLookLeftAnimation());
			}
			
			if(super.getCurrentAnimation() == super.getGoRightAnimation()) {
				super.setCurrentAnimation(super.getLookRightAnimation());
			}
			
		}
		
		System.out.println("------");
		System.out.println("getCenterX " + getCenterX());
		System.out.println("getCenterY " + getCenterY());
		System.out.println("getCenterXTile " + getCenterXTile());
		System.out.println("getCenterYTile " + getCenterYTile());
		
	}
	
	private List<Node> findPath() {
		
		Node initialNode = new Node(super.getCenterYTile(), super.getCenterXTile());
        Node finalNode = new Node(8, 5);
        
        int rows = Game.getCurrentMap().getTiledMap().getHeight();
        int cols = Game.getCurrentMap().getTiledMap().getWidth();
                
        AStar aStar = new AStar(rows, cols, initialNode, finalNode);
        
        int[][] blocksArray = new int[rows * cols][2];
        
        int notWalkableLayerIndex = Game.getCurrentMap().getTiledMap().getLayerIndex("NotWalkable");
        
        int k = 0;
        
        for(int i = 0; i < rows; i++) {
        	for(int j = 0; j < cols; j++) {
        		if(Game.getCurrentMap().getTiledMap().getTileId(j, i, notWalkableLayerIndex) != 0) {
        			blocksArray[k][0] = i;
        			blocksArray[k][1] = j;
        			k++;
        		}
        	}
        }
                        
        aStar.setBlocks(blocksArray);
        
        return aStar.findPath();
               		
	}
	
	public void render(Graphics g) {
		
		super.getCurrentAnimation().draw(screenRelativeX, screenRelativeY);

		if(super.getBar().getCurrentValue() > 0) {
			super.getBar().render(g);
		}
		
		if(super.isDrawBlood()) {
			super.drawBlood(screenRelativeX, screenRelativeY);
		}
				
	}
	
	private boolean isUpCollision() {
		
		if(super.getCollisionBox().willIntersectUp(player.getCollisionBox(), super.getMovementSpeed())) {
			return true;
		}
		
		npcList.remove(this);
		
		for(NPC npc : npcList) {
			
			if(super.getCollisionBox().willIntersectUp(npc.getCollisionBox(), super.getMovementSpeed()) && npc.isAlive()) {
				return true;
			}
			
		}
				
		if(tiledMap.getTileId((int) super.getCollisionBox().getTopLeftX()/Main.TILE_SIZE, (int) (super.getCollisionBox().getTopLeftY() - super.getMovementSpeed())/Main.TILE_SIZE, notWalkableLayerIndex) == 0 &&
		   tiledMap.getTileId((int) super.getCollisionBox().getTopRightX()/Main.TILE_SIZE, (int) (super.getCollisionBox().getTopRightY() - super.getMovementSpeed())/Main.TILE_SIZE, notWalkableLayerIndex) == 0) {	
			
			return false;
			
		} else {
			
			return true;
			
		}
		
	}
	
	private boolean isDownCollision() {
		
		if(super.getCollisionBox().willIntersectUp(player.getCollisionBox(), super.getMovementSpeed())) {
			return true;
		}
		
		npcList.remove(this);
		
		for(NPC npc : npcList) {
			
			if(super.getCollisionBox().willIntersectDown(npc.getCollisionBox(), super.getMovementSpeed()) && npc.isAlive()) {
				return true;
			}
			
		}
				
		if(tiledMap.getTileId((int) super.getCollisionBox().getBottomLeftX()/Main.TILE_SIZE, (int) (super.getCollisionBox().getBottomLeftY() + super.getMovementSpeed())/Main.TILE_SIZE, notWalkableLayerIndex) == 0 &&
		   tiledMap.getTileId((int) super.getCollisionBox().getBottomRightX()/Main.TILE_SIZE, (int) (super.getCollisionBox().getBottomRightY() + super.getMovementSpeed())/Main.TILE_SIZE, notWalkableLayerIndex) == 0) {
			
			return false;
			
		} else {
			
			return true;
			
		}
		
		
	}
	
	private boolean isLeftCollision() {
		
		if(super.getCollisionBox().willIntersectUp(player.getCollisionBox(), super.getMovementSpeed())) {
			return true;
		}
		
		npcList.remove(this);
		
		for(NPC npc : npcList) {
			
			if(super.getCollisionBox().willIntersectLeft(npc.getCollisionBox(), super.getMovementSpeed()) && npc.isAlive()) {
				return true;
			}
			
		}
					
		if(tiledMap.getTileId((int) (super.getCollisionBox().getTopLeftX() - super.getMovementSpeed())/Main.TILE_SIZE, (int) super.getCollisionBox().getTopLeftY()/Main.TILE_SIZE, notWalkableLayerIndex) == 0 &&
		   tiledMap.getTileId((int) (super.getCollisionBox().getBottomLeftX() - super.getMovementSpeed())/Main.TILE_SIZE, (int) super.getCollisionBox().getBottomLeftY()/Main.TILE_SIZE, notWalkableLayerIndex) == 0) {	
			
			return false;
			
		} else {
			
			return true;
			
		}
		
		
	}
	
	private boolean isRightCollision() {
		
		if(super.getCollisionBox().willIntersectUp(player.getCollisionBox(), super.getMovementSpeed())) {
			return true;
		}
		
		npcList.remove(this);
		
		for(NPC npc : npcList) {
			
			if(super.getCollisionBox().willIntersectRight(npc.getCollisionBox(), super.getMovementSpeed()) && npc.isAlive()) {
				return true;
			}
			
		}
		
		if(tiledMap.getTileId((int) (super.getCollisionBox().getTopRightX() + super.getMovementSpeed())/Main.TILE_SIZE, (int) super.getCollisionBox().getTopRightY()/Main.TILE_SIZE, notWalkableLayerIndex) == 0 &&
		   tiledMap.getTileId((int) (super.getCollisionBox().getBottomRightX() + super.getMovementSpeed())/Main.TILE_SIZE, (int) super.getCollisionBox().getBottomRightY()/Main.TILE_SIZE, notWalkableLayerIndex) == 0) {
			
			return false;
			
		} else {
			
			return true;
			
		}
		
	}
					
}
