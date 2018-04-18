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

    private ArrayList<Move> legalQueen() {
        // obtain current co-ordinates
        int x = this.getX();
        int y = this.getY();

        // Create a new vector to store legal legalMoves
        ArrayList<Move> legalMoves = new ArrayList<Move>();

        // set up m to refer to a Move object
        Move theMove = null;
        int i=1;
        int j=1;

        //GOING UP AS ROOK - while not occupied, or occupied by black AND in range
          i = 1;
          while ((!getBoard().outOfRange(x, y + i)) ) {
              if (getBoard().occupied(x, y + i) && (getBoard().getPiece(x, y + i).getColour() != this.getColour())) {
                  theMove = new Move(this, x, y, x, y + i, true);
                  legalMoves.add(theMove);
              }
              if (!getBoard().occupied(x, y + i)) {
                  theMove = new Move(this, x, y, x, y + i, false);
                  legalMoves.add(theMove);
              }
              i += 1;
          }


          i = -1;
          while (!getBoard().outOfRange(x, y + i)) {
              if (getBoard().occupied(x, y + i) && (getBoard().getPiece(x, y + 1).getColour() != this.getColour())) {
                  theMove = new Move(this, x, y, x, y + i, true);
                  legalMoves.add(theMove);
              }
              if (!getBoard().occupied(x, y + i)) {
                  theMove = new Move(this, x, y, x, y + i, false);
                  legalMoves.add(theMove);
              }
              i -= 1;
          }

          i = 1;
          while (!getBoard().outOfRange(x + i, y)) {
              if (getBoard().occupied(x + i, y) && (getBoard().getPiece(x + i, y).getColour() != this.getColour())) {
                  theMove = new Move(this, x, y, x + i, y, true);
                  legalMoves.add(theMove);
              }
              if (!getBoard().occupied(x + i, y)) {
                  theMove = new Move(this, x, y, x + i, y, false);
                  legalMoves.add(theMove);
              }
              i += 1;
          }


          i = -1;
          while (!getBoard().outOfRange(x + i, y)) {
              if (getBoard().occupied(x + i, y) && (getBoard().getPiece(x + i, y).getColour() != this.getColour())) {
                  theMove = new Move(this, x, y, x + i, y, true);
                  legalMoves.add(theMove);
              }
              if (getBoard().occupied(x + i, y)) {
                  theMove = new Move(this, x, y, x + i, y, false);
                  legalMoves.add(theMove);
              }
              i -= 1;
          }

        //COPIED FROM BISHOP TO GO DIAGONAL
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
