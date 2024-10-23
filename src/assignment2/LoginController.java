
package assignment2;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This function facilitates the login and registration process by connecting
 * the user interface to the database It handles user actions, validates
 * credentials, inserts new users into the database, and updates the
 * leaderboard, ensuring that users can log in or register easily.
 *
 * @author Alexandra and Laina
 */
public class LoginController {

    private LoginDatabase database;
    private LoginView view;
    private LeaderboardDatabase leaderboardDatabase;

    public LoginController(LoginDatabase database, LoginView view, LeaderboardDatabase leaderboardDatabase) {
        this.view = view;
        this.database = database;
        this.leaderboardDatabase = leaderboardDatabase;

        setupListeners(); //set up listeners
    }

    private void setupListeners() {
        //action listener for login button
        view.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = view.getUsername(); //username from the login page
                String password = view.getPassword(); //password from login page

                if (!database.checkUsername(username)) { //if username is not in the database
                    database.insertUsername(username, password); //add the username to the database
                    leaderboardDatabase.setCurrentUsername(username);
                    leaderboardDatabase.insertScoresInLeaderboard(username); //insert the new user into the leaderboard
                    CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
                    cardLayout.show(view.getParent(), "instructionsPanel"); //if a new user then send to the instructions panel
                    database.closeDatabase();
                } else if (database.checkUsernameAndPassword(username, password)) { //of the username and password is correct
                    leaderboardDatabase.setCurrentUsername(username);
                    database.closeDatabase();
                    CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
                    cardLayout.show(view.getParent(), "menuPanel");
                } else { //if username is correct but password is not the same
                    view.addUsernameUsed(); //show the username has been used
                }
            }
        });
    }
}
