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
        HumanPlayer playerW = new HumanPlayer();
        boolean occupiedFlag;
        ArrayList<Move> theLegalMoves = new ArrayList<Move>();
        Piece currentPiece = null;

        display(piecesW, piecesB);

        int[] arrayOfCoords = playerW.playerInput();

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

            boolean legalMoveFlag = playerW.checkMove(currentPiece, currentMove);

            System.out.println(legalMoveFlag + "legalMoveFlag");

            //Get Pieces based on colour
            //Add piece in new position (use setPosition)
            //Remove current piece
            //Display again
            if (!(occupiedFlag)) {
                playingBoard.removePiece(arrayOfCoords[0], arrayOfCoords[1]);
                playingBoard.setPosition(arrayOfCoords[2], arrayOfCoords[3], currentPiece);
                currentPiece.setPosition(arrayOfCoords[2], arrayOfCoords[3]);
            }

        }

        display(piecesW, piecesB);

    }
}
