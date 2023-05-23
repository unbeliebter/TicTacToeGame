public class TicTacToeController {

    private String status;
    private int winsA;
    private int winsB;
    private int[] fieldsOfA = new int[8];
    private int[] fieldsOfB = new int[8];

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

    public void setWinsB(int winsB) {
        this.winsB = winsB;
    }

    public int[] getFieldsOfA() {
        return fieldsOfA;
    }

    public void setFieldsOfA(int[] fieldsOfA, int index) {
        fieldsOfA[index] = index;
        this.fieldsOfA = fieldsOfA;
    }

    public int[] getFieldsOfB() {
        return fieldsOfB;
    }

    public void setFieldsOfB(int[] fieldsOfB, int index) {
        fieldsOfA[index] = index;
        this.fieldsOfB = fieldsOfB;
    }
}
