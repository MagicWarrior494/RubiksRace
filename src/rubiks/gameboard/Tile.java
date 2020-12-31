package rubiks.gameboard;

import java.awt.Color;
import java.awt.Graphics;

import rubiks.driver.Driver;

public class Tile {

	private int size, x, y;
	private Color color;
	private int boardSize;
	private int tileSpacing = 10;
	private boolean goal = false;
	
	public Tile(int size, Color color, int x, int y, int boardSize) {
		this.size = size;
		this.color = color;
		this.x = x;
		this.y = y;
		this.boardSize = boardSize;
	}
	
	public Tile(int size, Color color, int x, int y, int boardSize, boolean goal) {
		this.size = size;
		this.color = color;
		this.x = x;
		this.y = y;
		this.boardSize = boardSize;
		this.setGoal(goal);
	}
	
	public void draw(Graphics g, int index, boolean editable) {
		
		int drawX = Driver.width - ((size*boardSize)+(tileSpacing*(boardSize-1))) + (x*tileSpacing) + (size*x) - Driver.width/10;
		int drawY = ((size*boardSize)+(tileSpacing*(boardSize-1))) + (y*tileSpacing) + (size*y) - Driver.height/10;

		g.setColor(color);
		g.fillRect(drawX, drawY, size, size);
		if(color != Color.WHITE) {
			g.setColor(Color.BLACK);
			g.drawRect(drawX, drawY, size, size);
		}
	}
	
	public void draw(Graphics g, int index) {
		
		int drawX = ((Driver.width - ((size*boardSize)+(tileSpacing*(boardSize-1))))/2) + (x*tileSpacing) + (size*x);
		int drawY = ((Driver.height - ((size*boardSize)+(tileSpacing*(boardSize-1))))/2) + (y*tileSpacing) + (size*y);
		g.setColor(color);
		g.fillRect(drawX, drawY, size, size);
		if(color != Color.WHITE) {
			g.setColor(Color.BLACK);
			g.drawRect(drawX, drawY, size, size);
		}
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	public int getSize() {
		return size;
	}

	public int getX() {
		return x;
	}
	
	public int getScreenX() {
		return ((Driver.width - ((size*boardSize)+(tileSpacing*(boardSize-1))))/2) + (x*tileSpacing) + (size*x);
	}

	public void setX(int x) {
		this.x = x;
		
	}

	public int getY() {
		return y;
	}
	
	public int getScreenY() {
		return ((Driver.height - ((size*boardSize)+(tileSpacing*(boardSize-1))))/2) + (y*tileSpacing) + (size*y);
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isGoal() {
		return goal;
	}

	public void setGoal(boolean goal) {
		this.goal = goal;
	}

}
