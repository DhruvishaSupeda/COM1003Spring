package assignment2018;

import java.util.*;
import assignment2018.Board;
import assignment2018.Move;

public class King extends Piece {

    public King(int ix, int iy, int c, Board b) {
        super(PieceCode.KING, ix, iy, c, b);
    }

    // method implements abstract availableMoves method in Piece class
    public ArrayList<Move> availableMoves() {
        return legalMoves();
    }

    private ArrayList<Move> legalRook() {
        // obtain current co-ordinates
        int x = this.getX();
        int y = this.getY();

        // Create a new vector to store legal legalMoves
        ArrayList<Move> legalMoves = new ArrayList<Move>();

        // set up m to refer to a Move object
        Move theMove = null;

        while ((!getBoard().occupied(x, y+i) || getBoard().occupied(x, y+i)
                && (getBoard().getPiece(x, y+i).getColour() != this.getColour()))
                && (!getBoard().outOfRange(x, y+i)) ) {

            if (getBoard().occupied(x, y+i) && (getBoard().getPiece(x, y+i).getColour() != this.getColour())) {
                
