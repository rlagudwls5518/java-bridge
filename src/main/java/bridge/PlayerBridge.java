package bridge;

import java.util.ArrayList;
import java.util.List;

public class PlayerBridge {
    private final List<PlayerMove> playerMoves = new ArrayList<>();

    public void successMove(String currentSpace) {
        playerMoves.add(new PlayerMove("O",currentSpace));
    }

    public void failMove(String currentSpace) {
        playerMoves.add(new PlayerMove("X",currentSpace));
    }

    public int playerMovesSize() {
        return playerMoves.size();
    }
    public List<PlayerMove> playerMoves() {
        return playerMoves;
    }


}
