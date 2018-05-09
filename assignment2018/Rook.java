package assignment2018;

import java.util.*;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;
import assignment2018.Board;
import assignment2018.Move;

public class Rook extends Piece {

	public Rook(int ix, int iy, int c, Board b) {
		super(PieceCode.ROOK, ix, iy, c, b);
	}

	// method implements abstract availableMoves method in Piece class
	// returns the legal moves
	public ArrayList<Move> availableMoves() {
		return legalRook();
	}

	public ArrayList<Move> getYMove(int x, int y, int i, int sign) {
	    Move theMove = null;
        ArrayList<Move> theMoves = new ArrayList<Move>();
        while (!(getBoard().outOfRange(x, y + i))) {
            if (getBoard().occupied(x, y + i)) {
                if (getBoard().getPiece(x, y + i).getColour() != this.getColour()) {
                    theMove = new Move(this, x, y, x, y + i, true);
                    // System.out.println(theMove.toString());
                    theMoves.add(theMove);
                    break;
                } else
                    break;
            } else {
                theMove = new Move(this, x, y, x, y + i, false);
                // System.out.println(theMove.toString());
                theMoves.add(theMove);
            }
            i += sign;
        }
        return theMoves;
    }

    public ArrayList<Move> getXMove(int x, int y, int i, int sign) {
	    Move theMove = null;
        ArrayList<Move> theMoves = new ArrayList<Move>();
        while (!getBoard().outOfRange(x + i, y)) {
            if (getBoard().occupied(x + i, y)) {
                if (getBoard().getPiece(x + i, y).getColour() != this.getColour()) {
                    theMove = new Move(this, x, y, x + i, y, true);
                     System.out.println(theMove.toString());
                    theMoves.add(theMove);
                    break;
                } else
                    break;
            } else {
                theMove = new Move(this, x, y, x + i, y, false);
                 System.out.println(theMove.toString());
                theMoves.add(theMove);
            }
            i += sign;
        }
        return theMoves;
    }

	// method to return list of legal moves for a white rook
	private ArrayList<Move> legalRook() {
		// obtain current co-ordinates
		int x = this.getX();
		int y = this.getY();
		int i = 0;

		// Create a new vector to store legal legalMoves
		ArrayList<Move> legalMoves = new ArrayList<Move>();

		// set up m to refer to a Move object
		ArrayList<Move> theMoves = new ArrayList<Move>();

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

		if (legalMoves.isEmpty())
			return null;
		return legalMoves;
	}
}
