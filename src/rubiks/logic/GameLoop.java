package rubiks.logic;

import rubiks.driver.Driver;
import rubiks.gameboard.GameBoard;
import rubiks.gui.Display;
import rubiks.gui.Render;
import rubiks.io.EventListener;
import rubiks.screen.HomeScreen;
import rubiks.screen.ScreenEnum;

public class GameLoop {

	boolean running = false;

	Display display;

	private EventListener eventListener;
	private BoardUtil boardUtil = new BoardUtil();
	private int boardSize = 5;

	private GameBoard gameBoard = new GameBoard(boardSize, 2, 2);
	private GameBoard goal = new GameBoard(3, boardSize);
	private HomeScreen homeScreen =  new HomeScreen();
	
	private Render render = new Render();

	private ScreenEnum screen = ScreenEnum.HOME;

	public GameLoop(EventListener eventListener, Display display) {
		this.display = display;
		this.eventListener = eventListener;
		
		homeScreen.setScreen(display);
	}

	public boolean start(boolean running) {
		this.running = running;
		while (running) {
			switch(screen) {
			case GAMEBOARD:
				String direction = eventListener.getDirection();
				Integer mouseX = eventListener.getMouseX();
				Integer mouseY = eventListener.getMouseY();
				Integer distanceRadius = eventListener.getDistanceRadius();
	
				if (direction != null) {
					eventListener.resetMouse();
					boardUtil.onTile(gameBoard, mouseX, mouseY, direction);
				}
	
				render.draw(gameBoard.getGameBoard(), display, mouseX, mouseY, distanceRadius, goal);
				if(boardUtil.checkWin(gameBoard, goal)) {
					System.out.println("YOU WIN");
				}
				break;
			case HOME:
				homeScreen.draw();
				
				break;
			case LOBBYVIEWER:
				break;
			case SETTINGS:
				break;
			case WAITINGLOBBY:
				break;
			case WIN:
				break;
			default:
				break;
			}
		}
		return running;
	}
}
