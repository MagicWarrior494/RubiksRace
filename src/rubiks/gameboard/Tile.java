package rubiks.gameboard;

import java.awt.Color;
import java.awt.Graphics;

import rubiks.driver.Driver;

public class Tile {

	private int size, x, y;
	private Color color;
	private int boardSize;
	private int tileSpacing = 10;
	
	public Tile(int size, Color color, int x, int y, int boardSize) {
		this.size = size;
		this.color = color;
		this.x = x;
		this.y = y;
		this.boardSize = boardSize;
	}
	
	public void draw(Graphics g, int index) {
		int drawX = ((Driver.width - ((size*boardSize)+(tileSpacing*(boardSize-1))))/2) + (x*tileSpacing) + (size*x);
		int drawY = ((Driver.height - ((size*boardSize)+(tileSpacing*(boardSize-1))))/2) + (y*tileSpacing) + (size*y);
		
		g.setColor(color);
		g.fillRect(drawX, drawY, size, size);
		g.setColor(Color.BLACK);
		g.drawRect(drawX, drawY, size, size);
		g.setColor(Color.pink);
		g.drawString(Integer.toString(index), x+2, y+2);
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

	public void setX(int x) {
		this.x = x;
		
	}

	public int getY() {
		return y;
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

}
