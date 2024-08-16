package bai6.baitap.Shape;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(2, "red");
        System.out.println(circle.getRadius());
        System.out.println(circle.getColor());
        System.out.println(circle);
        Cylinder cylinder = new Cylinder(3,"blue",3);
        System.out.println(cylinder.getRadius());
        System.out.println(cylinder.getHeight());
        System.out.println(cylinder.getColor());
        System.out.println(cylinder);
    }
}
