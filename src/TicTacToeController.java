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
}
