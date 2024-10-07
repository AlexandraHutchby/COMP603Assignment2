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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 *
 * @author laina
 */
public class InstructionsView extends JPanel
{
    public InstructionsView(Color gold, JPanel mainPanel, CardLayout cardLayout)
    {
        //Setting background
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        
        //Creating heading
        JLabel header = new JLabel("How to play:", SwingConstants.CENTER);
        header.setFont(new Font("Broadway", Font.BOLD, 30));
        header.setForeground(gold);
        add(header, BorderLayout.NORTH);
        
        //Area for instructions
        JTextArea howTo = new JTextArea();
        howTo.setFont(new Font("Ariel", Font.PLAIN, 18));
        howTo.setForeground(gold);
        howTo.setBackground(Color.BLACK);
        howTo.setLineWrap(true);
        howTo.setWrapStyleWord(true);
        howTo.setEditable(false);
                
        //Load in text file
        String instructions = loadInstructionsFromFile("./resources/Instructions.txt");
        howTo.setText(instructions);
        add(howTo, BorderLayout.CENTER);
        
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

        //ActionLister for menu button
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
    private static String loadInstructionsFromFile(String filePath) 
    {
        StringBuilder instructions = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                instructions.append(line).append("\n"); // Append each line to the StringBuilder
            }
        } catch (IOException e) {
            e.printStackTrace();
            instructions.append("Error loading instructions."); // Show error message if file cannot be read
        }
        return instructions.toString();
    }
}
