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
public class BankOfferController {
    private BankOfferView view;
    private BankOfferModel model;
    private CasesModel casesModel;
    private double[] remainingValues;
    private int offer;
    private EndView endView;
    private LeaderboardDatabase leaderboardDatabase;
    
    public BankOfferController(BankOfferView view, BankOfferModel model, CasesModel casesModel, EndView endView, LeaderboardDatabase leaderboardDatabase)
    {
        this.view = view;
        this.model = model;
        this.casesModel = casesModel;
        this.remainingValues = casesModel.getRemaining();
        this.endView = endView;
        this.leaderboardDatabase = leaderboardDatabase;
        
        setupListeners();
        setupOffer();
    }
    
    //update so that view goes to the end page
    private void setupListeners(){
        view.getDeal().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                endView.setWinTotal(offer);
                leaderboardDatabase.updateScore(offer);
                CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
                cardLayout.show(view.getParent(), "endPanel");
            }
        });
        
        view.getNoDeal().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
               
                CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
                cardLayout.show(view.getParent(), "gamePanel");
            }
        });
    }
    
    public void updateBankerOffer(){
        setupOffer();
    }
    
    private void setupOffer(){
        offer = model.calculateOffer(remainingValues);
        view.getOfferLabel().setText("$ "+offer);
    }

    public void reset() 
    {
        remainingValues = casesModel.getRemaining(); // Fetch the latest remaining values after reset
        setupOffer();
        //reset label and buttons
        view.getOfferLabel().setText("$ " + offer);
        view.getDeal().setEnabled(true); 
        view.getNoDeal().setEnabled(true);
    }
    
    
}

