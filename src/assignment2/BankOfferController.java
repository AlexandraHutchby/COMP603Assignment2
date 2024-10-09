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
    private double[] remainingValues;
    
    public BankOfferController(BankOfferView view, BankOfferModel model, CasesModel c){
        this.view = view;
        this.model = model;
        this.remainingValues = c.getRemaining();
        setupListeners();
        
        setupOffer();
    }
    
    //update so that view goes to the end page
    private void setupListeners(){
        view.getDeal().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
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
        int offer = model.calculateOffer(remainingValues);
        view.getOfferLabel().setText("$ "+offer);
    }
    
    
}

