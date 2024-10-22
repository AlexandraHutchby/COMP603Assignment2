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

/**
 *
 * @author Alexandra
 */
public class FinalRoundView extends JPanel{
    private JLabel selectCaseLabel;
    private JButton case1;
    private JButton case2;
    private int userCase;
    private int remainingCase;

    public FinalRoundView(Color gold, JPanel mainPanel, CardLayout cardLayout){ 
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        selectCaseLabel = new JLabel("..", SwingConstants.CENTER);
        
        heading(gold);
        
        select(gold);
        
        casesPanel(gold);
    }
    
    private void heading(Color gold){
        
        //Creating heading
        JLabel heading = new JLabel("FINAL ROUND", SwingConstants.CENTER);
        heading.setFont(new Font("Broadway", Font.BOLD, 50));
        heading.setForeground(gold);
       
        
        add(heading, BorderLayout.NORTH);
    }
    
    private void select(Color gold){
        selectCaseLabel.setText("Please select the case you want:");
        selectCaseLabel.setFont(new Font("Arial", Font.PLAIN, 45));
        selectCaseLabel.setForeground(gold);
        add(selectCaseLabel, BorderLayout.CENTER);
    }
    
    private void casesPanel(Color gold){
        //panel for the cases
        JPanel casesPanel = new JPanel();
        casesPanel.setBackground(Color.BLACK);
        casesPanel.setLayout(new GridLayout(1, 2, 10, 10));
        
        //user case button
        case1 = new JButton("Case ");
        case1.setFont(new Font("Arial", Font.PLAIN, 18));
        case1.setForeground(Color.BLACK);
        case1.setBackground(gold);
        case1.setPreferredSize(new Dimension(100, 50));
        casesPanel.add(case1);
        
        
        //remaining case button
        case2 = new JButton("Case " );
        case2.setFont(new Font("Arial", Font.PLAIN, 18));
        case2.setForeground(Color.BLACK);
        case2.setBackground(gold);
        case2.setPreferredSize(new Dimension(100, 50));
        casesPanel.add(case2);
        
        add(casesPanel, BorderLayout.SOUTH);
    }
    
    public JButton getCase1(){
        return this.case1;
    }
    
    public JButton getCase2(){
        return this.case2;
    }

}
