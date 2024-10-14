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
    
    private void heading(Color gold)
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
    
    private void finalWin(Color gold)
    {
        //INSERT FINAL CASE THINGS
        finalWinTotal.setText("$ ");
        finalWinTotal.setFont(new Font("Arial", Font.PLAIN, 45));
        finalWinTotal.setForeground(gold);
        add(finalWinTotal, BorderLayout.CENTER);
    }
    
    private void buttonPanel(Color gold)
    {
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
        
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    public void setWinTotal(double winning){
        finalWinTotal.setText("$ "+winning);
    }
    
    public JButton getPlayAgain(){
        return this.playAgain;
    }
    
    public JButton getMenu(){
        return this.menu;
    }
}
