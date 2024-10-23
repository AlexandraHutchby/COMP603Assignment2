
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
 *This function encapsulates the logic for managing leaderboard data including user score
 * insertion, updating and retrieving scores.
 * @author Alexandra and Laina
 */
public class LeaderboardDatabase {

    private final String USER_NAME = "COMP603Group10"; //username for database connection
    private final String PASSWORD = "group10"; //password for database connection
    private final String dbURL = "jdbc:derby://localhost:1527/LeaderboardDB; create =true"; //url for database connection
    
    private Connection conn; //represents the connection to the database
    private Statement statement; //used to execute the SQL queries
    private PreparedStatement preparedStatement; //executes parameterised queries
    private ResultSet resultSet; //holds the data returned from a SQL query
    private String currentUsername; //stores the current user's username

    //initialises the database leaderboard
    public LeaderboardDatabase() {
        connectToDatabase(); //connects to the database
        createLeaderboardTable(); //creates teh leaderboard if not already made
        insertScoresInLeaderboard(currentUsername);
        retrieveLeaderboard(); //get the leaderboard
    }

    //this function connects to the database
    private void connectToDatabase() {
        try {
            conn = DriverManager.getConnection(dbURL, USER_NAME, PASSWORD);
            conn.setAutoCommit(true);
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            System.out.println("SQLException in Leaderboard Database");
        }
    }
    
    //this function closes the database
    public void closeDatabase() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("SQLException 2 in Leaderboard Database");
        }
    }

    //this function creates the leaderboard table
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
            System.out.println("Leaderboard table already exists");
        }
    }

    //this function inserts a new user into the leaderboard by making the score 0
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

    //this function updates the score if the new score is bigger than the current score
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

    //this function gets the current score of the user
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

    //this function retrieves the leaderboard
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

    //this function returns the top 10 scores to show in the leaderboard
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
    
    //this function returns the current username
    public void setCurrentUsername(String username){
        currentUsername = username;
    }
}
