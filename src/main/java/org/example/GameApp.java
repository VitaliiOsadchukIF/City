package org.example;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class GameApp {
    private static JTextArea computerBoard;
    private static JTextArea playerBoard;
    private static JFrame gameFrame;
    private static Move move = new Move();

    public static void start() {
        SwingUtilities.invokeLater(GameApp::showInitialWindow);
    }

    private static void showInitialWindow() {
        JFrame initialFrame = new JFrame("City Game");
        initialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initialFrame.setSize(400, 200);

        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(e -> {
            initialFrame.dispose();
            showGameWindow();
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("To start the game, press OK"));
        panel.add(startButton);

        initialFrame.getContentPane().add(panel);
        initialFrame.setVisible(true);
    } //dsfdsfdsfdfssdasdsadsa

    private static void showGameWindow() {
        gameFrame = new JFrame("City Game");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(600, 400);

        playerBoard = new JTextArea();
        computerBoard = new JTextArea();
        JButton moveButton = new JButton("Move");
        JButton skipButton = new JButton("Skip");
        JButton surrenderButton = new JButton("Surrender");

        computerBoard.setEditable(false);

        Dimension textAreaSize = new Dimension(40, 30);
        computerBoard.setPreferredSize(textAreaSize);
        playerBoard.setPreferredSize(textAreaSize);

        Font inputFont = new Font("Arial", Font.PLAIN, 14);
        playerBoard.setFont(inputFont);
        computerBoard.setFont(inputFont);

        playerBoard.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        computerBoard.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Ограничение на максимальное количество символов
        ((AbstractDocument) playerBoard.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                int currentLength = fb.getDocument().getLength();
                int insertLength = text.length();
                if (currentLength + insertLength <= 26) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });

        playerBoard.setColumns(20);
        computerBoard.setColumns(20);

        moveButton.addActionListener(e -> processPlayerMove());

        playerBoard.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        playerBoard.getActionMap().put("enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processPlayerMove();
            }
        });

        skipButton.addActionListener(e -> {
            String computerMove = move.skip();                 // додав Віталій
            computerBoard.append(computerMove + "\n");         // додав Віталій
        });

        surrenderButton.addActionListener(e -> {
            playerBoard.setText("");
            computerBoard.setText("");

            gameFrame.dispose();
            showInitialWindow();
        });

        JPanel topPanel = new JPanel(new GridLayout(1, 2));
        topPanel.add(playerBoard);
        topPanel.add(computerBoard);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));
        buttonPanel.add(moveButton);
        buttonPanel.add(skipButton);
        buttonPanel.add(surrenderButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        mainPanel.setBackground(Color.GRAY);

        gameFrame.getContentPane().add(mainPanel);
        gameFrame.setVisible(true);
    }

    private static void processPlayerMove() {
        String input = playerBoard.getText().trim();
        playerBoard.setText("");

        move.playGame(input);     // додав Віталій

        // Тут можна додати логіку для обробки ходу гравця
    }

}
