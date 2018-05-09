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

  /**
   * Randomly chooses the moves out of all moves possible, and makes that move
   * @return returns true to show that the move taken was legal
   */
  public boolean makeMove() {
    Piece currentPiece = null;
    Move currentMove = null;
    boolean occupiedFlag = false;
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

  /**
   * Gets all of the available moves for all of the pieces belonging to the player
   * @return the ArrayList of all of the moves available
   */
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

  /**
   * Using the move chosen, moves the pieces in the board
   * @param occupiedFlag  boolean to show whether the piece to move into is occupied
   * @param currentPiece  the piece being moved
   * @param arrayOfCoords the array of coordinates of the current piece and where it is moving to
   * @param currentBoard  the board being used in the game
   * @param currentMove   the move object of the move being used
   */
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



}
