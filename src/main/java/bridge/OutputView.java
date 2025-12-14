package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {


    public void nextSpaceInputPrint(){
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }
    public void retryGamePrint(){
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(PlayerBridge playerBridge) {

        System.out.print("[");
        for (int i = 0; i < playerBridge.playerMovesSize(); i++) {
            if(playerBridge.playerMoves().get(i).getcurrentSpace().equals("U")){
                System.out.print(" "+playerBridge.playerMoves().get(i).getSuccess()+" ");
            }
            else{
                System.out.print("   ");
            }
            if (i < playerBridge.playerMovesSize() - 1) {
                System.out.print("|");
            }

        }
        System.out.print("]");

        System.out.println();

        System.out.print("[");
        for (int i = 0; i < playerBridge.playerMovesSize(); i++) {
            if(playerBridge.playerMoves().get(i).getcurrentSpace().equals("D")){
                System.out.print(" "+playerBridge.playerMoves().get(i).getSuccess()+" ");
            }
            else{
                System.out.print("   ");
            }
            if (i < playerBridge.playerMovesSize() - 1) {
                System.out.print("|");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame, PlayerBridge playerBridge) {

        System.out.println("최종 게임 결과");
        printMap(playerBridge);

        if (bridgeGame.isGameClear()) {
            System.out.println("게임 성공 여부: 성공");
        } else {
            System.out.println("게임 성공 여부: 실패");
        }
        System.out.println("총 시도한 횟수: " + bridgeGame.getTryCount());
    }
}
