package assignment2018;

import assignment2018.*;
import assignment2018.codeprovided.*;

import java.util.*;

public class HumanPlayer extends Player {

  private String name;
  private Pieces pieces;
  private Board playingBoard;
  private Player opponent;

  public HumanPlayer(String n, Pieces p, Board b, Player o) {
    super(n,p,b,o);
    name = n;
    pieces = p;
    playingBoard = b;
    opponent = o;
  }


  public HumanPlayer getOpponent() {
      return (HumanPlayer)opponent;
  }

  public boolean makeMove(){
      return false;
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
      if (colour == PieceCode.WHITE)
          System.out.print("Player 1 (white) move: ");
      else
          System.out.print("Player 2 (black) move: ");
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


  public void movePieces(boolean occupiedFlag, Piece currentPiece, int[] arrayOfCoords, Board currentBoard) {
      if (currentBoard.getPiece(currentMove.getNX(), currentMove.getNY()) != null) {
          if (occupiedFlag && (currentPiece.getColour() != (currentBoard.getPiece(currentMove.getNX(), currentMove.getNY())).getColour())) {
              this.getOpponent().getPieces().delete(currentBoard.getPiece(currentMove.getNX(), currentMove.getNY()));
              currentBoard.removePiece(currentMove.getNX(), currentMove.getNY());
          }
      }

      currentBoard.removePiece(arrayOfCoords[0], arrayOfCoords[1]);
      currentBoard.setPosition(arrayOfCoords[2], arrayOfCoords[3], currentPiece);
      currentPiece.setPosition(arrayOfCoords[2], arrayOfCoords[3]);
  }



}
