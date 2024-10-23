package assignment2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * This function creates the visual component for displaying a leaderboard.
 *
 * @author Alexandra and Laina
 */
public class LeaderboardView extends JPanel {

    private Color gold; //colour used for GUI elements

    private JButton menu; //button for main menu
    private JButton start; //button for new game

    private JTable scoresTable; //Table for the user scores
    private DefaultTableModel tableModel; //Model for the scoresTable - managing the data it displays
    private JPanel scoresPanel; //panel containing the scores table

    public LeaderboardView(Color gold) {
        this.gold = gold;
        //Setting background
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());

        //Creating heading
        JLabel header = new JLabel("Leaderboard", SwingConstants.CENTER);
        header.setFont(new Font("Broadway", Font.BOLD, 30));
        header.setForeground(gold);
        add(header, BorderLayout.NORTH);

        createButtons(); //creates the buttons
        createScores(); //creates the scores
    }

    private void createButtons() {
        //Buttons panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setLayout(new BorderLayout());

        //Start Game button
        start = new JButton("Start Game");
        start.setFont(new Font("Arial", Font.BOLD, 18));
        start.setForeground(Color.BLACK);
        start.setBackground(gold);
        buttonPanel.add(start, BorderLayout.EAST);

        //Main Menu Button
        menu = new JButton("Main Menu");
        menu.setFont(new Font("Arial", Font.BOLD, 18));
        menu.setForeground(Color.BLACK);
        menu.setBackground(gold);
        buttonPanel.add(menu, BorderLayout.WEST);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void createScores() {
        //Scores panel
        scoresPanel = new JPanel(new BorderLayout());
        scoresPanel.setBackground(Color.BLACK);

        //Creating the scores table
        tableModel = new DefaultTableModel(new Object[]{"Username", "Score"}, 0);
        scoresTable = new JTable(tableModel);
        scoresTable.setFillsViewportHeight(true);
        scoresTable.setRowHeight(40);
        scoresTable.setFont(new Font("Arial", Font.PLAIN, 20));
        scoresTable.getTableHeader().setBackground(Color.BLACK);
        scoresTable.getTableHeader().setForeground(gold);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setBackground(Color.BLACK);
        renderer.setForeground(gold);
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < scoresTable.getColumnCount(); i++) {
            scoresTable.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }

        scoresPanel.add(scoresTable, BorderLayout.CENTER);

        add(scoresPanel, BorderLayout.CENTER);
    }

    //this function updates the scores table with the data - clears exisitng rows
    public void updateScores(List<String> scores) {
        tableModel.setRowCount(0);
        for (String score : scores) {
            String[] parts = score.split(",");
            tableModel.addRow(parts);
        }
        scoresPanel.revalidate();
        scoresPanel.repaint();
    }

    //returns menu button
    public JButton getMenu() {
        return menu;
    }

    //returns the start button
    public JButton getStart() {
        return start;
    }
}
