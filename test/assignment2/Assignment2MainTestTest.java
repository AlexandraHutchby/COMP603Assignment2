/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package assignment2;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alexandra
 */
public class Assignment2MainTestTest {
    
    public Assignment2MainTestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     *
     */
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /*
    this part of the code is testing the banker offer part of our code
    We thought this was an important part of the code as the banker offer code is written
    to help the user decide if they want to accept a determined amount of money or risk it
    and keep a case amount
    */
    @Test
    public void testCalculateOffer_withNonEmptyArray(){
        BankOfferModel model = new BankOfferModel();
        double[] remainingValues = {100.0, 200.0, 300.0, 0.0};
        int offer = model.calculateOffer(remainingValues);
        
        assertEquals(100, offer);
    }
    
    @Test
    public void testCalculateOffer_withZeros(){
        BankOfferModel model = new BankOfferModel();
        double[] remainingValues = {0.0, 0.0, 0.0};
        int offer = model.calculateOffer(remainingValues);
        
        assertEquals(0, offer);
    }
    
    @Test
    public void testCalculateOffer_withMixedValues(){
        BankOfferModel model = new BankOfferModel();
        double[] remainingValues = {500.0, 1000.0};
        int offer = model.calculateOffer(remainingValues);
        
        assertEquals(375, offer);
    }
    
    
    /*
    this part of the code is testing the cases part of our code
    This is an important part of our code as this determines all parts of the game
    including which round they are in, how much money they are to win, how much money
    they just lost etc.
    */
    private CasesModel casesModel;
    
    @Before
    public void setUpCasesModel(){
        casesModel = new CasesModel();
        casesModel.createCases();
    }
    
    @Test
    public void testCreateCases(){
        assertNotNull(casesModel.getCases());
        assertEquals(26, casesModel.getCases().size());
    }
    
    @Test
    public void testGetPrice(){
        double price = casesModel.getPrice(1); //price of case 1
        assertTrue(price > 0);
    }
    
    @Test
    public void testResetCases(){
        casesModel.resetCases();
        assertEquals(26, casesModel.getCases().size());
    }
    
    /*
    this part of the code is testing our leaderboard database
    This is an important part of the game as it makes users want to compete with each other
    to get into the top 10 players.
    */
    
    private LeaderboardDatabase leaderboardDatabase;
    
    @Before
    public void setUpLeaderboardDatabase(){
        leaderboardDatabase = new LeaderboardDatabase();
    }
    
    @Test
    public void testInsertAndRetrieveScores(){
        String username = "hi"; //I used this as this is our testing username which should be in the top 10 scores
        leaderboardDatabase.insertScoresInLeaderboard(username);
        
        List<String> scores = leaderboardDatabase.getTopScores();
        assertFalse(scores.isEmpty());
        
        boolean found = scores.stream().anyMatch(score -> score.contains(username));
        assertTrue(found);
    }

    
}
