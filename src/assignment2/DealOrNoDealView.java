/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Alexandra
 */
public class DealOrNoDealView extends JFrame{
    private JPanel openingScreen = new JPanel();
    private JPanel gameScreen = new JPanel();
    
    private JLabel title = new JLabel("Deal or No Deal");
    private JButton startButton = new JButton("Start");
    
    
    private void setUpCases(){
        gameScreen.setLayout(new GridLayout(5, 5));
        
        Case c = new Case();
        Set<Integer> caseNumbers = c.cases.keySet();
        JButton[]  caseButtons = new JButton[caseNumbers.size()];
        
        int index = 0;
        for(int caseNumber : caseNumbers){
            caseButtons[index] = new JButton("Case "+caseNumber);
            final int buttonIndex = index;
            final int caseNum = caseNumber;
            caseButtons[index].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    handleCaseSelection(buttonIndex, caseNum);
                }
            });
        }
        
        
    }
    
    private void handleCaseSelection(int buttonIndex, int caseNumber){
            buttonIndex = caseNumber;
    }
}
