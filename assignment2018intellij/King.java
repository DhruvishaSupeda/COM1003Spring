package assignment2018;

import java.util.*;
import assignment2018.Board;
import assignment2018.Move;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;

public class King extends Piece {

	public King(int ix, int iy, int c, Board b) {
		super(PieceCode.KING, ix, iy, c, b);
	}

	// method implements abstract availableMoves method in Piece class
	public ArrayList<Move> availableMoves() {
		return legalKing();
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
		if ((!getBoard().occupied(x, y + 1)
				|| getBoard().occupied(x, y + 1) && (getBoard().getPiece(x, y + 1).getColour() != this.getColour()))
				&& (!getBoard().outOfRange(x, y + 1))) {

			if (getBoard().occupied(x, y + 1) && (getBoard().getPiece(x, y + 1).getColour() != this.getColour())) {
				theMove = new Move(this, x, y, x, y + 1, true);
				legalMoves.add(theMove);
			} else {
				theMove = new Move(this, x, y, x, y + 1, false);
				legalMoves.add(theMove);
			}
		}

		// Checks square above king on the right
		if ((!getBoard().occupied(x + 1, y + 1) || getBoard().occupied(x + 1, y + 1)
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
		}

		// Checks square above king on the left
		if ((!getBoard().occupied(x - 1, y + 1) || getBoard().occupied(x - 1, y + 1)
				&& (getBoard().getPiece(x - 1, y + 1).getColour() != this.getColour()))
				&& (!getBoard().outOfRange(x - 1, y + 1))) {

			if (getBoard().occupied(x - 1, y + 1)
					&& (getBoard().getPiece(x - 1, y + 1).getColour() != this.getColour())) {
				theMove = new Move(this, x, y, x - 1, y + 1, true);
				legalMoves.add(theMove);
			} else {
				theMove = new Move(this, x, y, x - 1, y + 1, false);
				legalMoves.add(theMove);
			}
		}

		// Checks square on the left
		if ((!getBoard().occupied(x - 1, y)
				|| getBoard().occupied(x - 1, y) && (getBoard().getPiece(x - 1, y).getColour() != this.getColour()))
				&& (!getBoard().outOfRange(x - 1, y))) {

			if (getBoard().occupied(x - 1, y) && (getBoard().getPiece(x - 1, y).getColour() != this.getColour())) {
				theMove = new Move(this, x, y, x - 1, y, true);
				legalMoves.add(theMove);
			} else {
				theMove = new Move(this, x, y, x - 1, y, false);
				legalMoves.add(theMove);
			}
		}

		// Checks square on the right
		if ((!getBoard().occupied(x + 1, y)
				|| getBoard().occupied(x + 1, y) && (getBoard().getPiece(x + 1, y).getColour() != this.getColour()))
				&& (!getBoard().outOfRange(x + 1, y))) {

			if (getBoard().occupied(x + 1, y) && (getBoard().getPiece(x + 1, y).getColour() != this.getColour())) {
				theMove = new Move(this, x, y, x + 1, y, true);
				legalMoves.add(theMove);
			} else {
				theMove = new Move(this, x, y, x + 1, y, false);
				legalMoves.add(theMove);
			}
		}

		// Checks square below the king
		if ((!getBoard().occupied(x, y - 1)
				|| getBoard().occupied(x, y - 1) && (getBoard().getPiece(x, y - 1).getColour() != this.getColour()))
				&& (!getBoard().outOfRange(x, y - 1))) {

			if (getBoard().occupied(x, y - 1) && (getBoard().getPiece(x, y - 1).getColour() != this.getColour())) {
				theMove = new Move(this, x, y, x, y - 1, true);
				legalMoves.add(theMove);
			} else {
				theMove = new Move(this, x, y, x, y - 1, false);
				legalMoves.add(theMove);
			}
		}

		// Checks square below king on the left
		if ((!getBoard().occupied(x - 1, y - 1) || getBoard().occupied(x - 1, y - 1)
				&& (getBoard().getPiece(x - 1, y - 1).getColour() != this.getColour()))
				&& (!getBoard().outOfRange(x - 1, y - 1))) {

			if (getBoard().occupied(x - 1, y - 1)
					&& (getBoard().getPiece(x - 1, y - 1).getColour() != this.getColour())) {
				theMove = new Move(this, x, y, x - 1, y - 1, true);
				legalMoves.add(theMove);
			} else {
				theMove = new Move(this, x, y, x - 1, y - 1, false);
				legalMoves.add(theMove);
			}
		}

		// Checks square above king on the right
		if ((!getBoard().occupied(x + 1, y - 1) || getBoard().occupied(x + 1, y - 1)
				&& (getBoard().getPiece(x + 1, y - 1).getColour() != this.getColour()))
				&& (!getBoard().outOfRange(x + 1, y - 1))) {

			if (getBoard().occupied(x + 1, y - 1)
					&& (getBoard().getPiece(x + 1, y - 1).getColour() != this.getColour())) {
				theMove = new Move(this, x, y, x + 1, y - 1, true);
				legalMoves.add(theMove);
			} else {
				theMove = new Move(this, x, y, x + 1, y - 1, false);
				legalMoves.add(theMove);
			}
		}

		if (legalMoves.isEmpty())
			return null;
		return legalMoves;
	} // legalmoves end

} // class end
