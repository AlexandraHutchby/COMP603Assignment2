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
public class FinalRoundController {
    private FinalRoundView view;
    private EndView endView;
    private int userCase;
    private int remainingCase;
    private CasesModel casesModel;
    private LeaderboardDatabase leaderboardDatabase;
    
    public FinalRoundController(FinalRoundView view, EndView endView, CasesModel casesModel, LeaderboardDatabase leaderboardDatabase){
        this.view = view;
        this.endView = endView;
        this.casesModel = casesModel;
        this.leaderboardDatabase = leaderboardDatabase;
        setupListeners();
    }
    
    public void setCases(int userCase, int remainingCase){
        this.userCase = userCase;
        this.remainingCase = remainingCase;
        view.getCase1().setText("Case " + userCase);
        view.getCase2().setText("Case " + remainingCase);
    }
    
    private void setupListeners(){
        view.getCase1().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                endView.setWinTotal(casesModel.getPrice(userCase));
                leaderboardDatabase.updateScore(casesModel.getPrice(userCase));
                CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
                cardLayout.show(view.getParent(), "endPanel");
            }
        });
        
        view.getCase2().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                endView.setWinTotal(casesModel.getPrice(remainingCase));
                leaderboardDatabase.updateScore(casesModel.getPrice(userCase));
                CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
                cardLayout.show(view.getParent(), "endPanel");
            }
        });
    }

    void reset() 
    {
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
