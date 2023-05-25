import java.io.*;

public class TicTacToeController {

    private String status;
    private int winsA;
    private int winsB;
    private int ties;
    private int[] fieldsOfA = new int[9];
    private int[] fieldsOfB = new int[9];

    public TicTacToeController(String status, int winsA, int winsB) {
        setStatus(status);
        setWinsA(winsA);
        setWinsB(winsB);
    }

    public TicTacToeController() {

    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public int getWinsA() {
        return winsA;
    }

    public void setWinsA(int winsA) {
        this.winsA = winsA;
    }

    public int getWinsB() {
        return winsB;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public void setWinsB(int winsB) {
        this.winsB = winsB;
    }

    public int[] getFieldsOfA() {
        return fieldsOfA;
    }

    public void setFieldsOfA(int[] fieldsOfA, int index) {
        fieldsOfA[index] = 1;
        this.fieldsOfA = fieldsOfA;
    }

    public int[] getFieldsOfB() {
        return fieldsOfB;
    }

    public void setFieldsOfB(int[] fieldsOfB, int index) {
        fieldsOfB[index] = 1;
        this.fieldsOfB = fieldsOfB;
    }

    public void clear(int[] fieldsOfA, int[] fieldsOfB, String status) {
        setStatus("A");
        this.fieldsOfA = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        this.fieldsOfB = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
    }

    public String statsPicker(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String readString;
        String cleanReadString;
        int winsOfA = 0;
        int winsOfB = 0;
        int ties = 0;
        int games = 0;

        while ((readString = reader.readLine()) != null) {
            cleanReadString =  readString.replace("|", "");
            games =  games + Integer.parseInt(cleanReadString.split("")[0].substring(0));

            System.out.println(games);
            if (cleanReadString.split("|")[1].substring(0).equalsIgnoreCase("A")) {
                if (winsOfA < Integer.parseInt(cleanReadString.split("")[0].substring(0))) {
                    winsOfA = Integer.parseInt(cleanReadString.split("")[0].substring(0));
                }

            } else if (cleanReadString.split("")[1].substring(0).equalsIgnoreCase("B")) {
                if (winsOfB < Integer.parseInt(cleanReadString.split("")[0].substring(0))) {
                    winsOfB = Integer.parseInt(cleanReadString.split("")[0].substring(0));
                }

            } else if (cleanReadString.split("")[1].substring(0).equalsIgnoreCase("U")) {
                if (ties < Integer.parseInt(cleanReadString.split("")[0].substring(0))) {
                    ties = Integer.parseInt(cleanReadString.split("")[0].substring(0));
                }
            }
        }
        return "Spiele insgesamt: " + games + "\n" +
                "Spieler A: " + winsOfA + " Gewonnene Spiele" + "\n" +
                "Spieler B: " + winsOfB + " Gewonnene Spiele" + "\n" +
                "Unentschieden: " + ties + " Spiele";
    }
}
