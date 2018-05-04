package assignment2018;

import java.util.*;
import assignment2018.Board;
import assignment2018.Move;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;

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
        while (!getBoard().outOfRange(x+i, y+j)) {
            if (getBoard().occupied(x+1, y+j)) {
                if (getBoard().getPiece(x+1, y+j).getColour() != this.getColour()) {
                    theMove = new Move(this, x, y, x+1 , y+j, true);
                    System.out.println(theMove.toString());
                    legalMoves.add(theMove);
                    break;
                }
                else
                    break;
            }
            else {
                theMove = new Move(this, x, y, x+1, y+j, false);
                System.out.println(theMove.toString());
                legalMoves.add(theMove);
            }
            i += 1;
            j+=1;
        }

        i=-1;
        j=1;
        while (!(getBoard().outOfRange(x+1, y + i)))  {
            if (getBoard().occupied(x+1, y+i)) {
                if (getBoard().getPiece(x+1, y+i).getColour() != this.getColour()) {
                    theMove = new Move(this, x, y, x+1 , y+i, true);
                    System.out.println(theMove.toString());
                    legalMoves.add(theMove);
                    break;
                }
                else
                    break;
            }
            else {
                theMove = new Move(this, x, y, x+1, y+i, false);
                System.out.println(theMove.toString());
                legalMoves.add(theMove);
            }
            i -= 1;
            j+=1;
        }

        i=-1;
        j=-1;
        while (!getBoard().outOfRange(x+i, y+j)) {
            if (getBoard().occupied(x+1, y+j)) {
                if (getBoard().getPiece(x+1, y+j).getColour() != this.getColour()) {
                    theMove = new Move(this, x, y, x+1 , y+j, true);
                    System.out.println(theMove.toString());
                    legalMoves.add(theMove);
                    break;
                }
                else
                    break;
            }
            else {
                theMove = new Move(this, x, y, x+1, y+j, false);
                System.out.println(theMove.toString());
                legalMoves.add(theMove);
            }
            i-=1;
            j-=1;
        }

        i=1;
        j=-1;
        while (!getBoard().outOfRange(x+i, y+j)) {
            if (getBoard().occupied(x+1, y+j)) {
                if (getBoard().getPiece(x+1, y+j).getColour() != this.getColour()) {
                    theMove = new Move(this, x, y, x+1 , y+j, true);
                    System.out.println(theMove.toString());
                    legalMoves.add(theMove);
                    break;
                }
                else
                    break;
            }
            else {
                theMove = new Move(this, x, y, x+1, y+j, false);
                System.out.println(theMove.toString());
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
