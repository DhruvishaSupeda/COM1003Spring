package assignment2018;

import assignment2018.codeprovided.*;
import assignment2018.*;
import assignment2018.Move;
import assignment2018.codeprovided.PieceCode;

import java.util.*;

public class Chess {

  public static void display(Pieces piecesW, Pieces piecesB) {
    TextDisplay one = new TextDisplay();
    one.resetFlags();
    one.displayBoard(piecesW);
    one.displayBoard(piecesB);
  }

  public static void main(String[] args) {
    Board playingBoard = new Board();
    Pieces piecesW = new Pieces(playingBoard, PieceCode.WHITE);
    Pieces piecesB = new Pieces(playingBoard, PieceCode.BLACK);
    Scanner scanner = new Scanner(System.in);
    int player1 = 0, player2 = 0;

    while (player1 != 1 && player1 != 2 && player1 != 3) {
        System.out.println("1 for Human, 2 for Random, 3 for Aggressive");
        System.out.print("What type of player is Player 1? ");
        player1 = scanner.nextInt();
    }
    while (player2 != 1 && player2 != 2 && player2 != 3) {
        System.out.println("1 for Human, 2 for Random, 3 for Aggressive");
        System.out.print("What type of player is Player 2? ");
        player2 = scanner.nextInt();
    }

    RandomPlayer playerW = new RandomPlayer("White Player", piecesW, playingBoard, null);
    HumanPlayer playerB = new HumanPlayer("Black Player", piecesB, playingBoard, playerW);
    playerW.setOpponent(playerB);
    ArrayList<Move> theLegalMoves = new ArrayList<Move>();
    Piece currentPiece = null;
    Move currentMove = null;
    boolean kingTaken = false, occupiedFlag = false, legalMoveFlag = false;
    boolean whiteTurn = false;
    boolean blackTurn = true;
    int[] arrayOfCoords = null;
    //Player currentPlayer = playerW;
    //currentPlayer.toString();

    while (!kingTaken) {
      //Display board
      display(piecesW, piecesB);
      arrayOfCoords = null;

      theLegalMoves = null;
      legalMoveFlag = false;
      while (!legalMoveFlag) {

        //RANDOM PLAYER
        if (whiteTurn) {
          ArrayList<Move> allMoves = new ArrayList<Move>();
          allMoves = playerW.getMoves();
          Random rand = new Random();
          int randomMove = rand.nextInt(allMoves.size()) + 1;
          currentMove = allMoves.get(randomMove);
          System.out.println(currentMove);
          arrayOfCoords[0] = currentMove.getOX();
          arrayOfCoords[1] = currentMove.getOY();
          arrayOfCoords[2] = currentMove.getNX();
          arrayOfCoords[3] = currentMove.getNY();
          currentPiece = playingBoard.getPiece(arrayOfCoords[0], arrayOfCoords[1]);
          //IF KING WINS, IDK HOW TO PUT THIS IN YET
          occupiedFlag = true;
          if (playingBoard.getPiece(currentMove.getNX(), currentMove.getNY()) != null){
            if (playingBoard.getPiece(currentMove.getNX(), currentMove.getNY()).getValue() == PieceCode.KING) {
              kingTaken = true;
              if (whiteTurn)
                System.out.println("White player wins");
              else
                System.out.println("Black player wins");
              break;
            }
          }

          legalMoveFlag = playerW.checkMove(currentPiece, currentMove);
        }
        //BLACK TURN - HUMAN PLAYER ATM

        else {
          legalMoveFlag = playerB.makeMove();

            if (!legalMoveFlag) {
              System.out.println("Illegal move. Please try a valid move:");
            }
          }
        }


      if (whiteTurn) {
        playerW.movePieces(occupiedFlag, currentPiece, arrayOfCoords, playingBoard, currentMove);
      }


      //Make it the next players turn
      whiteTurn = !whiteTurn;
      blackTurn = !blackTurn;


      //kingTaken = true;
    } //end of while loop
  }

}
