class Person {
    private String name;
    private int age;


    // 게터와 세터는 사용자가 메소드를 정의해서 사용해야 한다.
    public String getName() {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    // age 를 게터,세터 로 입출력 하는것과
    // 직접 입력받고 조건을 걸어서 출력하는것의 차이점을 느끼자 / 또, 이경우 굳이 private 로 해야하는가 도 생각해보자
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if (age < 18) {
            System.out.println("성인만 가입 가능.");
        } else {
            this.age = age;
        }
    }

}



public class Main {
    public static void main(String[] args) {
        Person person = new Person();

//        person.name = "응혁";                     // 직접접근 입력  // name 이 private 가되면 접근 불가
//        System.out.println(person.name);         // 직접접근 출력  // name 이 private 가되면 접근 불가

        person.setName("응혁");                   // 세터접근 입력
        System.out.println(person.getName());    // 게터접근 출력

        person.setAge(10)

    }
}
