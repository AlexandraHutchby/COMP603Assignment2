/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author laina
 */
public class leaderboardPanel extends JPanel
{
    public leaderboardPanel(Color gold, JPanel mainPanel, CardLayout cardLayout)
    {
        //Setting background
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        
        //Creating heading
        JLabel header = new JLabel("Leaderoard", SwingConstants.CENTER);
        header.setFont(new Font("Broadway", Font.BOLD, 30));
        header.setForeground(gold);
        add(header, BorderLayout.NORTH);
        
        //Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setLayout(new BorderLayout());
        
        //Start Game button
        JButton start = new JButton("Start Game");
        start.setFont(new Font("Arial", Font.BOLD, 18));
        start.setForeground(Color.BLACK);
        start.setBackground(gold);
        buttonPanel.add(start, BorderLayout.EAST);
        
        //Main Menu Button
        JButton menu = new JButton("Main Menu");
        menu.setFont(new Font("Arial", Font.BOLD, 18));
        menu.setForeground(Color.BLACK);
        menu.setBackground(gold);
        buttonPanel.add(menu, BorderLayout.WEST);
 
        add(buttonPanel, BorderLayout.SOUTH);
        
        //ActionLister for menu
        menu.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                cardLayout.show(mainPanel, "menuPanel");
            }
        });   
        
        //ActionLister for start game
        /*start.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                cardLayout.show(mainPanel, "menuPanel");
            }
        });*/
    }
}
