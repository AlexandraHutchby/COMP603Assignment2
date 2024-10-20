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
public class EndController {
    private EndView viewGame;
    private GameController gameController;
    
    public EndController(EndView viewGame, GameController gameController){
        this.viewGame = viewGame;
        this.gameController = gameController;
        setupListeners();
    }
    
    private void setupListeners(){
        viewGame.getMenu().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                gameController.handleRestartMainMenu();
                CardLayout cardLayout = (CardLayout) viewGame.getParent().getLayout();
                cardLayout.show(viewGame.getParent(), "menuPanel");
            }
        });
        
        viewGame.getPlayAgain().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                gameController.handleRestartPlayAgain();
                CardLayout cardLayout = (CardLayout) viewGame.getParent().getLayout();
                cardLayout.show(viewGame.getParent(), "gamePanel");
            }
        });
    }
}
