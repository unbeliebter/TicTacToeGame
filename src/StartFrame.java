import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class StartFrame {
    public StartFrame() {
        JFrame startframe = new JFrame("TicTacToe");
        startframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startframe.setSize(200, 180);

        JPanel startPanel = new JPanel();

        JLabel nameLabel = new JLabel("TicTacToe - JETZT SPIELEN");
        startPanel.add(nameLabel);

        JButton startButton = new JButton("Spiel starten");
        startPanel.add(startButton);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameFrame gameFrame = new GameFrame();
                startframe.setVisible(false);
            }
        });

        JButton windowCloseButton = new JButton("Spiel beenden");
        startPanel.add(windowCloseButton);
        windowCloseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startframe.setVisible(false);
            }
        });

        JButton statsButton = new JButton("Statistiken");
        startPanel.add(statsButton);
        statsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    StatsFrame statsFrame = new StatsFrame();
                } catch (IOException ex) {
                    throw new RuntimeException("Es ist ein Fehler aufgetreten. " + ex);
                }
                startframe.setVisible(false);
            }
        });

        startframe.add(startPanel);
        startframe.setVisible(true);
    }
}
