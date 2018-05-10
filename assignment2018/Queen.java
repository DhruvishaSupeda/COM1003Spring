package assignment2018;

import java.util.*;
import assignment2018.Board;
import assignment2018.Move;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;

public class Queen extends Piece {

	public Queen(int ix, int iy, int c, Board b) {
		super(PieceCode.QUEEN, ix, iy, c, b);
	}

	public ArrayList<Move> availableMoves() {
		return legalQueen();
	}

	private ArrayList<Move> getYMove(int x, int y, int i, int sign) {
		Move theMove = null;
		ArrayList<Move> theMoves = new ArrayList<Move>();
		while (!(getBoard().outOfRange(x, y + i))) {
			if (getBoard().occupied(x, y + i)) {
				if (getBoard().getPiece(x, y + i).getColour() != this.getColour()) {
					theMove = new Move(this, x, y, x, y + i, true);
					theMoves.add(theMove);
					break;
				} else
					break;
			} else {
				theMove = new Move(this, x, y, x, y + i, false);
				theMoves.add(theMove);
			}
			i += sign;
		}
		return theMoves;
	}

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

    private ArrayList<Move> getBMoves(int x, int y, int i, int j, int isign, int jsign) {
        Move theMove = null;
        ArrayList<Move> theMoves = new ArrayList<Move>();
        while (!getBoard().outOfRange(x + i, y + j)) {
            if (getBoard().occupied(x + i, y + j)) {
                if (getBoard().getPiece(x + i, y + j).getColour() != this.getColour()) {
                    theMove = new Move(this, x, y, x + i, y + j, true);
                    // System.out.println(theMove.toString());
                    theMoves.add(theMove);
                    break;
                } else
                    break;
            } else {
                theMove = new Move(this, x, y, x + i, y + j, false);
                // System.out.println(theMove.toString());
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

		//BISHOP CRAP
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
