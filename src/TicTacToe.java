import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe {
    int boardWidth = 600;
    int boardHeight = 650;

    JFrame frame = new JFrame("Tic-Tac_Toe");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();
    JButton[][] board = new JButton[3][3];
    String playerA = "Anisa"; 
    String playerF = "Fatima";
    String currentPlayer = playerA;

    boolean gameOver = false; 
    int turns = 0;



    TicTacToe(){
                                                                                              //frame window done 
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        //to set frame in the center
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                                  //for exiting on close
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



                                                                                   // setting up the 3  by 3 layout for tic-tac-toe game 

         boardPanel.setLayout( new GridLayout(3,3));
         boardPanel.setBackground(Color.lightGray);
         frame.add(boardPanel);

         for (int r = 0; r < 3; r++){
            for (int c = 0; c < 3; c++){
             JButton tile =new JButton();
             board[r][c]= tile;
             boardPanel.add(tile);

             tile.setBackground(Color.DARK_GRAY);
             tile.setForeground(Color.WHITE);;
             tile.setFont(new Font("Arial", Font.BOLD, 30));
             tile.setFocusable(false);

             tile.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e){
                if (gameOver) return;
                JButton tile = (JButton) e.getSource(); 
                if  (tile.getText().equals("")){
                    tile.setText(currentPlayer);
                    turns++;
                    checkWinner();
                    if (!gameOver){
                        currentPlayer = currentPlayer.equals(playerA)? playerF : playerA;
                        textLabel.setText(currentPlayer +  "'s turn.");

                    }
                }
                
               }
                
             });

            }
         }

     }
     void checkWinner(){
    //horizontal side winner condition
        for (int r = 0; r < 3; r++){
            if (board[r][0].getText().equals("")) continue;

            if (board[r][0].getText().equals(board[r][1].getText()) && 
                board[r][1].getText().equals(board[r][2].getText())){ 
                    for (int i = 0; i < 3; i++){
                        setWinner(board[r][i]);
                    }  
                    gameOver = true;

            }
        }
    //vertical side winner condition    

    for (int c = 0; c < 3; c++){
       if (board[0][c].getText() == "") continue;
       
       if (board[0][c].getText() ==  board[1][c].getText() &&
          board[0][c].getText() == board[2][c].getText()){
       for (int i = 0; i < 3; i++){
        setWinner(board[i][c]);
       }
        gameOver = true;
        return;
       }
    }

    // diagonal side winner condition 

    if (board[0][0].getText() ==  board[1][1].getText() &&
        board[1][1].getText() ==  board[2][2].getText() &&
         board[0][0].getText() != "") {
            for (int i= 0; i <3 ; i++){
                setWinner(board[i][i]);
            }
            gameOver = true;
            return;
         }
    // anti-diagonal side winner condition      
    if (board[0][2].getText() ==  board[1][1].getText() &&
    board[1][1].getText() ==  board[2][0].getText() &&
     board[0][2].getText() != ("")) {
        for (int i= 0; i <3 ; i++){
            setWinner(board[0][2]);
            setWinner(board[1][1]);
            setWinner(board[2][0]);
        gameOver = true;
        return;
     }
     if (turns == 9){
        for (int r= 0; r< 3 ; r++){
            for (int c=0; c<3; c++){
        setTie(board[r][c]);
        }
    }
        gameOver = true; 
     }
    }

          
}
  void setWinner(JButton tile){
    tile.setForeground(Color.green);
    tile.setBackground(Color.gray);
    textLabel.setText(currentPlayer + " wins!");
    return;
  }
  void setTie(JButton tile){
    tile.setForeground(Color.orange);
    tile.setBackground(Color.gray);
    textLabel.setText(currentPlayer + " it's a tie");
    return;
  }
  public static void main(String[]args){
    new TicTacToe();
  }
 }
