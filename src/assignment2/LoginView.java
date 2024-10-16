/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author laina
 */
public class LoginView extends JFrame
{
    private JPanel userPanel = new JPanel();
    private JLabel uName = new JLabel("Username: ");
    private JLabel pWord = new JLabel("Password: ");
    private JTextField unInput = new JTextField(10);
    private JTextField pwInput = new JTextField(10);
    private JButton loginButton = new JButton("Log in");
    
    public LoginView(Color gold)
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 500);
        
        userPanel.setBackground(Color.BLACK);
        uName.setForeground(gold);
        pWord.setForeground(gold);
        unInput.setForeground(Color.BLACK); 
        pwInput.setForeground(Color.BLACK); 
        loginButton.setForeground(Color.BLACK);
        loginButton.setBackground(gold);
        
        userPanel.add(uName);
        userPanel.add(unInput);
        userPanel.add(pWord);
        userPanel.add(pwInput);
        userPanel.add(loginButton);
        this.add(userPanel);
    }
    
    public String getUsername() 
    {
        return unInput.getText();
    }

    public String getPassword() 
    {
        return pwInput.getText();
    }
    
    public void addLoginListener(ActionListener loginListener) 
    {
        loginButton.addActionListener(loginListener);
    }
}
