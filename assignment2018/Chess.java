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
        RandomPlayer playerW = new RandomPlayer("White Player", piecesW, playingBoard, null);
        HumanPlayer playerB = new HumanPlayer("Black Player", piecesB, playingBoard, playerW);
        playerW.setOpponent(playerB);
        ArrayList<Move> theLegalMoves = new ArrayList<Move>();
        Piece currentPiece = null;
        Move currentMove = null;
        boolean kingTaken = false, occupiedFlag = false, legalMoveFlag = false;
        boolean whiteTurn = true;
        boolean blackTurn = false;
        int[] arrayOfCoords = null;
        System.out.println(playingBoard.toString());
        //HumanPlayer currentPlayer = new playerW;
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

              //legalMoveFlag = playerW.checkMove(currentPiece, currentMove);
              legalMoveFlag = true;
            }
            //BLACK TURN - HUMAN PLAYER ATM
            else {
                arrayOfCoords = playerB.playerInput(PieceCode.BLACK);
                if (playingBoard.occupied(arrayOfCoords[0], arrayOfCoords[1])) {
                    currentPiece = playingBoard.getPiece(arrayOfCoords[0], arrayOfCoords[1]);

                    //if black piece in new coordinate, make thing in move true, else false
                    if (playingBoard.occupied(arrayOfCoords[2], arrayOfCoords[3])) {
                        occupiedFlag = true;
                        if (playingBoard.getPiece(arrayOfCoords[2], arrayOfCoords[3]).getValue() == PieceCode.KING) {
                            kingTaken = true;
                            if (whiteTurn)
                                System.out.println("White player wins");
                            else
                                System.out.println("Black player wins");
                            break;
                        }
                    }
                    else
                        occupiedFlag = false;

                    //makes new move for current move
                    currentMove = new Move(currentPiece, arrayOfCoords[0], arrayOfCoords[1],
                          arrayOfCoords[2], arrayOfCoords[3], occupiedFlag);

                    legalMoveFlag = playerB.checkMove(currentPiece, currentMove);

                    if (!legalMoveFlag) {
                        System.out.println("Illegal move. Please try a valid move:");
                    }
                }
            }



            }

            if (whiteTurn)
                playerW.movePieces(occupiedFlag, currentPiece, arrayOfCoords, playingBoard, currentMove);
            else
                playerB.movePieces(occupiedFlag, currentPiece, arrayOfCoords, playingBoard);

            //Make it the next players turn
            whiteTurn = !whiteTurn;
            blackTurn = !blackTurn;


            //kingTaken = true;
        }
    }
}
