package assignment2018;
import assignment2018.codeprovided.*;

public class Chess {
  public static void main(String[] args) {
    Board playingBoard = new Board();
    Pieces initPiecesW = new Pieces(playingBoard, PieceCode.WHITE);
    Pieces initPiecesB = new Pieces(playingBoard, PieceCode.BLACK);

    TextDisplay one = new TextDisplay();
    one.resetFlags();
    one.displayBoard(initPiecesW);
    one.displayBoard(initPiecesB);

  }

}
