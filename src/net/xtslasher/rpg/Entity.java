package net.xtslasher.rpg;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public abstract class Entity {
	
	/** Entity Coordinates */
	protected double x, y;
	
	/** Entity Size */
	protected int width, height, dx, dy;
	
	/** Entity Speed */
	protected double moveSpeed;
	
	protected double health;
	
	/** Entity Tile Position */
	protected int[] id;
	
	/** Entity Rendered Image */
	protected Image image;
	
	
	private Rectangle me;
	private Rectangle him = new Rectangle();
	
	public Entity(int[] i, double x, double y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		moveSpeed = 1.8;
		health = 100;
		id = i;
		me = new Rectangle((int)x, (int)y, width, height);
	}
	
	public void move(double delta) {
		x += (moveSpeed * delta) * dx;
		y += (moveSpeed * delta) * dy;
	}
	
	public void setImage(int[] i) {
		image = Tile.characters.getSubimage(i[0] * Tile.size, i[1] * Tile.size, width, height);
	}
	
	public void render(Graphics g) {
		setImage(id);
		g.drawImage(image, (int)(x - Core.oX), (int)(y - Core.oY), null);
	}
	
	public boolean colidesWith(Entity entity) {
		him.setBounds((int)entity.x, (int)entity.y, entity.width, entity.height);
		return me.intersects(him);
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() { 
		return y;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getHealth() { 
		return health;
	}
	
	public abstract void collidedWith(Entity entity);
}
