package assignment2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * this class is the visual for the end screen view of the players winnings and
 * provides options to play again or return to main menu
 *
 * @author Alexandra and Laina
 */
public class EndView extends JPanel {

    private JLabel finalWinTotal;
    private JButton playAgain;
    private JButton menu;

    //Constructor for componets of the class
    public EndView(Color gold) {
        //Setting Background
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        finalWinTotal = new JLabel("..", SwingConstants.CENTER);

        //Adding heading, final win total and button panel
        heading(gold);
        finalWin(gold);
        buttonPanel(gold);
    }

    //Creates and adds heading to view, displays congragualtions messages
    private void heading(Color gold) {
        JLabel congrats = new JLabel("CONGRATULATIONS!", SwingConstants.CENTER);
        congrats.setFont(new Font("Broadway", Font.BOLD, 50));
        congrats.setForeground(gold);

        JLabel youWon = new JLabel(" YOU HAVE WON: ", SwingConstants.CENTER);
        youWon.setFont(new Font("Broadway", Font.BOLD, 50));
        youWon.setForeground(gold);

        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new BoxLayout(headingPanel, BoxLayout.Y_AXIS));
        headingPanel.setBackground(Color.BLACK);

        //adds labels to the heading
        headingPanel.add(congrats);
        headingPanel.add(youWon);

        // Align the labels within the panel
        congrats.setAlignmentX(Component.CENTER_ALIGNMENT);
        youWon.setAlignmentX(Component.CENTER_ALIGNMENT);

        //adds heading panel to top of main panel
        add(headingPanel, BorderLayout.NORTH);
    }

    //creates and displays players final winnings
    private void finalWin(Color gold) {
        //sets up final winings label
        finalWinTotal.setText("$ ");
        finalWinTotal.setFont(new Font("Arial", Font.PLAIN, 45));
        finalWinTotal.setForeground(gold);
        add(finalWinTotal, BorderLayout.CENTER);
    }

    //Creates and adds button panel for play again and main menu buttons
    private void buttonPanel(Color gold) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setLayout(new BorderLayout());

        //Play again button
        playAgain = new JButton("Play Again");
        playAgain.setFont(new Font("Arial", Font.BOLD, 18));
        playAgain.setForeground(Color.BLACK);
        playAgain.setBackground(gold);
        buttonPanel.add(playAgain, BorderLayout.WEST);

        //Menu button
        menu = new JButton("Main Menu");
        menu.setFont(new Font("Arial", Font.BOLD, 18));
        menu.setForeground(Color.BLACK);
        menu.setBackground(gold);
        buttonPanel.add(menu, BorderLayout.EAST);

        //adds button panel to bottom of the main panel
        add(buttonPanel, BorderLayout.SOUTH);
    }

    //gets and sets 
    public void setWinTotal(double winning) {
        finalWinTotal.setText("$ " + winning);
    }

    public JButton getPlayAgain() {
        return this.playAgain;
    }

    public JButton getMenu() {
        return this.menu;
    }
}
