package assignment2018;

import assignment2018.codeprovided.*;

public class Board { //MAKE BOARD WIDTH AND HEIGHT CONSTANTS
  private Piece playingBoard[][] = new Piece[8][8];

  public Board() {
    for (int row = 0; row < 8; row++) {
      for (int column = 0; column < 8; column++)
          playingBoard[row][column] = null;
    }
  }

  public void setPosition(int x, int y, Piece piece){
    piece.setPosition(x, y);
    playingBoard[x][y] = piece;
  }

  public void removePiece(int x, int y) {
    playingBoard[x][y] = null;
  }

  public Piece getPiece(int x, int y) {
    return playingBoard[x][y];
  }

  public boolean occupied(int x, int y) {
    if (!outOfRange(x,y) && (playingBoard[x][y] != null))
      return true;
    else
      return false;
  }

  public boolean outOfRange(int x, int y) {
    if ((x > 7 || y > 7) || (x < 0 || y < 0))
        return true;
    else
        return false;
  }

}
