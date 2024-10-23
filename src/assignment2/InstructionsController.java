package assignment2;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * manages the interaction between the instruction view and game panels
 * it handles user actions in the instructions view and switches between 
 * different panels
 * @author Alexandra and Laina
 */
public class InstructionsController {

    private InstructionsView view;

    //constructor to initizlise the view nad setip listeenrs
    public InstructionsController(InstructionsView view) {
        this.view = view;
        setupListeners();
    }

    private void setupListeners() {
        //action listener for menu button
        view.getMenu().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
                cardLayout.show(view.getParent(), "menuPanel");
            }
        });
        //ActionLister for start game
        view.getStart().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
                cardLayout.show(view.getParent(), "gamePanel");
            }
        });
    }
}
