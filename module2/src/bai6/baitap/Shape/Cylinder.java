package bai6.baitap.Shape;

public class Cylinder extends Circle{
    public double height;
    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height=height;

    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                '}';
    }
}
