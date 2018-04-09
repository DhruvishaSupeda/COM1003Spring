package assignment2018;

import assignment2018.codeprovided.*;
import assignment2018.*;
import assignment2018.Move;
import assignment2018.codeprovided.PieceCode;

import java.util.*;

public class Chess {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board playingBoard = new Board();
        Pieces PiecesW = new Pieces(playingBoard, PieceCode.WHITE);
        Pieces PiecesB = new Pieces(playingBoard, PieceCode.BLACK);
        playingBoard.toStrin();
        HumanPlayer playerW = new HumanPlayer();
        boolean occupiedFlag;
        ArrayList<Move> theLegalMoves = new ArrayList<Move>();
        Piece currentPiece = null;

        System.out.println(PiecesW.toString());

        TextDisplay one = new TextDisplay();
        one.resetFlags();
        one.displayBoard(PiecesW);
        one.displayBoard(PiecesB);

        //Input from first players
        System.out.print("Player 1 (white) move: ");
        //Takes input - NEED EXCEPTION ERROR IF NOT IN CORRECT FORMAT/PUT NOTHING IN
        String coords = scanner.nextLine();
        //Uses space as delimiter and puts from and to into 2 elements of array
        char[] arrayOfCoords = coords.replaceAll("\\s", "").toCharArray();
        //Prints out array (for debugging)
        //for (int i = 0; i < arrayOfCoords.length; i++)
        //    System.out.println(arrayOfCoords[i]);

        int[] arrayOfCoordsInts = new int[4];
        arrayOfCoordsInts[0] = playerW.checkCoords(arrayOfCoords[0]);
        arrayOfCoordsInts[1] = ((int) arrayOfCoords[1] - '0')-1;
        arrayOfCoordsInts[2] = playerW.checkCoords(arrayOfCoords[2]);
        arrayOfCoordsInts[3] = ((int) arrayOfCoords[3] - '0')-1;

        //WHY IS PIECE OBJECT NULL????
        System.out.print(arrayOfCoordsInts[0] + arrayOfCoordsInts[1]);
        if (playingBoard.occupied(arrayOfCoordsInts[0], arrayOfCoordsInts[1])) {
            currentPiece = playingBoard.getPiece(arrayOfCoordsInts[0], arrayOfCoordsInts[1]);
            //currentPiece = new Pawn(0, 1, PieceCode.WHITE, playingBoard);
            System.out.println(currentPiece.toString());
            if (currentPiece != null) System.out.println("Truuueeeeee00");
            //}


            //if black piece in new coordinate, make thing in move true, else false
            if (playingBoard.occupied(arrayOfCoordsInts[2], arrayOfCoordsInts[3]))
                occupiedFlag = true;
            else
                occupiedFlag = false;
            System.out.println(occupiedFlag + "occupiedFlag");
            //makes new move for current move

            Move currentMove = new Move(currentPiece, arrayOfCoordsInts[0], arrayOfCoordsInts[1],
                    arrayOfCoordsInts[2], arrayOfCoordsInts[3], occupiedFlag);

            System.out.println(arrayOfCoordsInts[0]);
            //-'0' to get rid of the ASCII value of 0, making it the actual value of the char
            System.out.println(arrayOfCoordsInts[1]);

            boolean legalMoveFlag = false;
            //Now iterate through move arraylist somehow

            theLegalMoves = currentPiece.availableMoves();
            System.out.println(theLegalMoves);

            if (theLegalMoves != null) {
                System.out.println(theLegalMoves.size() + "legalMovesSize");
                for (int i = 1; i < theLegalMoves.size(); i++) {
                    if (theLegalMoves.get(i).equals(currentMove)) {
                        legalMoveFlag = true;
                        break;
                    } else
                        legalMoveFlag = false;
                }
            }


            System.out.println(legalMoveFlag + "legalMoveFlag");

            //Get Pieces based on colour
            //Remove current piece
            //Add piece in new position
            //Display again

            /*if (currentPiece.getColour() == PieceCode.WHITE) {
                PiecesW.delete(currentPiece);
                Piece newPawn = new Pawn(arrayOfCoordsInts[2], arrayOfCoordsInts[3], PieceCode.WHITE, playingBoard);
                //PiecesW.add(newPawn);
            }*/

            one.resetFlags();
            one.displayBoard(PiecesW);
            one.displayBoard(PiecesB);
        }

    }
}
