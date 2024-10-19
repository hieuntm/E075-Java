package day6.baitap.BT3;


public class Rectangle implements Shape {
    double width;
    double length;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public void ShowArea() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                '}';
    }
}
