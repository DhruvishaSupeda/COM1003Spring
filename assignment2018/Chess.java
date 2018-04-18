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
        HumanPlayer playerW = new HumanPlayer("White Player", piecesW, playingBoard, null); //change opponent to null
        HumanPlayer playerB = new HumanPlayer("Black Player", piecesB, playingBoard, playerW);
        playerW.setOpponent(playerB);
        ArrayList<Move> theLegalMoves = new ArrayList<Move>();
        Piece currentPiece = null;
        boolean kingTaken = false, occupiedFlag = false, legalMoveFlag = false;
        boolean whiteTurn = true;
        boolean blackTurn = false;
        int[] arrayOfCoords = null;
        HumanPlayer currentPlayer = playerW;

        display(piecesW, piecesB);

        while (!kingTaken) {

            theLegalMoves = null;

            currentPlayer.playerInput(playerW.getPieces().getPiece(0).getColour()); //null pointer exception?

            if (playingBoard.occupied(arrayOfCoords[0], arrayOfCoords[1])) {
                currentPiece = playingBoard.getPiece(arrayOfCoords[0], arrayOfCoords[1]);

                //if black piece in new coordinate, make thing in move true, else false
                if (playingBoard.occupied(arrayOfCoords[2], arrayOfCoords[3]))
                    occupiedFlag = true;
                else
                    occupiedFlag = false;
                System.out.println(occupiedFlag + "occupiedFlag");

                //makes new move for current move
                Move currentMove = new Move(currentPiece, arrayOfCoords[0], arrayOfCoords[1],
                        arrayOfCoords[2], arrayOfCoords[3], occupiedFlag);
                System.out.println(currentMove.toString());

                if (whiteTurn) {
                    legalMoveFlag = currentPlayer.checkMove(currentPiece, currentMove);
                }
                else {
                    legalMoveFlag = currentPlayer.checkMove(currentPiece, currentMove);
                }


                System.out.println(legalMoveFlag + "legalMoveFlag");

                //Get Pieces based on colour
                //Add piece in new position (use setPosition)
                //Remove current piece
                //Display again
                if (legalMoveFlag){
                    if (!(occupiedFlag)) {
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
                    }
                }

            }

            currentPlayer = currentPlayer.getOpponent();

            display(piecesW, piecesB);

            //kingTaken = true;
        }
    }
}
