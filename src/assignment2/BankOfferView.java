
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

/**
 * This represents the view for the banker offer screen in the game
 * It displays the bankers offer and provides buttons for the player
 * to accept or decline. 
 * @author Alexandra + Laina
 */
public class BankOfferView extends JPanel{
    private JLabel bankerOfferLabel;
    private JButton deal;
    private JButton noDeal;
    
    //Constructor to set up the view 
    public BankOfferView(Color gold){ 
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        bankerOfferLabel = new JLabel("..", SwingConstants.CENTER);
        heading(gold);
        offer(gold);
        buttonsPanel();
    }
    
    //Creates and adds the heading label to view
    public void heading(Color gold){
        
        //Creating heading
        JLabel heading = new JLabel("BANKER OFFER", SwingConstants.CENTER);
        heading.setFont(new Font("Broadway", Font.BOLD, 50));
        heading.setForeground(gold);
       
        add(heading, BorderLayout.NORTH);
    }
    
    //Sets up bankers offer label in the center of view
    public void offer(Color gold){
        bankerOfferLabel.setText("$ ");
        bankerOfferLabel.setFont(new Font("Arial", Font.PLAIN, 45));
        bankerOfferLabel.setForeground(gold);
        add(bankerOfferLabel, BorderLayout.CENTER);
    }
    
    //Sets up button panel with deal or no deal buttons, uses grid layout
    public void buttonsPanel(){
        //panel for the deal or no deal
        JPanel dealOrNoDeal = new JPanel();
        dealOrNoDeal.setBackground(Color.BLACK);
        dealOrNoDeal.setLayout(new GridLayout(1, 2, 10, 10));
        
        //Deal button
        deal = new JButton("Deal");
        deal.setFont(new Font("Arial", Font.PLAIN, 18));
        deal.setForeground(Color.BLACK);
        deal.setBackground(Color.GREEN);
        deal.setPreferredSize(new Dimension(100, 50));
        dealOrNoDeal.add(deal);
        
        //No deal button
        noDeal = new JButton("No Deal");
        noDeal.setFont(new Font("Arial", Font.PLAIN, 18));
        noDeal.setForeground(Color.BLACK);
        noDeal.setBackground(Color.RED);
        noDeal.setPreferredSize(new Dimension(100, 50));
        dealOrNoDeal.add(noDeal);
        
        add(dealOrNoDeal, BorderLayout.SOUTH);
    }
    
    //get functions for returning buttons interacting with controller
    public JButton getDeal(){
        return deal;
    }
    
    public JButton getNoDeal(){
        return noDeal;
    }
    
    //returns label used to display bankers offer
    public JLabel getOfferLabel(){
        return bankerOfferLabel;
    }
}
