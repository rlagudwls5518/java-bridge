package bridge;


public class InputHandler {

    public static void validateNumber(String input) {
        if (input == null || !input.matches("-?\\d+")) {
            throw new IllegalArgumentException("정수가 아닙니다. 다시입력하세요");
        }
    }

    public static void numberValidator(int number){
        if(number<3 || number>20){
            throw new IllegalArgumentException("다시입력하세요");
        }
    }
    public static void stringValidator(String input){
        if(!(input.equals("U") || input.equals("D") || input.equals("R") || input.equals("Q"))){
            throw new IllegalArgumentException("다시 입력하세요");
        }
    }
}
