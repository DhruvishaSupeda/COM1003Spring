package assignment2018;

import java.util.*;
import assignment2018.Board;
import assignment2018.Move;

public class Rook extends Piece {

    public Rook(int ix, int iy, int c, Board b) {
        super(PieceCode.ROOK, ix, iy, c, b);
    }

    //HIS CODE
    // method implements abstract availableMoves method in Piece class
    public ArrayList<Move> availableMoves() {
        return legalRook();

    public ArrayList<Move> moveYCoords() {
      //???? MAYBE NEED A WAY TO PUT THEM IN THE SAME ARRAYLIST IDK
      //IF ITS BY REFERENCE, CAN DO IT???
      //BUT ALSO NEED TO RETURN IT IDK DON'T WANT TO return
    }

    // method to return list of legal moves for a white rook
    private ArrayList<Move> legalRook() {
        // obtain current co-ordinates
        int x = this.getX();
        int y = this.getY();
        int i = 1;

        // Create a new vector to store legal legalMoves
        ArrayList<Move> legalMoves = new ArrayList<Move>();

        // set up m to refer to a Move object
        Move theMove = null;

        //GOING UP AS ROOK - while not occupied, or occupied by black AND in range
        while ((!getBoard().occupied(x, y+i) || getBoard().occupied(x, y+i)
                && (getBoard().getPiece(x, y+i).getColour() != this.getColour()))
                && (!getBoard().outOfRange(x, y+i)) ) {

            if (getBoard().occupied(x, y+i) && (getBoard().getPiece(x, y+i).getColour() != this.getColour())) {
              theMove = new Move(this, x, y, x, y+i, true);
              legalMoves.add(theMove);
            }
            else {
              theMove = new Move(this, x, y, x, y+i, false);
              legalMoves.add(theMove);
            }
            i+=1;
        }

        i=-1;
        while ((!getBoard().occupied(x, y+i) || getBoard().occupied(x, y+i)
                && (getBoard().getPiece(x, y+i).getColour() != this.getColour()))
                && (!getBoard().outOfRange(x, y+i)) ) {

            if (getBoard().occupied(x, y+i) && (getBoard().getPiece(x, y+1).getColour() != this.getColour())) {
              theMove = new Move(this, x, y, x, y+i, true);
              legalMoves.add(theMove);
            }
            else {
              theMove = new Move(this, x, y, x, y+i, false);
              legalMoves.add(theMove);
            }
            i-=1;
        }


        i=1;
        while ((!getBoard().occupied(x+i, y) || getBoard().occupied(x+i, y)
                && (getBoard().getPiece(x+i, y).getColour() != this.getColour()))
                && (!getBoard().outOfRange(x+i, y)) ) {

            if (getBoard().occupied(x+i, y) && (getBoard().getPiece(x+i, y).getColour() != this.getColour())) {
              theMove = new Move(this, x, y, x+i, y, true);
              legalMoves.add(theMove);
            }
            else {
              theMove = new Move(this, x, y, x+i, y, false);
              legalMoves.add(theMove);
            }
            i+=1;
        }

        i=-1;
        while ((!getBoard().occupied(x+i, y) || getBoard().occupied(x+i, y)
                && (getBoard().getPiece(x+i, y).getColour() != this.getColour()))
                && (!getBoard().outOfRange(x+i, y)) ) {

            if (getBoard().occupied(x+i, y) && (getBoard().getPiece(x+i, y).getColour() != this.getColour())) {
              theMove = new Move(this, x, y, x+i, y, true);
              legalMoves.add(theMove);
            }
            else {
              theMove = new Move(this, x, y, x+i, y, false);
              legalMoves.add(theMove);
            }
            i-=1;
        }

        if (legalMoves.isEmpty())
            return null;
        return legalMoves;
    }



}
