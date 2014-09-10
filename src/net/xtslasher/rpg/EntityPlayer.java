package net.xtslasher.rpg;

import java.awt.Graphics;

public class EntityPlayer extends Entity {
	
	public double moveSpeed = 1.8;
	
	private static int Rx, Ry;
	
	public static int[][] pImgDOWN = {{0, 0}, {1, 0}, {2, 0}};
	public static int[][] pImgLEFT = {{0, 1}, {1, 1}, {2, 1}};
	public static int[][] pImgRIGHT = {{0, 2}, {1, 2}, {2, 2}};
	public static int[][] pImgUP = {{0, 3}, {1, 3}, {2, 3}};
	
	public static boolean isMoving = false;
	
	public int animationFrame = 0;
	public int animationLoc = 0;
	public int animationTime = 20;
	public int animationShift = 0;
	public int animationDelta = 0;
	
	public EntityPlayer(Core td, double x, double y, int width, int height) {
		super(new int[]{0, 1}, x, y, width, height);
		
		Rx = (int)(x - Core.oX);
		Ry = (int)(y - Core.oY);
		
		moveSpeed = 1.8;
		health = 100;
	}
	
	public void move(double delta) {
		if(isMoving) {
			animationDelta++;
			
			if(animationDelta >= animationTime) {
				if(animationShift == 0) {
					animationFrame++;
					animationDelta = 0;
					if(animationFrame == 2) {
						animationShift = 1;
					}
				} else if(animationShift == 1){
					animationFrame--;
					animationDelta = 0;
					if(animationFrame == 0) {
						animationShift = 0;
					}
				}
			}
		}
		if(Core.bW){
			Core.oY -= moveSpeed * delta;
			animationLoc = 3;
			if(Core.oY < -1) {
				Core.oY = 0;
			} else if(Core.oY > 2200) {
				Core.oY = 2200;
			}
		}
		if(Core.bS) {
			Core.oY += moveSpeed * delta;
			animationLoc = 0;
			if(Core.oY < -1) {
				Core.oY = 0;
			} else if(Core.oY > 2200) {
				Core.oY = 2200;
			}
		}
		if(Core.bA) {
			Core.oX -= moveSpeed * delta;
			animationLoc = 1;
			if(Core.oX < -1) {
				Core.oX = 0;
			} else if(Core.oX > 2200) {
				Core.oX = 2200;
			}
		}
		if(Core.bD) {Core.oX += moveSpeed * delta;
			animationLoc = 2;
			if(Core.oX < -1) {
				Core.oX = 0;
			} else if(Core.oX > 2200) {
				Core.oX = 2200;
			}
		}
		
		Level.getTilebyID(2, Core.oX, Core.oY);
	}
	
	public void render(Graphics g) {
		setImage(new int[]{animationFrame, animationLoc});
		g.drawImage(image, Rx, Ry, null);	
	}

	@Override
	public void collidedWith(Entity entity) {
		
	}
}
