package net.xtslasher.rpg;

import java.awt.Graphics;
import java.awt.Rectangle;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Level {
	
	public static int width = 100;
	public static int height = 100;

	public static Background[][] bg = new Background[width][height];
	public static Solid[][] solid = new Solid[width][height];
	public static Item[][] item = new Item[width][height];
	
	public final String Dpath = "res/World/level_";
	public String path = Dpath;
	
	public static TiledMap map = null;
	
	public static int background;
	//public static int solids;
	public static int items;
	
	public Level(int id) {
		path = Dpath + Integer.toString(id) + ".tmx";
		System.out.println(path);
		
		try {
			map = new TiledMap(path, false);
		} catch(SlickException e) {
			System.out.println("Failed to load map: " + id);
		}
		
		for(int x=0;x<bg.length;x++) {
			for(int y=0;y<bg[0].length;y++) {
				bg[x][y] = new Background(new Rectangle(x * Tile.size, y * Tile.size, Tile.size, Tile.size), Tile.blank);
				solid[x][y] = new Solid(new Rectangle(x * Tile.size, y * Tile.size, Tile.size, Tile.size), Tile.blank);
				item[x][y] = new Item(new Rectangle(x * Tile.size, y * Tile.size, Tile.size, Tile.size), Tile.blank);
			}
		}
		
		loadWorld();
	}
	
	public static void getTilebyID(int layer, double x, double y) {		
		if(layer == 0) {
			for(int x1=0;x1<bg.length;x1++) {
				for(int y1=0;y1<bg[0].length;y1++) {
					if(x1 == (int)x/Tile.size && y1 == (int)y/Tile.size) {
						if(map.getTileId(x1, y1, background) == 1) {
							System.out.println("Grass");
						}
					}
				}
			}
		} else if(layer == 2){
			for(int x1=0;x1<item.length;x1++) {
				for(int y1=0;y1<item[0].length;y1++) {
					if((int)x/Tile.size == x1 && (int)y/Tile.size == y1) {
						if(map.getTileId(x1, y1, items) == 65) {
							System.out.println("Bottle");
						}
					}
				}
			}
		}
	}
	
	public void loadWorld() {
		System.out.println("Loading World");
		
		background = map.getLayerIndex("background");
		//solids = map.getLayerIndex("collison");
		items = map.getLayerIndex("items");
		
		for(int x=0;x<bg.length;x++) {
			for(int y=0;y<bg[0].length;y++) {
				//background
				if(map.getTileId(x, y, background) == 1) {
					bg[x][y].id = Tile.grass;
				}
				if(map.getTileId(x, y, background) == 2) {
					bg[x][y].id = Tile.leaves;
				}
				if(map.getTileId(x, y, background) == 3) {
					bg[x][y].id = Tile.road_Horizontal;
				}
				if(map.getTileId(x, y, background) == 4) {
					bg[x][y].id = Tile.road_Vertical;
				}
				if(map.getTileId(x, y, background) == 5) {
					bg[x][y].id = Tile.road_CurveLeftUp;
				}
				if(map.getTileId(x, y, background) == 6) {
					bg[x][y].id = Tile.road_CurveRightUp;
				}
				if(map.getTileId(x, y, background) == 7) {
					bg[x][y].id = Tile.road_CurveDownLeft;
				}
				if(map.getTileId(x, y, background) == 8) {
					bg[x][y].id = Tile.road_CurveDownRight;
				}
				
				//items
				if(map.getTileId(x, y, items) == 65) {
					item[x][y].id = Tile.item_bottle;
					System.out.println("X: " + x + " Y: " + y);
				}
				
				//solids
				//if(map.getTileId(x, y, solids) == 65) {
				//	solid[x][y].id = Tile.grass;
				//}
				
				
			}
		}
	}
	
	public void tick(double delta) {
		
	}
	
	public void render(Graphics g, int camX, int camY, int renX, int renY) {
		for(int x=(camX / Tile.size); x<(camX / Tile.size) + renX; x++) {
			for(int y=(camY / Tile.size); y<(camY / Tile.size) + renY; y++) {
				if(x >= 0 && y >= 0 && x < width && y < height) {
					bg[x][y].render(g);
				}
			}
		}
		
		for(int x=(camX / Tile.size); x<(camX / Tile.size) + renX; x++) {
			for(int y=(camY / Tile.size); y<(camY / Tile.size) + renY; y++) {
				if(x >= 0 && y >= 0 && x < width && y < height) {
					item[x][y].render(g);
				}
			}
		}
	}
}
