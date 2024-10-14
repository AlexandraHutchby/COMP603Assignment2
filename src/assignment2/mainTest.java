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
        
        CasesModel c = new CasesModel();
        c.createCases();
        
        UserCaseModel userCase = new UserCaseModel();
        
        EndView endView = new EndView(gold, mainPanel, cardLayout);
        EndController endController = new EndController (endView);
        
        BankOfferView bankOfferView = new BankOfferView(gold, mainPanel, cardLayout);
        BankOfferModel bankOfferModel = new BankOfferModel();
        BankOfferController bankOfferController = new BankOfferController(bankOfferView, bankOfferModel, c, endView);
        
        GameView gameView = new GameView(gold, mainPanel, cardLayout);
        FinalRoundView finalRoundView = new FinalRoundView(gold, mainPanel, cardLayout);
        
        FinalRoundController finalRoundController = new FinalRoundController(finalRoundView, endView, c);
        GameController controller = new GameController(c, gameView, bankOfferController, gold, userCase, finalRoundController);
        
        LeaderboardView leaderboardView = new LeaderboardView(gold, mainPanel, cardLayout);
        LeaderboardDatabase leaderboardDatabase = new LeaderboardDatabase();
        LeaderboardController leaderboardController = new LeaderboardController(leaderboardDatabase, leaderboardView);
        
        
        //Add different panels to CardLayout
        mainPanel.add(new MenuView(gold, mainPanel, cardLayout), "menuPanel");
        mainPanel.add(new InstructionsView(gold, mainPanel, cardLayout), "instructionsPanel");
        mainPanel.add(leaderboardView, "leaderboardPanel");
        mainPanel.add(gameView, "gamePanel");
        mainPanel.add(bankOfferView, "bankerOfferPanel");
        mainPanel.add(endView, "endPanel");
        mainPanel.add(finalRoundView, "finalRoundPanel");
        
        //show the frame
        frame.add(mainPanel);
        frame.setVisible(true);
        
        //Show menu panel
        cardLayout.show(mainPanel, "menuPanel");
    }
    
}
