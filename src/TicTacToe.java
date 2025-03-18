import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe {
    int boardWidth = 600;
    int boardHeight = 650;

    JFrame frame = new JFrame("Tic-Tac_Toe");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();

    TicTacToe(){
        //frame window done 
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        //to set frame in the center
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //for exiting on close
        frame.setLayout(new BorderLayout());

        //setting up the window
        textLabel.setBackground(Color.ORANGE);
        textLabel.setForeground(Color.DARK_GRAY);
        textLabel.setFont(new Font("Arial", Font.BOLD, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic-Tac-Toe");
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel);
        frame.add(textPanel, BorderLayout.NORTH);



     }
    }
