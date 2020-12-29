package rubiks.driver;

import rubiks.gui.Display;
import rubiks.io.EventListener;
import rubiks.logic.GameLoop;

public class Driver implements Runnable {

	private EventListener eventListener = new EventListener();

	public String title;
	public static int width, height;

	private GameLoop gameLoop;

	private Display display;
	private Thread thread;

	private boolean running = false;

	public Driver(String title, int width, int height) {
		this.title = title;
		Driver.width = width;
		Driver.height = height;
	}

	public void init() {
		display = new Display(title, width, height);

		display.getFrame().addKeyListener(eventListener);
		display.getCanves().addMouseListener(eventListener);
		display.getCanves().addMouseMotionListener(eventListener);

		gameLoop = new GameLoop(eventListener, display);
	}

	@Override
	public void run() {
		init();
		running = gameLoop.start(running);
	}

	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this, "3dGameEngine");
		thread.start();
	}

	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
