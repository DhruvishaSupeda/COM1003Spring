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

    //HIS CODE
    // method implements abstract availableMoves method in Piece class
    public ArrayList<Move> availableMoves() {
        return legalRook();
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
        Move theMove = null;

        //GOING UP AS ROOK - while not occupied, or occupied by black AND in range
          i = 1;
        while (!(getBoard().outOfRange(x, y + i)))  {
            if (getBoard().occupied(x, y + i) && (getBoard().getPiece(x, y + i).getColour() != this.getColour())) {
                theMove = new Move(this, x, y, x, y + i, true);
                legalMoves.add(theMove);
                break;
            }
            if (!getBoard().occupied(x, y + i)) {
                theMove = new Move(this, x, y, x, y + i, false);
                legalMoves.add(theMove);
            }
            if (getBoard().occupied(x, y + i) && (getBoard().getPiece(x, y + i).getColour() == this.getColour())) {
                break;
            }
            i += 1;
        }


        i = 1;
        while (!getBoard().outOfRange(x, y - i)) {
            System.out.println(x + "AND" + (y-i));
            if (getBoard().occupied(x, y - i) && (getBoard().getPiece(x, y - 1).getColour() != this.getColour())) {
                theMove = new Move(this, x, y, x, y - i, true);
                legalMoves.add(theMove);
                break;
            }
            if (!getBoard().occupied(x, y - i)) {
                theMove = new Move(this, x, y, x, y - i, false);
                legalMoves.add(theMove);
            }
            if (getBoard().occupied(x, y - i) && (getBoard().getPiece(x, y - 1).getColour() == this.getColour())) {
                break;
            }
            i += 1;
        }

        i = 1;
        while (!getBoard().outOfRange(x + i, y)) {
            if (getBoard().occupied(x + i, y) && (getBoard().getPiece(x + i, y).getColour() != this.getColour())) {
                theMove = new Move(this, x, y, x + i, y, true);
                legalMoves.add(theMove);
                break;
            }
            if (!getBoard().occupied(x + i, y)) {
                theMove = new Move(this, x, y, x + i, y, false);
                legalMoves.add(theMove);
            }
            if (getBoard().occupied(x + i, y) && (getBoard().getPiece(x + i, y).getColour() == this.getColour())) {
                break;
            }
            i += 1;
        }


        i = 1;
        while (!(getBoard().outOfRange(x - i, y))) {
            if (getBoard().occupied(x - i, y) && (getBoard().getPiece(x - i, y).getColour() != this.getColour())) {
                theMove = new Move(this, x, y, x - i, y, true);
                legalMoves.add(theMove);
                break;
            }
            if (!getBoard().occupied(x - i, y)) {
                theMove = new Move(this, x, y, x - i, y, false);
                legalMoves.add(theMove);
            }
            if (getBoard().occupied(x - i, y) && (getBoard().getPiece(x - i, y).getColour() == this.getColour())) {
                break;
            }
            i += 1;
        }

        if (legalMoves.isEmpty())
            return null;
        return legalMoves;
    }



}
