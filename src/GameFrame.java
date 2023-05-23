import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class GameFrame {
    public JButton[] buttons = new JButton[9];
    public GameFrame() {

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

                    if (game.getStatus().equalsIgnoreCase("A")) {
                        game.setFieldsOfA(game.getFieldsOfA(), index);
                        whoPlaysLabel.setText("Spieler B ist dran");
                        game.setStatus("B");
                    } else if(game.getStatus().equalsIgnoreCase("B")){
                        game.setFieldsOfB(game.getFieldsOfB(), index);
                        whoPlaysLabel.setText("Spieler A ist dran");
                        game.setStatus("A");
                    }
                    String winner = checkWin(game.getFieldsOfA(), game.getFieldsOfB());

                    JFrame winFrame = new JFrame("TicTacToe");
                    winFrame.setSize(100, 100);
                    winFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                    JLabel winlabel = new JLabel();
                    winFrame.add(winlabel);

                    if (winner.equalsIgnoreCase("A")) {
                        game.setWinsA(game.getWinsA() + 1);
                        winlabel.setText("Spieler A hat gewonnen!");
                        winFrame.setVisible(true);
                        System.out.println("WIN A");
                    } else if(winner.equalsIgnoreCase("B")){
                        game.setWinsB(game.getWinsB() + 1);
                        winlabel.setText("Spieler B hat gewonnen!");
                        winFrame.setVisible(true);
                        System.out.println("WIN B");
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

    public String checkWin(int[] fieldsOfA, int[] fieldsOfB) {
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

        System.out.println("A - " + fieldsOfACode);
        System.out.println("B - " + fieldsOfBCode);

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

        return "FEHLER";
    }
}