package assignment2018;

import assignment2018.codeprovided.*;

public class Move {

  private Piece piece;
  private int x;
  private int y;
  private int newX;
  private int newY;
  private boolean occupiedToTake;

  public Move(Piece p, int oX, int oY, int nX, int nY, boolean o) {
  //Stores reference to a piece, from coordinates and to coordinates
    piece = p;
    x = oX;
    y = oY;
    newX = nX;
    newY = nY;
    occupiedToTake = o;
  }
}
