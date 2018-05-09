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
  private int[] arrayOfCoords = new int[4];

  private GraphicalDisplay gDisplay;
  private TextDisplay tDisplay;

  public HumanPlayer(String n, Pieces p, Board b, Player o) {
    super(n,p,b,o);
    name = n;
    pieces = p;
    playingBoard = b;
    opponent = o;
  }

    /**
     * Converts the letters from the input from the player to numbers to be used as coordinates
     * @param xCoord the coordinate being converted to a number
     * @return returns the number equivalent of the letter given
     */
    public static int checkCoords(char xCoord) {
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

    /**
     * Asks the user for input if the player is a HumanPlayer
     * @param player
     * @return
     */
    public static int[] playerInput() {
        Scanner scanner = new Scanner(System.in);
        boolean correct = false;
        System.out.print("Please enter your move: ");
        String coords = scanner.nextLine().toUpperCase();
        //Uses space as delimiter and puts from and to into 2 elements of array
        char[] arrayOfCoords = coords.replaceAll("\\s", "").toCharArray();
        int[] arrayOfCoordsInts = new int[4];

        while (!correct) {
            if ((arrayOfCoords[0] >= 'A' && arrayOfCoords[0] <= 'H') && (arrayOfCoords[1] >= '1' && arrayOfCoords[1] <= '8') &&
                    (arrayOfCoords[2] >= 'A' && arrayOfCoords[2] <= 'H') && (arrayOfCoords[3] >= '1' && arrayOfCoords[3] <= '8')) {
                arrayOfCoordsInts[0] = checkCoords(arrayOfCoords[0]);
                arrayOfCoordsInts[1] = 8 - ((int) arrayOfCoords[1] - '0');
                arrayOfCoordsInts[2] = checkCoords(arrayOfCoords[2]);
                arrayOfCoordsInts[3] = 8 - ((int) arrayOfCoords[3] - '0');
                correct = true;
            }
            else {
                System.out.println("Incorrect input. Please try again: ");
                coords = scanner.nextLine().toUpperCase();
                //Uses space as delimiter and puts from and to into 2 elements of array
                arrayOfCoords = coords.replaceAll("\\s", "").toCharArray();
            }
        }
        return arrayOfCoordsInts;
    }

  public boolean makeMove(){
      Piece currentPiece = null;
      Move currentMove = null;
      boolean occupiedFlag = false, legalMoveFlag = false, kingTaken = false;
      char[] coordsInput = new char[4];

      if (tDisplay.getDisplayNeeded())
          arrayOfCoords = playerInput();
      else {
          coordsInput = gDisplay.getInput();
          arrayOfCoords[0] = checkCoords(coordsInput[0]);
          arrayOfCoords[1] = 8 - ((int) coordsInput[1] - '0');
          arrayOfCoords[2] = checkCoords(coordsInput[2]);
          arrayOfCoords[3] = 8 - ((int) coordsInput[3] - '0');
      }

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
      gDisplay.setButtonPressed(false);
      if (!legalMoveFlag) {
          gDisplay.incorrectInput();
          return false;
      }
      else {
          gDisplay.correctInput();
          movePieces(occupiedFlag, currentPiece, arrayOfCoords, playingBoard);
      }
      return legalMoveFlag;
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

  public void setArrayOfCoords(int[] array) {
      arrayOfCoords = array;
  }

  public void setGDisplay(GraphicalDisplay gui) {
        gDisplay = gui;
  }

  public void setTDisplay(TextDisplay text) {
      tDisplay = text;
  }

}
