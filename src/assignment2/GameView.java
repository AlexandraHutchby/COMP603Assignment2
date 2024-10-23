package assignment2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * This class represents the graphical UI for deal or no deal manages the
 * display of cases, prices and game state
 *
 * @author Alexandra and Laina
 */
public class GameView extends JPanel {

    CasesModel c;
    JLabel roundLabel;
    private ArrayList<JButton> caseButtons;
    private ArrayList<JButton> priceButtons;
    private JLabel remainingCasesLabel;
    private JButton playAgainButton;
    private JButton backToMainMenuButton;
    private Color gold;

    public GameView(Color gold) {
        this.gold = gold;

        //setting background
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());

        caseButtons = new ArrayList<>();
        priceButtons = new ArrayList<>();

        //Sets up header, cases, prices and bottom panel
        setupHeader(gold);
        setupCasesPanel();
        setupPricePanels(gold);
        setupBottomPanel(gold);
    }

    //reset gameview to intial state
    public void resetGameView() {
        //reseting case buttons to default
        int index = 1;
        for (JButton cButton : caseButtons) {
            cButton.setText("Case " + index);
            cButton.setBackground(Color.GRAY);
            cButton.setForeground(Color.BLACK);
            cButton.setEnabled(true);
            index++;
        }

        // Reset price buttons to default state
        for (JButton pButton : priceButtons) {
            pButton.setBackground(gold);
            pButton.setForeground(Color.BLACK);
            pButton.setEnabled(true);
        }

        // Reset round and remaining cases labels
        updateRoundLabel(1);
        updateRemainingCasesLabel(6); // First round opens 6 cases
        revalidate();
        repaint();
    }

    //sets up header panel
    private void setupHeader(Color gold) {
        //header panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.BLACK);

        //Creating heading label
        JLabel header = new JLabel("Deal or No Deal", SwingConstants.CENTER);
        header.setFont(new Font("Broadway", Font.BOLD, 36));
        header.setForeground(gold);
        headerPanel.add(header, BorderLayout.NORTH);

        //creating round label
        roundLabel = new JLabel("Select your case", SwingConstants.CENTER);
        roundLabel.setFont(new Font("Broadway", Font.BOLD, 24));
        roundLabel.setForeground(Color.GRAY);
        headerPanel.add(roundLabel, BorderLayout.SOUTH);

        add(headerPanel, BorderLayout.NORTH);
    }

    //sets up case button panel
    private void setupCasesPanel() {
        //Case Panel
        JPanel casesPanel = new JPanel(new GridLayout(7, 4, 10, 10));
        casesPanel.setBackground(Color.BLACK);

        //creating case buttons
        for (int i = 1; i <= 26; i++) {
            int index = i;
            JButton cButton = new JButton("Case " + i);
            cButton.setFont(new Font("Arial", Font.PLAIN, 18));
            cButton.setForeground(Color.BLACK);
            cButton.setBackground(Color.GRAY);

            caseButtons.add(cButton);
            casesPanel.add(cButton);
        }
        add(casesPanel, BorderLayout.CENTER);
    }

    //method to set up price button panels
    private void setupPricePanels(Color gold) {

        //Amounts Panel left
        JPanel amountPanelLeft = new JPanel(new GridLayout(13, 1, 5, 5));
        amountPanelLeft.setBackground(Color.BLACK);

        //Amounts Panel right
        JPanel amountPanelRight = new JPanel(new GridLayout(13, 1, 5, 5));
        amountPanelRight.setBackground(Color.BLACK);

        c = new CasesModel();
        double[] amount = c.getAmounts();

        //creating price buttons for left panel
        for (int i = 0; i < 13; i++) {
            JButton price = new JButton("$ " + amount[i]);
            price.setFont(new Font("Arial", Font.PLAIN, 18));
            price.setForeground(Color.BLACK);
            price.setBackground(gold);
            priceButtons.add(price);
            amountPanelLeft.add(price);
        }

        //creating price buttons for right panel
        for (int i = 13; i < 26; i++) {
            JButton price = new JButton("$ " + amount[i]);
            price.setFont(new Font("Arial", Font.PLAIN, 18));
            price.setForeground(Color.BLACK);
            price.setBackground(gold);
            priceButtons.add(price);
            amountPanelRight.add(price);
        }

        add(amountPanelLeft, BorderLayout.WEST);
        add(amountPanelRight, BorderLayout.EAST);
    }

    //setiing up bottom panel
    private void setupBottomPanel(Color gold) {
        //Bottom panel
        JPanel bottom = new JPanel();
        bottom.setBackground(Color.BLACK);
        bottom.setLayout(new BorderLayout());

        //cases remaining
        remainingCasesLabel = new JLabel("Cases Remaining ...", SwingConstants.CENTER);
        remainingCasesLabel.setFont(new Font("Broadway", Font.BOLD, 18));
        remainingCasesLabel.setForeground(Color.GRAY);
        bottom.add(remainingCasesLabel, BorderLayout.CENTER);

        //Back to main menu Button
        backToMainMenuButton = new JButton("Main Menu");
        backToMainMenuButton.setFont(new Font("Arial", Font.BOLD, 18));
        backToMainMenuButton.setForeground(Color.BLACK);
        backToMainMenuButton.setBackground(gold);
        bottom.add(backToMainMenuButton, BorderLayout.EAST);

        // restart Button
        playAgainButton = new JButton("Restart");
        playAgainButton.setFont(new Font("Arial", Font.BOLD, 18));
        playAgainButton.setForeground(Color.BLACK);
        playAgainButton.setBackground(gold);
        bottom.add(playAgainButton, BorderLayout.WEST);

        add(bottom, BorderLayout.SOUTH);

    }

    //update methods 
    public void updateRoundLabel(String roundText) {
        roundLabel.setText(roundText);
    }

    //Updating rounds label
    public void updateRoundLabel(int round) {
        roundLabel.setText("Round " + round);
    }

    //updating remaining cases label
    public void updateRemainingCasesLabel(int remainingCases) {
        remainingCasesLabel.setText("Cases Remaining: " + remainingCases);
    }

    //get methods
    public ArrayList<JButton> getCaseButtons() {
        return caseButtons;
    }

    public ArrayList<JButton> getPriceButtons() {
        return priceButtons;
    }

    public JLabel getRemainingCasesLabel() {
        return remainingCasesLabel;
    }

    public JButton getPlayAgainButton() {
        return playAgainButton;
    }

    public JButton getBackToMainMenuButton() {
        return backToMainMenuButton;
    }

}
