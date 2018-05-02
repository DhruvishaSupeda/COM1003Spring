package assignment2018;
import assignment2018.codeprovided.*;
import assignment2018.codeprovided.PieceCode;
import assignment2018.*;
import javax.swing.*;
import java.awt.*;

public class GraphicalDisplay extends JFrame implements Display {
    public GraphicalDisplay() {
        setTitle("Chess");

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenDimensions = toolkit.getScreenSize();
        setSize(screenDimensions.width/2, screenDimensions.height/2);

        setSize(900,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(8,8));

        JButton[][] boardButtons = new JButton[8][8];
        for (int y = 0; y<8; y++) {
            for (int x=0; x<8; x++) {
                boardButtons[x][y] = new JButton();
                contentPane.add(boardButtons[x][y]);
            }
        }
    }

    public void displayBoard(Pieces myPieces) {
        Board playingBoard = myPieces.getPiece(1).getBoard();
        System.out.println(playingBoard.toString());

        case (myPieces.getPiece(i).getChar()): {

        }

    }







}