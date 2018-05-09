package assignment2018;
import assignment2018.codeprovided.*;
import assignment2018.codeprovided.PieceCode;
import assignment2018.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GraphicalDisplay extends JFrame implements ActionListener, Display{

    private JLabel[][] boardButtons = new JLabel[8][8];
    private boolean displayNeeded, buttonPressed;
    private JComboBox letterOne = new JComboBox();
    private JComboBox letterTwo = new JComboBox();
    private JComboBox numberOne = new JComboBox();
    private JComboBox numberTwo = new JComboBox();
    private JLabel correctness = new JLabel();

    public GraphicalDisplay() {
        setTitle("Chess");

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenDimensions = toolkit.getScreenSize();
        setSize(screenDimensions.width/2, screenDimensions.height);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Adds all the containers
        Container contentPane = getContentPane();
        JPanel letterPanel = new JPanel();
        JPanel numberPanel = new JPanel();
        JPanel boardPanel = new JPanel();
        JPanel inputPanel = new JPanel();
        JPanel displayPanel = new JPanel();

        //sets layouts of all containers
        contentPane.setLayout(new BorderLayout());
        letterPanel.setLayout(new GridLayout(1,0));
        numberPanel.setLayout(new GridLayout(0,1));
        boardPanel.setLayout(new GridLayout(0,8));
        inputPanel.setLayout(new GridLayout(0,3));
        displayPanel.setLayout(new BorderLayout());

        boolean grey=true;

        //Makes number and letter panels, sets borders to board labels and adds them
        for (int y = 0; y < 8; y++) {
            numberPanel.add(new JLabel(Integer.toString(8-y, JLabel.CENTER)));
            letterPanel.add(new JLabel(String.valueOf((char)('A' + y))));
            grey=!grey;
            for (int x = 0; x < 8; x++) {
                boardButtons[x][y] = new JLabel();
                if (grey)
                    boardButtons[x][y].setBackground(Color.lightGray);

                boardButtons[x][y].setBorder(BorderFactory.createLineBorder(Color.black));
                boardButtons[x][y].setHorizontalAlignment(JLabel.CENTER);
                boardButtons[x][y].setOpaque(true);
                boardPanel.add(boardButtons[x][y]);
                grey = !grey;
            }
        }


        //Adds the input label
        JLabel playerLabel = new JLabel("Input:");
        inputPanel.add(playerLabel);
        //Adds blank label for inbetween
        inputPanel.add(new JLabel());
        inputPanel.add(correctness);

        for (int i = 1; i<9; i++) {
            letterOne.addItem((char)('A' + i-1));
            letterTwo.addItem((char)('A' + i-1));
            numberOne.addItem(i);
            numberTwo.addItem(i);
        }

        inputPanel.setSize(screenDimensions.width/6, screenDimensions.height);
        inputPanel.add(new JLabel("Current position:"));
        inputPanel.add(letterOne);
        inputPanel.add(numberOne);
        inputPanel.add(new JLabel("New position: "));
        inputPanel.add(letterTwo);
        inputPanel.add(numberTwo);

        for (int i=0; i<2; i++)
            inputPanel.add(new JLabel());

        JButton submit = new JButton("Submit");
        submit.addActionListener(this);
        inputPanel.add(submit);

        displayPanel.add(letterPanel, BorderLayout.NORTH);
        displayPanel.add(numberPanel, BorderLayout.WEST);
        displayPanel.add(boardPanel, BorderLayout.CENTER);
        contentPane.add(displayPanel, BorderLayout.CENTER);
        contentPane.add(inputPanel, BorderLayout.EAST);
        setVisible(true);
    }

    public void displayBoard(Pieces myPieces) {
        buttonPressed = false;
        Board playingBoard = myPieces.getPiece(1).getBoard();
        ImageIcon b_bishop = new ImageIcon("images/b_bishop.png");
        ImageIcon b_rook = new ImageIcon("images/b_rook.png");
        ImageIcon b_king = new ImageIcon("images/b_king.png");
        ImageIcon b_knight = new ImageIcon("images/b_knight.png");
        ImageIcon b_pawn = new ImageIcon("images/b_pawn.png");
        ImageIcon b_queen = new ImageIcon("images/b_queen.png");
        ImageIcon w_bishop = new ImageIcon("images/w_bishop.png");
        ImageIcon w_king = new ImageIcon("images/w_king.png");
        ImageIcon w_knight = new ImageIcon("images/w_knight.png");
        ImageIcon w_pawn = new ImageIcon("images/w_pawn.png");
        ImageIcon w_queen = new ImageIcon("images/w_queen.png");
        ImageIcon w_rook = new ImageIcon("images/w_rook.png");

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (playingBoard.getPiece(x , y) != null) {
                    switch (playingBoard.getPiece(x, y).getChar()) {
                        case PieceCode.PAWNWHITE:
                            boardButtons[x][y].setIcon(w_pawn);
                            break;
                        case PieceCode.KNIGHTWHITE:
                            boardButtons[x][y].setIcon(w_knight);
                            break;
                        case PieceCode.BISHOPWHITE:
                            boardButtons[x][y].setIcon(w_bishop);
                            break;
                        case PieceCode.ROOKWHITE:
                            boardButtons[x][y].setIcon(w_rook);
                            break;
                        case PieceCode.QUEENWHITE:
                            boardButtons[x][y].setIcon(w_queen);
                            break;
                        case PieceCode.KINGWHITE:
                            boardButtons[x][y].setIcon(w_king);
                            break;
                        case PieceCode.PAWNBLACK:
                            boardButtons[x][y].setIcon(b_pawn);
                            break;
                        case PieceCode.KNIGHTBLACK:
                            boardButtons[x][y].setIcon(b_knight);
                            break;
                        case PieceCode.BISHOPBLACK:
                            boardButtons[x][y].setIcon(b_bishop);
                            break;
                        case PieceCode.ROOKBLACK:
                            boardButtons[x][y].setIcon(b_rook);
                            break;
                        case PieceCode.QUEENBLACK:
                            boardButtons[x][y].setIcon(b_queen);
                            break;
                        case PieceCode.KINGBLACK:
                            boardButtons[x][y].setIcon(b_king);
                            break;
                        default:
                            boardButtons[x][y].setIcon(null);
                            break;

                    } //end of switch
                } //end of if
                else
                    boardButtons[x][y].setIcon(null);
            } //end of x for
        } //end of y for

    }


    public void actionPerformed(ActionEvent e) {
        buttonPressed = true;
    }

    public char[] getInput() {
        char[] arrayOfCoords = new char[4];
        arrayOfCoords[0] = (char)letterOne.getSelectedItem();
        arrayOfCoords[1] = numberOne.getSelectedItem().toString().charAt(0);
        arrayOfCoords[2] = (char)letterTwo.getSelectedItem();
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

    public void incorrectInput() {
        correctness.setText("Incorrect input!");
    }

    public void correctInput() {
        correctness.setText(null);
    }

}







