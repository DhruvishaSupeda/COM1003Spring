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
  public static boolean checkKing(Player player) { //GET OPPONENTS PIECES, IF THERE IS NO KING THEN TAKEN
      for (int i=0; i<player.getOpponent().getPieces().getNumPieces(); i++ ) {
          if (player.getOpponent().getPieces().getPiece(i).getValue() == PieceCode.KING) {
              return false;
          }
      }
      System.out.println(player.toString() + " wins!");
      return true;
  }

  public static void main(String[] args) {
    Board playingBoard = new Board();
    Pieces piecesW = new Pieces(playingBoard, PieceCode.WHITE);
    Pieces piecesB = new Pieces(playingBoard, PieceCode.BLACK);
    Scanner scanner = new Scanner(System.in);
    int player1 = 0, player2 = 0;
    GraphicalDisplay gDisplay = new GraphicalDisplay();
    TextDisplay tDisplay = new TextDisplay();
    gDisplay.displayBoard(piecesW);
    Player playerW = null, playerB = null;

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

    switch (player1) {
        case 1: playerW = new HumanPlayer("White Player", piecesW, playingBoard, null);
                break;
        case 2: playerW = new RandomPlayer("White Player", piecesW, playingBoard, null);
                break;
        case 3: playerW = new AggressivePlayer("White Player", piecesW, playingBoard, null);
                break;
        default:playerW = new HumanPlayer("White Player", piecesW, playingBoard, null);
                break;
    }

      switch (player2) {
          case 1: playerB = new HumanPlayer("Black Player", piecesB, playingBoard, null);
              break;
          case 2: playerB = new RandomPlayer("Black Player", piecesB, playingBoard, null);
              break;
          case 3: playerB = new AggressivePlayer("Black Player", piecesB, playingBoard, null);
              break;
          default:playerB = new HumanPlayer("Black Player", piecesB, playingBoard, null);
              break;
      }

    playerW.setOpponent(playerB);
    playerB.setOpponent(playerW);
    boolean whiteTurn = true;
    boolean kingTaken = false,
    legalMoveFlag= false;

    while (!kingTaken) {
      //Display board

      tDisplay.displayBoard(piecesW);
      gDisplay.displayBoard(piecesW);
      legalMoveFlag = false;
      while (!legalMoveFlag) {
        System.out.println();
        if (whiteTurn) {
            System.out.println("Player 1 (white player)'s turn:");
            legalMoveFlag = playerW.makeMove();
            kingTaken = checkKing(playerW);
        }
        else {
            System.out.println("Player 2 (black player)'s turn:");
            legalMoveFlag = playerB.makeMove();
            kingTaken = checkKing(playerB);
        }
        if (!legalMoveFlag)
            System.out.println("Illegal move. Please try a valid move:");
      }//end of while!legal


      //Make it the next players turn
      whiteTurn = !whiteTurn;


    } //end of while loop
      tDisplay.displayBoard(piecesW);
      gDisplay.displayBoard(piecesW);
    System.exit(0);
  } //end ofmain

}//end of class
