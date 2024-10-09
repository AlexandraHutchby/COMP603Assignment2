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
    
    public BankOfferController(BankOfferView view, BankOfferModel model){
        this.view = view;
        this.model = model;
        setupListeners();
    }
    
    //update so that view goes to the end page
    private void setupListeners(){
        view.getDeal().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
                cardLayout.show(view.getParent(), "menuPanel");
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
}
