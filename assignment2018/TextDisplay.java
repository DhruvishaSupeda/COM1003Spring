package assignment2018;
import assignment2018.codeprovided.*;

public class TextDisplay implements Display {

  private char[][] pieceArray = new char[8][8];
  //Counter so that every time both piece colours are put into object, displays board
  private int bwCounter;
  //Flags for white pieces and black pieces used
  private boolean wFlag;
  private boolean bFlag;

  public TextDisplay() {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
          pieceArray[i][j] = '.';
      }
    }
    wFlag = false;
    bFlag = false;
  }

  public void resetFlags() {
      wFlag = false;
      bFlag = false;
  }

  public void displayBoard(Pieces myPieces) {
    Piece newPiece;
    char pieceChar;
    int pieceColour;
    for (int i = 0; i < myPieces.getNumPieces(); i++) {
      //for (int j = 1; j < 9; j++) {
        newPiece = myPieces.getPiece(i);
        pieceChar = newPiece.getChar();
        pieceColour = newPiece.getColour();
        pieceArray[newPiece.getX()][newPiece.getY()] = pieceChar;
        if (pieceColour == 0)
            bFlag = true;
        else
            wFlag = true;
        //MAKE Array
        //USE myPieces.getPiece maybe?
        //Then get character from that piece object and put in array then display array maybe?
    //  }
    }
    if ((bFlag==true) && (wFlag==true)) {
      for (int i = 0; i < 8; i++) { //MAKE BOARD_WIDTH AND HEUGHT CONSTANTS
          for (int j = 0; j < 8; j++) {
              System.out.print(pieceArray[j][i]);
          }
          System.out.println();
      }
    }
  }
}
