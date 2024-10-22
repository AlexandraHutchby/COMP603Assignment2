package assignment2;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class manages interactions after the game ends. controls transitions
 * between the end screen and either restarts game or returns to main menu
 *
 * @author Alexandra and Laina
 */
public class EndController {

    private EndView viewGame;
    private GameController gameController;

    //Constructor to initilize ocmponest and setup listeners 
    public EndController(EndView viewGame, GameController gameController) {
        this.viewGame = viewGame;
        this.gameController = gameController;
        setupListeners();
    }

    private void setupListeners() {
        //Listener for menu button
        viewGame.getMenu().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.handleRestartMainMenu();     //triggers restart
                CardLayout cardLayout = (CardLayout) viewGame.getParent().getLayout();
                cardLayout.show(viewGame.getParent(), "menuPanel");
            }
        });
        //listener for play again button
        viewGame.getPlayAgain().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.handleRestartPlayAgain();    //triggers restart
                CardLayout cardLayout = (CardLayout) viewGame.getParent().getLayout();
                cardLayout.show(viewGame.getParent(), "gamePanel");
            }
        });
    }
}
