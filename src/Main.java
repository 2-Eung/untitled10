class CPU {
    public int register = 0;                         // 여기서 계산 수행
    public int[] memory = {5, 10, 0};                // 저장 공간

    private static final int LOAD = 1;  // 로드       // LOAD 의 메모리주소 1
    private static final int SAVE = 2;  // 저장
    private static final int ADD = 3;   // 더하기
    private static final int SUB = 4;   // 빼기
    private static final int HALT = 5;  // 중지        // 탈출

    // 데이터의 이동방법, 데이터의 도착지     // 어셈블리어 와 유사
    private int[][] program = {     // 2차원 배열
            {LOAD, 0},       // register = memory[0];
            {ADD, 1},       // resister = resister + memory[1];
            {SAVE, 2},       // memory[2] = register;
            {HALT, 0}       // stop program execution
    };
    public  void executeProgram() {
        int pc = 0;

        while(true){
            int opcode = program[pc][0];  // opcode 는 실행해야 할 명령어
            int operand = program[pc][1]; // operand 는 메모리 주소
                                          // program[][n] 에서 n 이 주소가 아니다.
                                          // 그냥 과정을 쉽게 보여주려는 배열을위한 번호일뿐.
            switch (opcode) {
                case LOAD :         // 레지스터에 연산할값(메모리값) 을 집어넣는다.
                    register = memory[operand];
                    System.out.println("MOV: Loading memory[" + operand + "] = " + memory[0] + " into register, New resister : " + register);
                    break;
                case ADD :          // 레지스터에 저장된 값에 연산할값(메모리값) 을 더하고 다시 레지스터에 입력한다.
                    register = register + memory[operand];
                    System.out.println("ADD: Adding memory[" + operand + "] = " + memory[operand] + " to register. New register value : " + register);
                    break;
                case SAVE :         // 레지스터의 값을 메모리로 옮겨 저장한다.
                    memory[operand] = register;
                    System.out.println("SAVE: Saving memory[" + operand + "] from register. New register value : " + register);
                    break;
                 case SUB :         // 레지스터에 저장된 값에 연산할값(메모리값) 을 빼고 다시 레지스터에 입력한다.
                    register = register - memory[operand];
                    System.out.println("SUB: Subtracting memory[" + operand + "] (" + memory[operand] + ") from register. New register value : " + register);
                    break;
                case HALT :         // 다음 계산을 위해 레지스터를 비운다.
                    System.out.println("HALT: Stopping program execution. New register value : 0 ");
                default:            // 에러 발생하면 종료
                    System.out.println("Unknown instruction. Halting.");
                    return;
            }
            pc++;   // 계산수를 카운트 (순서대로 진행)
        }
    }
}
public class Main {
    public static void main(String[] args) {
        CPU cpu = new CPU();

        cpu.executeProgram();

        System.out.println("Final memory state: memory[2] = " + cpu.memory[2]);
        // 레지스터에서 계산 후 메모리[2] 에 옮겨진 값 출력
    }
}