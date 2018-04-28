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
    //Player playerW, playerB;

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

    if (player1 == 1)
        playerW = new HumanPlayer("White Player", piecesW, playingBoard, null);
    if (player1 == 2)
        playerW = new RandomPlayer("White Player", piecesW, playingBoard, null);
    if (player2 == 1)
        playerB = new HumanPlayer("Black Player", piecesB, playingBoard, null);
    if (player2 == 2)
        playerB = new RandomPlayer("Black Player", piecesB, playingBoard, null);

    /*switch (player1) {
        case 1: HumanPlayer playerW = new HumanPlayer("White Player", piecesW, playingBoard, null);
                break;
        case 2: RandomPlayer playerW = new RandomPlayer("White Player", piecesW, playingBoard, null);
                break;
        default:HumanPlayer playerW = new HumanPlayer("White Player", piecesW, playingBoard, null);
                break;
    }

    switch (player2) {
        case 1: HumanPlayer playerB = new HumanPlayer("Black Player", piecesB, playingBoard, null);
                break;
        case 2: RandomPlayer playerB = new RandomPlayer("Black Player", piecesB, playingBoard, null);
                break;
        default:HumanPlayer playerB = new HumanPlayer("Black Player", piecesB, playingBoard, null);
                break;
     }*/


    //RandomPlayer playerW = new RandomPlayer("White Player", piecesW, playingBoard, null);
    //HumanPlayer playerB = new HumanPlayer("Black Player", piecesB, playingBoard, playerW);
    playerW.setOpponent(playerB);
    playerB.setOpponent(playerW);
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
            System.out.println("Player 1 (white player)'s turn:");
            legalMoveFlag = playerW.makeMove();
            kingTaken = playerW.checkKing(whiteTurn);
        }

        //BLACK TURN - HUMAN PLAYER ATM
        else {
            System.out.println("Player 2 (black player)'s turn:");
            legalMoveFlag = playerB.makeMove();
            kingTaken = playerB.checkKing(whiteTurn);

          if (!legalMoveFlag)
              System.out.println("Illegal move. Please try a valid move:");
        }
      }//end of while!legal


      //Make it the next players turn
      whiteTurn = !whiteTurn;
      blackTurn = !blackTurn;


    } //end of while loop
  } //end ofmain

}//end of class
