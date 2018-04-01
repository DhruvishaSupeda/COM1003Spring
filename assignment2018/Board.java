package assignment2018;

import assignment2018.codeprovided.*;

public class Board {
  private Piece playingBoard[][] = new Piece[8][8];

  public Board() {
    Piece playingBoard[][] = new Piece[8][8];
    Pieces initPiecesW = new Pieces(playingBoard, PieceCode.WHITE);
    Pieces initPiecesB = new Pieces(playingBoard, PieceCode.BLACK);
  }

  public void setPosition(int x, int y, Piece piece){
    piece.setPosition(x, y);
  }

  public void removePiece(int x, int y, Board playingBoard) {
    playingBoard[x][y] = null;
  }

  public Piece getPiece(int x, int y, Board playingBoard) {
    return playingBoard[x][y];
  }

  public boolean occupied(int x, int y) {
    if (playingBoard[x][y] != null)
      return true;
    else
      return false;
  }

  public boolean outOfRange(int x, int y) {
    if ((x > 8 || y > 8) || (x < 1 || y < 1))
        return false;
    else
        return true;
  }

}
