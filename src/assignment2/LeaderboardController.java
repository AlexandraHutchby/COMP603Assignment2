
package assignment2;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author Alexandra and Laina
 */
public class LeaderboardController {
    private LeaderboardDatabase database;
    private LeaderboardView view;
    
    public LeaderboardController(LeaderboardDatabase database, LeaderboardView view){
        this.database = database;
        this.view = view;
        setupListeners(); //set up all listeners
        updateLeaderboard(); //creates the leaderboard
        
    }
    
    //retrieves the top scores from the database and updates the view in view
    private void updateLeaderboard(){
        List<String> topScores = database.getTopScores();
        view.updateScores(topScores);
    }
    
    //this function sets up all listeners
    private void setupListeners(){
        //menu listener
        view.getMenu().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                database.closeDatabase(); //close database
                CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
                cardLayout.show(view.getParent(), "menuPanel"); //switch to main view
            }
        });
        //start listener
        view.getStart().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                database.closeDatabase(); //close database
                CardLayout cardLayout = (CardLayout) view.getParent().getLayout();
                cardLayout.show(view.getParent(), "gamePanel"); //go to game view
            }
        });
    }
    
}
