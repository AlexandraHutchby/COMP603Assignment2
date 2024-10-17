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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author laina
 */
public class LoginView extends JPanel
{
    private Color gold;
    
    private JPanel userPanel = new JPanel();
    private JLabel uName = new JLabel("Username: ");
    private JLabel pWord = new JLabel("Password: ");
    
    private JTextField unInput = new JTextField(10);
    private JTextField pwInput = new JTextField(10);
    
    private JButton loginButton = new JButton("Log in");
    private JLabel usernameUsed = new JLabel("Username Used. Please pick a new one");
    
    public LoginView(Color gold, JPanel mainPanel, CardLayout cardLayout)
    {
        this.gold = gold;
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        
        createHeading();
        createLogin();
    }
    
    public LoginView(){
        
    }
    
    private void createHeading(){
        JLabel header = new JLabel("Login", SwingConstants.CENTER);
        header.setFont(new Font("Broadway", Font.BOLD, 30));
        header.setForeground(gold);
        add(header, BorderLayout.NORTH);
    }
    
    private void createLogin(){
        JPanel login = new JPanel();
        login.setBackground(Color.BLACK);
        
        uName.setForeground(gold);
        pWord.setForeground(gold);
        
        unInput.setForeground(Color.BLACK); 
        pwInput.setForeground(Color.BLACK);
        
        loginButton.setForeground(Color.BLACK);
        loginButton.setBackground(gold);
        
        login.add(uName);
        login.add(unInput);
        login.add(pWord);
        login.add(pwInput);
        login.add(loginButton);
        this.add(login, BorderLayout.CENTER);
    }
    
    public String getUsername() 
    {
        return unInput.getText();
    }

    public String getPassword() 
    {
        return pwInput.getText();
    }
    
    public JButton getLoginButton(){
        return loginButton;
    }
    
    public void addLoginListener(ActionListener loginListener) 
    {
        loginButton.addActionListener(loginListener);
    }
    
    public void addUsernameUsed(){
        usernameUsed.setForeground(gold);
        add(usernameUsed, BorderLayout.SOUTH);
        this.repaint();
        this.revalidate();
    }
}
