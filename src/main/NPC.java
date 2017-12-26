package main;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import util.CollisionBox;

public class NPC {
	
	private final int spriteSize = 64;
	
	private float relativeToMapX;
	private float relativeToMapY;
	
	private float relativeToScreenX;
	private float relativeToScreenY;
						
	private final int maxHealth;
	private int currentHealth;
	
	private CollisionBox collisionBox;

	private SpriteSheet spriteSheet;
	
	private Animation lookUpAnimation;
	private Animation lookDownAnimation;
	private Animation lookLeftAnimation;
	private Animation lookRightAnimation;
	
	private Animation dieAnimation;

	private Animation currentAnimation;

	public NPC(float x, float y, int maxHealth, String spriteSheetPath) throws SlickException {
		
		this.relativeToMapX = x - spriteSize / 4;
		this.relativeToMapY = y - spriteSize / 2;
		
		this.relativeToScreenX = Game.getCurrentMap().getX() + relativeToMapX;
		this.relativeToScreenY = Game.getCurrentMap().getY() + relativeToMapY;
		
		this.maxHealth = maxHealth;
		this.currentHealth = maxHealth;
		
		this.spriteSheet = new SpriteSheet(spriteSheetPath, 64, 64);
		
		lookUpAnimation = new Animation(spriteSheet, 0, 8, 0, 8, true, 100, true);
		lookDownAnimation = new Animation(spriteSheet, 0, 10, 0, 10, true, 100, true);
		lookLeftAnimation = new Animation(spriteSheet, 0, 9, 0, 9, true, 100, true);
		lookRightAnimation = new Animation(spriteSheet, 0, 11, 0, 11, true, 100, true);
		
		dieAnimation = new Animation(spriteSheet, 0, 20, 5, 20, true, 100, true);
		dieAnimation.setLooping(false);
		
		currentAnimation = lookRightAnimation;
		
		collisionBox = new CollisionBox(relativeToMapX + spriteSize/4, relativeToMapY + spriteSize/2, spriteSize/2, spriteSize/2);
		
	}
	
	public void update() {
				
		if(currentHealth <= 0) {
			currentAnimation = dieAnimation;
		}
		
		relativeToScreenX = (int) Game.getCurrentMap().getX() + relativeToMapX;		
		relativeToScreenY = (int) Game.getCurrentMap().getY() + relativeToMapY;
																	
	}

	public void render(Graphics g) {
		
		currentAnimation.draw(relativeToScreenX, relativeToScreenY);
		
		
		if(currentHealth > 0) {
			g.setColor(Color.black);
			g.fillRect(relativeToScreenX, relativeToScreenY, spriteSize, 5);
			
			g.setColor(Color.red);
			g.fillRect(relativeToScreenX, relativeToScreenY, (float) currentHealth/maxHealth * 64, 5);
		}
		
		g.setColor(Color.white);
						
	}
	
	public void decreaseHealth(int amount) {
				
		if(currentHealth > 0) {
			currentHealth = currentHealth - amount;
		}
		
		if(currentHealth < 0) {
			currentHealth = 0;
		}
		
	}
	
	public CollisionBox getCollisionBox() {
		return collisionBox;
	}
	
	public float getRelativeToMapY() {
		return relativeToMapY;
	}
	
}
