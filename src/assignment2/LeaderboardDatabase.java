/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexandra
 */
public class LeaderboardDatabase {

    private final String USER_NAME = "COMP603Group10";
    private final String PASSWORD = "group10";
    private final String dbURL = "jdbc:derby://localhost:1527/LeaderboardDB; create =true";
    private Connection conn;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String currentUsername;

    public LeaderboardDatabase() {
        connectToDatabase();
        createLeaderboardTable();
        insertScoresInLeaderboard(currentUsername);
        retrieveLeaderboard();
    }

    private void connectToDatabase() {
        try {
            conn = DriverManager.getConnection(dbURL, USER_NAME, PASSWORD);
            conn.setAutoCommit(true);
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            System.out.println("SQLException in Leaderboard Database");
        }
    }

    public void closeDatabase() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("SQLException 2 in Leaderboard Database");
        }
    }

    private void createLeaderboardTable() {
        try {
            if (conn == null) {
                connectToDatabase();
            }

            this.statement = conn.createStatement();

            String createTableSQL = "CREATE TABLE leaderboard ("
                    + "username VARCHAR(255) NOT NULL, "
                    + "score DOUBLE NOT NULL)";

            statement.execute(createTableSQL);

            System.out.println("Leaderboard table created");
        } catch (SQLException e) {
            System.out.println("SQLException in create table");
        }
    }

    public void insertScoresInLeaderboard(String username) {
        try {
            if (conn == null) {
                connectToDatabase();
            }

            String insertSQL = "INSERT INTO leaderboard (username, score) VALUES (?, ?)";
            this.preparedStatement = conn.prepareStatement(insertSQL);
            preparedStatement.setString(1, username);
            preparedStatement.setDouble(2, 0.0);

            preparedStatement.executeUpdate();
            System.out.println("A new score has been added");

        } catch (SQLException e) {
            System.out.println("SQLException in insert scores in leaderboard");
        }
    }

    public void updateScore(double newscore) {
        try {
            if (conn == null) {
                connectToDatabase();
            }
            if (currentScore() < newscore) {
                String updateSQL = "UPDATE leaderboard SET score = ? WHERE username = ?";
                this.preparedStatement = conn.prepareStatement(updateSQL);
                preparedStatement.setDouble(1, newscore);
                preparedStatement.setString(2, currentUsername);
                
                preparedStatement.executeUpdate();
                System.out.println("Score updated");
            }
        } catch (SQLException e) {
            System.out.println("SQLException in updateScore");
        }
    }

    private double currentScore() {
        double currentScore = -1;
        try {
            if (conn == null) {
                connectToDatabase();
            }
            String query = "SELECT score FROM leaderboard WHERE username = ?";
            this.preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, currentUsername);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                currentScore = resultSet.getDouble("score");
            }
        } catch (SQLException e) {
            System.out.println("SQLException in currentScore");
        }
        return currentScore;
    }

    private void retrieveLeaderboard() {
        try {
            if (conn == null) {
                connectToDatabase();
            }

            String query = "SELECT * FROM leaderboard ORDER BY score DESC";
            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                double score = resultSet.getDouble("score");
            }
        } catch (SQLException e) {
            System.out.println("SQLException in retrieve leaderboard");
        }
    }

    public List<String> getTopScores() {
        List<String> scores = new ArrayList<>();
        String query = "SELECT username, score FROM leaderboard ORDER BY score DESC FETCH FIRST 10 ROWS ONLY";

        try {
            if (conn == null) {
                connectToDatabase();
            }
            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                double score = resultSet.getDouble("score");
                scores.add(username + "," + score);
            }
        } catch (SQLException e) {
            System.out.println("SQLException in get top scores");
        }
        return scores;
    }
    
    public void setCurrentUsername(String username){
        currentUsername = username;
    }
}
