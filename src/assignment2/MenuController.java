
package assignment2;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This function manages the interaction between the menu view and user actions
 * 
 * @author Alexandra and Laina
 */
public class MenuController {

    private MenuView view;

    public MenuController(MenuView view) {
        this.view = view;

        setupListeners();
    }

    //this function for setting up all action listeners
    private void setupListeners() {
        //Action Listener for how to button
        view.getHowTo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
                cardLayout.show(view.getParent(), "instructionsPanel");

            }
        });

        //Action listener for leaderboard button
        view.getLeaderBoard().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
                cardLayout.show(view.getParent(), "leaderboardPanel");

            }
        });

        //Action listener for start button
        view.getStart().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
                cardLayout.show(view.getParent(), "gamePanel");
            }
        });
    }
}
