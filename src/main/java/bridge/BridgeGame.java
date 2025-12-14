package bridge;

import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private final PlayerBridge playerBridge;
    private int tryCount = 1;
    private int index = 0;


    public BridgeGame(List<String> bridge, PlayerBridge playerBridge) {
        this.bridge = bridge;
        this.playerBridge = playerBridge;
    }

    public boolean isGameClear(){
        return bridge.size() == index;
    }

    public Boolean GamePlay(String currentSpace) {
        if (Objects.equals(currentSpace, bridge.get(index))) {
            move(currentSpace);
            return true;
        } else {
            retry(currentSpace);
            return false;
        }
    }

    private void move(String currentSpace) {
        playerBridge.successMove(currentSpace);
        index++;
    }

    private void retry(String currentSpace) {
        playerBridge.failMove(currentSpace);
        tryCount++;
    }

    public int getTryCount() {
        return tryCount;
    }
}
