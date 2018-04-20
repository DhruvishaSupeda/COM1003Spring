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

  public boolean equals(Move move2) {
      return (piece==move2.piece && x==move2.x && y==move2.y && newX==move2.newX && newY==move2.newY &&
          occupiedToTake==move2.occupiedToTake);
  }

  public String toString() {
      return (piece.toString() + " " + x + " " + y + " " + newX + " " + newY + " " + occupiedToTake);
  }

  public boolean getOccupied(){
      return occupiedToTake;
  }

  public int getOX() {
    return x;
  }

  public int getOY() {
    return y;
  }

  public int getNX() {
    return newX;
  }

  public int getNY() {
    return newY;
  }
}
