package assignment2018;

import java.util.*;
import assignment2018.Board;
import assignment2018.Move;

public class Queen extends Piece {

    public Queen(int ix, int iy, int c, Board b) {
        super(PieceCode.QUEEN, ix, iy, c, b);
    }

    //HIS CODE
    // method implements abstract availableMoves method in Piece class
    public ArrayList<Move> availableMoves() {
        if (getColour() == PieceCode.WHITE)
            return whitePawn();
        else
            return blackPawn();
    }
