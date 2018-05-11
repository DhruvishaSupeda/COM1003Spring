package assignment2018;

import java.util.*;
import assignment2018.Board;
import assignment2018.Move;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;

/**
 * Queen.java 
 * Class representing the queen
 * 
 * @author Dhruvisha Supeda
 */
public class Queen extends Piece {

	public Queen(int ix, int iy, int c, Board b) {
		super(PieceCode.QUEEN, ix, iy, c, b);
	}

	public ArrayList<Move> availableMoves() {
		return legalQueen();
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
	 * Checks the available moves of the bishop in a certain diagonal direction
	 * 
	 * @param x
	 *            current x coordinate
	 * @param y
	 *            current y coordinate
	 * @param i
	 *            number to add to the x coordinate
	 * @param j
	 *            number to add to the y coordinate
	 * @param isign
	 *            integer saying whether to increase or decrease i with each loop
	 * @param jsign
	 *            integer saying whether to increase or decrease j with each loop
	 * @return returns an array list of the possible moves in that particular
	 *         direction
	 */
	private ArrayList<Move> getBMoves(int x, int y, int i, int j, int isign, int jsign) {
		Move theMove = null;
		ArrayList<Move> theMoves = new ArrayList<Move>();
		// While the program doesn't look out of the range of the board
		while (!getBoard().outOfRange(x + i, y + j)) {
			// If position is occupied by the opponents piece, set occupied to true to make
			// the move
			if (getBoard().occupied(x + i, y + j)) {
				if (getBoard().getPiece(x + i, y + j).getColour() != this.getColour()) {
					theMove = new Move(this, x, y, x + i, y + j, true);
					theMoves.add(theMove);
					break;
				} else
					break;
				// If position not occupied, set occupied to false to make the move
			} else {
				theMove = new Move(this, x, y, x + i, y + j, false);
				theMoves.add(theMove);
			}
			i += isign;
			j += jsign;
		}
		return theMoves;
	}

	private ArrayList<Move> legalQueen() {
		// obtain current co-ordinates
		int x = this.getX();
		int y = this.getY();

		// Create a new vector to store legal legalMoves
		ArrayList<Move> legalMoves = new ArrayList<Move>();
		ArrayList<Move> theMoves = new ArrayList<Move>();

		// set up m to refer to a Move object
		Move theMove = null;
		int i = 1;
		int j = 1;

		i = 1;
		theMoves = getYMove(x, y, i, 1);
		legalMoves.addAll(theMoves);

		i = -1;
		theMoves = getYMove(x, y, i, -1);
		legalMoves.addAll(theMoves);

		i = 1;
		theMoves = getXMove(x, y, i, 1);
		legalMoves.addAll(theMoves);

		i = -1;
		theMoves = getXMove(x, y, i, -1);
		legalMoves.addAll(theMoves);

		i = 1;
		j = 1;
		legalMoves.addAll(getBMoves(x, y, i, j, i, j));

		i = -1;
		j = 1;
		legalMoves.addAll(getBMoves(x, y, i, j, i, j));

		i = -1;
		j = -1;
		legalMoves.addAll(getBMoves(x, y, i, j, i, j));

		i = 1;
		j = -1;
		legalMoves.addAll(getBMoves(x, y, i, j, i, j));

		if (legalMoves.isEmpty())
			return null;
		return legalMoves;
	}

}
