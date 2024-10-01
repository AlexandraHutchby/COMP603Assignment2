/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
public class menuGUI 
{
    public static void main(String[] args) 
    {
      SwingUtilities.invokeLater(() -> createMenuGui());  
    }
    public static void createMenuGui()
    {
        //Creating frame
        JFrame frame = new JFrame("Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        
        //Setting Background
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(new BorderLayout());
        
        //Creating title
        JLabel title = new JLabel("DEAL OR NO DEAL", SwingConstants.CENTER);
        title.setFont(new Font("Broadway", Font.BOLD, 75));
        title.setForeground(Color.YELLOW);
        title.setBorder(new EmptyBorder(50, 0, 100, 0)); // Adds padding around the title for better centering
        panel.add(title, BorderLayout.NORTH);
        
        
        //Creating Buttons panels
        JPanel startPanel = new JPanel();
        startPanel.setBackground(Color.BLACK);
        startPanel.setBorder(new EmptyBorder(50, 0, 0, 0)); // Add padding to push the button lower
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setLayout(new BorderLayout());
        
        //Start Button
        JButton start = new JButton("Start Game");
        start.setFont(new Font("Arial", Font.BOLD, 30));
        start.setForeground(Color.BLACK);
        start.setBackground(Color.YELLOW);
        startPanel.add(start, BorderLayout.CENTER);
        
        //Instruction button
        JButton instuc = new JButton("How to Play");
        instuc.setFont(new Font("Arial", Font.BOLD, 18));
        instuc.setForeground(Color.BLACK);
        instuc.setBackground(Color.YELLOW);
        buttonPanel.add(instuc, BorderLayout.WEST);  // Bottom-left corner
        
        //Leaderboard button
        JButton leaderBoard = new JButton("Leaderboard");
        leaderBoard.setFont(new Font("Arial", Font.BOLD, 18));
        leaderBoard.setForeground(Color.BLACK);
        leaderBoard.setBackground(Color.YELLOW);
        buttonPanel.add(leaderBoard, BorderLayout.EAST); // Bottom-right corner

        panel.add(startPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH); // Position buttons panel at the bottom

        frame.add(panel);
        frame.setVisible(true);
    }
}
