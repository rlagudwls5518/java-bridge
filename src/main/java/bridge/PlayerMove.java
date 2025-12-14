package bridge;

public class PlayerMove {

    private final String success;
    private final String currentSpace;

    PlayerMove(String success, String currentSpace) {
        this.success = success;
        this.currentSpace = currentSpace;
    }

    public String getSuccess() {
        return success;
    }
    public String getcurrentSpace() {
        return currentSpace;
    }


}
