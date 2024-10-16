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
    private String dbURL = "jdbc:derby:leaderboardDB;create=true";
    private Connection conn;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
    private void connectToDatabase(){
        try{
            conn = DriverManager.getConnection(dbURL);
            if(conn != null){
                System.out.println("Connected to the database");
            }
        }catch(SQLException e){
            System.out.println("SQLException in Leaderboard Database");
        }finally{
            try{
                if(conn != null){
                    conn.close();
                }
            }catch(SQLException e){
                System.out.println("SQLException 2 in Leaderboard Database");
            }
        }
    }
    
    private void createLeaderboardTable(){
        try{
            conn = DriverManager.getConnection(dbURL);
            statement = conn.createStatement();
            String createTableSQL = "CREATE TABLE leaderboard ("
                    + "id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, "
                    + "username VARCHAR(255) NOT NULL, "
                    + "score INT NOT NULL)";
            statement.execute(createTableSQL);
            
            System.out.println("Leaderboard table created");
        }catch(SQLException e){
            System.out.println("SQLException in create table");
        }finally{
            try{
                if(statement != null){
                    statement.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch(SQLException e){
                System.out.println("SQLException 2 in create table");
            }
        }
    }
    
    private void insertScoresInLeaderboard(){
        try{
            conn = DriverManager.getConnection(dbURL);
            
            String insertSQL = "INSERT INTO leaderboard (username, score) VALUES (?, ?, ?)";
            preparedStatement = conn.prepareStatement(insertSQL);
            preparedStatement.setString(1, "HERE");
            preparedStatement.setDouble(2, 0);
            
            int rows = preparedStatement.executeUpdate();
            if(rows > 0){
                System.out.println("A new score was inserted");
            }
        }catch(SQLException e){
            System.out.println("SQLException in insert scores in leaderboard");
        }finally{
            try{
                if(preparedStatement != null){
                    preparedStatement.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch(SQLException e){
                System.out.println("SQLException 2 in insert scores in leaderboard");
            }
        }
    }
    
    private void retrieveLeaderboard(){
        try{
            conn = DriverManager.getConnection(dbURL);
            
            String query = "SELECT * FROM leaderboard ORDER BY score DESC";
            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                double score = resultSet.getInt("score");
            }
        }catch(SQLException e){
            System.out.println("SQLException in retrieve leaderboard");
        }finally{
            try{
                if(resultSet != null){
                    resultSet.close();
                }
                if(statement != null){
                    statement.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch(SQLException e){
                System.out.println("SQLException 2 in retrieve leaderboard");
            }
        }
    }
    
    public List<String> getTopScores(){
        List<String> scores = new ArrayList<>();
        String query = "SELECT username, score FROM leaderboard ORDER BY score DESC FETCH FIRST 10 ROWS ONLY";
        
        try{
            conn = DriverManager.getConnection(dbURL);
            //preparedStatement = conn.prepareStatement(query);
            resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                String username = resultSet.getString("username");
                double score = resultSet.getDouble("score");
                scores.add(username + ": "+score);
            }
        }catch(SQLException e){
            System.out.println("SQLException in get top scores");
        }
        return scores;
    }
}
