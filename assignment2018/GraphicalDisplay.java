package assignment2018;

import assignment2018.codeprovided.*;
import assignment2018.codeprovided.PieceCode;
import assignment2018.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * GraphicalDisplay.java
 *
 * Constructs and updates a GUI with dropdowns for input for the user
 * 
 * @author Dhruvisha Supeda
 */
public class GraphicalDisplay extends JFrame implements ActionListener, Display {

	// Array storing all of the labels used in the game
	private JLabel[][] boardLabels = new JLabel[8][8];
	private boolean displayNeeded, buttonPressed;
	// Four combo boxes for the user inputs
	private JComboBox letterOne = new JComboBox();
	private JComboBox letterTwo = new JComboBox();
	private JComboBox numberOne = new JComboBox();
	private JComboBox numberTwo = new JComboBox();
	// Labels that change depending on if the user input is correct or not, and
	// which player is currently moving
	private JLabel correctness = new JLabel();
	private JLabel playerLabel = new JLabel();

	// Constants for the height and width of the board
	private final int BOARD_HEIGHT = 8;
	private final int BOARD_WIDTH = 8;

	/**
	 * Constructs the initial state of the board
	 */
	public GraphicalDisplay() {
		setTitle("Chess");

		// Sets the size of the display to be half the screen size
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenDimensions = toolkit.getScreenSize();
		setSize(screenDimensions.width, screenDimensions.height);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Creates the containers used for the different components
		Container contentPane = getContentPane();
		JPanel letterPanel = new JPanel();
		JPanel numberPanel = new JPanel();
		JPanel boardPanel = new JPanel();
		JPanel inputPanel = new JPanel();
		JPanel displayPanel = new JPanel();

		// Sets layouts of all of the containers
		contentPane.setLayout(new BorderLayout());
		letterPanel.setLayout(new GridLayout(1, 0));
		numberPanel.setLayout(new GridLayout(0, 1));
		boardPanel.setLayout(new GridLayout(0, BOARD_WIDTH));
		inputPanel.setLayout(new GridLayout(0, 3));
		displayPanel.setLayout(new BorderLayout());

		// Boolean variable to say whether each square should be grey or white
		boolean grey = false;

		// Makes number and letter panels, makes the new labels for the pieces (makes
		// grey if necessary)
		// Then adds them all to the board panel
		for (int y = 0; y < BOARD_HEIGHT; y++) {
			numberPanel.add(new JLabel(Integer.toString(BOARD_WIDTH - y)));
			letterPanel.add(new JLabel(String.valueOf((char) ('A' + y)), SwingConstants.CENTER));
			grey = !grey;
			for (int x = 0; x < BOARD_WIDTH; x++) {
				boardLabels[x][y] = new JLabel();
				if (grey)
					boardLabels[x][y].setBackground(Color.lightGray);
				boardLabels[x][y].setOpaque(true);

				boardLabels[x][y].setHorizontalAlignment(JLabel.CENTER);
				boardPanel.add(boardLabels[x][y]);
				grey = !grey;
			}
		}

		// Top labels for the input panel are added
		inputPanel.add(playerLabel);
		inputPanel.add(new JLabel());
		inputPanel.add(correctness);

		// Adds the items to the dropdowns for the user input
		for (int i = 1; i < 9; i++) {
			letterOne.addItem((char) ('A' + i - 1));
			letterTwo.addItem((char) ('A' + i - 1));
			numberOne.addItem(i);
			numberTwo.addItem(i);
		}

		// Adds combo boxes and labels to the input panel
		inputPanel.setSize(screenDimensions.width / 6, screenDimensions.height);
		inputPanel.add(new JLabel("Current position:"));
		inputPanel.add(letterOne);
		inputPanel.add(numberOne);
		inputPanel.add(new JLabel("New position: "));
		inputPanel.add(letterTwo);
		inputPanel.add(numberTwo);

		// Adds empty labels to fill in gaps and the submit button
		inputPanel.add(new JLabel());
		inputPanel.add(new JLabel());

		// Adds the submit button to submit the input with an action listener to the
		// input panel
		JButton submit = new JButton("Submit");
		submit.addActionListener(this);
		submit.setPreferredSize(new Dimension(100, 20));
		inputPanel.add(submit);

		// Adds the containers to the display panel or content pane as appropriate
		displayPanel.add(letterPanel, BorderLayout.NORTH);
		displayPanel.add(numberPanel, BorderLayout.WEST);
		displayPanel.add(boardPanel, BorderLayout.CENTER);
		contentPane.add(displayPanel, BorderLayout.CENTER);
		contentPane.add(inputPanel, BorderLayout.EAST);
	}

	/**
	 * Updates the state of the display to the current board used in the game
	 * 
	 * @param myPieces
	 *            the pieces of one of the players, which is used to get the current
	 *            board
	 */
	public void displayBoard(Pieces myPieces) {
		setVisible(true);
		buttonPressed = false;
		// Gets the board of the pieces to be displayed
		Board playingBoard = myPieces.getPiece(0).getBoard();
		// Initialises the icons used to show the board
		ImageIcon b_bishop = new ImageIcon("assignment2018/images/b_bishop.png");
		ImageIcon b_rook = new ImageIcon("assignment2018/images/b_rook.png");
		ImageIcon b_king = new ImageIcon("assignment2018/images/b_king.png");
		ImageIcon b_knight = new ImageIcon("assignment2018/images/b_knight.png");
		ImageIcon b_pawn = new ImageIcon("assignment2018/images/b_pawn.png");
		ImageIcon b_queen = new ImageIcon("assignment2018/images/b_queen.png");
		ImageIcon w_bishop = new ImageIcon("assignment2018/images/w_bishop.png");
		ImageIcon w_king = new ImageIcon("assignment2018/images/w_king.png");
		ImageIcon w_knight = new ImageIcon("assignment2018/images/w_knight.png");
		ImageIcon w_pawn = new ImageIcon("assignment2018/images/w_pawn.png");
		ImageIcon w_queen = new ImageIcon("assignment2018/images/w_queen.png");
		ImageIcon w_rook = new ImageIcon("assignment2018/images/w_rook.png");

		// for each label in the array, checks the piece and sets the icon of the piece
		// accordingly if not null
		for (int y = 0; y < BOARD_HEIGHT; y++) {
			for (int x = 0; x < BOARD_WIDTH; x++) {
				if (playingBoard.getPiece(x, y) != null) {
					switch (playingBoard.getPiece(x, y).getChar()) {
					case PieceCode.PAWNWHITE:
						boardLabels[x][y].setIcon(w_pawn);
						break;
					case PieceCode.KNIGHTWHITE:
						boardLabels[x][y].setIcon(w_knight);
						break;
					case PieceCode.BISHOPWHITE:
						boardLabels[x][y].setIcon(w_bishop);
						break;
					case PieceCode.ROOKWHITE:
						boardLabels[x][y].setIcon(w_rook);
						break;
					case PieceCode.QUEENWHITE:
						boardLabels[x][y].setIcon(w_queen);
						break;
					case PieceCode.KINGWHITE:
						boardLabels[x][y].setIcon(w_king);
						break;
					case PieceCode.PAWNBLACK:
						boardLabels[x][y].setIcon(b_pawn);
						break;
					case PieceCode.KNIGHTBLACK:
						boardLabels[x][y].setIcon(b_knight);
						break;
					case PieceCode.BISHOPBLACK:
						boardLabels[x][y].setIcon(b_bishop);
						break;
					case PieceCode.ROOKBLACK:
						boardLabels[x][y].setIcon(b_rook);
						break;
					case PieceCode.QUEENBLACK:
						boardLabels[x][y].setIcon(b_queen);
						break;
					case PieceCode.KINGBLACK:
						boardLabels[x][y].setIcon(b_king);
						break;
					default:
						boardLabels[x][y].setIcon(null);
						break;
					}
				}
				// If the coordinate does not have a piece (is null), shows a blank label
				else
					boardLabels[x][y].setIcon(null);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		// Makes the buttonPressed variable true to indicate the user wants to submit
		// their input
		buttonPressed = true;
	}

	/**
	 * Takes the input from the user and puts it into an array of characters to be
	 * used by the human player
	 * 
	 * @return the array of characters that stores the user input from the dropdowns
	 */
	public char[] getInput() {
		char[] arrayOfCoords = new char[4];
		arrayOfCoords[0] = (char) letterOne.getSelectedItem();
		arrayOfCoords[1] = numberOne.getSelectedItem().toString().charAt(0);
		arrayOfCoords[2] = (char) letterTwo.getSelectedItem();
		arrayOfCoords[3] = numberTwo.getSelectedItem().toString().charAt(0);
		return arrayOfCoords;
	}

	public void setDisplayNeeded(boolean needed) {
		displayNeeded = needed;
	}

	public boolean getButtonPressed() {
		return buttonPressed;
	}

	public void setButtonPressed(boolean pressed) {
		buttonPressed = pressed;
	}

	public boolean getDisplayNeeded() {
		return displayNeeded;
	}

	/**
	 * changes the text in the correctness label to show the user has entered an
	 * incorrect input
	 */
	public void incorrectInput() {
		correctness.setText("Invalid Move!");
	}

	/**
	 * removes any text from the correctness label
	 */
	public void correctInput() {
		correctness.setText(null);
	}

	/**
	 * Changes the player name displayed depending on who's turn it is (black or
	 * white)
	 * 
	 * @param player
	 *            the player who is making a move next
	 */
	public void changePlayerLabel(Player player) {
		if (player.getPieces().getPiece(1).getColour() == PieceCode.WHITE)
			playerLabel.setText("White Player's Turn");
		else
			playerLabel.setText("Black Player's Turn");

	}

}
