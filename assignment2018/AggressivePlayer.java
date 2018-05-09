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

    /**
     * Chooses which move to use, based on which moves take a piece and the value of the piece taken
     * The highest value piece is taken, but if none can be taken, a random move is selected
     * @param  allMoves all of the moves possible using all of the pieces for that player
     * @return the move chosen to be used
     */
    public Move chooseMove(ArrayList<Move> allMoves) {
        ArrayList<Move> trueMoves = new ArrayList<Move>();
        ArrayList<Move> bigMoves = new ArrayList<Move>();
        Random rand = new Random();
        Move move = null, currentMove = null;
        int newX = 0, newY = 0, randomMove = 0, biggestValue = 0;

        for (int i = 0; i<allMoves.size(); i++) {
            if (allMoves.get(i).getOccupied())
                trueMoves.add(allMoves.get(i));
        }

        if (trueMoves != null) {
            //Gets everything where occupied is true
            for (int i = 0; i < trueMoves.size(); i++) {
                move = trueMoves.get(i);
                newX = move.getNX();
                newY = move.getNY();
                if (playingBoard.getPiece(newX, newY).getValue() > biggestValue) { //GET NEWX AND NEWY
                    biggestValue = playingBoard.getPiece(newX, newY).getValue();
                }
            }
            while (bigMoves.size() == 0 && biggestValue >=0) {
                for (int i = 0; i < trueMoves.size(); i++) {
                    move = trueMoves.get(i);
                    newX = move.getNX();
                    newY = move.getNY();
                    if (playingBoard.getPiece(newX, newY).getValue() == biggestValue) { //GET NEWX AND NEWY
                        bigMoves.add(trueMoves.get(i));
                    }
                }
                if (bigMoves == null) {
                    biggestValue -= 1;
                }
                else
                    break;

            }
            if (bigMoves.size() > 0) {
                randomMove = rand.nextInt(bigMoves.size());
                currentMove = bigMoves.get(randomMove);
            }
            else {
                randomMove = rand.nextInt(allMoves.size());
                currentMove = allMoves.get(randomMove);
            }
        }
        else {
            randomMove = rand.nextInt(allMoves.size());
            currentMove = allMoves.get(randomMove);
        }
        return currentMove;
    }

    /**
     * Chooses the moves out of all moves possible, and makes that move
     * @return returns true to show that the move taken was legal
     */
    public boolean makeMove() {
        ArrayList<Move> allMoves = new ArrayList<Move>();

        allMoves = getMoves();
        Move currentMove = chooseMove(allMoves);

        arrayOfCoords[0] = currentMove.getOX();
        arrayOfCoords[1] = currentMove.getOY();
        arrayOfCoords[2] = currentMove.getNX();
        arrayOfCoords[3] = currentMove.getNY();
        boolean occupiedFlag = currentMove.getOccupied();
        Piece currentPiece = playingBoard.getPiece(arrayOfCoords[0], arrayOfCoords[1]);

        movePieces(occupiedFlag, currentPiece, arrayOfCoords, playingBoard, currentMove);
        return true;
    }

    /**
     * Gets all of the available moves from all of the pieces for the player
     * @return an ArrayList of all of the possible moves for the player
     */
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

    /**
     * Using the move chosen, moves the pieces in the board
     * @param occupiedFlag  boolean to show whether the piece to move into is occupied
     * @param currentPiece  the piece being moved
     * @param arrayOfCoords the array of coordinates of the current piece and where it is moving to
     * @param currentBoard  the board being used in the game
     * @param currentMove   the move object of the move being used
     */
    public void movePieces(boolean occupiedFlag, Piece currentPiece, int[] arrayOfCoords, Board currentBoard, Move currentMove) {
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



}
