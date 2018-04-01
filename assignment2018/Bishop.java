package assignment2018;

import java.util.*;
import assignment2018.Board;
import assignment2018.Move;

public class Bishop extends Piece {

    public Bishop(int ix, int iy, int c, Board b) {
        super(PieceCode.BISHOP, ix, iy, c, b);
    }

    // method implements abstract availableMoves method in Piece class
    public ArrayList<Move> availableMoves() {
        return legalBishop();
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

        while ((!getBoard().occupied(x+i, y+j) || getBoard().occupied(x+i, y+j)
                && (getBoard().getPiece(x+i, y+j).getColour() != this.getColour()))
                && (!getBoard().outOfRange(x+i, y+j)) ) {

            if (getBoard().occupied(x+i, y+j) && (getBoard().getPiece(x+i, y+j).getColour() != this.getColour())) {
              theMove = new Move(this, x, y, x+i, y+j, true);
              legalMoves.add(theMove);
            }
            else {
              theMove = new Move(this, x, y, x+i, y+j, false);
              legalMoves.add(theMove);
            }
            i+=1;
            j+=1;
        }

        i=-1;
        j=1;
        while ((!getBoard().occupied(x+i, y+j) || getBoard().occupied(x+i, y+j)
                && (getBoard().getPiece(x+i, y+j).getColour() != this.getColour()))
                && (!getBoard().outOfRange(x+i, y+j)) ) {

            if (getBoard().occupied(x+i, y+j) && (getBoard().getPiece(x+i, y+j).getColour() != this.getColour())) {
              theMove = new Move(this, x, y, x+i, y+j, true);
              legalMoves.add(theMove);
            }
            else {
              theMove = new Move(this, x, y, x+i, y+j, false);
              legalMoves.add(theMove);
            }
            i-=1;
            j+=1;
        }

        i=-1;
        j=-1;
        while ((!getBoard().occupied(x+i, y+j) || getBoard().occupied(x+i, y+j)
                && (getBoard().getPiece(x+i, y+j).getColour() != this.getColour()))
                && (!getBoard().outOfRange(x+i, y+j)) ) {

            if (getBoard().occupied(x+i, y+j) && (getBoard().getPiece(x+i, y+j).getColour() != this.getColour())) {
              theMove = new Move(this, x, y, x+i, y+j, true);
              legalMoves.add(theMove);
            }
            else {
              theMove = new Move(this, x, y, x+i, y+j, false);
              legalMoves.add(theMove);
            }
            i-=1;
            j-=1;
        }

        i=1;
        j=-1;
        while ((!getBoard().occupied(x+i, y+j) || getBoard().occupied(x+i, y+j)
                && (getBoard().getPiece(x+i, y+j).getColour() != this.getColour()))
                && (!getBoard().outOfRange(x+i, y+j)) ) {

            if (getBoard().occupied(x+i, y+j) && (getBoard().getPiece(x+i, y+j).getColour() != this.getColour())) {
              theMove = new Move(this, x, y, x+i, y+j, true);
              legalMoves.add(theMove);
            }
            else {
              theMove = new Move(this, x, y, x+i, y+j, false);
              legalMoves.add(theMove);
            }
            i+=1;
            j-=1;
        }

        if (legalMoves.isEmpty())
            return null;
        return legalMoves;
    }
}
