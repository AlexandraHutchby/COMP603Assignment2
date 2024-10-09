/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

import java.util.List;

/**
 *
 * @author Alexandra
 */
public class LeaderboardController {
    private LeaderboardDatabase database;
    private LeaderboardView view;
    
    public LeaderboardController(LeaderboardDatabase database, LeaderboardView view){
        this.database = database;
        this.view = view;
    }
    
    public void updateLeaderboard(){
        List<String> topScores = database.getTopScores();
        view.updateScores(topScores);
    }
    
}
