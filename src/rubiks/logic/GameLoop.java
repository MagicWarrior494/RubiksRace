package rubiks.logic;

import rubiks.gameboard.GameBoard;
import rubiks.gui.Display;
import rubiks.gui.Render;
import rubiks.io.EventListener;

public class GameLoop {

	boolean running = false;

	Display display;

	private EventListener eventListener;
	private BoardUtil boardUtil = new BoardUtil();

	private GameBoard gameBoard = new GameBoard(5, 2, 2);

	private Render render = new Render();

	public GameLoop(EventListener eventListener, Display display) {
		this.display = display;
		this.eventListener = eventListener;
	}
	
	public boolean start(boolean running) {
		this.running = running;
		while (running) {
			String direction = eventListener.getDirection();
			Integer circleX = eventListener.getCircleX();
			Integer circleY = eventListener.getCircleY();
			Integer dragCircleX = eventListener.getDragCircleX();
			Integer dragCircleY = eventListener.getDragCircleY();
			Integer distanceRadius = eventListener.getDistanceRadius();
			if(direction != null) {
				System.out.println(direction);			
			}
			
			
			render.draw(gameBoard.getGameBoard(), display, circleX, circleY,dragCircleX, dragCircleY, 5, distanceRadius);
		}
		
		return running;
	}
}
