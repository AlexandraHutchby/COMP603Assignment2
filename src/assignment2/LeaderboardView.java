/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author laina
 */
public class LeaderboardView extends JPanel {

    private Color gold;

    private JButton menu;
    private JButton start;

    private JTable scoresTable;
    private DefaultTableModel tableModel;
    private JPanel scoresPanel;

    public LeaderboardView(Color gold, JPanel mainPanel, CardLayout cardLayout) {
        this.gold = gold;
        //Setting background
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());

        //Creating heading
        JLabel header = new JLabel("Leaderboard", SwingConstants.CENTER);
        header.setFont(new Font("Broadway", Font.BOLD, 30));
        header.setForeground(gold);
        add(header, BorderLayout.NORTH);

        createButtons();
        createScores();
    }

    private void createButtons() {
        //Buttons
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
        scoresPanel = new JPanel(new BorderLayout());
        scoresPanel.setBackground(Color.BLACK);

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

        for (int i = 0;i < scoresTable.getColumnCount(); i++) {
            scoresTable.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }

        scoresPanel.add(scoresTable, BorderLayout.CENTER);

        add(scoresPanel, BorderLayout.CENTER);
    }

    public void updateScores(List<String> scores) {
        tableModel.setRowCount(0);
        for (String score : scores) {
            String[] parts = score.split(",");
            tableModel.addRow(parts);
        }
        scoresPanel.revalidate();
        scoresPanel.repaint();
    }

    public JButton getMenu() {
        return menu;
    }

    public JButton getStart() {
        return start;
    }
}
