/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author laina
 */
public class EndView extends JPanel
{
    private JLabel finalWinTotal;
    private JButton playAgain;
    private JButton menu;
    
    public EndView(Color gold, JPanel mainPanel, CardLayout cardLayout)
    {
        //Setting Background
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        finalWinTotal = new JLabel("..", SwingConstants.CENTER);
        
        heading(gold);
        finalWin(gold);
        buttonPanel(gold);
    }
    
    public void heading(Color gold)
    {
        JLabel congrats = new JLabel("CONGRATULATIONS!", SwingConstants.CENTER);
        congrats.setFont(new Font("Broadway", Font.BOLD, 50));
        congrats.setForeground(gold);

        
        JLabel youWon = new JLabel(" YOU HAVE WON: ", SwingConstants.CENTER);
        youWon.setFont(new Font("Broadway", Font.BOLD, 50));
        youWon.setForeground(gold);

        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new BoxLayout(headingPanel, BoxLayout.Y_AXIS)); 
        headingPanel.setBackground(Color.BLACK); 
        
        headingPanel.add(congrats);
        headingPanel.add(youWon);
        // Align the labels within the panel
        congrats.setAlignmentX(Component.CENTER_ALIGNMENT);
        youWon.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        add(headingPanel, BorderLayout.NORTH);
    }
    
    public void finalWin(Color gold)
    {
        //INSERT FINAL CASE THINGS
        finalWinTotal.setText("$ ");
        finalWinTotal.setFont(new Font("Arial", Font.PLAIN, 45));
        finalWinTotal.setForeground(gold);
        add(finalWinTotal, BorderLayout.CENTER);
    }
    
    public void buttonPanel(Color gold)
    {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setLayout(new BorderLayout());
        
        //Play again button
        JButton play = new JButton("Play Again");
        play.setFont(new Font("Arial", Font.BOLD, 18));
        play.setForeground(Color.BLACK);
        play.setBackground(gold);
        buttonPanel.add(play, BorderLayout.WEST);
        
        //Menu button
        JButton menu = new JButton("Main Menu");
        menu.setFont(new Font("Arial", Font.BOLD, 18));
        menu.setForeground(Color.BLACK);
        menu.setBackground(gold);
        buttonPanel.add(menu, BorderLayout.EAST);
        
        add(buttonPanel, BorderLayout.SOUTH);
    }
    

    //TESTING MAIN DELETE 
    /*public static void main(String[] args) {
        // Create the frame (window)
        JFrame frame = new JFrame("EndView Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);

        // Create the main panel and card layout (which you pass to EndView)
        JPanel mainPanel = new JPanel(new CardLayout());
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();

        // Create the EndView panel with a sample gold color
        Color gold = new Color(255, 215, 0); // Gold color
        EndView endView = new EndView(gold, mainPanel, cardLayout);

        // Add the EndView panel to the frame
        frame.add(endView);

        // Make the frame visible
        frame.setVisible(true);
    }*/
}
