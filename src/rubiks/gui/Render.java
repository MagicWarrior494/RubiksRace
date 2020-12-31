package rubiks.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import rubiks.driver.Driver;
import rubiks.gameboard.GameBoard;
import rubiks.gameboard.Tile;

public class Render {

	public Graphics g;

	public BufferStrategy bs;

	public Render() {
	}

	public void drawCircle(Integer x, Integer y, Integer distanceRadius) {
		if (distanceRadius != null) {
			distanceRadius *= 2;
			g.setColor(Color.blue);
			g.fillArc(x - distanceRadius / 2, y - distanceRadius / 2, distanceRadius, distanceRadius, 45, -90);
			g.setColor(Color.green);
			g.fillArc(x - distanceRadius / 2, y - distanceRadius / 2, distanceRadius, distanceRadius, 135, -90);
			g.setColor(Color.YELLOW);
			g.fillArc(x - distanceRadius / 2, y - distanceRadius / 2, distanceRadius, distanceRadius, 225, -90);
			g.setColor(Color.darkGray);
			g.fillArc(x - distanceRadius / 2, y - distanceRadius / 2, distanceRadius, distanceRadius, 315, -90);
		}
		g.setColor(Color.black);
	}

	public Graphics getGraphics() {
		return g;
	}

	public void drawGoal(GameBoard goal) {
		int counter = 0;
		for (Tile[] t : goal.getGameBoard()) {
			for (Tile T : t) {
				T.draw(g, counter, goal.isEditable());
				counter++;
			}
		}
	}
	
//	public void draw(IScreen screen) {
//		
//	}
	
	public void draw(Tile[][] gameBoard, Display display, Integer x, Integer y, Integer distanceRadius, GameBoard goal) {
		bs = display.getCanves().getBufferStrategy();
		if (bs == null) {
			display.getCanves().createBufferStrategy(3);
			return;
		}

		g = bs.getDrawGraphics();
		g.clearRect(0, 0, Driver.width, Driver.height);

		/////////////////////////////////////////////////////////////////////////////////////////////////////
		int counter = 0;
		for (Tile[] t : gameBoard) {
			for (Tile T : t) {
				T.draw(g, counter);
				counter++;
			}
		}
		if (x != null && y != null)
			drawCircle(x, y, distanceRadius);
		
		drawGoal(goal);

		/////////////////////////////////////////////////////////////////////////////////////////////////////

		bs.show();
		g.dispose();
	}
	
	public Graphics getG() {
		return g;
	}
	public BufferStrategy getBs() {
		return bs;
	}
	
}
