package models;

import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.tiled.TiledMap;

import main.Game;
import main.Main;
import manager.CharacterManager;
import util.CollisionBox;

public class Player extends Character {
		
	private final float screenRelativeX = Main.WIDTH / 2 - super.getSpriteSize() / 2;
	private final float screenRelativeY = Main.HEIGHT / 2 - super.getSpriteSize() / 2;
	
	private final float screenRelativeOverSizeX = Main.WIDTH / 2 - super.getOverSizeSpriteSize() / 2;
	private final float screenRelativeOverSizeY = Main.HEIGHT / 2 - super.getOverSizeSpriteSize() / 2;
		
	private boolean lookUp = false;
	private boolean lookDown = false;
	private boolean lookLeft = false;
	private boolean lookRight = false;
	
	private Input input = Main.appGameContainer.getInput();
	
	private int notWalkableLayerIndex;
	private TiledMap tiledMap;
	private ArrayList<NPC> npcList;
		
	private boolean damageDealt = false;
	
	private boolean isAttacking = false;
	private boolean isShooting = false;
	private boolean isSpelling = false;
	
	private boolean arrowCreated = false;
	private boolean spellCreated = false;
		
	private Inventory inventory = new Inventory();
		
	public Player() throws SlickException {
		
		super(0, 64, "resources/HumanSpriteSheet.png");
				
		super.setEnvironmentCollisionBox(new CollisionBox(super.getRelativeToMapX() + 6, super.getRelativeToMapY() + 16, super.getSpriteSize()/2 - 12, super.getSpriteSize()/2 - 18));
		
		super.setHealthBar(new HealthBar(20, Main.HEIGHT - 40, 350, 25, 5, 200, 200));
		
		Game.getCurrentMap().setX(screenRelativeX - super.getRelativeToMapX() + super.getSpriteSize() / 4);
		Game.getCurrentMap().setY(screenRelativeY - super.getRelativeToMapY() + super.getSpriteSize() / 2);
		
		notWalkableLayerIndex = Game.getCurrentMap().getTiledMap().getLayerIndex("NotWalkable");
		tiledMap = Game.getCurrentMap().getTiledMap();
		npcList = CharacterManager.getNpcList();
		
	}
	
	public void update() throws SlickException {
		
		notWalkableLayerIndex = Game.getCurrentMap().getTiledMap().getLayerIndex("NotWalkable");
		tiledMap = Game.getCurrentMap().getTiledMap();
		npcList = CharacterManager.getNpcList();
		
		super.setRelativeToMapX((screenRelativeX + super.getSpriteSize() / 4) - Game.getCurrentMap().getX());
		super.setRelativeToMapY((screenRelativeY + super.getSpriteSize() / 2) - Game.getCurrentMap().getY()); 
												
		super.getEnvironmentCollisionBox().setX(super.getRelativeToMapX() + 6);
		super.getEnvironmentCollisionBox().setY(super.getRelativeToMapY() + 16);
		 		
		super.getAttackUpCollisionBox().setX(super.getRelativeToMapX() - 28);
		super.getAttackUpCollisionBox().setY(super.getRelativeToMapY() - 37);
		
		super.getAttackDownCollisionBox().setX(super.getRelativeToMapX() - 28);
		super.getAttackDownCollisionBox().setY(super.getRelativeToMapY() + 12);
		
		super.getAttackLeftCollisionBox().setX(super.getRelativeToMapX() - 67);
		super.getAttackLeftCollisionBox().setY(super.getRelativeToMapY() - 16);
		
		super.getAttackRightCollisionBox().setX(super.getRelativeToMapX() + 31);
		super.getAttackRightCollisionBox().setY(super.getRelativeToMapY() - 16);
		
		inventory.update();
		
		updateMove();
		updateAttack();
		updateShoot();
		updateSpell();
		updatePickUpItem();

	}
	
	public void render(Graphics g) {
		
		if(isAttacking) {
		
			super.getCurrentAnimation().draw(screenRelativeOverSizeX, screenRelativeOverSizeY);
			
		} else {
			
			super.getCurrentAnimation().draw(screenRelativeX, screenRelativeY);
			
		}
		
		if(super.isDrawBlood()) {
			super.drawBlood(screenRelativeX, screenRelativeY);
		}
		
		g.setColor(Color.white);
		g.drawString("relativeToMapX:  " + super.getRelativeToMapX(), 50, 50);
		g.drawString("relativeToMapY:  " + super.getRelativeToMapY(), 50, 100);
				
	}
	
	private void updateMove() {
		
		if(!isAttacking && !isShooting && !isSpelling) {
						
			if(input.isKeyDown(Input.KEY_UP) && !input.isKeyDown(Input.KEY_DOWN) && !input.isKeyDown(Input.KEY_LEFT) && !input.isKeyDown(Input.KEY_RIGHT) && !inventory.isInventoryOpen()) {
				
				if(isUpCollision()) {
						
					super.setCurrentAnimation(super.getLookUpAnimation());
					
				} else {
					
					Game.getCurrentMap().setY(Game.getCurrentMap().getY() + super.getMovementSpeed());
					super.setCurrentAnimation(super.getGoUpAnimation());
				
				}
				
				lookUp = true;
				lookDown = false;
				lookLeft = false;
				lookRight = false;
				
	
			} else if(input.isKeyDown(Input.KEY_DOWN) && !input.isKeyDown(Input.KEY_UP) && !input.isKeyDown(Input.KEY_LEFT) && !input.isKeyDown(Input.KEY_RIGHT) && !inventory.isInventoryOpen()) {
					
				
				if(isDownCollision()) {
					
					super.setCurrentAnimation(super.getLookDownAnimation());
					
				} else {
				
					Game.getCurrentMap().setY(Game.getCurrentMap().getY() - super.getMovementSpeed());
					super.setCurrentAnimation(super.getGoDownAnimation());
								
				}
				
				lookUp = false;
				lookDown = true;
				lookLeft = false;
				lookRight = false;
				
			} else if(input.isKeyDown(Input.KEY_LEFT) && !input.isKeyDown(Input.KEY_UP) && !input.isKeyDown(Input.KEY_DOWN) && !input.isKeyDown(Input.KEY_RIGHT) && !inventory.isInventoryOpen()) {
				
				if(isLeftCollision()) {
					
					super.setCurrentAnimation(super.getLookLeftAnimation());
					
				} else {
				
					Game.getCurrentMap().setX(Game.getCurrentMap().getX() + super.getMovementSpeed());
					super.setCurrentAnimation(super.getGoLeftAnimation());
	
				}
						
				lookUp = false;
				lookDown = false;
				lookLeft = true;
				lookRight = false;
				
			} else if(input.isKeyDown(Input.KEY_RIGHT) && !input.isKeyDown(Input.KEY_UP) && !input.isKeyDown(Input.KEY_DOWN) && !input.isKeyDown(Input.KEY_LEFT) && !inventory.isInventoryOpen()) {
			
				if(isRightCollision()) {
					
					super.setCurrentAnimation(super.getLookRightAnimation());
					
				} else {
				
					Game.getCurrentMap().setX(Game.getCurrentMap().getX() - super.getMovementSpeed());
					super.setCurrentAnimation(super.getGoRightAnimation());
					
				}
				
				lookUp = false;
				lookDown = false;
				lookLeft = false;
				lookRight = true;
				
			} else if(input.isKeyDown(Input.KEY_UP) && input.isKeyDown(Input.KEY_LEFT) && !input.isKeyDown(Input.KEY_DOWN) && !input.isKeyDown(Input.KEY_RIGHT) && !inventory.isInventoryOpen()) {
				
				if(!isUpCollision()) {
					Game.getCurrentMap().setY(Game.getCurrentMap().getY() + super.getDiagonalMovementSpeed());
				}
				
				if(!isLeftCollision()) {
					Game.getCurrentMap().setX(Game.getCurrentMap().getX() + super.getDiagonalMovementSpeed());
				}
				
				if(!isUpCollision() || !isLeftCollision()) {
					super.setCurrentAnimation(super.getGoLeftAnimation());
				} else {
					super.setCurrentAnimation(super.getLookLeftAnimation());
				}
		
				lookUp = false;
				lookDown = false;
				lookLeft = true;
				lookRight = false;
				
			} else if(input.isKeyDown(Input.KEY_UP) && input.isKeyDown(Input.KEY_RIGHT) && !input.isKeyDown(Input.KEY_DOWN) && !input.isKeyDown(Input.KEY_LEFT) && !inventory.isInventoryOpen()) {
				
				if(!isUpCollision()) {
					Game.getCurrentMap().setY(Game.getCurrentMap().getY() + super.getDiagonalMovementSpeed());
				}
				
				if(!isRightCollision()) {
					Game.getCurrentMap().setX(Game.getCurrentMap().getX() - super.getDiagonalMovementSpeed());
				}
				
				if(!isUpCollision() || !isRightCollision()) {
				
					super.setCurrentAnimation(super.getGoRightAnimation());
					
				} else {
					
					super.setCurrentAnimation(super.getLookRightAnimation());
					
				}
				
				lookUp = false;
				lookDown = false;
				lookLeft = false;
				lookRight = true;
				
			} else if(input.isKeyDown(Input.KEY_DOWN) && input.isKeyDown(Input.KEY_LEFT) && !input.isKeyDown(Input.KEY_UP) && !input.isKeyDown(Input.KEY_RIGHT) && !inventory.isInventoryOpen()) {
				
				
				if(!isDownCollision()) {
					Game.getCurrentMap().setY(Game.getCurrentMap().getY() - super.getDiagonalMovementSpeed());
				} 
				
				if(!isLeftCollision()) {
					Game.getCurrentMap().setX(Game.getCurrentMap().getX() + super.getDiagonalMovementSpeed());
				}
				
				if(!isDownCollision() || !isLeftCollision()) {
				
					super.setCurrentAnimation(super.getGoLeftAnimation());
	
				} else {
					
					super.setCurrentAnimation(super.getLookLeftAnimation());
					
				}
				
				lookUp = false;
				lookDown = false;
				lookLeft = true;
				lookRight = false;
	
			} else if(input.isKeyDown(Input.KEY_DOWN) && input.isKeyDown(Input.KEY_RIGHT) && !input.isKeyDown(Input.KEY_UP) && !input.isKeyDown(Input.KEY_LEFT) && !inventory.isInventoryOpen()) {
					
				if(!isDownCollision()) {
					Game.getCurrentMap().setY(Game.getCurrentMap().getY() - super.getDiagonalMovementSpeed());
				} 
				
				if(!isRightCollision()) {
					Game.getCurrentMap().setX(Game.getCurrentMap().getX() - super.getDiagonalMovementSpeed());
				}
				
				if(!isDownCollision() || !isRightCollision()) {
				
					super.setCurrentAnimation(super.getGoRightAnimation());
				
				} else {
				
					super.setCurrentAnimation(super.getLookRightAnimation());
				
				}
				
				lookUp = false;
				lookDown = false;
				lookLeft = false;
				lookRight = true;
		
			} else {
				
				if(lookUp) {
					super.setCurrentAnimation(super.getLookUpAnimation());
				}
				
				if(lookDown) {
					super.setCurrentAnimation(super.getLookDownAnimation());	
				}
				
				if(lookLeft) {
					super.setCurrentAnimation(super.getLookLeftAnimation());
				}
				
				if(lookRight) {
					super.setCurrentAnimation(super.getLookRightAnimation());
				}
	
				lookUp = false;
				lookDown = false;
				lookLeft = false;
				lookRight = false;
				
				input.clearKeyPressedRecord();
				
			}
		
		}
							
	}
	
	private void updateAttack() {
 		
		if(input.isKeyDown(Input.KEY_X) && !isShooting && !isAttacking && !isSpelling && !inventory.isInventoryOpen()) {
						
			if(super.getCurrentAnimation() == super.getLookUpAnimation() || super.getCurrentAnimation() == super.getGoUpAnimation()) {
				super.setCurrentAnimation(super.getAttackUpAnimation());
			}
			
			if(super.getCurrentAnimation() == super.getLookDownAnimation() || super.getCurrentAnimation() == super.getGoDownAnimation()) {
				super.setCurrentAnimation(super.getAttackDownAnimation());
			}
			
			if(super.getCurrentAnimation() == super.getLookLeftAnimation() || super.getCurrentAnimation() == super.getGoLeftAnimation()) {
				super.setCurrentAnimation(super.getAttackLeftAnimation());
			}
			
			if(super.getCurrentAnimation() == super.getLookRightAnimation() || super.getCurrentAnimation() == super.getGoRightAnimation()) {
				super.setCurrentAnimation(super.getAttackRightAnimation());
			}
			
			super.getCurrentAnimation().start();
			isAttacking = true;
			damageDealt = false;
			
		}
		
		if(isAttacking && super.getAttackUpAnimation().isStopped()) {
			super.getAttackUpAnimation().restart();
			super.setCurrentAnimation(super.getLookUpAnimation());
			isAttacking = false;
		}
		
		if(isAttacking && super.getAttackDownAnimation().isStopped()) {
			super.getAttackDownAnimation().restart();
			super.setCurrentAnimation(super.getLookDownAnimation());
			isAttacking = false;
		}
		
		if(isAttacking && super.getAttackLeftAnimation().isStopped()) {
			super.getAttackLeftAnimation().restart();
			super.setCurrentAnimation(super.getLookLeftAnimation());
			isAttacking = false;
		}
		
		if(isAttacking && super.getAttackRightAnimation().isStopped()) {
			super.getAttackRightAnimation().restart();
			super.setCurrentAnimation(super.getLookRightAnimation());
			isAttacking = false;
		}
		
		if(!damageDealt) {
		
			if(super.getCurrentAnimation() == super.getAttackUpAnimation() && super.getCurrentAnimation().getFrame() == 3) {
				for(NPC npc : npcList) {
					if(super.getAttackUpCollisionBox().intersects(npc.getCharacterCollisionBox()) && npc.isAlive()) {
						npc.decreaseHealth(10);
						damageDealt = true;
					}
				}
			}
			
			if(super.getCurrentAnimation() == super.getAttackDownAnimation() && super.getCurrentAnimation().getFrame() == 3) {
				for(NPC npc : npcList) {
					if(super.getAttackDownCollisionBox().intersects(npc.getCharacterCollisionBox()) && npc.isAlive()) {
						npc.decreaseHealth(10);
						damageDealt = true;
					}
				}
			}
			
			if(super.getCurrentAnimation() == super.getAttackLeftAnimation() && super.getCurrentAnimation().getFrame() == 3) {
				for(NPC npc : npcList) {
					if(super.getAttackLeftCollisionBox().intersects(npc.getCharacterCollisionBox()) && npc.isAlive()) {
						npc.decreaseHealth(10);
						damageDealt = true;
					}
				}		
			}
			
			if(super.getCurrentAnimation() == super.getAttackRightAnimation() && super.getCurrentAnimation().getFrame() == 3) {
				for(NPC npc : npcList) {
					if(super.getAttackRightCollisionBox().intersects(npc.getCharacterCollisionBox()) && npc.isAlive()) {
						npc.decreaseHealth(10);
						damageDealt = true;
					}				
				}			
			}		
		}
	}
	
	private void updateShoot() throws SlickException {
 		
		if(input.isKeyDown(Input.KEY_Y) && !isShooting && !isAttacking && !isSpelling && !inventory.isInventoryOpen()) {
			
			if(super.getCurrentAnimation() == super.getLookUpAnimation() || super.getCurrentAnimation() == super.getGoUpAnimation()) {
				super.setCurrentAnimation(super.getShootUpAnimation());
				arrowCreated = false;
			}
			
			if(super.getCurrentAnimation() == super.getLookDownAnimation() || super.getCurrentAnimation() == super.getGoDownAnimation()) {
				super.setCurrentAnimation(super.getShootDownAnimation());
				arrowCreated = false;
			}
			
			if(super.getCurrentAnimation() == super.getLookLeftAnimation() || super.getCurrentAnimation() == super.getGoLeftAnimation()) {
				super.setCurrentAnimation(super.getShootLeftAnimation());
				arrowCreated = false;
			}
			
			if(super.getCurrentAnimation() == super.getLookRightAnimation() || super.getCurrentAnimation() == super.getGoRightAnimation()) {
				super.setCurrentAnimation(super.getShootRightAnimation());
				arrowCreated = false;
			}
			
			super.getCurrentAnimation().start();
			isShooting = true;
			
		}
		
		if(isShooting && super.getShootUpAnimation().isStopped()) {
			super.getShootUpAnimation().restart();
			super.setCurrentAnimation(super.getLookUpAnimation());
			isShooting = false;
		}
		
		if(isShooting && super.getShootDownAnimation().isStopped()) {
			super.getShootDownAnimation().restart();
			super.setCurrentAnimation(super.getLookDownAnimation());
			isShooting = false;
		}
		
		if(isShooting && super.getShootLeftAnimation().isStopped()) {
			super.getShootLeftAnimation().restart();
			super.setCurrentAnimation(super.getLookLeftAnimation());
			isShooting = false;
		}
		
		if(isShooting && super.getShootRightAnimation().isStopped()) {
			super.getShootRightAnimation().restart();
			super.setCurrentAnimation(super.getLookRightAnimation());
			isShooting = false;
		}
		
		if(super.getCurrentAnimation() == super.getShootUpAnimation() && super.getCurrentAnimation().getFrame() == 9 && !arrowCreated) {

			Projectile projectile = new Projectile(super.getRelativeToMapX() + 16, super.getRelativeToMapY(), new Animation(new SpriteSheet("resources/arrow.png", 64, 64), 1, 0, 1, 0, true, 100, true), 0);
			arrowCreated = true;
			Game.getProjectileManager().addProjectile(projectile);
			
		}
		
		if(super.getCurrentAnimation() == super.getShootDownAnimation() && super.getCurrentAnimation().getFrame() == 9 && !arrowCreated) {

			Projectile projectile = new Projectile(super.getRelativeToMapX() + 16, super.getRelativeToMapY(), new Animation(new SpriteSheet("resources/arrow.png", 64, 64), 3, 0, 3, 0, true, 100, true), 1);
			arrowCreated = true;
			Game.getProjectileManager().addProjectile(projectile);
			
		}
		
		if(super.getCurrentAnimation() == super.getShootLeftAnimation() && super.getCurrentAnimation().getFrame() == 9 && !arrowCreated) {

			Projectile projectile = new Projectile(super.getRelativeToMapX() + 16, super.getRelativeToMapY(), new Animation(new SpriteSheet("resources/arrow.png", 64, 64), 0, 0, 0, 0, true, 100, true), 2);
			arrowCreated = true;
			Game.getProjectileManager().addProjectile(projectile);
			
		}
		
		if(super.getCurrentAnimation() == super.getShootRightAnimation() && super.getCurrentAnimation().getFrame() == 9 && !arrowCreated) {

			Projectile projectile = new Projectile(super.getRelativeToMapX() + 16, super.getRelativeToMapY(), new Animation(new SpriteSheet("resources/arrow.png", 64, 64), 2, 0, 2, 0, true, 100, true), 3);
			arrowCreated = true;
			Game.getProjectileManager().addProjectile(projectile);
			
		}
		
	}

	private void updateSpell() throws SlickException {
 		
		if(input.isKeyDown(Input.KEY_C) && !isShooting && !isAttacking && !isSpelling && !inventory.isInventoryOpen()) {
						
			if(super.getCurrentAnimation() == super.getLookUpAnimation() || super.getCurrentAnimation() == super.getGoUpAnimation()) {
				super.setCurrentAnimation(super.getSpellUpAnimation());
				spellCreated = false;
			}
			
			if(super.getCurrentAnimation() == super.getLookDownAnimation() || super.getCurrentAnimation() == super.getGoDownAnimation()) {
				super.setCurrentAnimation(super.getSpellDownAnimation());
				spellCreated = false;
			}
			
			if(super.getCurrentAnimation() == super.getLookLeftAnimation() || super.getCurrentAnimation() == super.getGoLeftAnimation()) {
				super.setCurrentAnimation(super.getSpellLeftAnimation());
				spellCreated = false;
			}
			
			if(super.getCurrentAnimation() == super.getLookRightAnimation() || super.getCurrentAnimation() == super.getGoRightAnimation()) {
				super.setCurrentAnimation(super.getSpellRightAnimation());
				spellCreated = false;
			}
			
			super.getCurrentAnimation().start();
			isSpelling = true;
			
		}
		
		if(isSpelling && super.getSpellUpAnimation().isStopped()) {
			super.getSpellUpAnimation().restart();
			super.setCurrentAnimation(super.getLookUpAnimation());
			isSpelling = false;
		}
		
		if(isSpelling && super.getSpellDownAnimation().isStopped()) {
			super.getSpellDownAnimation().restart();
			super.setCurrentAnimation(super.getLookDownAnimation());
			isSpelling = false;
		}
		
		if(isSpelling && super.getSpellLeftAnimation().isStopped()) {
			super.getSpellLeftAnimation().restart();
			super.setCurrentAnimation(super.getLookLeftAnimation());
			isSpelling = false;
		}
		
		if(isSpelling && super.getSpellRightAnimation().isStopped()) {
			super.getSpellRightAnimation().restart();
			super.setCurrentAnimation(super.getLookRightAnimation());
			isSpelling = false;
		}
		
		if(super.getCurrentAnimation() == super.getSpellUpAnimation() && super.getCurrentAnimation().getFrame() == 5 && !spellCreated) {
									
			Projectile projectile = new Projectile(super.getRelativeToMapX() + 16, super.getRelativeToMapY(), new Animation(new SpriteSheet("resources/fireball1.png", 64, 64), 0, 1, 7 , 1, true, 100, true), 0);
			spellCreated = true;
			Game.getProjectileManager().addProjectile(projectile);
			
		}
		
		if(super.getCurrentAnimation() == super.getSpellDownAnimation() && super.getCurrentAnimation().getFrame() == 5 && !spellCreated) {

			Projectile projectile = new Projectile(super.getRelativeToMapX() + 16, super.getRelativeToMapY(), new Animation(new SpriteSheet("resources/fireball1.png", 64, 64), 0, 3, 7 , 3, true, 100, true), 1);
			spellCreated = true;
			Game.getProjectileManager().addProjectile(projectile);
			
		}
		
		if(super.getCurrentAnimation() == super.getSpellLeftAnimation() && super.getCurrentAnimation().getFrame() == 5 && !spellCreated) {

			Projectile projectile = new Projectile(super.getRelativeToMapX() + 16, super.getRelativeToMapY(), new Animation(new SpriteSheet("resources/fireball1.png", 64, 64), 0, 0, 7 , 0, true, 100, true), 2);
			spellCreated = true;
			Game.getProjectileManager().addProjectile(projectile);
			
		}
		
		if(super.getCurrentAnimation() == super.getSpellRightAnimation() && super.getCurrentAnimation().getFrame() == 5 && !spellCreated) {

			Projectile projectile = new Projectile(super.getRelativeToMapX() + 16, super.getRelativeToMapY(), new Animation(new SpriteSheet("resources/fireball1.png", 64, 64), 0, 2, 7 , 2, true, 100, true), 3);
			spellCreated = true;
			Game.getProjectileManager().addProjectile(projectile);
			
		}
		
	}
	
	private void updatePickUpItem() throws SlickException {
		
		ArrayList<Item> itemList = Game.getItemManager().getItemList();
		
		for(Item item : itemList) {
			
			if(super.getEnvironmentCollisionBox().intersects(item.getCollisionBox())) {
				
				Game.getItemManager().removeItem(item);
				inventory.addItem(item);
				
				if(item.getItemType().getName().equals("Gold")){
					inventory.incrementGoldCounter();
				}
				
			}
			
		}
		
	}

	private boolean isUpCollision() {
				
		for(NPC npc : npcList) {
			
			if(super.getEnvironmentCollisionBox().willIntersectUp(npc.getCharacterCollisionBox(), super.getMovementSpeed()) && npc.isAlive()) {
				return true;
			}
			
		}
				
		if(tiledMap.getTileId((int) super.getEnvironmentCollisionBox().getTopLeftX()/Main.TILE_SIZE, (int) (super.getEnvironmentCollisionBox().getTopLeftY() - super.getMovementSpeed())/Main.TILE_SIZE, notWalkableLayerIndex) == 0 &&
		   tiledMap.getTileId((int) super.getEnvironmentCollisionBox().getTopRightX()/Main.TILE_SIZE, (int) (super.getEnvironmentCollisionBox().getTopRightY() - super.getMovementSpeed())/Main.TILE_SIZE, notWalkableLayerIndex) == 0) {	
			
			return false;
			
		} else {
			
			return true;
			
		}
		
	}
	
	private boolean isDownCollision() {
		
		for(NPC npc : npcList) {
			
			if(super.getEnvironmentCollisionBox().willIntersectDown(npc.getCharacterCollisionBox(), super.getMovementSpeed()) && npc.isAlive()) {
				return true;
			}
			
		}
				
		if(tiledMap.getTileId((int) super.getEnvironmentCollisionBox().getBottomLeftX()/Main.TILE_SIZE, (int) (super.getEnvironmentCollisionBox().getBottomLeftY() + super.getMovementSpeed())/Main.TILE_SIZE, notWalkableLayerIndex) == 0 &&
		   tiledMap.getTileId((int) super.getEnvironmentCollisionBox().getBottomRightX()/Main.TILE_SIZE, (int) (super.getEnvironmentCollisionBox().getBottomRightY() + super.getMovementSpeed())/Main.TILE_SIZE, notWalkableLayerIndex) == 0) {
			
			return false;
			
		} else {
			
			return true;
			
		}
		
		
	}
	
	private boolean isLeftCollision() {
		
		for(NPC npc : npcList) {
			
			if(super.getEnvironmentCollisionBox().willIntersectLeft(npc.getCharacterCollisionBox(), super.getMovementSpeed()) && npc.isAlive()) {
				return true;
			}
			
		}
					
		if(tiledMap.getTileId((int) (super.getEnvironmentCollisionBox().getTopLeftX() - super.getMovementSpeed())/Main.TILE_SIZE, (int) super.getEnvironmentCollisionBox().getTopLeftY()/Main.TILE_SIZE, notWalkableLayerIndex) == 0 &&
		   tiledMap.getTileId((int) (super.getEnvironmentCollisionBox().getBottomLeftX() - super.getMovementSpeed())/Main.TILE_SIZE, (int) super.getEnvironmentCollisionBox().getBottomLeftY()/Main.TILE_SIZE, notWalkableLayerIndex) == 0) {	
			
			return false;
			
		} else {
			
			return true;
			
		}
		
		
	}
	
	private boolean isRightCollision() {
		
		for(NPC npc : npcList) {
			
			if(super.getEnvironmentCollisionBox().willIntersectRight(npc.getCharacterCollisionBox(), super.getMovementSpeed()) && npc.isAlive()) {
				return true;
			}
			
		}
		
		if(tiledMap.getTileId((int) (super.getEnvironmentCollisionBox().getTopRightX() + super.getMovementSpeed())/Main.TILE_SIZE, (int) super.getEnvironmentCollisionBox().getTopRightY()/Main.TILE_SIZE, notWalkableLayerIndex) == 0 &&
		   tiledMap.getTileId((int) (super.getEnvironmentCollisionBox().getBottomRightX() + super.getMovementSpeed())/Main.TILE_SIZE, (int) super.getEnvironmentCollisionBox().getBottomRightY()/Main.TILE_SIZE, notWalkableLayerIndex) == 0) {
			
			return false;
			
		} else {
			
			return true;
			
		}
		
	}

	public Inventory getInventory() {
		return inventory;
	}

}