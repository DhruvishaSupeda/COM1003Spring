package assignment2018;

import java.util.*;
import assignment2018.Board;
import assignment2018.Move;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;

/**
 * King.java
 * Class representing the king
 * @author Dhruvisha Supeda
 */
public class King extends Piece {

	public King(int ix, int iy, int c, Board b) {
		super(PieceCode.KING, ix, iy, c, b);
	}

	// method implements abstract availableMoves method in Piece class
	public ArrayList<Move> availableMoves() {
		return legalKing();
	}

	private Move getMove(int x, int y, int i, int j) {
		Move theMove = null;
		if (!getBoard().outOfRange(x + i, y + j)) {
			if (getBoard().occupied(x + i, y + j) && (getBoard().getPiece(x + i, y + j).getColour() != this.getColour())) {
				theMove = new Move(this, x, y, x + i, y + j, true);
				return theMove;
			}
			if (!getBoard().occupied(x + i, y + j)) {
				theMove = new Move(this, x, y, x + i, y + j, false);
				return theMove;
			}
		}
	}

	private ArrayList<Move> legalKing() {
		// obtain current co-ordinates
		int x = this.getX();
		int y = this.getY();

		// Create a new vector to store legal legalMoves
		ArrayList<Move> legalMoves = new ArrayList<Move>();

		// set up m to refer to a Move object
		Move theMove = null;

		// Checks square above king
		int i=0;
		int j=1;
		theMove = getMove(x, y, i, j);
		legalMoves.add(theMove);

		// Checks square above king on the right
		/*if ((!getBoard().occupied(x + 1, y + 1) || getBoard().occupied(x + 1, y + 1)
				&& (getBoard().getPiece(x + 1, y + 1).getColour() != this.getColour()))
				&& (!getBoard().outOfRange(x + 1, y + 1))) {

			if (getBoard().occupied(x + 1, y + 1)
					&& (getBoard().getPiece(x + 1, y + 1).getColour() != this.getColour())) {
				theMove = new Move(this, x, y, x + 1, y + 1, true);
				legalMoves.add(theMove);
			} else {
				theMove = new Move(this, x, y, x + 1, y + 1, false);
				legalMoves.add(theMove);
			}
		}*/

		i=1;
		j=1;
		theMove = getMove(x, y, i, j);
		legalMoves.add(theMove);

		i=-1;
		j=1;
		theMove = getMove(x, y, i, j);
		legalMoves.add(theMove);

		i=-1;
		j=0;
		theMove = getMove(x, y, i, j);
		legalMoves.add(theMove);

		i=1;
		j=0;
		theMove = getMove(x, y, i, j);
		legalMoves.add(theMove);

		i=0;
		j=-1;
		theMove = getMove(x, y, i, j);
		legalMoves.add(theMove);

		i=-1;
		j=-1;
		theMove = getMove(x, y, i, j);
		legalMoves.add(theMove);

		i=1;
		j=-1;
		theMove = getMove(x, y, i, j);
		legalMoves.add(theMove);

		if (legalMoves.isEmpty())
			return null;
		return legalMoves;
	}

}
