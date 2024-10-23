package assignment2;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is responsible for managing the logic and flow of the final round
 * of the game where the player selects between their case and remaining case to
 * determine winnings
 *
 * @author Alexandra and Laina
 */
public class FinalRoundController {

    private FinalRoundView view;
    private EndView endView;
    private int userCase;
    private int remainingCase;
    private CasesModel casesModel;
    private LeaderboardDatabase leaderboardDatabase;

    //Constrtor for components of this class
    public FinalRoundController(FinalRoundView view, EndView endView, CasesModel casesModel, LeaderboardDatabase leaderboardDatabase) {
        this.view = view;
        this.endView = endView;
        this.casesModel = casesModel;
        this.leaderboardDatabase = leaderboardDatabase;
        setupListeners();
    }

    //Sets players seleved case and remining case in final round
    public void setCases(int userCase, int remainingCase) {
        this.userCase = userCase;
        this.remainingCase = remainingCase;
        //updates the labels in the view to display the case numbers
        view.getCase1().setText("Case " + userCase);
        view.getCase2().setText("Case " + remainingCase);
    }

    //sets ups action listeners
    private void setupListeners() {
        //listener for player selected case (case 1)
        view.getCase1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endView.setWinTotal(casesModel.getPrice(userCase));
                leaderboardDatabase.updateScore(casesModel.getPrice(userCase));
                CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
                cardLayout.show(view.getParent(), "endPanel");
            }
        });

        //lister for remaining unopend case(case 2)
        view.getCase2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endView.setWinTotal(casesModel.getPrice(remainingCase));
                leaderboardDatabase.updateScore(casesModel.getPrice(userCase));
                CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
                cardLayout.show(view.getParent(), "endPanel");
            }
        });
    }

    //resets the case numbers to default state.
    void reset() {
        //reset cases to default state
        userCase = -1;
        remainingCase = -1;

        //reset view lables for final cases
        view.getCase1().setText("Case " + userCase);
        view.getCase2().setText("Case " + remainingCase);

        //Reset winning total to zero
        endView.setWinTotal(0);

        //Resetting buttons for final round
        view.getCase1().setEnabled(true);
        view.getCase2().setEnabled(true);
    }
}
