package assignment2018;

import assignment2018.*;
import assignment2018.Move;
import assignment2018.codeprovided.*;
import assignment2018.codeprovided.PieceCode;

import java.util.*;

public class HumanPlayer extends Player {

  private String name;
  private Pieces pieces;
  private Board playingBoard;
  private Player opponent;
  private int[] arrayOfCoords;

  public HumanPlayer(String n, Pieces p, Board b, Player o) {
    super(n,p,b,o);
    name = n;
    pieces = p;
    playingBoard = b;
    opponent = o;
  }

    public boolean checkKing(boolean whiteTurn) { //GET OPPONENTS PIECES, IF THERE IS NO KING THEN TAKEN
        /*if ((playingBoard.getPiece(arrayOfCoords[2], arrayOfCoords[3]) != null) &&
        (playingBoard.getPiece(arrayOfCoords[2], arrayOfCoords[3]).getValue() == PieceCode.KING))  {
            if (whiteTurn)
                System.out.println("White player wins");
            else
                System.out.println("Black player wins");
            return true;
        }
        else
            return false;*/

        for (int i=0; i<this.getOpponent().getPieces().getNumPieces(); i++ ) {
            if (this.getOpponent().getPieces().getPiece(i).getValue() == PieceCode.KING) {
                return false;
            }
        }
        System.out.println(name + " wins!");
        return true;
    }

  public boolean makeMove(){

      Piece currentPiece = null;
      Move currentMove = null;
      boolean occupiedFlag = false, legalMoveFlag = false, kingTaken = false;
      boolean whiteTurn = false;
      boolean blackTurn = true;

      arrayOfCoords = playerInput(PieceCode.BLACK);
      if (playingBoard.occupied(arrayOfCoords[0], arrayOfCoords[1])) {
          currentPiece = playingBoard.getPiece(arrayOfCoords[0], arrayOfCoords[1]);

          //if black piece in new coordinate, make thing in move true, else false
          if (playingBoard.occupied(arrayOfCoords[2], arrayOfCoords[3])) {
              occupiedFlag = true;
          } else
              occupiedFlag = false;

          //makes new move for current move
          currentMove = new Move(currentPiece, arrayOfCoords[0], arrayOfCoords[1],
                  arrayOfCoords[2], arrayOfCoords[3], occupiedFlag);

          legalMoveFlag = checkMove(currentPiece, currentMove);
      }
      if (!legalMoveFlag)
          return false;
      else
          movePieces(occupiedFlag, currentPiece, arrayOfCoords, playingBoard);
      return legalMoveFlag;
  }

  public int checkCoords(char xCoord) {
    int equivInt = 0;
    switch (xCoord) {
      case 'A': equivInt = 0;
                break;
      case 'B': equivInt = 1;
                break;
      case 'C': equivInt = 2;
                break;
      case 'D': equivInt = 3;
                break;
      case 'E': equivInt = 4;
                break;
      case 'F': equivInt = 5;
                break;
      case 'G': equivInt = 6;
                break;
      case 'H': equivInt = 7;
                break;
      default:  equivInt = 8;
                break;
    }
    return equivInt;
  }


  public int[] playerInput(int colour) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Please enter your move: ");
      //Takes input - NEED EXCEPTION ERROR IF NOT IN CORRECT FORMAT/PUT NOTHING IN
      String coords = scanner.nextLine().toUpperCase();
      //Uses space as delimiter and puts from and to into 2 elements of array
      char[] arrayOfCoords = coords.replaceAll("\\s", "").toCharArray();

      int[] arrayOfCoordsInts = new int[4];
      arrayOfCoordsInts[0] = checkCoords(arrayOfCoords[0]);
      arrayOfCoordsInts[1] = 8-((int) arrayOfCoords[1] - '0');
      arrayOfCoordsInts[2] = checkCoords(arrayOfCoords[2]);
      arrayOfCoordsInts[3] = 8-((int) arrayOfCoords[3] - '0');
      return arrayOfCoordsInts;
  }

  public boolean checkMove(Piece currentPiece, Move currentMove) {
      boolean legalMoveFlag = false;
      //Now iterate through move arraylist somehow

      ArrayList<Move> theLegalMoves = new ArrayList<Move>();
      theLegalMoves = currentPiece.availableMoves();

      if (theLegalMoves != null) {
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


  public void movePieces(boolean occupiedFlag, Piece currentPiece, int[] arrayOfCoords, Board currentBoard) {
      if (currentBoard.getPiece(arrayOfCoords[2], arrayOfCoords[3]) != null) {
          if (occupiedFlag && (currentPiece.getColour() != (currentBoard.getPiece(arrayOfCoords[2], arrayOfCoords[3])).getColour())) {
              this.getOpponent().getPieces().delete(currentBoard.getPiece(arrayOfCoords[2], arrayOfCoords[3]));
              currentBoard.removePiece(arrayOfCoords[2], arrayOfCoords[3]);
          }
      }

      currentBoard.removePiece(arrayOfCoords[0], arrayOfCoords[1]);
      currentBoard.setPosition(arrayOfCoords[2], arrayOfCoords[3], currentPiece);
      currentPiece.setPosition(arrayOfCoords[2], arrayOfCoords[3]);
  }



}
