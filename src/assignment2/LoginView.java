
package assignment2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * This function builds the login interface providing fields for username and
 * password input, login button and error message.
 *
 * @author Alexandra and Laina
 */
public class LoginView extends JPanel {

    private Color gold; // colour gold for styling

    private JLabel uName = new JLabel("Username: "); //username label
    private JLabel pWord = new JLabel("Password: "); //password label

    private JTextField unInput = new JTextField(10); //username input
    private JTextField pwInput = new JTextField(10); //password input

    private JButton loginButton = new JButton("Log in"); //login button
    private JLabel usernameUsed = new JLabel("Username Used. Please pick a new one"); //label that shows if username is used

    public LoginView(Color gold) {
        this.gold = gold;
        //set background colour
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());

        createHeading(); //create heading
        createLogin(); //create login
    }

    public LoginView() {

    }

    //function that creates heading
    private void createHeading() {
        JLabel header = new JLabel("Login", SwingConstants.CENTER);
        header.setFont(new Font("Broadway", Font.BOLD, 30));
        header.setForeground(gold);
        add(header, BorderLayout.NORTH);
    }

    //function that creates the login
    private void createLogin() {
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

    //returns the username that is in the username input
    public String getUsername() {
        return unInput.getText();
    }

    //returns the password that is the password input
    public String getPassword() {
        return pwInput.getText();
    }

    //returns the login button
    public JButton getLoginButton() {
        return loginButton;
    }

    //if the username is used show the username
    public void addUsernameUsed() {
        usernameUsed.setForeground(gold);
        usernameUsed.setFont(new Font("Arial", Font.BOLD, 36));
        add(usernameUsed, BorderLayout.SOUTH);
        this.repaint();
        this.revalidate();
    }
}
