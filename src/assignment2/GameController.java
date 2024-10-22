/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Alexandra
 */
public class GameController {

    private CasesModel cases;
    private GameView view;
    private Rounds rounds;
    private BankOfferController bankOfferController;
    private int casesOpenedThisRound = 0;
    Color gold;
    private double[] casesOpened;
    private UserCaseModel userCase;
    private boolean userCasePicked;
    private int casesRemaining;
    private FinalRoundController finalRound;
    private boolean reset = false;
    private double price;

    public GameController(CasesModel cases, GameView view, BankOfferController bankOfferController, Color gold, UserCaseModel userCase, FinalRoundController finalRound) {
        this.cases = cases;
        this.view = view;
        this.gold = gold;
        this.userCase = userCase;
        this.bankOfferController = bankOfferController;
        this.finalRound = finalRound;
        casesOpened = new double[26];
        this.userCasePicked = false;
        casesRemaining = 26;

        this.rounds = new Rounds(26); //26 cases 

        // Update view with initial round and remaining cases
        view.updateRemainingCasesLabel(rounds.getRemainingCasesThisRound());

        //view.getBackToMainMenuButton().addActionListener(e -> resetGame());
        setupListeners();
    }

    private void setupListeners() {
        ArrayList<JButton> caseButtons = view.getCaseButtons();
        ArrayList<JButton> priceButtons = view.getPriceButtons();

        for (int i = 0; i < caseButtons.size(); i++) {
            int caseIndex = i + 1;
            JButton caseButton = caseButtons.get(i);
            setPrice(caseIndex);
            caseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (userCasePicked) {
                        if (caseIndex != userCase.getUserCaseNumber() && casesOpened[caseIndex - 1] != 0) {
                            caseButton.setText("$ " + casesOpened[caseIndex -1]);
                            caseButton.setBackground(Color.DARK_GRAY);
                            caseButton.setForeground(Color.WHITE);

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
                                    bankOffer();
                                }
                                if (casesRemaining == 2) {
                                    goToFinalRound();
                                }

                        }
                    } else {
                        userCase.setUserCase(cases, caseIndex);
                        caseButton.setBackground(Color.WHITE);
                        caseButton.setForeground(Color.BLACK);
                        userCasePicked = true;
                        view.updateRoundLabel(1);
                        view.updateRemainingCasesLabel(rounds.getRemainingCasesThisRound());
                    }

                }
            });
        }

        /*view.getPlayAgainButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleRestartPlayAgain();
            }
        });
        
        view.getBackToMainMenuButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleRestartMainMenu();
            }
        });*/
        view.getPlayAgainButton().addActionListener(e -> handleRestartPlayAgain());
        view.getBackToMainMenuButton().addActionListener(e -> handleRestartMainMenu());
    }
    
    private void setPrice(int caseNum){
        casesOpened[caseNum - 1] = cases.getPrice(caseNum);
    }

    private void goToFinalRound() {
        int userCaseNumber = userCase.getUserCaseNumber();
        int remainingCase = 0;
        for (int i = 0; i < casesOpened.length; i++) {
            if (i != userCaseNumber) {
                if (casesOpened[i] == 0) {
                    remainingCase = i + 1;
                }
            }
        }
        finalRound.setCases(userCaseNumber, remainingCase);
        CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
        cardLayout.show(view.getParent(), "finalRoundPanel");
    }

    void handleRestartPlayAgain() {
        resetGame();

        CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
        cardLayout.show(view.getParent(), "gamePanel");
    }
    
    void handleRestartMainMenu() {
        resetGame();

        CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
        cardLayout.show(view.getParent(), "menuPanel");
    }

    private void resetGame() 
    {
        rounds.reset();         //reseting rounds
        cases.resetCases();     //reseting cases
        //reset any opened cases array
        for(int i = 0; i < casesOpened.length; i++)
        {
            casesOpened[i] = cases.getPrice(i + 1);
            setPrice(i+1);
        }
        
        view.resetGameView();   //reseting game view
        userCase.reset();       //reset usercase
        userCasePicked = false; //usercase not selected
        casesRemaining = 26;
        
        //reseting banker offer contoller
        bankOfferController.reset();
        bankOfferController.updateBankerOffer();
        
        casesOpenedThisRound  = 0;
        
        view.updateRoundLabel("Select your case");
        
        //updating view
        view.updateRemainingCasesLabel(rounds.getRemainingCasesThisRound()); 
        
    }

    private void bankOffer() {
        cases.setPricesRemaining(casesOpened);
        bankOfferController.updateBankerOffer();
        CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
        cardLayout.show(view.getParent(), "bankerOfferPanel");
        if (rounds.nextRound()) {
            view.updateRoundLabel(rounds.getCurrentRound());
            view.updateRemainingCasesLabel(rounds.getRemainingCasesThisRound());
        }
    }
}
