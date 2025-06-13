class Animal {
    public void makeSound() {
        System.out.println();
    }
}
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("멍멍");
    }
}
class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("야옹");
    }
}
class Quokka extends Animal {
    @Override
    public void makeSound() {
        System.out.println("ㅎㅎㅎ");
    }
}
public class Main {
    public static void main(String[] args) {
        Animal a1 = new Dog();          // 타입은 Animal 을 취하지만 내용은 Dog 으로 이루어짐
        Animal a2 = new Cat();          // 내용이 다른것들이 하나의 Animal 타입으로 만드는,관리하는 것이 다형성
        Animal a3 = new Quokka();

        // a2 = new cat(); // ??? 이게 머지

// 장점 : 배열에 넣어 관리 할 수 있다.

        Animal[] animals = {a1, a2, a3};
        for (Animal animal : animals) { // for ( 클래스 요소명 : 배열) {
            animal.makeSound();         // 요소.기능()                  // 요소의 기능을 전부 실행
        }                               // }
//        for (int i = 0; i<animals.length; i++) {  위랑 동일한 기능
//            animals[i].makeSound();
//        }

// 번외 : Dog 랑 Cat 합쳐서 키메라 만들수 있나?? : 이를 다중상속 이라고 하는데 자바에서는 지원하지 않는다.
// 만든다고 한다면 Class 키메라 를 만들어서 @개특성, @고양이특성 을 추가한다.
// 이번경우에는 만약에 만들면 울음소리를 개로 할지 고양이로 할지



        a1.makeSound();
        a2.makeSound();
        a3.makeSound();
    }
}