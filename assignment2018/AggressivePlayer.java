package assignment2018;

import assignment2018.*;
import assignment2018.Move;
import assignment2018.codeprovided.*;

import java.util.*;

public class AggressivePlayer extends Player {

    private String name;
    private Pieces pieces;
    private Board playingBoard;
    private Player opponent;
    private int[] arrayOfCoords = new int[4];

    public AggressivePlayer(String n, Pieces p, Board b, Player o) {
        super(n,p,b,o);
        name = n;
        pieces = p;
        playingBoard = b;
        opponent = o;
    }

    public boolean checkKing(boolean whiteTurn) {
        if (/*(playingBoard.getPiece(arrayOfCoords[2], arrayOfCoords[3]) != null) && */
                (playingBoard.getPiece(arrayOfCoords[2], arrayOfCoords[3]).getValue() == PieceCode.KING))  {
            if (whiteTurn)
                System.out.println("White player wins");
            else
                System.out.println("Black player wins");
            return true;
        }
        else
            return false;
    }

    public Move chooseMove(ArrayList<Move> allMoves) {
        ArrayList<Move> trueMoves = new ArrayList<Move>();
        ArrayList<Move> bigMoves = new ArrayList<Move>();
        Move move = null;
        int newX = 0, newY = 0;
        int biggestValue = 0;
        for (int i = 0; i<allMoves.size(); i++) {
            if (allMoves.get(i).getOccupied()){
                trueMoves.add(allMoves.get(i));
            }
        }
        if (trueMoves != null) {
            while (bigMoves != null) {
                for (int i = 0; i < trueMoves.size(); i++) {
                    move = trueMoves.get(i);
                    newX = move.getNX();
                    newY = move.getNY();
                    if (playingBoard.getPiece(newX, newY).getValue() > biggestValue) { //GET NEWX AND NEWY
                        biggestValue = playingBoard.getPiece(newX, newY).getValue();
                    }
                }
                System.out.println(biggestValue + "BIGGEST VALUE");
                for (int i = 0; i < trueMoves.size(); i++) {
                    move = trueMoves.get(i);
                    newX = move.getNX();
                    newY = move.getNY();
                    if (playingBoard.getPiece(newX, newY).getValue() == biggestValue) { //GET NEWX AND NEWY
                        bigMoves.add(trueMoves.get(i));
                    }
                }
            }
            Random rand = new Random();
            int randomMove = rand.nextInt(bigMoves.size());
            //Move currentMove = null;
            Move currentMove = bigMoves.get(randomMove);
            return currentMove;
        }
        else {
            Random rand = new Random();
            int randomMove = rand.nextInt(allMoves.size());
            Move currentMove = allMoves.get(randomMove);
            return currentMove;
        }

    }

    public boolean makeMove() {
        ArrayList<Move> theLegalMoves = new ArrayList<Move>();
        Piece currentPiece = null;
        Move currentMove = null;
        boolean kingTaken = false, occupiedFlag = false, legalMoveFlag = false;
        boolean whiteTurn = false;
        boolean blackTurn = true;
        ArrayList<Move> allMoves = new ArrayList<Move>();
        allMoves = getMoves();
        Random rand = new Random();

        currentMove = chooseMove(allMoves);

        //int randomMove = rand.nextInt(allMoves.size());
        //currentMove = allMoves.get(randomMove);
        arrayOfCoords[0] = currentMove.getOX();
        arrayOfCoords[1] = currentMove.getOY();
        arrayOfCoords[2] = currentMove.getNX();
        arrayOfCoords[3] = currentMove.getNY();
        occupiedFlag = currentMove.getOccupied();
        currentPiece = playingBoard.getPiece(arrayOfCoords[0], arrayOfCoords[1]);

        movePieces(occupiedFlag, currentPiece, arrayOfCoords, playingBoard, currentMove);

        return true;
    }

    public ArrayList<Move> getMoves() {
        Piece currentPiece = null;
        ArrayList<Move> allMoves = new ArrayList<Move>();
        for (int i = 0; i<getPieces().getNumPieces(); i++) {
            currentPiece = getPieces().getPiece(i);
            if (currentPiece.availableMoves() != null) {
                allMoves.addAll(currentPiece.availableMoves());
            }
        }
        return allMoves;
    }

    public void movePieces(boolean occupiedFlag, Piece currentPiece, int[] arrayOfCoords, Board currentBoard, Move currentMove) {
        System.out.println(occupiedFlag);
        if (currentBoard.getPiece(currentMove.getNX(), currentMove.getNY()) != null) {
            if (occupiedFlag && (currentPiece.getColour() != (currentBoard.getPiece(currentMove.getNX(), currentMove.getNY())).getColour())) {
                this.getOpponent().getPieces().delete(currentBoard.getPiece(currentMove.getNX(), currentMove.getNY()));
                currentBoard.removePiece(currentMove.getNX(), currentMove.getNY());
            }
        }

        currentBoard.removePiece(currentMove.getOX(), currentMove.getOY());
        currentBoard.setPosition(currentMove.getNX(), currentMove.getNY(), currentPiece);
        currentPiece.setPosition(currentMove.getNX(), currentMove.getNY());
    }

    public boolean checkMove(Piece currentPiece, Move currentMove) {
        boolean legalMoveFlag = false;
        //Now iterate through move arraylist somehow

        ArrayList<Move> theLegalMoves = new ArrayList<Move>();
        theLegalMoves = currentPiece.availableMoves();
        System.out.println(theLegalMoves);

        if (theLegalMoves != null) {
            System.out.println(theLegalMoves.size() + "legalMovesSize");
            for (int i = 0; i < theLegalMoves.size(); i++) {
                if (theLegalMoves.get(i).equals(currentMove)) {
                    if (currentPiece.getColour() == pieces.getPiece(0).getColour()) {
                        legalMoveFlag = true;
                        System.out.println("Legal + " + theLegalMoves.get(i).toString());
                        break;
                    }
                } else
                    legalMoveFlag = false;
            }
        }
        return legalMoveFlag;
    }







}