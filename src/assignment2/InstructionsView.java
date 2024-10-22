package assignment2;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 * displays instructions for game and includes navigation buttons
 * @author Alexandra and Laina
 */
public class InstructionsView extends JPanel
{
    //navigation buttons for menu and satarting game
    private JButton menu;
    private JButton start;
    
    //constructor
    public InstructionsView(Color gold)
    {
        //Setting background
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        
        //creating heading and adding instrcutions and buttons
        createHeading(gold);
        addInstructions(gold);
        createButtons(gold);     

    }
    
    //creates heading
    private void createHeading(Color gold){
        //Creating heading
        JLabel header = new JLabel("How to play:", SwingConstants.CENTER);
        header.setFont(new Font("Broadway", Font.BOLD, 30));
        header.setForeground(gold);
        add(header, BorderLayout.NORTH);
    }
    
    //add the instructions text area
    private void addInstructions(Color gold){
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
    }
    
    //creating navigation buttons
    private void createButtons(Color gold){
        //Buttons panel
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
    
    //loading instructions from specified file
    private static String loadInstructionsFromFile(String filePath) 
    {
        StringBuilder instructions = new StringBuilder(); //holds instructions
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                instructions.append(line).append("\n"); // Append each line to the StringBuilder
            }
        } catch (IOException e) {
            e.printStackTrace();    //printing stacktrace if there is an error
            instructions.append("Error loading instructions."); // Show error message if file cannot be read
        }
        return instructions.toString();
    }
    
    //get methods
    public JButton getMenu(){
        return this.menu;
    }
    
    public JButton getStart(){
        return this.start;
    }
}
