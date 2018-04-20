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
        HumanPlayer playerW = new HumanPlayer("White Player", piecesW, playingBoard, null);
        HumanPlayer playerB = new HumanPlayer("Black Player", piecesB, playingBoard, playerW);
        playerW.setOpponent(playerB);
        ArrayList<Move> theLegalMoves = new ArrayList<Move>();
        Piece currentPiece = null;
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

                if (whiteTurn) {
                    arrayOfCoords = playerW.playerInput(PieceCode.WHITE);
                }
                else {
                    arrayOfCoords = playerB.playerInput(PieceCode.BLACK);
                }

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
                    Move currentMove = new Move(currentPiece, arrayOfCoords[0], arrayOfCoords[1],
                            arrayOfCoords[2], arrayOfCoords[3], occupiedFlag);

                    if (whiteTurn) {
                        legalMoveFlag = playerW.checkMove(currentPiece, currentMove);
                    }
                    else {
                        legalMoveFlag = playerB.checkMove(currentPiece, currentMove);
                    }

                    if (!legalMoveFlag) {
                        System.out.println("Illegal move. Please try a valid move:");
                    }
                }
            }

            if (whiteTurn)
                playerW.movePieces(occupiedFlag, currentPiece, arrayOfCoords, playingBoard);
            else
                playerB.movePieces(occupiedFlag, currentPiece, arrayOfCoords, playingBoard);

            //Make it the next players turn
            whiteTurn = !whiteTurn;
            blackTurn = !blackTurn;


            //kingTaken = true;
        }
    }
}
