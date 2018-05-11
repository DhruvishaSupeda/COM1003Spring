package assignment2018;

import assignment2018.codeprovided.*;

/**
 * Board.java
 *
 * Class representing the board of the game, storing the pieces as an array
 * 
 * @author Dhruvisha Supeda
 */
public class Board {
	private Piece playingBoard[][] = new Piece[8][8];
	private final int BOARD_HEIGHT = 8;
	private final int BOARD_WIDTH = 8;

	public Board() {
		for (int row = 0; row < 8; row++) {
			for (int column = 0; column < 8; column++)
				playingBoard[row][column] = null;
		}
	}

	public void setPosition(int x, int y, Piece piece) {
		playingBoard[x][y] = piece;
	}

	/**
	 * Removes the piece from the current board
	 * 
	 * @param x
	 *            x coordinate of piece to be removed
	 * @param y
	 *            y coordinate of piece to be removed
	 */
	public void removePiece(int x, int y) {
		playingBoard[x][y] = null;
	}

	public Piece getPiece(int x, int y) {
		return playingBoard[x][y];
	}

	/**
	 * Checks if the position specified is occupied by a piece
	 * 
	 * @param x
	 *            x coordinate of position to be checked
	 * @param y
	 *            x coordinate of position to be checked
	 * @return boolean that is true if the position is occupied, otherwise false
	 */
	public boolean occupied(int x, int y) {
		if (!outOfRange(x, y) && (playingBoard[x][y] != null))
			return true;
		else
			return false;
	}

	/**
	 * Checks if the position given is out of range of the board
	 * 
	 * @param x
	 *            x coordinate of position to be checked
	 * @param y
	 *            x coordinate of position to be checked
	 * @return boolean that is true if the position is out of range, otherwise false
	 */
	public boolean outOfRange(int x, int y) {
		if (x > 7 || y > 7 || x < 0 || y < 0)
			return true;
		else
			return false;
	}

	public String toString() {
		String arrayString = "";
		for (int i = 0; i < BOARD_WIDTH; i++) {
			for (int j = 0; j < BOARD_HEIGHT; j++) {
				if (playingBoard[i][j] != null)
					arrayString = arrayString + playingBoard[i][j].toString();
			}
		}
		return arrayString;
	}

}
