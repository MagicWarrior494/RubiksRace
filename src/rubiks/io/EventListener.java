package rubiks.io;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class EventListener implements KeyListener, MouseListener, MouseMotionListener {
	private static boolean[] keys = new boolean[256];
	public static boolean r, left, right, up , down;	
	
	private Integer mousePressX = null;
	private Integer mousePressY = null;
	private Integer mouseDragX = null;
	private Integer mouseDragY = null;
	private Integer distanceToReach = null;
	public String getDirection() {
		
		if(mousePressX == null || mousePressY == null || mouseDragX == null || mouseDragY == null) {
			return null;
		}
		
		int distance = (int) Math.sqrt(Math.pow(mousePressX - mouseDragX,2) + Math.pow(mousePressY - mouseDragY,2));
		distanceToReach = 28;
		if(distance > distanceToReach) {
			int xDis = mousePressX - mouseDragX;
			int yDis = mousePressY - mouseDragY;
			int disToReach = (int) ((Math.sqrt(2)/2)*distanceToReach);
			
			if(xDis < -disToReach) {
				//Right
				return "right";
			}
			if(xDis > disToReach) {
				//left
				return "left";
			}
			if(yDis < -disToReach) {
				//down
				return "down";
			}
			if(yDis > disToReach) {
				//up
				return "up";
			}
			return null;
		}
		return null;
	}
	public void resetMouse() {
		mousePressX = null;
		mousePressY = null;
		mouseDragX = null;
		mouseDragY = null;
	}
	
	public Integer getMouseX() {
		return mousePressX;
	}
	public Integer getMouseY() {
		return mousePressY;
	}
	
	public Integer getDistanceRadius() {
		return distanceToReach;
	}
	
	private static void updateKeys() {
		r = keys[KeyEvent.VK_R];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		updateKeys();

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		mousePressX = arg0.getX();
		mousePressY = arg0.getY();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		resetMouse();
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		mouseDragX = arg0.getX();
		mouseDragY = arg0.getY();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {

	}
}
