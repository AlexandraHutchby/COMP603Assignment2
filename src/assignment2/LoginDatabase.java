package assignment2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This function provides essential methods for user registration and login
 * validation by managing database connections, creating necessary tables,
 * inserting user credentials and checking for existing users
 *
 * @author Alexandra and Laina
 */
public class LoginDatabase {

    private final String USER_NAME = "COMP603Group10"; //username of the database
    private final String PASSWORD = "group10"; //password of the database
    private final String dbURL = "jdbc:derby://localhost:1527/LeaderboardDB; create =true"; //url of the database

    private Connection conn; //Connection object used to communicate with the database
    private Statement statement; //used to execute the SQL statements without parameters
    private PreparedStatement preparedStatement; //used to execute the SQL statements with parameters
    private ResultSet resultSet; //used to store the results of SQL queries

    //initialised the login database
    public LoginDatabase() {
        connectToDatabase(); //establish a connection to the database
        createLoginTable(); //creates a login table if it doesn't exist
    }

    //function that connects to the database
    private void connectToDatabase() {
        try {
            conn = DriverManager.getConnection(dbURL, USER_NAME, PASSWORD);
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            System.out.println("SQLException in login Database");
        }
    }

    //function that closes the database connection
    public void closeDatabase() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("SQLException 2 in login Database");
        }
    }

    //function that creates the login table
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
            System.out.println("Login table already exists");
        }
    }

    //adds a new username if the username doesn't exist
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

    //checks that that the username and password matches the existing records
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

    //checks if the username already exists
    public boolean checkUsername(String username) {
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
