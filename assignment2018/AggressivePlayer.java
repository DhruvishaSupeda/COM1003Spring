package assignment2018;

import assignment2018.*;
import assignment2018.Move;
import assignment2018.codeprovided.*;

import java.util.*;

/**
 * AggressivePlayer.java Subclass of Player which chooses moves based on the
 * values of any pieces that can be taken
 * 
 * @author Dhruvisha Supeda
 */
public class AggressivePlayer extends Player {

	private String name;
	private Pieces pieces;
	private Board playingBoard;
	private Player opponent;

	public AggressivePlayer(String n, Pieces p, Board b, Player o) {
		super(n, p, b, o);
		name = n;
		pieces = p;
		playingBoard = b;
		opponent = o;
	}

	/**
	 * Chooses which move to use, based on which moves take a piece and the value of
	 * the piece taken The highest value piece is taken, but if none can be taken, a
	 * random move is selected
	 * 
	 * @param allMoves
	 *            all of the moves possible using all of the pieces for that player
	 * @return the move chosen to be used
	 */
	public Move chooseMove(ArrayList<Move> allMoves) {
		ArrayList<Move> trueMoves = new ArrayList<Move>();
		ArrayList<Move> bigMoves = new ArrayList<Move>();
		Random rand = new Random();
		Move move = null, currentMove = null;
		int randomMove = 0, biggestValue = 0;

		// Puts any moves that would take a piece in trueMoves
		for (int i = 0; i < allMoves.size(); i++) {
			if (allMoves.get(i).getOccupied())
				trueMoves.add(allMoves.get(i));
		}

		// If there are pieces to take, finds the moves which take the highest value
		// pieces possible
		if (trueMoves != null) {
			// Gets everything where occupied is true
			for (int i = 0; i < trueMoves.size(); i++) {
				move = trueMoves.get(i);
				if (playingBoard.getPiece(move.getNX(), move.getNY()).getValue() > biggestValue) {
					biggestValue = playingBoard.getPiece(move.getNX(), move.getNY()).getValue();
				}
			}
			// Puts all of the pieces with biggestValue into bigMoves
			for (int i = 0; i < trueMoves.size(); i++) {
				move = trueMoves.get(i);
				if (playingBoard.getPiece(move.getNX(), move.getNY()).getValue() == biggestValue)
					bigMoves.add(trueMoves.get(i));
			}
			// If there are moves in bigMove (where biggestValue is bigger than 0), one of
			// the moves are chosen randomly
			if (bigMoves.size() != 0) {
				randomMove = rand.nextInt(bigMoves.size());
				currentMove = bigMoves.get(randomMove);
			}
			// If there are no moves in bigMove, picks a random move from all possible moves
			else {
				randomMove = rand.nextInt(allMoves.size());
				currentMove = allMoves.get(randomMove);
			}
		}
		// If there are no moves taking a piece, picks a random move from all possible
		// moves
		else {
			randomMove = rand.nextInt(allMoves.size());
			currentMove = allMoves.get(randomMove);
		}
		return currentMove;
	}

	/**
	 * Chooses the moves out of all moves possible, and makes that move
	 * 
	 * @return returns true to show that the move taken was legal
	 */
	public boolean makeMove() {
		ArrayList<Move> allMoves = new ArrayList<Move>();
		// Gets all of the possible moves for the player
		allMoves = getMoves();

		// Chooses a move out of them using the chooseMove method
		Move currentMove = chooseMove(allMoves);
		boolean occupiedFlag = currentMove.getOccupied();
		// Makes a piece for the piece in the current position
		Piece currentPiece = playingBoard.getPiece(currentMove.getOX(), currentMove.getOY());

		// Moves the current piece
		movePieces(occupiedFlag, currentPiece, playingBoard, currentMove);
		return true;
	}

	/**
	 * Gets all of the available moves from all of the pieces for the player
	 * 
	 * @return an ArrayList of all of the possible moves for the player
	 */
	public ArrayList<Move> getMoves() {
		Piece currentPiece = null;
		ArrayList<Move> allMoves = new ArrayList<Move>();
		// Iterates through each piece in the pieces for the player, and adds all of the
		// moves available to allMoves
		for (int i = 0; i < getPieces().getNumPieces(); i++) {
			currentPiece = getPieces().getPiece(i);
			if (currentPiece.availableMoves() != null) {
				allMoves.addAll(currentPiece.availableMoves());
			}
		}
		return allMoves;
	}

	/**
	 * Using the move chosen, moves the pieces in the board
	 * 
	 * @param occupiedFlag
	 *            boolean to show whether the piece to move into is occupied
	 * @param currentPiece
	 *            the piece being moved
	 * @param currentBoard
	 *            the board being used in the game
	 * @param currentMove
	 *            the move object of the move being used
	 */
	public void movePieces(boolean occupiedFlag, Piece currentPiece, Board currentBoard, Move currentMove) {
		// If the move is taking an opponents piece, deletes the piece from the
		// opponents Pieces
		if (currentBoard.getPiece(currentMove.getNX(), currentMove.getNY()) != null) {
			if (occupiedFlag && (currentPiece
					.getColour() != (currentBoard.getPiece(currentMove.getNX(), currentMove.getNY())).getColour())) {
				this.getOpponent().getPieces().delete(currentBoard.getPiece(currentMove.getNX(), currentMove.getNY()));
				currentBoard.removePiece(currentMove.getNX(), currentMove.getNY());
			}
		}
		// Moves the pieces on the board
		currentBoard.removePiece(currentMove.getOX(), currentMove.getOY());
		currentBoard.setPosition(currentMove.getNX(), currentMove.getNY(), currentPiece);
		currentPiece.setPosition(currentMove.getNX(), currentMove.getNY());
	}
}
