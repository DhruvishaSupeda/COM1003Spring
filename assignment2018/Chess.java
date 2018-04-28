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
    boolean whiteTurn = false;
    boolean blackTurn = true;
    boolean kingTaken = false,
      legalMoveFlag= false;
    //Player currentPlayer = playerW;
    //currentPlayer.toString();

    while (!kingTaken) {
      //Display board
      display(piecesW, piecesB);
      legalMoveFlag = false;
      while (!legalMoveFlag) {
        //RANDOM PLAYER
        if (whiteTurn) {
            legalMoveFlag = playerW.makeMove();
            kingTaken = playerW.checkKing(whiteTurn);
        }

        //BLACK TURN - HUMAN PLAYER ATM
        else {
            legalMoveFlag = playerB.makeMove();
            kingTaken = playerB.checkKing(whiteTurn);

          if (!legalMoveFlag) {
              System.out.println("Illegal move. Please try a valid move:");
          }
        }
      }


      //Make it the next players turn
      whiteTurn = !whiteTurn;
      blackTurn = !blackTurn;


    } //end of while loop
  }

}
