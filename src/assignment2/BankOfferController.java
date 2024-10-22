package assignment2;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is the controller for handling interactions between BankOfferView,
 * BankOfferModel and other components of the game. It manages the bankers offer
 * and sets up actions for the Deal and no deal buttons that determine what
 * happens when the player accepts or rejects offer It also connects to leader
 * board to update player score if deal is accepted
 *
 * @author Alexandra + Laina
 */
public class BankOfferController {

    private BankOfferView view;
    private BankOfferModel model;
    private CasesModel casesModel;
    private EndView endView;
    private LeaderboardDatabase leaderboardDatabase;
    private double[] remainingValues;       //Array of remaining values in the game
    private int offer;                      //Current offer made at bank

    //Constructor inistilising componets
    public BankOfferController(BankOfferView view, BankOfferModel model, CasesModel casesModel, EndView endView, LeaderboardDatabase leaderboardDatabase) {
        this.view = view;
        this.model = model;
        this.casesModel = casesModel;
        this.remainingValues = casesModel.getRemaining(); //Getting remiaing case values
        this.endView = endView;
        this.leaderboardDatabase = leaderboardDatabase;

        //Action listeerns for deal/Nodela buttons and claulating inital offer
        setupListeners();
        setupOffer();
    }

    //Ading action listeners to the deal or no deal buttons
    private void setupListeners() {
        //player choses deal, goes to end view and updates score
        view.getDeal().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endView.setWinTotal(offer);
                leaderboardDatabase.updateScore(offer);
                CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
                cardLayout.show(view.getParent(), "endPanel");
            }
        });
        //player chooses no deal, returns to game panel
        view.getNoDeal().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
                cardLayout.show(view.getParent(), "gamePanel");
            }
        });
    }

    //updates bankers offer each round
    public void updateBankerOffer() {
        setupOffer();
    }

    //calculates the current bank offer and updates the label
    private void setupOffer() {
        offer = model.calculateOffer(remainingValues);
        view.getOfferLabel().setText("$ " + offer);
    }

    //resets controllers state when game is restarted
    public void reset() {
        remainingValues = casesModel.getRemaining(); // Fetch the latest remaining values after reset
        setupOffer();
        //reset label and buttons
        view.getOfferLabel().setText("$ " + offer);
        view.getDeal().setEnabled(true);
        view.getNoDeal().setEnabled(true);
    }
}
