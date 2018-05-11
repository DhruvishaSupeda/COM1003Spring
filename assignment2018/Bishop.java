package assignment2018;

import java.util.*;
import assignment2018.Board;
import assignment2018.Move;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;

/**
 * Bishop.java
 * Class representing the bishop
 * @author Dhruvisha Supeda
 */
public class Bishop extends Piece {

	public Bishop(int ix, int iy, int c, Board b) {
		super(PieceCode.BISHOP, ix, iy, c, b);
	}

	// method implements abstract availableMoves method in Piece class
	public ArrayList<Move> availableMoves() {
		return legalBishop();
	}

	/**
	 * Checks the available moves of the bishop in a certain diagonal direction
	 * @param  x    current x coordinate
 	 * @param  y    current y coordinate
 	 * @param  i    number to add to the x coordinate
	 * @param  j    number to add to the y coordinate
	 * @param  isign integer saying whether to increase or decrease i with each loop
	 * @param  jsign integer saying whether to increase or decrease j with each loop
	 * @return        returns an array list of the possible moves in that particular direction
	 */
	private ArrayList<Move> getMoves(int x, int y, int i, int j, int isign, int jsign) {
	    Move theMove = null;
	    ArrayList<Move> theMoves = new ArrayList<Move>();
			//While the program doesn't look out of the range of the board
        while (!getBoard().outOfRange(x + i, y + j)) {
					//If position is occupied by the opponents piece, set occupied to true to make the move
            if (getBoard().occupied(x + i, y + j)) {
                if (getBoard().getPiece(x + i, y + j).getColour() != this.getColour()) {
                    theMove = new Move(this, x, y, x + i, y + j, true);
                    theMoves.add(theMove);
                    break;
                } else
                    break;
						//If position not occupied, set occupied to false to make the move
            } else {
                theMove = new Move(this, x, y, x + i, y + j, false);
                theMoves.add(theMove);
            }
            i += isign;
            j += jsign;
        }
        return theMoves;
    }

	private ArrayList<Move> legalBishop() {
		// obtain current co-ordinates
		int x = this.getX();
		int y = this.getY();

		// Create a new vector to store legal legalMoves
		ArrayList<Move> legalMoves = new ArrayList<Move>();

		// set up m to refer to a Move object
		Move theMove = null;

		int i = 1;
		int j = 1;
		legalMoves.addAll(getMoves(x, y, i, j, i, j));

		i = -1;
		j = 1;
        legalMoves.addAll(getMoves(x, y, i, j, i, j));

		i = -1;
		j = -1;
        legalMoves.addAll(getMoves(x, y, i, j, i, j));

		i = 1;
		j = -1;
        legalMoves.addAll(getMoves(x, y, i, j, i, j));


		if (legalMoves.isEmpty())
			return null;
		return legalMoves;
	}


}
