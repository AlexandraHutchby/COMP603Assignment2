/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 *
 * @author Alexandra
 */
public class BankOfferView extends JPanel{
    private JLabel bankerOfferLabel;
    
    public BankOfferView(Color gold, JPanel mainPanel, CardLayout cardLayout){ 
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        bankerOfferLabel = new JLabel("..", SwingConstants.CENTER);
        
        heading(gold);
        
        offer(gold);
        
        buttonsPanel();
    }
    
    public void heading(Color gold){
        
        //Creating heading
        JLabel heading = new JLabel("BANKER OFFER", SwingConstants.CENTER);
        heading.setFont(new Font("Broadway", Font.BOLD, 50));
        heading.setForeground(gold);
       
        
        add(heading, BorderLayout.NORTH);
    }
    
    public void offer(Color gold){
        bankerOfferLabel.setText("$ ");
        bankerOfferLabel.setFont(new Font("Arial", Font.PLAIN, 45));
        bankerOfferLabel.setForeground(gold);
        add(bankerOfferLabel, BorderLayout.CENTER);
    }
    
    public void buttonsPanel(){
        //panel for the deal or no deal
        JPanel dealOrNoDeal = new JPanel();
        dealOrNoDeal.setBackground(Color.BLACK);
        dealOrNoDeal.setLayout(new GridLayout(1, 2, 10, 10));
        
        //Deal button
        JButton deal = new JButton("Deal");
        deal.setFont(new Font("Arial", Font.PLAIN, 18));
        deal.setForeground(Color.BLACK);
        deal.setBackground(Color.GREEN);
        deal.setPreferredSize(new Dimension(100, 50));
        dealOrNoDeal.add(deal);
        
        
        //or label
        JLabel or = new JLabel("or");
        or.setFont(new Font("Arial", Font.PLAIN, 18));
        or.setForeground(Color.WHITE);
        or.setBackground(Color.BLACK);
        //dealOrNoDeal.add(or, BorderLayout.CENTER);
        
        //No deal button
        JButton noDeal = new JButton("No Deal");
        noDeal.setFont(new Font("Arial", Font.PLAIN, 18));
        noDeal.setForeground(Color.BLACK);
        noDeal.setBackground(Color.RED);
        noDeal.setPreferredSize(new Dimension(100, 50));
        dealOrNoDeal.add(noDeal);
        
        add(dealOrNoDeal, BorderLayout.SOUTH);
    }
}
