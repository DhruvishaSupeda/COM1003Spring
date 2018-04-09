package assignment2018;

import assignment2018.codeprovided.*;
import assignment2018.*;
import java.util.*;

public class Chess {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Board playingBoard = new Board();
    Pieces PiecesW = new Pieces(playingBoard, PieceCode.WHITE);
    Pieces PiecesB = new Pieces(playingBoard, PieceCode.BLACK);
    HumanPlayer playerW = new HumanPlayer();
    boolean occupiedFlag;

    System.out.println(PiecesW.toString());

    TextDisplay one = new TextDisplay();
    one.resetFlags();
    one.displayBoard(PiecesW);
    one.displayBoard(PiecesB);

    //Input from first players
    System.out.print("Player 1 (white) move: ");
    //Takes input - NEED EXCEPTION ERROR IF NOT IN CORRECT FORMAT/PUT NOTHING IN
    String coords = scanner.nextLine();
    //Uses space as delimiter and puts from and to into 2 elements of array
    //String[] arrayOfCoords = coords.split("\\s+");
    char[] arrayOfCoords = coords.replaceAll("\\s", "").toCharArray();
    //Prints out array (for debugging)
    //for (int i = 0; i < arrayOfCoords.length; i++)
    //    System.out.println(arrayOfCoords[i]);

    //WHY IS PIECE OBJECT NULL????
    if (playingBoard.occupied(playerW.checkCoords(arrayOfCoords[0]), arrayOfCoords[1]-'0')) {
      Piece currentPiece = playingBoard.getPiece(playerW.checkCoords(arrayOfCoords[0]), (int)arrayOfCoords[1]-'0');
      System.out.println("Trurreeeeee00");
      System.out.println(currentPiece.toString());
    }


    //if black piece in new coordinate, make thing in move true, else false
    if (playingBoard.occupied(playerW.checkCoords(arrayOfCoords[2]), arrayOfCoords[3]-'0'))
        occupiedFlag = true;
    else
        occupiedFlag = false;
    //makes new move for current move

    Piece currentPiece = playingBoard.getPiece(playerW.checkCoords(arrayOfCoords[0]), (int)arrayOfCoords[1]-'0');
    Move currentMove = new Move(currentPiece, playerW.checkCoords(arrayOfCoords[0]), (int)arrayOfCoords[1]-'0',
        playerW.checkCoords(arrayOfCoords[2]), (int)arrayOfCoords[3]-'0', occupiedFlag);
    System.out.println(currentMove.toString());

    //System.out.println(currentPiece.toString());
    System.out.println(playerW.checkCoords(arrayOfCoords[0]));
    //-'0' to get rid of the ASCII value of 0, making it the actual value of the char
    System.out.println((int)arrayOfCoords[1]-'0');

    //Need to check A = 1, B=2 etc for coordinates
    //System.out.println(coords[1]);

    boolean legalMoveFlag = false;
    //Now iterate through move arraylist somehow

    //System.out.println(currentPiece.toString());

    if (currentPiece != null) {
      for (int i=1; i<currentPiece.availableMoves().size(); i++) { //doesnt work??
        if (currentPiece.availableMoves().get(i).equals(currentMove)) {
          legalMoveFlag = true;
        }
        else
          legalMoveFlag = false;
      }
    }


    System.out.println(legalMoveFlag);

  }

}
