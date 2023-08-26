package org.example;

import javax.swing.*;
import java.awt.*;

public class GameApp {
    public static void start() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                showInitialWindow();
            }
        });
    }
    private static void showInitialWindow() {
        JFrame initialFrame = new JFrame("City Game");
        initialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initialFrame.setSize(300, 150);

        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(e -> {
            initialFrame.dispose(); // Закрываем начальное окно
            showGameWindow();
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("To start the game, press OK"));
        panel.add(startButton);

        initialFrame.getContentPane().add(panel);
        initialFrame.setVisible(true);
    }

    private static void showGameWindow() {
        JFrame gameFrame = new JFrame("City Game");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(400, 300);

        JTextField inputField = new JTextField();
        JTextArea computerBoard = new JTextArea();
        JButton moveButton = new JButton("Make a move");

        moveButton.addActionListener(e -> {
            String input = inputField.getText().trim();

            computerBoard.append("Computer's move...\n");

            inputField.setText("");
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(inputField, BorderLayout.NORTH);
        panel.add(computerBoard, BorderLayout.CENTER);
        panel.add(moveButton, BorderLayout.SOUTH);

        gameFrame.getContentPane().add(panel);
        gameFrame.setVisible(true);
    }
}
