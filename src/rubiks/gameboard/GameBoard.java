package rubiks.gameboard;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

public class GameBoard {
	
	private int tileLength = 50;
	private boolean editable = false;
	private int localSize = -1;
	
	private int size;
	
	private Tile[][] gameBoard;
	
	
	public GameBoard(int size, int emptyX, int emptyY) {
		ArrayList<Color> colors = systematicColor((int) Math.pow(size,2));
		setSize(size);
		gameBoard = new Tile[size][size];
		int counter = 0;
		for(int j = 0; j < size; j++) {//X
			for(int i = 0; i < size; i++) {//Y
				
				if(emptyX == i && emptyY == j) {
					gameBoard[i][j] = new Tile(tileLength, Color.WHITE, i, j, size);
					continue;
				}
				
				gameBoard[i][j] = new Tile(tileLength, colors.get(counter) , i, j, size);
				counter++;
			}
		}
		
	}
	
	public GameBoard(int localSize, int size) {
		setSize(size);
		this.localSize = localSize;
		ArrayList<Color> colors = systematicColor((int) Math.pow(size,2));
		setEditable(true);
		gameBoard = new Tile[localSize][localSize];
		int counter = 0;
		for(int j = 0; j < localSize; j++) {//X
			for(int i = 0; i < localSize; i++) {//Y
				gameBoard[i][j] = new Tile(tileLength, colors.get(counter) , i, j, size, true);
				counter++;
			}
		}
		
	}
	
	public boolean swapTiles(int tile1X, int tile1Y, int tile2X, int tile2Y) {
		if(gameBoard[tile1X][tile1Y].getColor() != Color.WHITE && gameBoard[tile2X][tile2Y].getColor() != Color.WHITE)
			return false;

		Color tempColor = gameBoard[tile1X][tile1Y].getColor();
		
		gameBoard[tile1X][tile1Y].setColor(gameBoard[tile2X][tile2Y].getColor());
		
		gameBoard[tile2X][tile2Y].setColor(tempColor);
		return true;
		
	}
	
	public ArrayList<Color> systematicColor(int size) {
		ArrayList<Color> colorPicker = new ArrayList<>();
		colorPicker.add(new Color(148,0,211));
		colorPicker.add(new Color(109,88,176));
		colorPicker.add(new Color(0,0,255));
		colorPicker.add(new Color(0,255,0));
		colorPicker.add(new Color(255,255,0));
		colorPicker.add(new Color(255,177,0));
		colorPicker.add(new Color(255,0,0));
		colorPicker.add(new Color(0,0,0));
		colorPicker.add(new Color(128,128,128));
		colorPicker.add(new Color(153,0,0));
		colorPicker.add(new Color(255,0,127));
		
		ArrayList<Color> colors = new ArrayList<>();
		for(int i = 0; i < Math.sqrt(size)-1; i++) {
			for(int j = 0; j < (size-1)/(Math.sqrt(size)-1); j++) {
				colors.add(colorPicker.get(j));
			}
		}
		Collections.shuffle(colors);
		return colors;
	}
	
	public Tile[][] getGameBoard(){
		return gameBoard;
	}
	
	public void setGameBoard(Tile[][] gameBoard){
		this.gameBoard = gameBoard;
	}
	
	public int getGoalSize() {
		return localSize;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}
}
