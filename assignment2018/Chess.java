package assignment2018;

import assignment2018.codeprovided.*;
import assignment2018.*;
import assignment2018.Move;
import assignment2018.codeprovided.PieceCode;

import java.util.*;

public class Chess {

    /**
     * Checks the player passed in to see if it still has a king piece in its pieces, to check if either play has taken a king
     * @param player the player being checked to see if it has a king
     * @return returns false if the player still has a king, otherwise returns true
     */
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
    Player playerW = null, playerB = null;

    //Chooses which kind of display to have
    System.out.print("Would you like a GUI or text display? (1 or 0)");
    int displayType = scanner.nextInt();
    while (displayType != 1 && displayType != 0) {
        System.out.println("Incorrect input.");
        System.out.print("Would you like a GUI or text display? (1 or 0)");
        displayType = scanner.nextInt();
    }
    if (displayType == 1) {
       gDisplay.setDisplayNeeded(true);
    }
    else
        tDisplay.setDisplayNeeded(true);

    //Input for types of player
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

    //Makes appropriate player type for each player based on input
    switch (player1) {
        case 1: playerW = new HumanPlayer("White Player", piecesW, playingBoard, null);
                ((HumanPlayer)playerW).setGDisplay(gDisplay);
                ((HumanPlayer)playerW).setTDisplay(tDisplay);
                break;
        case 2: playerW = new RandomPlayer("White Player", piecesW, playingBoard, null);
                break;
        case 3: playerW = new AggressivePlayer("White Player", piecesW, playingBoard, null);
                break;
        default:playerW = new HumanPlayer("White Player", piecesW, playingBoard, null);
                ((HumanPlayer)playerW).setGDisplay(gDisplay);
                break;
    }

      switch (player2) {
          case 1: playerB = new HumanPlayer("Black Player", piecesB, playingBoard, null);
              ((HumanPlayer)playerB).setGDisplay(gDisplay);
              ((HumanPlayer)playerB).setTDisplay(tDisplay);
              break;
          case 2: playerB = new RandomPlayer("Black Player", piecesB, playingBoard, null);
              break;
          case 3: playerB = new AggressivePlayer("Black Player", piecesB, playingBoard, null);
              break;
          default:playerB = new HumanPlayer("Black Player", piecesB, playingBoard, null);
              ((HumanPlayer)playerB).setGDisplay(gDisplay);
              break;
      }

    playerW.setOpponent(playerB);
    playerB.setOpponent(playerW);
    boolean whiteTurn = true;
    boolean kingTaken = false,
    legalMoveFlag= false;

    //ASK IF WANTS GUI OR NOT
      //IF THEY DON'T, DO BELOW WHILE LOOP
      //IF THEY DO, DO ANOTHER WHILE LOOK WHICH HAS LIKE GDISPLAY.WHATEVER TO MAKE THE MOVES?
      //USE GETARRAYOFCOORDS TO GET AND SET IT IN GDISPLAY?

    if (tDisplay.getDisplayNeeded() == true) {
          while (!kingTaken) {
              //Display board
              tDisplay.displayBoard(piecesW);
              legalMoveFlag = false;
              while (!legalMoveFlag) {
                  System.out.println();
                  if (whiteTurn) {
                      System.out.println("Player 1 (white player)'s turn:");
                      legalMoveFlag = playerW.makeMove();
                      kingTaken = checkKing(playerW);
                  } else {
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
      } //end of if text display


      else {
        gDisplay.displayBoard(piecesW);
        while (!kingTaken) {
            legalMoveFlag = false;
            if (gDisplay.getButtonPressed()) {
                gDisplay.displayBoard(piecesW);
                if (whiteTurn) {
                    legalMoveFlag = playerW.makeMove();
                    kingTaken = checkKing(playerW);
                } else {
                    legalMoveFlag = playerB.makeMove();
                    kingTaken = checkKing(playerB);
                }
                gDisplay.displayBoard(piecesW);
                if (legalMoveFlag)
                    whiteTurn = !whiteTurn;
                gDisplay.setButtonPressed(false);
            } //end of if button pressed
        } //end of !kingtaken
        gDisplay.displayBoard(piecesW);
      } //end of else

    System.exit(0);
  } //end of main

}//end of class
