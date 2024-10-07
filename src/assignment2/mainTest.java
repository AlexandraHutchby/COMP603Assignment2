/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author laina
 */
public class mainTest 
{
    private static JPanel mainPanel;
    private static CardLayout cardLayout;
    
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> createMainFrame());
    }

    private static void createMainFrame() 
    {
        Color gold = new Color(255,215,0);
        
        //create frame
        JFrame frame = new JFrame("Deal or No Deal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,500);
        frame.setLocationRelativeTo(null);
        
        //Use cardLayout to switch between panels
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        //Add different panels to CardLayout
        mainPanel.add(new menuPanel(gold, mainPanel, cardLayout), "menuPanel");
        mainPanel.add(new instructionsPanel(gold, mainPanel, cardLayout), "instructionsPanel");
        mainPanel.add(new leaderboardPanel(gold, mainPanel, cardLayout), "leaderboardPanel");
        mainPanel.add(new gamePanel(gold, mainPanel, cardLayout), "gamePanel");
        
        //show the frame
        frame.add(mainPanel);
        frame.setVisible(true);
        
        //Show menu panel
        cardLayout.show(mainPanel, "menuPanel");
    }
    
    
    
}
