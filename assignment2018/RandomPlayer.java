package assignment2018;

import assignment2018.*;
import assignment2018.Move;
import assignment2018.codeprovided.*;

import java.util.*;

public class RandomPlayer extends Player {
  
  private String name;
  private Pieces pieces;
  private Board playingBoard;
  private Player opponent;
  private int[] arrayOfCoords = new int[4];

  public RandomPlayer(String n, Pieces p, Board b, Player o) {
    super(n,p,b,o);
    name = n;
    pieces = p;
    playingBoard = b;
    opponent = o;
  }

  public boolean checkKing(boolean whiteTurn) {
      for (int i=0; i<this.getOpponent().getPieces().getNumPieces(); i++ ) {
          if (this.getOpponent().getPieces().getPiece(i).getValue() == assignment2018.codeprovided.PieceCode.KING) {
              return false;
          }
      }
      System.out.println(name + " wins!");
      return true;
  }

  public boolean makeMove() {
    ArrayList<Move> theLegalMoves = new ArrayList<Move>();
    Piece currentPiece = null;
    Move currentMove = null;
    boolean kingTaken = false, occupiedFlag = false, legalMoveFlag = false;
    boolean whiteTurn = false;
    boolean blackTurn = true;
    ArrayList<Move> allMoves = new ArrayList<Move>();
    allMoves = getMoves();
    Random rand = new Random();
    int randomMove = rand.nextInt(allMoves.size());
    currentMove = allMoves.get(randomMove);
    arrayOfCoords[0] = currentMove.getOX();
    arrayOfCoords[1] = currentMove.getOY();
    arrayOfCoords[2] = currentMove.getNX();
    arrayOfCoords[3] = currentMove.getNY();
    occupiedFlag = currentMove.getOccupied();
    currentPiece = playingBoard.getPiece(arrayOfCoords[0], arrayOfCoords[1]);

    movePieces(occupiedFlag, currentPiece, arrayOfCoords, playingBoard, currentMove);

    return true;
  }

  public ArrayList<Move> getMoves() {
    Piece currentPiece = null;
    ArrayList<Move> allMoves = new ArrayList<Move>();
    for (int i = 0; i<this.getPieces().getNumPieces(); i++) {
      currentPiece = this.getPieces().getPiece(i);
      if (currentPiece.availableMoves() != null) {
        allMoves.addAll(currentPiece.availableMoves());
      }
    }
    return allMoves;
  }

  public void movePieces(boolean occupiedFlag, Piece currentPiece, int[] arrayOfCoords, Board currentBoard, Move currentMove) {
    if (currentBoard.getPiece(currentMove.getNX(), currentMove.getNY()) != null) {
      if (occupiedFlag && (currentPiece.getColour() != (currentBoard.getPiece(currentMove.getNX(), currentMove.getNY())).getColour())) {
        this.getOpponent().getPieces().delete(currentBoard.getPiece(currentMove.getNX(), currentMove.getNY()));
        currentBoard.removePiece(currentMove.getNX(), currentMove.getNY());
      }
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

    if (theLegalMoves != null) {
      System.out.println(theLegalMoves.size() + "legalMovesSize");
      for (int i = 0; i < theLegalMoves.size(); i++) {
        if (theLegalMoves.get(i).equals(currentMove)) {
          if (currentPiece.getColour() == pieces.getPiece(0).getColour()) {
            legalMoveFlag = true;
            break;
          }
        } else
        legalMoveFlag = false;
      }
    }
    return legalMoveFlag;
  }






}
