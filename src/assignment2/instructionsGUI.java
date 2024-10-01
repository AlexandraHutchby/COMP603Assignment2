/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
public class instructionsGUI 
{
    public static void main(String[] args) 
    {
      SwingUtilities.invokeLater(() -> createInstructGUI());  
    }
    public static void createInstructGUI()
    {
        Color gold = new Color(255, 215, 0);
        //Creating frame
        JFrame frame = new JFrame("Instructions");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null); 
        
        //Setting background
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(new BorderLayout());
        
        //Creating heading
        JLabel header = new JLabel("How to play:", SwingConstants.CENTER);
        header.setFont(new Font("Broadway", Font.BOLD, 30));
        header.setForeground(gold);
        panel.add(header, BorderLayout.NORTH);
        
        //Area for instructions
        JTextArea instruct = new JTextArea();
        instruct.setFont(new Font("Ariel", Font.PLAIN, 18));
        instruct.setForeground(gold);
        instruct.setBackground(Color.BLACK);
        instruct.setLineWrap(true);
        instruct.setWrapStyleWord(true);
        instruct.setEditable(false);
                
        //Load in text file
        String instructions = loadInstructionsFromFile("./resources/Instructions.txt");
        instruct.setText(instructions);
        
        //Adding boarder to instructions
        JPanel instructionsPanel = new JPanel();
        instructionsPanel.setLayout(new BorderLayout());
        instructionsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding
        instructionsPanel.setBackground(Color.BLACK);
        
        panel.add(instruct, BorderLayout.CENTER);
        
        //Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        
        JButton start = new JButton("Start Game");
        JButton menu = new JButton("Main Menu");

        start.setFont(new Font("Arial", Font.BOLD, 18));
        start.setForeground(Color.BLACK);
        start.setBackground(gold);
        
        menu.setFont(new Font("Arial", Font.BOLD, 18));
        menu.setForeground(Color.BLACK);
        menu.setBackground(gold);
        
        buttonPanel.add(start);
        buttonPanel.add(menu);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        frame.add(panel);
        frame.setVisible(true);
        
    }
    private static String loadInstructionsFromFile(String filePath) {
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
