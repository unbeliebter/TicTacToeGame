import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame {
    public StartFrame() {
        JFrame startframe = new JFrame("TicTacToe");
        startframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startframe.setSize(500, 500);

        JPanel startPanel = new JPanel();

        JLabel nameLabel = new JLabel("TicTacToe");
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
                StatsFrame statsFrame = new StatsFrame();
                startframe.setVisible(false);
            }
        });

        startframe.add(startPanel);
        startframe.setVisible(true);
    }
}
