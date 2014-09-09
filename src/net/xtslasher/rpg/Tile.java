package net.xtslasher.rpg;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Tile {
	
	public static int[] blank = {-1, -1};
	
	//background
	public static int[] grass = {0, 0};
	public static int[] leaves = {1, 0};
	public static int[] road_Horizontal = {2, 0};
	public static int[] road_Vertical = {3, 0};
	public static int[] road_CurveLeftUp = {4, 0};
	public static int[] road_CurveRightUp = {5, 0};
	public static int[] road_CurveDownLeft = {6, 0};
	public static int[] road_CurveDownRight = {7, 0};
	
	//collision
	

	//items
	
	
	//characters
	
	
	public static int size = 32;
	public static BufferedImage terrain, background, items, characters;
	
	public Tile() {
		try {
			Tile.background = ImageIO.read(new File("res/bg.png"));
			Tile.terrain = ImageIO.read(new File("res/terrain.png"));
			Tile.characters = ImageIO.read(new File("res/chars.png"));
			Tile.items = ImageIO.read(new File("res/items.png"));
		} catch (Exception e) {
			System.out.println("Error loading images");
			e.printStackTrace();
		}
	}
}
