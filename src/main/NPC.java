package main;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import util.CollisionBox;

public class NPC {
	
	private final int size = 64;
						
	private float topLeftX;
	private float topLeftY; 
	
	private int health;
	
	private CollisionBox collisionBox;

	private SpriteSheet spriteSheet;
	
	private Animation lookUpAnimation;
	private Animation lookDownAnimation;
	private Animation lookLeftAnimation;
	private Animation lookRightAnimation;
	
	private Animation dieAnimation;

	private Animation currentAnimation;

	public NPC(int topLeftX, int topLeftY, int health, String spriteSheetPath) throws SlickException {
		
		this.topLeftX = Game.getCurrentMap().getX() + topLeftX;
		this.topLeftY = Game.getCurrentMap().getY() + topLeftY;
		this.health = health;
		
		this.spriteSheet = new SpriteSheet(spriteSheetPath, 64, 64);
		
		lookUpAnimation = new Animation(spriteSheet, 0, 8, 0, 8, true, 100, true);
		lookDownAnimation = new Animation(spriteSheet, 0, 10, 0, 10, true, 100, true);
		lookLeftAnimation = new Animation(spriteSheet, 0, 9, 0, 9, true, 100, true);
		lookRightAnimation = new Animation(spriteSheet, 0, 11, 0, 11, true, 100, true);
		
		dieAnimation = new Animation(spriteSheet, 0, 20, 5, 20, true, 100, true);
		dieAnimation.setLooping(false);
		
		 currentAnimation = lookRightAnimation;
		
		collisionBox = new CollisionBox(topLeftX + 6, topLeftY + 16, size/2 - 12, size/2 - 18);
		
		
	}
	
	public void update() {
				
		if(health <= 0) {
			currentAnimation = dieAnimation;
		}
		
	}
		
	public void render(Graphics g) {
		
		currentAnimation.draw(Game.getCurrentMap().getX() + topLeftX, Game.getCurrentMap().getY() + topLeftY);
		
	}
	
	public void decreaseHealth(int amount) {
		
		health = health - amount;
		
	}
	
}
