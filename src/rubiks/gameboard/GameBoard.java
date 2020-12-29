package rubiks.gameboard;

import java.awt.Color;

public class GameBoard {
	
	private int tileLength = 50;
	
	
	private int size;
	
	private Tile[][] gameBoard;
	
	public GameBoard(int size, int emptyX, int emptyY) {
		setSize(size);
		gameBoard = new Tile[size][size];
		for(int j = 0; j < size; j++) {//X
			for(int i = 0; i < size; i++) {//Y
				
//				int startingPointX = (Driver.width - ((tileLength*width)+(tileSpacing*(width-1))))/2;
//				int startingPointY = (Driver.height - ((tileLength*height)+(tileSpacing*(height-1))))/2;
				
				
//				int tileX = startingPointX + (i*tileLength) + (tileSpacing*i);
//				int tileY = startingPointY + (j*tileLength) + (tileSpacing*j);
				
				if(emptyX == i && emptyY == j) {
					//gameBoard.add(new Tile(tileLength, tileLength, Color.WHITE, tileX, tileY, i+1, j+1, true));
					gameBoard[i][j] = new Tile(tileLength, Color.WHITE, i, j, size);
					continue;
				}
				gameBoard[i][j] = new Tile(tileLength, Color.RED, i, j, size);
			}
		}
		
	}
	
	public Tile[][] getGameBoard(){
		return gameBoard;
	}
	
	public void setGameBoard(Tile[][] gameBoard){
		this.gameBoard = gameBoard;
	}
	

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
