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
public class MenuController {
    private MenuView view;
    public MenuController(MenuView view){
        this.view = view;
        
        setupListeners();
    }
    
    private void setupListeners(){
               view.getHowTo().addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
                cardLayout.show(view.getParent(), "instructionsPanel");
                
            }
        });
        
        //Action listener for learder button
        view.getLeaderBoard().addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
                cardLayout.show(view.getParent(), "leaderboardPanel");
                
            }
        });
        
        view.getStart().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
                cardLayout.show(view.getParent(), "gamePanel");
            }
        });
    }
}
