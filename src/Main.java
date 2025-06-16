class CPU {
    public int register = 0;                                        // 여기서 계산 수행
    public int[] memory = {5, 10, 0};                               // 저장 공간

    private static final int LOAD = 1;  // 로드                   // LOAD 의 메모리주소 1
    private static final int SAVE = 2;  // 저장
    private static final int ADD = 3;   // 더하기
    private static final int SUB = 4;   // 빼기
    private static final int HALT = 5;  // 중지                   // 탈출

    // 데이터의 이동?, 도착지 도있으면 어셈블리어??
    private int[][] program = {     // 2차원 배열
            {LOAD, 0},       // register = memory[0];
            {ADD, 1},       // resister = resister + memory[1];
            {SAVE, 2},       // memory[2] = register;
            {HALT, 0}       // stop program execution
    };

    public  void executeProgram() {
        int pc = 0;

        while(true){
            int opcode = program[pc][0];        // opcode 는 실행해야 할 명령어
            int operand = program[pc][1];       // operand 는 저장된 메모리 주소

            switch (opcode) {
                case LOAD :
                    register = memory[operand];
                    System.out.println("MOV: Loading memory[" + operand + "] (" + memory[0] + ") into register.");
                    break;
                case SAVE :
                    memory[operand] = register;
                    System.out.println("SAVE: Saving memory[" + operand + "] (" + memory[0] + ") from register.");
                    break;
                case ADD :
                    register = register + memory[operand];  // 레지스터에 주소를 더한다
                    System.out.println("ADD: Adding memory[" + operand + "] (" + memory[operand] + ") to register. New register value: " + register);
                    break;
                case SUB :
                    register = register - memory[operand];
                    System.out.println("SUB: Subtracting memory[" + operand + "] (" + memory[operand] + ") from register. New register value: " + register);
                    break;
                case HALT :
                    System.out.println("HALT: Stopping program execution.");
                    return;
                default:
                    System.out.println("Unknown instruction. Halting.");
                    return;
            }

            pc++;   // 계산수를 카운트 (다음 명령줄 인것처럼 구현)
        }
    }
}


public class Main {
    public static void main(String[] args) {
        CPU cpu = new CPU();

        cpu.executeProgram();

        System.out.println("Final memory state: memory[2] = " + cpu.memory[2]);

    }
}