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
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author laina
 */
public class LeaderboardView extends JPanel
{
    private JPanel scoresPanel;
    private Color gold;
    private JButton menu;
    private JButton start;
    public LeaderboardView(Color gold, JPanel mainPanel, CardLayout cardLayout)
    {
        this.gold = gold;
        //Setting background
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        
        //Creating heading
        JLabel header = new JLabel("Leaderboard", SwingConstants.CENTER);
        header.setFont(new Font("Broadway", Font.BOLD, 30));
        header.setForeground(gold);
        add(header, BorderLayout.NORTH);
        
        //Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setLayout(new BorderLayout());
        
        //Start Game button
        start = new JButton("Start Game");
        start.setFont(new Font("Arial", Font.BOLD, 18));
        start.setForeground(Color.BLACK);
        start.setBackground(gold);
        buttonPanel.add(start, BorderLayout.EAST);
        
        //Main Menu Button
        menu = new JButton("Main Menu");
        menu.setFont(new Font("Arial", Font.BOLD, 18));
        menu.setForeground(Color.BLACK);
        menu.setBackground(gold);
        buttonPanel.add(menu, BorderLayout.WEST);
 
        add(buttonPanel, BorderLayout.SOUTH);
        
    }
    
    private void createScores(){
        scoresPanel = new JPanel();
        scoresPanel.setLayout(new BoxLayout(scoresPanel, BoxLayout.Y_AXIS));
        scoresPanel.setBackground(gold);
        add(scoresPanel, BorderLayout.CENTER);
    }
    
    public void updateScores(List<String> scores){
        scoresPanel.removeAll();
        
        for(String score : scores){
            JLabel scoreLabel = new JLabel(score, SwingConstants.CENTER);
            scoreLabel.setForeground(Color.BLACK);
            scoreLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            scoresPanel.add(scoreLabel);
        }
        scoresPanel.revalidate();
        scoresPanel.repaint();
    }
    
    public JButton getMenu(){
        return menu;
    }
    
    public JButton getStart(){
        return start;
    }
}
