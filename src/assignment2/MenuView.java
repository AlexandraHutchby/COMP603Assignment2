/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author laina
 */
public class MenuView extends JPanel
{
    private JButton start;
    private JButton howTo;
    private JButton leaderBoard;
    public MenuView(Color gold, JPanel mainPanel, CardLayout cardLayout)
    {        
        //Setting Background
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());          
        
        createHeader(gold);
        createStartPanel(gold);
        createButtons(gold);
    }
    
    private void createHeader(Color gold){
        //Creating title
        JLabel title = new JLabel("DEAL OR NO DEAL", SwingConstants.CENTER);
        title.setFont(new Font("Broadway", Font.BOLD, 75));
        title.setForeground(gold);  //Colour for gold
        title.setBorder(new EmptyBorder(50, 0, 100, 0)); // Adds padding around the title for better centering
        add(title, BorderLayout.NORTH);
    }
    
    private void createStartPanel(Color gold){
        JPanel startPanel = new JPanel();
        startPanel.setBackground(Color.BLACK);
        startPanel.setBorder(new EmptyBorder(50, 0, 0, 0)); // Add padding to push the button lower
        
        //Start Button
        start = new JButton("Start Game");
        start.setFont(new Font("Arial", Font.BOLD, 30));
        start.setForeground(Color.BLACK);
        start.setBackground(gold);
        startPanel.add(start, BorderLayout.CENTER);
        
        add(startPanel, BorderLayout.CENTER);
    }
    
    private void createButtons(Color gold){
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
    
    public JButton getHowTo(){
        return this.howTo;
    }
    
    public JButton getLeaderBoard(){
        return this.leaderBoard;
    }
    
    public JButton getStart(){
        return this.start;
    }
}
