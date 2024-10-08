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

/**
 *
 * @author Alexandra
 */
public class GameController {
    private CasesModel cases;
    private GameView view;
    private Rounds rounds;
    private int casesOpenedThisRound = 0;
    Color gold;
    
    public GameController(CasesModel cases, GameView view, Color gold){
        this.cases = cases;
        this.view = view;
        this.gold = gold;
        
        this.rounds = new Rounds(26); //26 cases 
        
        // Update view with initial round and remaining cases
        view.updateRoundLabel(rounds.getCurrentRound());
        view.updateRemainingCasesLabel(rounds.getRemainingCasesThisRound());
        
        setupListeners();
    }
    
    private void setupListeners(){
        ArrayList<JButton> caseButtons = view.getCaseButtons();
        ArrayList<JButton> priceButtons = view.getPriceButtons();
        
        for(int i = 0; i < caseButtons.size(); i++){
            int caseIndex = i+1;
            JButton caseButton = caseButtons.get(i);
            caseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    double price = cases.getPrice(caseIndex);
                    caseButton.setText("$ "+ price);
                    
                    for(JButton priceButton : priceButtons){
                        if(priceButton.getText().equals("$ "+price)){
                            priceButton.setBackground(Color.BLACK);
                            priceButton.setForeground(Color.GRAY);
                        }
                    }
                    
                    //view.getRemainingCasesLabel().setText("Cases Remaining "+1);
                    
                    //Open the case in current round andupdate the cases remaing label
                    rounds.updateRemainingCases();
                    int remainingCases = rounds.getRemainingCasesThisRound();
                    view.updateRemainingCasesLabel(rounds.getRemainingCasesThisRound());
                    
                    //checking if round is over and moving on to next
                    if(remainingCases == 0)
                    {
                        if(rounds.nextRound())
                        {
                            view.updateRoundLabel(rounds.getCurrentRound());
                            view.updateRemainingCasesLabel(rounds.getRemainingCasesThisRound());
                        }
                    }
                }
            });
        }
        
        view.getRestartButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                handleRestart();
            }
        });
    }
    
    private void handleRestart(){
        resetGame();
        
        CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
        cardLayout.show(view.getParent(), "menuPanel");
    }
    
    private void resetGame(){
        // Reset the rounds object to start from the first round
        this.rounds = new Rounds(26); // Reset rounds for new game
        //casesOpenedThisRound = 0; // Reset case tracking

        // Reset view labels for the new game
        view.updateRoundLabel(rounds.getCurrentRound()); // Reset round label to the first round
        view.updateRemainingCasesLabel(rounds.getRemainingCasesThisRound()); // Reset cases remaining label
        
        ArrayList<JButton> caseButtons = view.getCaseButtons();
        ArrayList<JButton> priceButtons = view.getPriceButtons();
        
        int index = 1;
        for(JButton cases : caseButtons){
            cases.setBackground(Color.GRAY);
            cases.setForeground(Color.BLACK);
            cases.setText("Case "+ index);
            index++;
        }
        
        for(JButton prices : priceButtons){
            prices.setBackground(gold);
            prices.setForeground(Color.BLACK);
        }

    }
}