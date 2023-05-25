import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class StatsFrame {
    public StatsFrame() throws IOException {
        TicTacToeController controller = new TicTacToeController();
        JFrame statsFrame = new JFrame("TicTacToe Rangliste");
        statsFrame.setSize(300, 150);

        JPanel statsPanel = new JPanel();

        JLabel statsLabel = new JLabel("Statistiken: (Nach meisten Rundengewinnen)");
        statsPanel.add(statsLabel);

        File file = new File("Statistiken.txt");

        String TextAreaText = controller.statsPicker(file);
        JTextArea statsTextArea = new JTextArea(TextAreaText);
        statsTextArea.setEditable(false);
        statsPanel.add(statsTextArea);

        statsFrame.add(statsPanel);
        statsFrame.setVisible(true);

    }
}

/*
- Textfeld was nicht editierbar ist
- Für jeden Spieler wird ein Bestwert gesucht
- Die sollen in dem TextFeld je nach Punkten sortiert sein
 */