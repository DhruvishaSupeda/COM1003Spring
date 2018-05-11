package assignment2018;

import assignment2018.codeprovided.*;
import assignment2018.codeprovided.PieceCode;

/**
 * TextDisplay.java
 * Class which initialises and shows the state of the board in the console using an array
 * @author Dhruvisha Supeda
 */
public class TextDisplay implements Display {
	private final int BOARD_HEIGHT = 8;
	private final int BOARD_WIDTH = 8;

	private char[][] pieceArray = new char[BOARD_WIDTH][BOARD_HEIGHT];
	private boolean displayNeeded;

	public TextDisplay() {
		for (int x = 0; x < BOARD_WIDTH; x++) {
			for (int y = 0; y < BOARD_HEIGHT; y++) {
				pieceArray[x][y] = '.';
			}
		}
	}

	/**
	 * Displays the board in the console using the board object
	 * @param myPieces Pieces arraylist used to get the current board
	 */
	public void displayBoard(Pieces myPieces) {
		Board playingBoard = myPieces.getPiece(0).getBoard();
		System.out.println(" |A B C D E F G H");
		System.out.println("- - - - - - - - -");
		for (int y = 0; y < BOARD_HEIGHT; y++) {
			System.out.print(BOARD_HEIGHT - y + "|");
			for (int x = 0; x < BOARD_WIDTH; x++) {
				if (playingBoard.getPiece(x, y) != null)
					System.out.print(playingBoard.getPiece(x, y).getChar() + " ");
				else
					System.out.print(". ");
			}
			System.out.println();
		}
	}

	public void setDisplayNeeded(boolean needed) {
		displayNeeded = needed;
	}

	public boolean getDisplayNeeded() {
		return displayNeeded;
	}

}
