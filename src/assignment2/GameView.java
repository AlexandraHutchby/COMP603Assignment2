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
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Alexandra
 */
public class GameView extends JPanel{
    private ArrayList<JButton> caseButtons;
    private ArrayList<JButton> priceButtons;
    CasesModel c;
    private JLabel remainingCasesLabel;
    private JButton restart;
        
    public GameView(Color gold, JPanel mainPanel, CardLayout cardLayout){
        //setting background
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        
        caseButtons = new ArrayList<>();
        priceButtons = new ArrayList<>();
        
        setupHeader(gold);
        
        setupCasesPanel();
        
        setupPricePanels(gold);
        
        setupBottomPanel(gold);
    }
    
    private void setupHeader(Color gold){
        //header panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.BLACK);
        
        //Creating heading
        JLabel header = new JLabel("Deal or No Deal", SwingConstants.CENTER);
        header.setFont(new Font("Broadway", Font.BOLD, 36));
        header.setForeground(gold);
        headerPanel.add(header, BorderLayout.NORTH);
        
        JLabel round = new JLabel("Round 1", SwingConstants.CENTER);
        round.setFont(new Font("Broadway", Font.BOLD, 24));
        round.setForeground(Color.GRAY);
        headerPanel.add(round, BorderLayout.SOUTH);
        
        add(headerPanel, BorderLayout.NORTH);
    }
    
    private void setupCasesPanel(){
        //Case Panel
        JPanel casesPanel = new JPanel(new GridLayout(7, 4, 10, 10));
        casesPanel.setBackground(Color.BLACK);

        for(int i = 1; i <= 26; i++){
            int index = i;
            JButton cButton = new JButton("Case "+ i);
            cButton.setFont(new Font("Arial", Font.PLAIN, 18));
            cButton.setForeground(Color.BLACK);
            cButton.setBackground(Color.GRAY);
            
            cButton.setPreferredSize(new Dimension(100, 50));
            
            caseButtons.add(cButton);            
            casesPanel.add(cButton);
        }
        add(casesPanel, BorderLayout.CENTER);
    }
    
    private void setupPricePanels(Color gold){
       
        //Amounts Panel left
        JPanel amountPanelLeft = new JPanel(new GridLayout(13, 1, 5, 5));
        amountPanelLeft.setBackground(Color.BLACK);
        
        //Amounts Panel right
        JPanel amountPanelRight = new JPanel(new GridLayout(13, 1, 5, 5));
        amountPanelRight.setBackground(Color.BLACK);
        
        c = new CasesModel();
        double[] amount = c.getAmounts();
       
        for(int i = 0; i < 13; i++){
            JButton price = new JButton("$ "+amount[i]);
            price.setFont(new Font("Arial", Font.PLAIN, 18));
            price.setForeground(Color.BLACK);
            price.setBackground(gold);
            priceButtons.add(price);
            amountPanelLeft.add(price);
        }
        
        for(int i = 13; i < 26; i++){
            JButton price = new JButton("$ "+amount[i]);
            price.setFont(new Font("Arial", Font.PLAIN, 18));
            price.setForeground(Color.BLACK);
            price.setBackground(gold);
            priceButtons.add(price);
            amountPanelRight.add(price);
        }
        
        add(amountPanelLeft, BorderLayout.WEST);
        add(amountPanelRight, BorderLayout.EAST);
    }
    
    private void setupBottomPanel(Color gold){
        //Bottom panel
        JPanel bottom = new JPanel();
        bottom.setBackground(Color.BLACK);
        bottom.setLayout(new BorderLayout());
        
        //cases remaining
        remainingCasesLabel = new JLabel("Cases Remaining ...", SwingConstants.CENTER);
        remainingCasesLabel.setFont(new Font("Broadway", Font.BOLD, 18));
        remainingCasesLabel.setForeground(Color.GRAY);
        bottom.add(remainingCasesLabel, BorderLayout.CENTER);
        
        //Return Button
        restart = new JButton("Main Menu");
        restart.setFont(new Font("Arial", Font.BOLD, 18));
        restart.setForeground(Color.BLACK);
        restart.setBackground(gold);
        bottom.add(restart, BorderLayout.EAST);
        
        
        add(bottom, BorderLayout.SOUTH);
        
    }
    
    public ArrayList<JButton> getCaseButtons(){
        return caseButtons;
    }
    
    public ArrayList<JButton> getPriceButtons(){
        return priceButtons;
    }
    
    public JLabel getRemainingCasesLabel(){
        return remainingCasesLabel;
    }
    
    public JButton getRestartButton(){
        return restart;
    }
}
