package assignment2018;

import java.util.*;
import assignment2018.Board;
import assignment2018.Move;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;

public class Knight extends Piece {

    public Knight(int ix, int iy, int c, Board b) {
        super(PieceCode.KNIGHT, ix, iy, c, b);
    }

    //HIS CODE
    // method implements abstract availableMoves method in Piece class
    public ArrayList<Move> availableMoves() {
        return legalKnight();
    }

    private ArrayList<Move> legalKnight() {
        // obtain current co-ordinates
        int x = this.getX();
        int y = this.getY();

        // otherwise create a new vector to store legal legalMoves
        ArrayList<Move> legalMoves = new ArrayList<Move>();

        // set up m to refer to a Move object
        Move theMove = null;

        // first legal move is to go from x,y to x-1,y+2
        if ((!getBoard().occupied(x-1, y+2)) || (getBoard().occupied(x-1, y+2)
                && (getBoard().getPiece(x-1, y+2).getColour() != this.getColour()))
                && (!getBoard().outOfRange(x-1, y+2)) ) {

            if (getBoard().occupied(x-1, y+2) && (getBoard().getPiece(x-1, y+2).getColour() != this.getColour())) {
              theMove = new Move(this, x, y, x-1, y+2, true);
              legalMoves.add(theMove);
            }
            else {
              theMove = new Move(this, x, y, x-1, y+2, false);
              legalMoves.add(theMove);
            }
        }

        if ((!getBoard().occupied(x+1, y+2)) || (getBoard().occupied(x+1, y+2)
                && (getBoard().getPiece(x+1, y+2).getColour() != this.getColour()))
                && (!getBoard().outOfRange(x+1, y+2)) ) {

            if (getBoard().occupied(x+1, y+2) && (getBoard().getPiece(x+1, y+2).getColour() != this.getColour())) {
              theMove = new Move(this, x, y, x+1, y+2, true);
              legalMoves.add(theMove);
            }
            else {
              theMove = new Move(this, x, y, x+1, y+2, false);
              legalMoves.add(theMove);
            }
        }

        if ((!getBoard().occupied(x+1, y-2)) || (getBoard().occupied(x+1, y-2)
                && (getBoard().getPiece(x+1, y-2).getColour() != this.getColour()))
                && (!getBoard().outOfRange(x+1, y-2)) ) {

            if (getBoard().occupied(x+1, y-2) && (getBoard().getPiece(x+1, y-2).getColour() != this.getColour())) {
              theMove = new Move(this, x, y, x+1, y-2, true);
              legalMoves.add(theMove);
            }
            else {
              theMove = new Move(this, x, y, x+1, y-2, false);
              legalMoves.add(theMove);
            }
        }

        if ((!getBoard().occupied(x-1, y-2)) || (getBoard().occupied(x-1, y-2)
                && (getBoard().getPiece(x-1, y-2).getColour() != this.getColour()))
                && (!getBoard().outOfRange(x-1, y-2)) ) {

            if (getBoard().occupied(x-1, y-2) && (getBoard().getPiece(x-1, y-2).getColour() != this.getColour())) {
              theMove = new Move(this, x, y, x-1, y-2, true);
              legalMoves.add(theMove);
            }
            else {
              theMove = new Move(this, x, y, x-1, y-2, false);
              legalMoves.add(theMove);
            }
        }

        if (legalMoves.isEmpty())
            return null;
        return legalMoves;

    }




}
