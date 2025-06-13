class Shape {
    public double area() {
        return 0;                               // 어짜피 오버라이딩되니까 상관없나???
    }
}
class Circle extends Shape {
    double r;

    public Circle (double r) {
        this.r = r;
    }
    @Override
    public double area() {
        return Math.PI*r*r;
    }
}
class Rectangle extends Shape {

    double v;
    double h;

    public Rectangle(double v,double h){
        this.v = v;
        this.h = h;
    }
    @Override
    public double area () {
        return v*h;
    }
}
public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];

        shapes[0] = new Circle(3);              // 왜갑자기 바꿔...
        shapes[1] = new Rectangle(3, 4);

        for (Shape shape : shapes) {
            System.out.println(shape.area());
        }
    }
}