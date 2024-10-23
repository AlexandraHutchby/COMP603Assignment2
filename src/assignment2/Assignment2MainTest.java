package assignment2;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * The main class for the Deal or no Deal game
 *
 * @author Alexandra and Laina
 */
public class Assignment2MainTest {

    private static JPanel mainPanel;        //Panel that holds all other panels
    private static CardLayout cardLayout;   //layout manager for switching between panels

    public static void main(String[] args) {
        //creating GUI
        SwingUtilities.invokeLater(() -> createMainFrame());
    }

    //creates and sets up the main application frame
    private static void createMainFrame() {
        Color gold = new Color(255, 215, 0);    //defines gold color

        //create frame
        JFrame frame = new JFrame("Deal or No Deal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);

        //Use cardLayout to switch between panels
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        //Creating model for cases and user cases
        CasesModel c = new CasesModel();
        c.createCases();    //initialising cases

        //model for user case
        UserCaseModel userCase = new UserCaseModel();

        // Initialise views and controllers for different parts of the game
        LeaderboardView leaderboardView = new LeaderboardView(gold);
        LeaderboardDatabase leaderboardDatabase = new LeaderboardDatabase();
        LeaderboardController leaderboardController = new LeaderboardController(leaderboardDatabase, leaderboardView);

        LoginView loginView = new LoginView(gold);
        LoginDatabase loginDatabase = new LoginDatabase();
        LoginController loginController = new LoginController(loginDatabase, loginView, leaderboardDatabase);

        EndView endView = new EndView(gold);

        BankOfferView bankOfferView = new BankOfferView(gold);
        BankOfferModel bankOfferModel = new BankOfferModel();
        BankOfferController bankOfferController = new BankOfferController(bankOfferView, bankOfferModel, c, endView, leaderboardDatabase);

        GameView gameView = new GameView(gold);
        FinalRoundView finalRoundView = new FinalRoundView(gold);

        FinalRoundController finalRoundController = new FinalRoundController(finalRoundView, endView, c, leaderboardDatabase);
        GameController controller = new GameController(c, gameView, bankOfferController, gold, userCase, finalRoundController);

        EndController endController = new EndController(endView, controller);

        MenuView menuView = new MenuView(gold);
        MenuController menuController = new MenuController(menuView);

        InstructionsView instructionsView = new InstructionsView(gold);
        InstructionsController instructionsController = new InstructionsController(instructionsView);

        //Add different panels to CardLayout
        mainPanel.add(loginView, "loginPanel");
        mainPanel.add(menuView, "menuPanel");
        mainPanel.add(instructionsView, "instructionsPanel");
        mainPanel.add(leaderboardView, "leaderboardPanel");
        mainPanel.add(gameView, "gamePanel");
        mainPanel.add(bankOfferView, "bankerOfferPanel");
        mainPanel.add(endView, "endPanel");
        mainPanel.add(finalRoundView, "finalRoundPanel");

        //show the frame
        frame.add(mainPanel);
        frame.setVisible(true);

        //Show menu panel
        cardLayout.show(mainPanel, "loginPanel");
    }

}
