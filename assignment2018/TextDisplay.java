package assignment2018;
import assignment2018.codeprovided.*;
import assignment2018.codeprovided.PieceCode;

public class TextDisplay implements Display {

  private char[][] pieceArray = new char[8][8];
  private boolean displayNeeded;

  public TextDisplay() {
      for (int i = 0; i < 8; i++) {
          for (int j = 0; j < 8; j++) {
              pieceArray[i][j] = '.';
          }
      }
  }

  public void displayBoard(Pieces myPieces) {
      Board playingBoard = myPieces.getPiece(1).getBoard();
      System.out.println(" |A B C D E F G H");
      System.out.println("- - - - - - - - -");
      for (int y = 0; y < 8; y++) { //MAKE BOARD_WIDTH AND HEIGHT CONSTANTS
          //8-i because it goes 8 downto 1 but can't change loop
          System.out.print(8 - y + "|");
          for (int x = 0; x < 8; x++) {
              if (playingBoard.getPiece(x, y) != null)
                  System.out.print(playingBoard.getPiece(x, y).getChar() + " ");
              else
                  System.out.print(". ");
          }
          System.out.println();
      }
    }

    public void setDisplayNeeded(boolean needed) {
        displayNeeded = needed;
    }

    public boolean getDisplayNeeded() {
        return displayNeeded;
    }


  }



