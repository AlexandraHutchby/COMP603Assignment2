package assignment2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * This function creates the menu interface, arranging the title and buttons for
 * interacting with different sections of the game
 *
 * @author Alexandra and Laina
 */
public class MenuView extends JPanel {

    private JButton start; // button for starting the game
    private JButton howTo; //button for instructions 
    private JButton leaderBoard; //button for leaderboard

    /*
    this creates the view with the gold colouring
     */
    public MenuView(Color gold) {
        //Setting Background
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());

        createHeader(gold); //create the header
        createStartPanel(gold); //create the start panel
        createButtons(gold); //create the buttons
    }

    /*
    this function creates the title 
     */
    private void createHeader(Color gold) {
        //Creating title
        JLabel title = new JLabel("DEAL OR NO DEAL", SwingConstants.CENTER);
        title.setFont(new Font("Broadway", Font.BOLD, 75));
        title.setForeground(gold);  //Colour for gold
        title.setBorder(new EmptyBorder(50, 0, 100, 0)); // Adds padding around the title for better centering
        add(title, BorderLayout.NORTH);
    }

    /*
    this function creates the start panel
     */
    private void createStartPanel(Color gold) {
        JPanel startPanel = new JPanel();
        startPanel.setBackground(Color.BLACK);
        startPanel.setBorder(new EmptyBorder(50, 0, 0, 0)); // Add padding to push the button lower

        //Start Button
        start = new JButton("Start Game"); //start button
        start.setFont(new Font("Arial", Font.BOLD, 30));
        start.setForeground(Color.BLACK);
        start.setBackground(gold);
        startPanel.add(start, BorderLayout.CENTER);

        add(startPanel, BorderLayout.CENTER);
    }

    /*
    this function creates buttons
     */
    private void createButtons(Color gold) {
        //Creating Buttons panels

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setLayout(new BorderLayout());

        //Instruction button
        howTo = new JButton("How to Play");
        howTo.setFont(new Font("Arial", Font.BOLD, 18));
        howTo.setForeground(Color.BLACK);
        howTo.setBackground(gold);
        buttonPanel.add(howTo, BorderLayout.WEST);  // Bottom-left corner

        //Leaderboard button
        leaderBoard = new JButton("Leaderboard");
        leaderBoard.setFont(new Font("Arial", Font.BOLD, 18));
        leaderBoard.setForeground(Color.BLACK);
        leaderBoard.setBackground(gold);
        buttonPanel.add(leaderBoard, BorderLayout.EAST); // Bottom-right corner

        add(buttonPanel, BorderLayout.SOUTH); // Position buttons panel at the bottom
    }

    // get functions
    public JButton getHowTo() {
        return this.howTo;
    }

    public JButton getLeaderBoard() {
        return this.leaderBoard;
    }

    public JButton getStart() {
        return this.start;
    }
}
