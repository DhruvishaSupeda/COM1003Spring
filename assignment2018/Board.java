package assignment2018;
import assignment2018.codeprovided;

public class Board {
  //Dimensions 8x8
  /*Methods:
    If location occupied or outside the Board
    Insert piece
    Remove piece
    Return Piece at particular location
    Return state of entire board
  */

  public initBoard() {
    Piece playingBoard[][] = new Piece[8][8];
    Pieces initPiecesW = new Pieces(playingBoard, PieceCode.WHITE);
    Pieces initPiecesB = new Pieces(playingBoard, PieceCode.BLACK);
    for (int i = 0; i < playingBoard.length; i++){
      for (int j = 0; j < playingBoard.length; j++){
        System.out.print(playingBoard[i][j].getChar); //MAYBE????
    }
  } //MAY HAVE TO PUT THE INITIAL BOARD IN CHESS.JAVA RATHER THAN HERE
  }

  public static void main(String[] args) {
    initBoard();
  }

}
