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
        if (getColour() == PieceCode.WHITE)
            return whitePawn();
        else
            return blackPawn();
    }

    public ArrayList<Move> moveYCoords() {
      //???? MAYBE NEED A WAY TO PUT THEM IN THE SAME ARRAYLIST IDK
      //IF ITS BY REFERENCE, CAN DO IT???
      //BUT ALSO NEED TO RETURN IT IDK DON'T WANT TO return
    }

    // method to return list of legal moves for a white rook
    private ArrayList<Move> whiteRook() {
        // obtain current co-ordinates
        int x = this.getX();
        int y = this.getY();
        int i = 1;

        // Create a new vector to store legal whiteMoves
        ArrayList<Move> whiteMoves = new ArrayList<Move>();

        // set up m to refer to a Move object
        Move theMove = null;

        //GOING UP AS ROOK - while not occupied, or occupied by black AND in range
        while (()!getBoard().occupied(x, y+1) || getBoard().occupied(x, y+1)
                && (getBoard().getPiece(x, y+1).getColour() != this.getColour()))
                && (!getBoard().outOfRange(x, y+1)) ) {

            if (getBoard().occupied(x, y+1) && (getBoard().getPiece(x, y+1).getColour() != this.getColour())) {
              theMove = new Move(this, x, y, x, y+1, true);
              whiteMoves.add(theMove);
            }
            else {
              theMove = new Move(this, x, y, x, y+1, false);
              whiteMoves.add(theMove);
            }
            i+=1;
        }

        i=-1;
        while (()!getBoard().occupied(x, y+1) || getBoard().occupied(x, y+1)
                && (getBoard().getPiece(x, y+1).getColour() != this.getColour()))
                && (!getBoard().outOfRange(x, y+1)) ) {

            if (getBoard().occupied(x, y+1) && (getBoard().getPiece(x, y+1).getColour() != this.getColour())) {
              theMove = new Move(this, x, y, x, y+1, true);
              whiteMoves.add(theMove);
            }
            else {
              theMove = new Move(this, x, y, x, y+1, false);
              whiteMoves.add(theMove);
            }
            i+=1;
        }


        i=1;
        while (()!getBoard().occupied(x+i, y) || getBoard().occupied(x+i, y)
                && (getBoard().getPiece(x+i, y).getColour() != this.getColour()))
                && (!getBoard().outOfRange(x+i, y)) ) {

            if (getBoard().occupied(x+i, y) && (getBoard().getPiece(x+i, y).getColour() != this.getColour())) {
              theMove = new Move(this, x, y, x+i, y, true);
              whiteMoves.add(theMove);
            }
            else {
              theMove = new Move(this, x, y, x+i, y, false);
              whiteMoves.add(theMove);
            }
            i+=1;
        }

        i=-1;
        while (()!getBoard().occupied(x+i, y) || getBoard().occupied(x+i, y)
                && (getBoard().getPiece(x+i, y).getColour() != this.getColour()))
                && (!getBoard().outOfRange(x+i, y)) ) {

            if (getBoard().occupied(x+i, y) && (getBoard().getPiece(x+i, y).getColour() != this.getColour())) {
              theMove = new Move(this, x, y, x+i, y, true);
              whiteMoves.add(theMove);
            }
            else {
              theMove = new Move(this, x, y, x+i, y, false);
              whiteMoves.add(theMove);
            }
            i+=1;
        }

        if (whiteMoves.isEmpty())
            return null;
        return whiteMoves;
    }

    // method to return list of legal moves for a black rook
    private ArrayList<Move> blackRook() {
        // obtain current co-ordinates
        int x = this.getX();
        int y = this.getY();
        int i = 1;

        // Create a new vector to store legal blackMoves
        ArrayList<Move> blackMoves = new ArrayList<Move>();

        // set up m to refer to a Move object
        Move theMove = null;

        //GOING UP AS ROOK - while not occupied, or occupied by black AND in range
        while (()!getBoard().occupied(x, y+1) || getBoard().occupied(x, y+1)
                && (getBoard().getPiece(x, y+1).getColour() != this.getColour()))
                && (!getBoard().outOfRange(x, y+1)) ) {

            if (getBoard().occupied(x, y+1) && (getBoard().getPiece(x, y+1).getColour() != this.getColour())) {
              theMove = new Move(this, x, y, x, y+1, true);
              blackMoves.add(theMove);
            }
            else {
              theMove = new Move(this, x, y, x, y+1, false);
              blackMoves.add(theMove);
            }
            i+=1;
        }

        i=-1;
        while (()!getBoard().occupied(x, y+1) || getBoard().occupied(x, y+1)
                && (getBoard().getPiece(x, y+1).getColour() != this.getColour()))
                && (!getBoard().outOfRange(x, y+1)) ) {

            if (getBoard().occupied(x, y+1) && (getBoard().getPiece(x, y+1).getColour() != this.getColour())) {
              theMove = new Move(this, x, y, x, y+1, true);
              blackMoves.add(theMove);
            }
            else {
              theMove = new Move(this, x, y, x, y+1, false);
              blackMoves.add(theMove);
            }
            i+=1;
        }


        i=1;
        while (()!getBoard().occupied(x+i, y) || getBoard().occupied(x+i, y)
                && (getBoard().getPiece(x+i, y).getColour() != this.getColour()))
                && (!getBoard().outOfRange(x+i, y)) ) {

            if (getBoard().occupied(x+i, y) && (getBoard().getPiece(x+i, y).getColour() != this.getColour())) {
              theMove = new Move(this, x, y, x+i, y, true);
              blackMoves.add(theMove);
            }
            else {
              theMove = new Move(this, x, y, x+i, y, false);
              blackMoves.add(theMove);
            }
            i+=1;
        }

        i=-1;
        while (()!getBoard().occupied(x+i, y) || getBoard().occupied(x+i, y)
                && (getBoard().getPiece(x+i, y).getColour() != this.getColour()))
                && (!getBoard().outOfRange(x+i, y)) ) {

            if (getBoard().occupied(x+i, y) && (getBoard().getPiece(x+i, y).getColour() != this.getColour())) {
              theMove = new Move(this, x, y, x+i, y, true);
              blackMoves.add(theMove);
            }
            else {
              theMove = new Move(this, x, y, x+i, y, false);
              blackMoves.add(theMove);
            }
            i+=1;
        }

        if (blackMoves.isEmpty())
            return null;
        return blackMoves;
    }

}
