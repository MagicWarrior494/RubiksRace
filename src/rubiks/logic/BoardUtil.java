package rubiks.logic;

import java.awt.Color;

import rubiks.gameboard.GameBoard;
import rubiks.gameboard.Tile;

public class BoardUtil {
	public BoardUtil() {

	}
	  
	public Boolean onTile(GameBoard board, Integer mouseX, Integer mouseY, String direction) {
		Tile[][] gameBoard = board.getGameBoard();
		int tileLength = gameBoard[0][0].getSize();
		for(int i = 0; i < gameBoard.length; i ++) {
			for(int j = 0; j < gameBoard[0].length; j++) {
				if(gameBoard[i][j].getScreenX() <= mouseX && gameBoard[i][j].getScreenX() + tileLength >= mouseX && gameBoard[i][j].getScreenY() <= mouseY && gameBoard[i][j].getScreenY() + tileLength >= mouseY) {
					return checkTileRow(board, direction, i, j);
				}
			}
		}
		return null;
	}
	
	public boolean checkWin(GameBoard gameBoard, GameBoard goal) {
		int goalLength = goal.getGoalSize();
		int boardLength = gameBoard.getSize();
		int startingPosition  = (boardLength - goalLength)/2;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(!gameBoard.getGameBoard()[j+startingPosition][i+startingPosition].getColor().equals(goal.getGameBoard()[j][i].getColor())) {
					return false;
				}
			}
		}
		return true;
	}
	
	public Boolean checkTileRow(GameBoard board, String direction, int tileX, int tileY) {
		Tile[][] gameBoard = board.getGameBoard();
		switch(direction){
		case("left"):
			for(int i = 0; i <= tileX; i++) {
				if(gameBoard[i][tileY].getColor() == Color.WHITE) {
					for(int j = i;  j < tileX; j++) {
						board.swapTiles(j, tileY, j+1, tileY);
						
					}
					return true;
				}
			}
		case("right"):
			for(int i = tileX; i <= gameBoard[tileY].length - 1; i++) {
				if(gameBoard[i][tileY].getColor() == Color.WHITE) {
					for(int j = i;  j > tileX; j--) {
						board.swapTiles(j, tileY, j-1, tileY);
					}
					return true;
				}
			}
		case("up"):
			for(int i = 0; i <= tileY; i++) {
				if(gameBoard[tileX][i].getColor() == Color.WHITE) {
					for(int j = i;  j < tileY; j++) {
						board.swapTiles(tileX, j, tileX, j+1);
					}
					return true;
				}
			}
		case("down"):
			for(int i = tileY; i <= gameBoard.length - 1; i++) {
				if(gameBoard[tileX][i].getColor() == Color.WHITE) {
					for(int j = i;  j > tileY; j--) {
						board.swapTiles(tileX,j, tileX, j-1);
					}
					return true;
				}
			}
		default:
			return null;
		}
	}
}
