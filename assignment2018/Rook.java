package assignment2018;

import java.util.*;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;
import assignment2018.Board;
import assignment2018.Move;

/**
 * Rook.java 
 * Class representing the rook
 * 
 * @author Dhruvisha Supeda
 */
public class Rook extends Piece {

	public Rook(int ix, int iy, int c, Board b) {
		super(PieceCode.ROOK, ix, iy, c, b);
	}

	// method implements abstract availableMoves method in Piece class
	// returns the legal moves
	public ArrayList<Move> availableMoves() {
		return legalRook();
	}

	/**
	 * Method to get the moves from the rook moving in the y direction
	 * 
	 * @param x
	 *            current x coordinate
	 * @param y
	 *            current y coordinate
	 * @param i
	 *            number to add to the y coordinate
	 * @param sign
	 *            positive or negative depending on which direction the program is
	 *            looking for moves
	 * @return returns an array list of the possible moves in that particular
	 *         direction
	 */
	private ArrayList<Move> getYMove(int x, int y, int i, int sign) {
		Move theMove = null;
		ArrayList<Move> theMoves = new ArrayList<Move>();
		// While it doesn't check outside the range of the board
		while (!(getBoard().outOfRange(x, y + i))) {
			// If occupied by an opponents piece, adds a new move with the occupied boolean
			// set to true
			if (getBoard().occupied(x, y + i)) {
				if (getBoard().getPiece(x, y + i).getColour() != this.getColour()) {
					theMove = new Move(this, x, y, x, y + i, true);
					theMoves.add(theMove);
					break;
				} else
					break;
				// If the coordinate isn't occupied, adds a new move with the occupied boolean
				// set to false
			} else {
				theMove = new Move(this, x, y, x, y + i, false);
				theMoves.add(theMove);
			}
			// Adds one of the sign to the value of i to check the next place along
			i += sign;
		}
		return theMoves;
	}

	/**
	 * Method to get the moves from the rook moving in the x direction
	 * 
	 * @param x
	 *            current x coordinate
	 * @param y
	 *            current y coordinate
	 * @param i
	 *            number to add to the y coordinate
	 * @param sign
	 *            positive or negative depending on which direction the program is
	 *            looking for moves
	 * @return returns an array list of the possible moves in that particular
	 *         direction
	 */
	private ArrayList<Move> getXMove(int x, int y, int i, int sign) {
		Move theMove = null;
		ArrayList<Move> theMoves = new ArrayList<Move>();
		while (!getBoard().outOfRange(x + i, y)) {
			if (getBoard().occupied(x + i, y)) {
				if (getBoard().getPiece(x + i, y).getColour() != this.getColour()) {
					theMove = new Move(this, x, y, x + i, y, true);
					theMoves.add(theMove);
					break;
				} else
					break;
			} else {
				theMove = new Move(this, x, y, x + i, y, false);
				theMoves.add(theMove);
			}
			i += sign;
		}
		return theMoves;
	}

	/**
	 * Gets all of the available moves for the piece into an array list
	 * 
	 * @return ArrayList of all possible moves
	 */
	private ArrayList<Move> legalRook() {
		// obtain current co-ordinates
		int x = this.getX();
		int y = this.getY();
		int i = 0;

		// Create a new vector to store legal legalMoves
		ArrayList<Move> legalMoves = new ArrayList<Move>();

		// set up m to refer to a Move object
		ArrayList<Move> theMoves = new ArrayList<Move>();

		// Checking north
		i = 1;
		theMoves = getYMove(x, y, i, 1);
		legalMoves.addAll(theMoves);

		// Checking south
		i = -1;
		theMoves = getYMove(x, y, i, -1);
		legalMoves.addAll(theMoves);

		// Checking east
		i = 1;
		theMoves = getXMove(x, y, i, 1);
		legalMoves.addAll(theMoves);

		// Checking west
		i = -1;
		theMoves = getXMove(x, y, i, -1);
		legalMoves.addAll(theMoves);

		if (legalMoves.isEmpty())
			return null;
		return legalMoves;
	}
}
