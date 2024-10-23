package assignment2;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 * This class handles the game logic it manages cases, user interactions, rounds
 * and transitions between frames
 *
 * @author Alexandra and Laina
 */
public class GameController {

    private CasesModel cases;
    private GameView view;
    private Rounds rounds;
    private BankOfferController bankOfferController;
    private FinalRoundController finalRound;
    private UserCaseModel userCase;

    private int casesOpenedThisRound = 0;   //Tracks number of cases opened in rund
    Color gold;                             //Colour used for UI elements
    private double[] casesOpened;           //tracks prices of opened cases
    private boolean userCasePicked;         //indicates if user has picked their case
    private int casesRemaining;             //tracks number of remaining cases
    private boolean reset = false;          //flag for resetting game
    private double price;                   //represents current price

    //construtor for class
    public GameController(CasesModel cases, GameView view, BankOfferController bankOfferController, Color gold, UserCaseModel userCase, FinalRoundController finalRound) {
        this.cases = cases;
        this.view = view;
        this.gold = gold;
        this.userCase = userCase;
        this.bankOfferController = bankOfferController;
        this.finalRound = finalRound;

        casesOpened = new double[26]; //array for prices of cases
        this.userCasePicked = false;   //initally, user case is not picked
        casesRemaining = 26;           //all cases are remiaing at the start
        this.rounds = new Rounds(26); //initilize rounds 26 cases 

        // Update view with initial round and remaining cases
        view.updateRemainingCasesLabel(rounds.getRemainingCasesThisRound());

        setupListeners();
    }

    private void setupListeners() {
        ArrayList<JButton> caseButtons = view.getCaseButtons(); //get case buttons from view
        ArrayList<JButton> priceButtons = view.getPriceButtons();   //get price buttons from view

        //add action listenr for each case button
        for (int i = 0; i < caseButtons.size(); i++) {
            int caseIndex = i + 1;
            JButton caseButton = caseButtons.get(i);
            setPrice(caseIndex);        //setting price for current case
            caseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (userCasePicked) {   //if user has already picked case
                        if (caseIndex != userCase.getUserCaseNumber() && casesOpened[caseIndex - 1] != 0) {
                            //updating UI for opened case
                            caseButton.setText("$ " + casesOpened[caseIndex - 1]);
                            caseButton.setBackground(Color.DARK_GRAY);
                            caseButton.setForeground(Color.WHITE);

                            //update corresponding price button to indicate opening
                            for (JButton priceButton : priceButtons) {
                                if (priceButton.getText().equals("$ " + casesOpened[caseIndex - 1])) {
                                    priceButton.setBackground(Color.BLACK);
                                    priceButton.setForeground(Color.GRAY);
                                }
                            }
                            casesOpened[caseIndex - 1] = 0;
                            //Open the case in current round andupdate the cases remaing label
                            rounds.updateRemainingCases();
                            int remainingCases = rounds.getRemainingCasesThisRound();
                            view.updateRemainingCasesLabel(rounds.getRemainingCasesThisRound());
                            casesRemaining--;

                            //checking if round is over and moving on to next
                            if (remainingCases == 0) {
                                bankOffer();    //triggers bank offer if all cases are opened in round
                            }
                            if (casesRemaining == 2) {
                                goToFinalRound();   //move to final round if two cases left
                            }

                        }
                    } else {    //if user has not picked case
                        userCase.setUserCase(cases, caseIndex);     //settting users case
                        caseButton.setBackground(Color.WHITE);
                        caseButton.setForeground(Color.BLACK);
                        userCasePicked = true;                      //usercasepicked flag is true
                        view.updateRoundLabel(1);                   //update round label
                        view.updateRemainingCasesLabel(rounds.getRemainingCasesThisRound());
                    }

                }
            });
        }
        //listenr for play again and main menu buttons
        view.getPlayAgainButton().addActionListener(e -> handleRestartPlayAgain());
        view.getBackToMainMenuButton().addActionListener(e -> handleRestartMainMenu());
    }

    private void setPrice(int caseNum) {
        casesOpened[caseNum - 1] = cases.getPrice(caseNum); //storing price of case
    }

    //going to final round
    private void goToFinalRound() {
        int userCaseNumber = userCase.getUserCaseNumber();  //holds user case number
        int remainingCase = 0;      //holds remaing case number
        //finds remaing case that has not been opened
        for (int i = 0; i < casesOpened.length; i++) {
            if (i != (userCaseNumber-1)) {
                if (casesOpened[i] != 0) {
                    System.out.println(i);
                    System.out.println(userCaseNumber);
                    remainingCase = i + 1;
                }
            }
        }
        //set cases for final round contoler and goes to final round panel
        finalRound.setCases(userCaseNumber, remainingCase);
        CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
        cardLayout.show(view.getParent(), "finalRoundPanel");
    }

    void handleRestartPlayAgain() {
        resetGame();    //restart game state
        //switches to game panel
        CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
        cardLayout.show(view.getParent(), "gamePanel");
    }

    void handleRestartMainMenu() {
        resetGame();    //restarts game state
        //goes to menu panel
        CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
        cardLayout.show(view.getParent(), "menuPanel");
    }

    //reset game
    private void resetGame() {
        rounds.reset();         //reseting rounds
        cases.resetCases();     //reseting cases
        //reset any opened cases array
        for (int i = 0; i < casesOpened.length; i++) {
            casesOpened[i] = cases.getPrice(i + 1);
            setPrice(i + 1);
        }

        view.resetGameView();   //reseting game view
        userCase.reset();       //reset usercase
        userCasePicked = false; //usercase not selected
        casesRemaining = 26;

        //reseting banker offer contoller
        bankOfferController.reset();
        bankOfferController.updateBankerOffer();

        casesOpenedThisRound = 0;

        view.updateRoundLabel("Select your case");

        //updating view
        view.updateRemainingCasesLabel(rounds.getRemainingCasesThisRound());

    }

    //bank offer
    private void bankOffer() {
        cases.setPricesRemaining(casesOpened);  //set remiing case prices for bank
        bankOfferController.updateBankerOffer();    //updates bank offer based on reaminig cases
        CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
        cardLayout.show(view.getParent(), "bankerOfferPanel");  //shows bank offer panel

        //checks if we should advance to next round
        if (rounds.nextRound()) {
            view.updateRoundLabel(rounds.getCurrentRound());
            view.updateRemainingCasesLabel(rounds.getRemainingCasesThisRound());
        }
    }
}
