class ReadOnlyStudent {
    private final int score;

    public ReadOnlyStudent(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}

public class Main {
    public static void main(String[] args) {
        ReadOnlyStudent ros = new ReadOnlyStudent(90);

        System.out.println(ros.getScore());
    }
}