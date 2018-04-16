package assignment2018;

import assignment2018.*;
import assignment2018.codeprovided.*;

import java.util.*;

public class HumanPlayer {

  private String name;
  private Pieces pieces;
  private Board playingBoard;
  private Player opponent;

  public HumanPlayer(String n, Pieces p, Board b, Player o) {
    name = n;
    pieces = p;
    playingBoard = b;
    opponent = o;
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
    }
    return equivInt;
  }

  public int[] playerInput() {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Player 1 (white) move: ");
      //Takes input - NEED EXCEPTION ERROR IF NOT IN CORRECT FORMAT/PUT NOTHING IN
      String coords = scanner.nextLine();
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
                  legalMoveFlag = true;
                  System.out.println("Legal + " + theLegalMoves.get(i).toString());
                  break;
              } else
                  legalMoveFlag = false;
          }
      }
      return legalMoveFlag;
  }
  //Interacts with the user through the console and keyboard to move the pieces


  /*MOVING Pieces
  --Get input from console
  --Chess requests new move from players in turn (supplied as to and from coordinates) e.g. A2 A3 moves from A2 to A3
  --Check whats in there (use PieceCode?/Pieces)
  --Or even better, getPiece or something then use pieceName.availableMoves()
  --Iterate through ArrayList, if Move they wanna make equal to any in ArrayList, let them make the move, taking over
  other piece if there is one there, else ask for input (while loop?)
  --If king, declare game over and winner

  Methods:
  --checkIfKing - need parameter of flag if its the king to take back to Chess or something
  --Check if legal moves
  --


  */
}
