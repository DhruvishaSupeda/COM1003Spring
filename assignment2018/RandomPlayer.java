package assignment2018;

import assignment2018.*;
import assignment2018.codeprovided.*;

import java.util.*;

public class RandomPlayer extends Player {

    private String name;
    private Pieces pieces;
    private Board playingBoard;
    private Player opponent;

    public RandomPlayer(String n, Pieces p, Board b, Player o) {
      super(n,p,b,o);
      name = n;
      pieces = p;
      playingBoard = b;
      opponent = o;
    }

    public boolean makeMove() {
      return false;
    }

    public ArrayList<Move> getMoves() {
      Piece currentPiece = null;
      ArrayList<Move> allMoves = new ArrayList<Move>();
      for (int i = 0; i<getPieces().getNumPieces(); i++) {
        currentPiece = getPieces().getPiece(i);
        if (currentPiece.availableMoves() != null) {
          allMoves.addAll(currentPiece.availableMoves());
        }
      }
      return allMoves;
    }

    public void movePieces(boolean occupiedFlag, Piece currentPiece, int[] arrayOfCoords, Board currentBoard, Move currentMove) {
      if (occupiedFlag && (currentPiece.getColour() != currentBoard.getPiece(currentMove.getNX(), currentMove.getNY()).getColour())) {
          this.getOpponent().getPieces().delete(currentBoard.getPiece(currentMove.getNX(), currentMove.getNY()));
          currentBoard.removePiece(currentMove.getNX(), currentMove.getNY());
      }

      currentBoard.removePiece(currentMove.getOX(), currentMove.getOY());
      currentBoard.setPosition(currentMove.getNX(), currentMove.getNY(), currentPiece);
      currentPiece.setPosition(currentMove.getNX(), currentMove.getNY());
    }

    public boolean checkMove(Piece currentPiece, Move currentMove) {
        boolean legalMoveFlag = false;
        //Now iterate through move arraylist somehow

        ArrayList<Move> theLegalMoves = new ArrayList<Move>();
        theLegalMoves = currentPiece.availableMoves();
        System.out.println(theLegalMoves);

        if (theLegalMoves != null) {
            System.out.println(theLegalMoves.size() + "legalMovesSize");
            for (int i = 0; i < theLegalMoves.size(); i++) {
                if (theLegalMoves.get(i).equals(currentMove)) {
                    if (currentPiece.getColour() == pieces.getPiece(0).getColour()) {
                        legalMoveFlag = true;
                        System.out.println("Legal + " + theLegalMoves.get(i).toString());
                        break;
                    }
                } else
                    legalMoveFlag = false;
            }
        }
        return legalMoveFlag;
    }







}
