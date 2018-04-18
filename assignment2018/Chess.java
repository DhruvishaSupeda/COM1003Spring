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
            System.out.println("RESTARTING");

            while (!legalMoveFlag) {

                if (whiteTurn) {
                    arrayOfCoords = playerW.playerInput(PieceCode.WHITE);
                    System.out.println("111111111111111111111111111");
                }
                else {
                    arrayOfCoords = playerB.playerInput(PieceCode.BLACK);
                }

                if (playingBoard.occupied(arrayOfCoords[0], arrayOfCoords[1])) {
                    currentPiece = playingBoard.getPiece(arrayOfCoords[0], arrayOfCoords[1]);

                    //if black piece in new coordinate, make thing in move true, else false
                    if (playingBoard.occupied(arrayOfCoords[2], arrayOfCoords[3])) {
                        occupiedFlag = true;
                        if (playingBoard.getPiece(arrayOfCoords[0], arrayOfCoords[1]).getValue() == PieceCode.charToInt('k'))
                            kingTaken = true;
                            break;
                    }
                    else
                        occupiedFlag = false;
                    System.out.println(occupiedFlag + "occupiedFlag");

                    //makes new move for current move
                    Move currentMove = new Move(currentPiece, arrayOfCoords[0], arrayOfCoords[1],
                            arrayOfCoords[2], arrayOfCoords[3], occupiedFlag);
                    System.out.println(currentMove.toString());

                    if (whiteTurn) {
                        legalMoveFlag = playerW.checkMove(currentPiece, currentMove);
                    }
                    else {
                        legalMoveFlag = playerB.checkMove(currentPiece, currentMove);
                    }

                    if (!legalMoveFlag) {
                        System.out.println("Illegal move");
                        System.out.println("22222222222222222222222222");
                    }

                    System.out.println(legalMoveFlag + "legalMoveFlag");
                }
            }
                //Get Pieces based on colour
                //Add piece in new position (use setPosition)
                //Remove current piece
                //Display again
                    /*if (!(occupiedFlag)) {
                        playingBoard.removePiece(arrayOfCoords[0], arrayOfCoords[1]);
                        playingBoard.setPosition(arrayOfCoords[2], arrayOfCoords[3], currentPiece);
                        currentPiece.setPosition(arrayOfCoords[2], arrayOfCoords[3]);
                    }

                    if (occupiedFlag && (currentPiece.getColour() != playingBoard.getPiece(arrayOfCoords[2], arrayOfCoords[3]).getColour())) {
                        playingBoard.removePiece(arrayOfCoords[2], arrayOfCoords[3]);
                        playingBoard.removePiece(arrayOfCoords[0], arrayOfCoords[1]);
                        playingBoard.setPosition(arrayOfCoords[2], arrayOfCoords[3], currentPiece);
                        currentPiece.setPosition(arrayOfCoords[2], arrayOfCoords[3]);

                        System.out.println(playingBoard.getPiece(arrayOfCoords[2], arrayOfCoords[3]));

                        if (currentPiece.getColourChar() == 'w') {
                            System.out.println(currentPiece.getColourChar());
                            piecesB.delete(playingBoard.getPiece(arrayOfCoords[2], arrayOfCoords[3]));
                            piecesB.toString();
                        }
                        else{
                            piecesW.delete(playingBoard.getPiece(arrayOfCoords[2], arrayOfCoords[3]));
                            piecesW.toString();
                        }
                    }*/
                    if (whiteTurn)
                        playerW.movePieces(occupiedFlag, currentPiece, arrayOfCoords, playingBoard);
                    else
                        playerB.movePieces(occupiedFlag, currentPiece, arrayOfCoords, playingBoard);




            //Make it the next players turn
            whiteTurn = !whiteTurn;
            blackTurn = !blackTurn;


            kingTaken = true;
        }
    }
}
