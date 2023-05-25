import javax.swing.*;

public class StatsFrame {
    public StatsFrame() {
        JFrame statsFrame = new JFrame("TicTacToe Rangliste");
        statsFrame.setSize(300, 500);

        JPanel statsPanel = new JPanel();

        JLabel statsLabel = new JLabel("Statistiken: (Nach meisten Rundengewinnen)");
        statsPanel.add(statsLabel);

    /*
    Anschauen: https://www.youtube.com/watch?v=qsHWHQMa0dM&t=104s
     */

        statsFrame.add(statsPanel);
        statsFrame.setVisible(true);

    }
}
