abstract class Animal {
    abstract void makeSound();

    public void sleep() {
        System.out.println("자는중 Zz...");
    }
}
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("왈왈");
    }
}

public class Main {
    public static void main(String[] args){
        Animal dog = new Dog();

        dog.makeSound();
        dog.sleep();
    }
}