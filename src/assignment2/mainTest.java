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
        
        
        GameView gp = new GameView(gold, mainPanel, cardLayout);
        CasesModel c = new CasesModel();
        c.createCases();
        GameController controller = new GameController(c, gp, gold);
        
        //Add different panels to CardLayout
        mainPanel.add(new MenuView(gold, mainPanel, cardLayout), "menuPanel");
        mainPanel.add(new InstructionsView(gold, mainPanel, cardLayout), "instructionsPanel");
        mainPanel.add(new LeaderboardView(gold, mainPanel, cardLayout), "leaderboardPanel");
        mainPanel.add(gp, "gamePanel");
        mainPanel.add(new BankOfferView(gold, mainPanel, cardLayout), "bankerOfferPanel");
        
        //show the frame
        frame.add(mainPanel);
        frame.setVisible(true);
        
        //Show menu panel
        cardLayout.show(mainPanel, "bankerOfferPanel");
    }
    
    
    
}
