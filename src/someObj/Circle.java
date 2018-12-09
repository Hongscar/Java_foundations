package someObj;

public class Circle extends GeometricObject{
    private double radius;
    private double area;
    public static double PI = 3.1415;

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
        this.area = PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        setArea(PI * radius * radius);
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
