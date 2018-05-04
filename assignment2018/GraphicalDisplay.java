package assignment2018;
import assignment2018.codeprovided.*;
import assignment2018.codeprovided.PieceCode;
import assignment2018.*;
import javax.swing.*;
import java.awt.*;

public class GraphicalDisplay extends JFrame implements Display {

    private JButton[][] boardButtons = new JButton[8][8];
    private Container contentPane = getContentPane();
    private JPanel letterPanel = new JPanel();
    JPanel numberPanel = new JPanel();
    JPanel boardPanel = new JPanel();

    public GraphicalDisplay() {
        setTitle("Chess");

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenDimensions = toolkit.getScreenSize();
        setSize(screenDimensions.width / 2, screenDimensions.height / 2);

        //setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Container contentPane = getContentPane();
        //contentPane.setLayout(new GridLayout(0, 9));
        contentPane.setLayout(new BorderLayout());
        letterPanel.setLayout(new GridLayout(1,0));
        numberPanel.setLayout(new GridLayout(0,1));
        boardPanel.setLayout(new GridLayout(0,8));


        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                boardButtons[x][y] = new JButton();
                boardPanel.add(boardButtons[x][y]);
            }
        }

        for (int i = 0; i<8; i++) {
            numberPanel.add(new JButton(Integer.toString(i)));
            letterPanel.add(new JButton("A"));
        }
        contentPane.add(letterPanel, BorderLayout.NORTH);
        contentPane.add(numberPanel, BorderLayout.WEST);
        contentPane.add(boardPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void displayBoard(Pieces myPieces) {
        Board playingBoard = myPieces.getPiece(1).getBoard();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
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
                //boardButtons[x][0].setText(Integer.toString((char)64+x));
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


}







