/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;

/**
 *
 * @author Alexandra
 */
public class LeaderboardController {
    private LeaderboardDatabase database;
    private LeaderboardView view;
    
    public LeaderboardController(LeaderboardDatabase database, LeaderboardView view){
        this.database = database;
        this.view = view;
        setupListeners();
        updateLeaderboard();
        
    }
    
    public void updateLeaderboard(){
        List<String> topScores = database.getTopScores();
        view.updateScores(topScores);
    }
    
    private void setupListeners(){
        
        view.getMenu().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                database.closeDatabase();
                CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
                cardLayout.show(view.getParent(), "menuPanel");
            }
        });
        
        view.getStart().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                database.closeDatabase();
                CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
                cardLayout.show(view.getParent(), "gamePanel");
            }
        });
    }
    
}
