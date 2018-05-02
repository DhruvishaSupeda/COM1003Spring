package assignment2018;
import assignment2018.codeprovided.*;
import assignment2018.codeprovided.PieceCode;
import assignment2018.*;
import javax.swing.*;
import java.awt.*;

public class GraphicalDisplay extends JFrame implements Display {

    private JButton[][] boardButtons = new JButton[8][8];

    public GraphicalDisplay() {
        setTitle("Chess");

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenDimensions = toolkit.getScreenSize();
        setSize(screenDimensions.width / 2, screenDimensions.height / 2);

        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(8, 8));

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                boardButtons[x][y] = new JButton();
                contentPane.add(boardButtons[x][y]);
            }
        }
    }

    public void displayBoard(Pieces myPieces) {
        Board playingBoard = myPieces.getPiece(1).getBoard();
        System.out.println(playingBoard.toString());


        for (int y = 0; y<8; y++) {
            for (int x = 0; x<8; x++) {
                if (playingBoard.getPiece(x,y) != null) {
                    System.out.println(playingBoard.getPiece(x,y));
                    switch (playingBoard.getPiece(x, y).getChar()) {
                        case PieceCode.PAWNWHITE:
                            break;
                        case PieceCode.KNIGHTWHITE:
                            break;
                        case PieceCode.BISHOPWHITE:
                            break;
                        case PieceCode.ROOKWHITE:
                            break;
                        case PieceCode.QUEENWHITE:
                            break;
                        case PieceCode.KINGWHITE:
                            break;
                        case PieceCode.PAWNBLACK:
                            break;
                        case PieceCode.KNIGHTBLACK:
                            break;
                        case PieceCode.BISHOPBLACK:
                            break;
                        case PieceCode.ROOKBLACK:
                            break;
                        case PieceCode.QUEENBLACK:
                            break;
                        case PieceCode.KINGBLACK:
                            break;
                        default:
                            break;

                    }
                }
            }
        }

    }







}