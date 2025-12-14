package bridge;

import java.util.List;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {

        int bridgeSize = bridgeSizeInput();
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);

        PlayerBridge recordPlayerBridge = new PlayerBridge();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridge, recordPlayerBridge);

        while (true) {
            if (bridgeGame.isGameClear()) {
                break;
            }
            String nextSpace = nextSpaceInput();
            boolean moveSuccess = bridgeGame.GamePlay(nextSpace);

            outputView.printMap(recordPlayerBridge);

            if (!moveSuccess) {
                String retryGameInput = gameRetryInput();
                if (retryGameInput.equals("Q")) {
                    break;
                }
            }
        }

        outputView.printResult(bridgeGame, recordPlayerBridge);
    }

    private int bridgeSizeInput() {
        try {
            return inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return bridgeSizeInput();
        }
    }

    private String nextSpaceInput() {
        try {
            outputView.nextSpaceInputPrint();
            return inputView.readMoving();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return nextSpaceInput();
        }
    }

    private String gameRetryInput() {
        try {
            outputView.retryGamePrint();
            return inputView.readGameCommand();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return gameRetryInput();
        }
    }
}
