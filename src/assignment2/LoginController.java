/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Alexandra
 */
public class LoginController {
    private LoginDatabase database;
    private LoginView view;
    private LeaderboardDatabase leaderboardDatabase;
    
    public LoginController(LoginDatabase database, LoginView view, LeaderboardDatabase leaderboardDatabase){
        this.view = view;
        this.database = database;
        this.leaderboardDatabase = leaderboardDatabase;
        
        setupListeners();
        database.insertUsername(view.getUsername(), view.getPassword());
    }
    
    public void setupListeners(){
        view.getLoginButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String username = view.getUsername();
                String password = view.getPassword();
                
                if(!database.checkUsername(username)){
                    database.insertUsername(username, password);
                    leaderboardDatabase.setCurrentUsername(username);
                    leaderboardDatabase.insertScoresInLeaderboard(username);
                    CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
                    cardLayout.show(view.getParent(), "instructionsPanel");
                    database.closeDatabase();
                }else if(database.checkUsernameAndPassword(username, password)){
                    leaderboardDatabase.setCurrentUsername(username);
                    database.closeDatabase();
                    CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
                    cardLayout.show(view.getParent(), "menuPanel");
                }else{
                    view.addUsernameUsed();
                }
            }
        });
    }
}
