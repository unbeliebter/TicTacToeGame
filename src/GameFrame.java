import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                    game.setStatus(buttonClicked(index, game.getStatus()));

                    if (game.getStatus().equalsIgnoreCase("B")) {
                        game.setFieldsOfA(game.getFieldsOfA(), index);
                    } else {
                        game.setFieldsOfB(game.getFieldsOfB(), index);
                    }
                    String winner = checkWin(game.getFieldsOfA(), game.getFieldsOfB());

                    JFrame winFrame = new JFrame("TicTacToe");
                    winFrame.setSize(100, 100);
                    winFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                    JLabel winlabel = new JLabel();
                    winlabel.add(winFrame);

                    if (winner.equalsIgnoreCase("A")) {
                        game.setWinsA(game.getWinsA() + 1);
                        winlabel.setText("Spieler A hat gewonnen!");
                        winFrame.setVisible(true);
                    } else if(winner.equalsIgnoreCase("B")){
                        game.setWinsB(game.getWinsB() + 1);
                        winlabel.setText("Spieler A hat gewonnen!");
                        winFrame.setVisible(true);
                    }
                }
            });
            gameFrame.add(buttons[i]);
        }

        gameFrame.setVisible(true);

    }

    public String buttonClicked(int index, String status) {
        if (status.equalsIgnoreCase("A") && buttons[index].getBackground() != Color.RED && buttons[index].getBackground() != Color.CYAN) {
            buttons[index].setBackground(Color.CYAN);
            return "B";
        } else if (status.equalsIgnoreCase("B") && buttons[index].getBackground() != Color.RED && buttons[index].getBackground() != Color.CYAN) {
            buttons[index].setBackground(Color.RED);
            return "A";
        }
        return "A";
    }

    public String checkWin(int[] fieldsOfA, int[] fieldsOfB) {
        return "null";
    }
}