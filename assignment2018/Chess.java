package assignment2018;

import assignment2018.codeprovided.*;
import assignment2018.*;
import assignment2018.Move;
import assignment2018.codeprovided.PieceCode;

import java.util.*;

/**
 * Chess.java
 *
 * Main class for the System 
 * Asks the user for inputs to pick what type of
 * interface and players they want 
 * Has the main logic for how the game works
 * depending on the types of players Checks after each move if the king has been
 * taken, to know when to end the game
 *
 * @author Dhruvisha Supeda
 */
public class Chess {

	/**
	 * Checks the player passed in to see if it still has a king piece in its
	 * pieces, to check if either play has taken a king
	 * 
	 * @param player
	 *            the player being checked to see if it has a king
	 * @return returns false if the player still has a king, otherwise returns true
	 */
	public static boolean checkKing(Player player) {
		for (int i = 0; i < player.getOpponent().getPieces().getNumPieces(); i++) {
			if (player.getOpponent().getPieces().getPiece(i).getValue() == PieceCode.KING)
				return false;
		}
		System.out.println(player.toString() + " wins!");
		return true;
	}

	public static void main(String[] args) {
		// Creates board
		Board playingBoard = new Board();
		// Created pieces for both players
		Pieces piecesW = new Pieces(playingBoard, PieceCode.WHITE);
		Pieces piecesB = new Pieces(playingBoard, PieceCode.BLACK);
		Scanner scanner = new Scanner(System.in);
		// Creates the objects of the graphical and text displays
		GraphicalDisplay gDisplay = new GraphicalDisplay();
		TextDisplay tDisplay = new TextDisplay();
		Player playerW = null, playerB = null;

		// Lets user choose which display they would prefer, and sets that display
		// boolean to true in that class
		System.out.print("Would you like a GUI or text display? (1 or 0)");
		int displayType = scanner.nextInt();
		while (displayType != 1 && displayType != 0) {
			System.out.println("Incorrect input.");
			System.out.print("Would you like a GUI or text display? (1 or 0)");
			displayType = scanner.nextInt();
		}
		// Sets the display based on the user input
		if (displayType == 1)
			gDisplay.setDisplayNeeded(true);
		else
			tDisplay.setDisplayNeeded(true);

		System.out.println();
		// Input for types of player
		int player1 = 0, player2 = 0;
		while (player1 != 1 && player1 != 2 && player1 != 3) {
			System.out.println("1 for Human, 2 for Random, 3 for Aggressive");
			System.out.print("What type of player is Player 1? (White)");
			player1 = scanner.nextInt();
		}
		System.out.println();
		while (player2 != 1 && player2 != 2 && player2 != 3) {
			System.out.println("1 for Human, 2 for Random, 3 for Aggressive");
			System.out.print("What type of player is Player 2? (Black)");
			player2 = scanner.nextInt();
		}

		// Makes appropriate player type for each player based on input
		// If the player is human, the display variable in the HumanPlayer class is set
		// to know which type of input is needed
		// from the user in makeMove()
		switch (player1) {
		case 1:
			playerW = new HumanPlayer("White Player", piecesW, playingBoard, null);
			((HumanPlayer) playerW).setGDisplay(gDisplay);
			((HumanPlayer) playerW).setTDisplay(tDisplay);
			break;
		case 2:
			playerW = new RandomPlayer("White Player", piecesW, playingBoard, null);
			break;
		case 3:
			playerW = new AggressivePlayer("White Player", piecesW, playingBoard, null);
			break;
		default:
			playerW = new HumanPlayer("White Player", piecesW, playingBoard, null);
			((HumanPlayer) playerW).setGDisplay(gDisplay);
			((HumanPlayer) playerW).setTDisplay(tDisplay);
			break;
		}

		switch (player2) {
		case 1:
			playerB = new HumanPlayer("Black Player", piecesB, playingBoard, null);
			((HumanPlayer) playerB).setGDisplay(gDisplay);
			((HumanPlayer) playerB).setTDisplay(tDisplay);
			break;
		case 2:
			playerB = new RandomPlayer("Black Player", piecesB, playingBoard, null);
			break;
		case 3:
			playerB = new AggressivePlayer("Black Player", piecesB, playingBoard, null);
			break;
		default:
			playerB = new HumanPlayer("Black Player", piecesB, playingBoard, null);
			((HumanPlayer) playerB).setGDisplay(gDisplay);
			((HumanPlayer) playerB).setTDisplay(tDisplay);
			break;
		}
		System.out.println();

		// Sets the opponent for each player
		playerW.setOpponent(playerB);
		playerB.setOpponent(playerW);
		// Player object used for the player making a move at the time
		Player currentPlayer = playerW;
		// Boolean value indicating who's turn it is
		boolean whiteTurn = true;
		boolean kingTaken = false, legalMove = false;

		// If the display type wanted is a text display
		if (displayType == 0) {
			while (!kingTaken) {
				// Display board
				tDisplay.displayBoard(piecesW);
				// Resets legal move flag
				legalMove = false;
				// While the user has inputted an invalid move
				while (!legalMove) {
					System.out.println();
					if (whiteTurn) {
						System.out.println("Player 1 (white player)'s turn:");
					} else {
						System.out.println("Player 2 (black player)'s turn:");
					}
					// Makes the move and checks if the king has been taken
					legalMove = currentPlayer.makeMove();
					kingTaken = checkKing(currentPlayer);
					// If the move is illegal, informs the user and loops back to the beginning of
					// the while loop
					if (!legalMove)
						System.out.println("Illegal move. Please try a valid move:");
				}

				// Make it the next players turn
				whiteTurn = !whiteTurn;
				if (whiteTurn)
					currentPlayer = playerW;
				else
					currentPlayer = playerB;

			}
			tDisplay.displayBoard(piecesW);
		}

		else {
			// Displays the graphical board, and changes the label to the current player
			gDisplay.displayBoard(piecesW);
			gDisplay.changePlayerLabel(currentPlayer);
			while (!kingTaken) {
				// Resets the legal move flag
				legalMove = false;
				System.out.print("");
				// If the current player is human and the submit button has been pressed, makes
				// the move
				if (currentPlayer instanceof HumanPlayer) {
					if (gDisplay.getButtonPressed()) {
						// Makes the move (if possible) and updates the GUI
						legalMove = currentPlayer.makeMove();
						kingTaken = checkKing(currentPlayer);
						gDisplay.displayBoard(piecesW);
						// If the move was legal, changes to the next player so they can make a move
						if (legalMove) {
							whiteTurn = !whiteTurn;
							if (whiteTurn)
								currentPlayer = playerW;
							else
								currentPlayer = playerB;
							gDisplay.changePlayerLabel(currentPlayer);
						}
					}
				} else {
					// Executes when the player is an AI player as opposed to human
					legalMove = currentPlayer.makeMove();
					kingTaken = checkKing(currentPlayer);
					gDisplay.displayBoard(piecesW);
					if (legalMove) {
						whiteTurn = !whiteTurn;
						if (whiteTurn)
							currentPlayer = playerW;
						else
							currentPlayer = playerB;
						gDisplay.changePlayerLabel(currentPlayer);
					}
				}
				// Resets the button pressed so it can wait until submit is pressed again
				gDisplay.setButtonPressed(false);
			}
			// Displays the graphical board for the last time once the king is taken
			gDisplay.displayBoard(piecesW);
		}
	}

}
