/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author laina
 */
public class LoginDatabase {

    private final String USER_NAME = "COMP603Group10";
    private final String PASSWORD = "group10";
    private final String dbURL = "jdbc:derby://localhost:1527/LeaderboardDB; create =true";
    private Connection conn;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public LoginDatabase() {
        connectToDatabase();
        createLoginTable();
    }

    private void connectToDatabase() {
        try {
            conn = DriverManager.getConnection(dbURL, USER_NAME, PASSWORD);
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            System.out.println("SQLException in login Database");
        }
    }

    public void closeDatabase() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("SQLException 2 in login Database");
        }
    }

    private void createLoginTable() {
        try {
            if (conn == null) {
                connectToDatabase();
            }

            this.statement = conn.createStatement();

            String createTableSQL = "CREATE TABLE login ("
                    + "username VARCHAR(255) NOT NULL, "
                    + "password VARCHAR(255) NOT NULL)";

            statement.execute(createTableSQL);

            System.out.println("Login table created");
        } catch (SQLException e) {
            System.out.println("SQLException in create table");
        }
    }

    public void insertUsername(String username, String password) {
        try {
            if (conn == null) {
                connectToDatabase();
            }
            if (!checkUsernameAndPassword(username, password) && !checkUsername(username)) {
                String insertSQL = "INSERT INTO login (username, password) VALUES (?, ?)";
                this.preparedStatement = conn.prepareStatement(insertSQL);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                preparedStatement.executeUpdate();
                System.out.println("A new user has been added");
            }
        } catch (SQLException e) {
            System.out.println("SQLException in insert username");
        }
    }

    public boolean checkUsernameAndPassword(String username, String password) {
        try {
            if (conn == null) {
                connectToDatabase();
            }

            String selectSQL = "SELECT * FROM login WHERE username = ? AND password = ?";
            this.preparedStatement = conn.prepareStatement(selectSQL);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            System.out.println("SQLException in check username in leaderboard");
            return false;
        }
    }
    
    public boolean checkUsername(String username){
                try {
            if (conn == null) {
                connectToDatabase();
            }

            String selectSQL = "SELECT * FROM login WHERE username = ?";
            this.preparedStatement = conn.prepareStatement(selectSQL);
            preparedStatement.setString(1, username);

            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            System.out.println("SQLException in check username in leaderboard");
            return false;
        }
    }

}
