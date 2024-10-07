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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Alexandra
 */
public class gamePanel extends JPanel{
    public gamePanel(Color gold, JPanel mainPanel, CardLayout cardLayout){
        //setting background
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        
        //header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.BLACK);
        headerPanel.setLayout(new BorderLayout());
        
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
        
        //Case Panel
        JPanel casesPanel = new JPanel();
        casesPanel.setBackground(Color.BLACK);
        casesPanel.setLayout(new GridLayout(7, 4, 10, 10));
        
        ArrayList<JButton> cases = new ArrayList<>();
        
        for(int i = 1; i <= 26; i++){
            JButton cButton = new JButton("Case "+ i);
            cButton.setFont(new Font("Arial", Font.PLAIN, 18));
            cButton.setForeground(Color.BLACK);
            cButton.setBackground(Color.GRAY);
            
            cButton.setPreferredSize(new Dimension(100, 50));
            
            cButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    cButton.setText("$..");
                }
            });            
            cases.add(cButton);
        }
        
        for(JButton caseButton : cases){
            casesPanel.add(caseButton);
        }

        add(casesPanel, BorderLayout.CENTER);
        
        //Amounts Panel left
        JPanel amountPanelLeft = new JPanel();
        amountPanelLeft.setBackground(gold);
        amountPanelLeft.setLayout(new GridLayout(13, 1, 0, 0));
        
        //Amounts Panel right
        JPanel amountPanelRight = new JPanel();
        amountPanelRight.setBackground(Color.BLACK);
        amountPanelRight.setLayout(new GridLayout(13, 1, 0, 0));
        
        double[] amount = {0.01, 1, 5, 10, 25, 50, 75, 100, 200, 300, 400, 500, 750, 1000, 5000, 10000, 25000, 50000, 75000, 100000, 200000, 300000, 400000, 500000, 750000, 1000000};
        
        for(int i = 0; i < amount.length/2; i++){
            JButton price = new JButton("$ "+amount[i]);
            price.setFont(new Font("Arial", Font.PLAIN, 18));
            price.setForeground(Color.BLACK);
            price.setBackground(gold);
            amountPanelLeft.add(price);
        }
        
        for(int i = amount.length/2; i < amount.length; i++){
            JButton price = new JButton("$ "+amount[i]);
            price.setFont(new Font("Arial", Font.PLAIN, 18));
            price.setForeground(Color.BLACK);
            price.setBackground(gold);
            amountPanelRight.add(price);
        }
        
        add(amountPanelLeft, BorderLayout.WEST);
        add(amountPanelRight, BorderLayout.EAST);
        
        //Bottom panel
        JPanel bottom = new JPanel();
        bottom.setBackground(Color.BLACK);
        bottom.setLayout(new BorderLayout());
        
        //cases remaining
        JLabel remaining = new JLabel("Cases Remaining ...");
        remaining.setFont(new Font("Broadway", Font.BOLD, 18));
        remaining.setForeground(Color.GRAY);
        bottom.add(remaining, BorderLayout.CENTER);
        
        //Return Button
        JButton restart = new JButton("Main Menu");
        restart.setFont(new Font("Arial", Font.BOLD, 18));
        restart.setForeground(Color.BLACK);
        restart.setBackground(gold);
        bottom.add(restart, BorderLayout.EAST);
        
        add(bottom, BorderLayout.SOUTH);
        
        //Action Listener for returning to menu
        restart.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e){
                cardLayout.show(mainPanel, "menuPanel");
            }
        });
    }
}
