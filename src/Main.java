abstract class Animal {
    public int register = 0;
    public int[] memory = {5, 10, 0};

    private static final int LOAD = 1;  // 로드
    private static final int SAVE = 2;  // 저장
    private static final int ADD = 3;   // 더하기
    private static final int SUB = 4;   // 빼기
    private static final int HALT = 4;  // 중지

    private int[][] program = {     // 2차원 배열
            {LOAD, 0},       // register = memory[0];
            {ADD, 1},       // resister = resister + memory[1];
            {SAVE, 2},       // memory[2] = register;
            {HALT, 0}       // stop program execution
    };

    public  void executeProgram() {
        int pc = 0;

        while(true){
            int opcode = program[pc][0];        // opcode 는 명령어
            int operand = program[pc][1];       // operand 는 메모리

            switch (opcode) {
                case LOAD :
                    register = memory[operand];
                    System.out.println("MOV: Loading memory[" + operand + " (" + memory[0] + ") into register.");
                    break;
                case SAVE :
                    memory[operand] = register;
                    System.out.println("SAVE: Saving memory[" + operand + " (" + memory[0] + ") into register.");
                    break;
                case ADD :

                    break;
                case SUB :

                    break;
                case HALT :

                    break;
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {

    }
}