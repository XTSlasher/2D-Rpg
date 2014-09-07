package net.xtslasher.rpg;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle {
	
	public double moveSpeed = 1.8;
	
	public static int[][] pImgDOWN = {{0, 0}, {1, 0}, {2, 0}};
	public static int[][] pImgLEFT = {{0, 1}, {1, 1}, {2, 1}};
	public static int[][] pImgRIGHT = {{0, 2}, {1, 2}, {2, 2}};
	public static int[][] pImgUP = {{0, 3}, {1, 3}, {2, 3}};
	
	public static boolean isMoving = false;
	public static boolean up = false;
	public static boolean down = false;
	public static boolean left = false;
	public static boolean right = false;
	
	public int animationFrame = 0;
	public int animationTime = 20;
	public int animationShift = 0;
	public int animationDelta = 0;
	
	public Player(String name) {
		width = 32;
		height = 32;
		setBounds((Core.pixel.width / 2) - (width / 2), (Core.pixel.height / 2) - (height / 2), width, height);
	}
	
	public void tick(double delta) { 
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
		
		if(up){
			Core.oY -= moveSpeed * delta;
		}
		if(down) {
			Core.oY += moveSpeed * delta;		
		}
		if(left) { 
			Core.oX -= moveSpeed * delta;
		}
		if(right) {
			Core.oX += moveSpeed * delta;
		}
	}
	
	public void render(Graphics g) {
		if(down) {
			g.drawImage(Tile.characters, this.x, this.y, x + width, y + height, pImgDOWN[animationFrame][0] * Tile.size, pImgDOWN[animationFrame][1] * Tile.size, pImgDOWN[animationFrame][0] * Tile.size + Tile.size, pImgDOWN[animationFrame][1] * Tile.size + Tile.size, null);
		} else if(up) {
			g.drawImage(Tile.characters, this.x, this.y, x + width, y + height, pImgUP[animationFrame][0] * Tile.size, pImgUP[animationFrame][1] * Tile.size, pImgUP[animationFrame][0] * Tile.size + Tile.size, pImgUP[animationFrame][1] * Tile.size + Tile.size, null);
		} else if(left) {
			g.drawImage(Tile.characters, this.x, this.y, x + width, y + height, pImgLEFT[animationFrame][0] * Tile.size, pImgLEFT[animationFrame][1] * Tile.size, pImgLEFT[animationFrame][0] * Tile.size + Tile.size, pImgLEFT[animationFrame][1] * Tile.size + Tile.size, null);
		} else if(right) {
			g.drawImage(Tile.characters, this.x, this.y, x + width, y + height, pImgRIGHT[animationFrame][0] * Tile.size, pImgRIGHT[animationFrame][1] * Tile.size, pImgRIGHT[animationFrame][0] * Tile.size + Tile.size, pImgRIGHT[animationFrame][1] * Tile.size + Tile.size, null);
		} else {
			g.drawImage(Tile.characters, this.x, this.y, x + width, y + height, pImgUP[0][0] * Tile.size, pImgUP[0][1] * Tile.size, pImgUP[0][0] * Tile.size + Tile.size, pImgUP[0][1] * Tile.size + Tile.size, null);
		}
		
	}
}
