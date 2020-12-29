package rubiks.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import rubiks.driver.Driver;
import rubiks.gameboard.Tile;

public class Render {
	
	public Graphics g;
	public BufferStrategy bs;
	
	public Render() {
	}
	
	public void drawCircle(Integer x, Integer y, Integer dragX, Integer dragY, int radius, Integer distanceRadius) {
		g.setColor(Color.blue);
		g.fillOval(x, y, radius, radius);
		if(distanceRadius != null) {
			g.fillArc(x, y, distanceRadius, distanceRadius, 90, 90);
		}
			
		g.setColor(Color.YELLOW);
		if(dragX != null && dragY != null)
			g.fillOval(dragX, dragY, radius, radius);
	}
	
	public Graphics getGraphics() {
		return g;
	}
	
	public void draw(Tile[][] gameBoard, Display display, Integer x, Integer y, Integer dragX, Integer dragY, int radius, Integer distanceRadius) {
		bs = display.getCanves().getBufferStrategy();
		if (bs == null) {
			display.getCanves().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, Driver.width, Driver.height);
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		int counter = 0;
		for(Tile[] t : gameBoard) {
			for(Tile T : t) {
				T.draw(g, counter);
				counter++;
			}
		}
		if(x != null && y != null)
			drawCircle(x, y, dragX, dragY, radius, distanceRadius);
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		
		bs.show();
		g.dispose();
	}
	
}
