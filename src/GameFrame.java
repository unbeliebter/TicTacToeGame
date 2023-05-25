import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class GameFrame {
    public JButton[] buttons = new JButton[9];
    public int counter = 0;
    public GameFrame() {

        File file = new File("Statistiken.txt");

        TicTacToeController game = new TicTacToeController("A", 0, 0);
        JFrame gameFrame = new JFrame("TicTacToe");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(400, 400);

        JLabel whoPlaysLabel = new JLabel("Spieler A ist dran");
        gameFrame.add(whoPlaysLabel);

        JLabel pointsOfA = new JLabel("Wins von A: " + String.valueOf(game.getWinsA()));
        gameFrame.add(pointsOfA);

        JLabel pointsOfB = new JLabel("Wins von B: " + String.valueOf(game.getWinsB()));
        gameFrame.add(pointsOfB);

        gameFrame.setLayout(new GridLayout(5, 3));

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            final int index = i; // Final variable for ActionListener
            buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    buttonClicked(index, game.getStatus());
                    counter++;

                    if (game.getStatus().equalsIgnoreCase("A")) {
                        game.setFieldsOfA(game.getFieldsOfA(), index);
                        whoPlaysLabel.setText("Spieler B ist dran");
                        game.setStatus("B");
                    } else if(game.getStatus().equalsIgnoreCase("B")){
                        game.setFieldsOfB(game.getFieldsOfB(), index);
                        whoPlaysLabel.setText("Spieler A ist dran");
                        game.setStatus("A");
                    }
                    String winner = checkWin(game.getFieldsOfA(), game.getFieldsOfB(), counter);

                    JFrame winFrame = new JFrame("TicTacToe");
                    winFrame.setSize(200, 100);
                    winFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                    JPanel winPanel = new JPanel();

                    JLabel winlabel = new JLabel();
                    winPanel.add(winlabel);

                    JButton backButton = new JButton("Ok");
                    winPanel.add(backButton);

                    backButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            winFrame.setVisible(false);
                        }
                    });

                    JButton gameCloseButton = new JButton("Spiel schließen");
                    winPanel.add(gameCloseButton);
                    winFrame.add(winPanel);

                    gameCloseButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
                                if (game.getWinsA() != 0) {
                                    writer.write(game.getWinsA() + "|A|" + LocalTime.now() + "-" + LocalDate.now());
                                    writer.newLine();
                                }

                                if (game.getWinsB() != 0) {
                                    writer.write(game.getWinsB() + "|B|" + LocalTime.now() + "-" + LocalDate.now());
                                    writer.newLine();
                                }

                                if (game.getTies() != 0) {
                                    writer.write(game.getTies() + "|U|" + LocalTime.now() + "-" + LocalDate.now());
                                    writer.newLine();
                                }
                                writer.close();

                            } catch (IOException ex) {
                                throw new RuntimeException("Es ist ein Fehler aufgetreten: " + ex);
                            }
                            System.exit(-1);
                        }
                    });

                    if (winner.equalsIgnoreCase("A")) {
                        game.setWinsA(game.getWinsA() + 1);
                        winlabel.setText("Spieler A hat gewonnen!");
                        pointsOfA.setText("Wins von A: " + String.valueOf(game.getWinsA()));
                        winFrame.setVisible(true);
                        buttonsClear();
                        game.clear(game.getFieldsOfA(), game.getFieldsOfB(), game.getStatus());
                        counter = 0;

                    } else if(winner.equalsIgnoreCase("B")){
                        game.setWinsB(game.getWinsB() + 1);
                        winlabel.setText("Spieler B hat gewonnen!");
                        pointsOfB.setText("Wins von B: " + String.valueOf(game.getWinsB()));
                        winFrame.setVisible(true);
                        buttonsClear();
                        game.clear(game.getFieldsOfA(), game.getFieldsOfB(), game.getStatus());
                        counter = 0;
                    } else if(winner.equalsIgnoreCase("U")) {
                        game.setTies(game.getTies() + 1);
                        winlabel.setText("Es ist ein unentschieden!");
                        winFrame.setVisible(true);
                        buttonsClear();
                        game.clear(game.getFieldsOfA(), game.getFieldsOfB(), game.getStatus());
                        counter = 0;
                    }
                }
            });
            gameFrame.add(buttons[i]);
        }
        gameFrame.setVisible(true);
    }

    public void buttonClicked(int index, String status) {
        if (status.equalsIgnoreCase("A") && buttons[index].getBackground() != Color.RED && buttons[index].getBackground() != Color.CYAN) {
            buttons[index].setBackground(Color.CYAN);
        } else if (status.equalsIgnoreCase("B") && buttons[index].getBackground() != Color.RED && buttons[index].getBackground() != Color.CYAN) {
            buttons[index].setBackground(Color.RED);
        }
    }

    public void buttonsClear() {
        for (JButton button : buttons) {
            button.setBackground(Color.WHITE);
        }
    }

    public String checkWin(int[] fieldsOfA, int[] fieldsOfB, int counter) {
        String fieldsOfACode = Arrays.toString(fieldsOfA);
        fieldsOfACode = fieldsOfACode.replace(",", "");
        fieldsOfACode =  fieldsOfACode.replace(" ", "");
        fieldsOfACode = fieldsOfACode.replace("[", "");
        fieldsOfACode = fieldsOfACode.replace("]", "");

        String fieldsOfBCode = Arrays.toString(fieldsOfB);
        fieldsOfBCode = fieldsOfBCode.replace(",", "");
        fieldsOfBCode =  fieldsOfBCode.replace(" ", "");
        fieldsOfBCode = fieldsOfBCode.replace("[", "");
        fieldsOfBCode = fieldsOfBCode.replace("]", "");

        switch (fieldsOfACode)  {
            case "111000000": return "A";
            case "000111000": return "A";
            case "000000111": return "A";
            case "100100100": return "A";
            case "010010010": return "A";
            case "001001001": return "A";
            case "100010001": return "A";
            case "001010100": return "A";
        }

        switch (fieldsOfBCode) {
            case "111000000": return "B";
            case "000111000": return "B";
            case "000000111": return "B";
            case "100100100": return "B";
            case "010010010": return "B";
            case "001001001": return "B";
            case "100010001": return "B";
            case "001010100": return "B";
        }

        if (counter == 9) {
            return "U";
        }

        return "FEHLER";
    }
}