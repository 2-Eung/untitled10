class Example {
   public int a = 1;
   protected int b = 2;
   int c = 3;
   private int d = 4;
}

public class Main {
    public static void main(String[] args) {
        Example ex = new Example();

        System.out.println(ex.a);
        System.out.println(ex.b);
        System.out.println(ex.c);
     // System.out.println(ex.d); // 다른클래스여서 접근 불가
    }
}
