package someObj;

public class Rectangle extends GeometricObject{
    private double length;
    private double width;
    private double area;

    public Rectangle() {

    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getArea() {
        return area;
    }

    public void setLength(double length) {
        this.length = length;
        setArea(length * getWidth());
    }

    public void setWidth(double width) {
        this.width = width;
        setArea(width * getLength());
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Rectangle(double l, double w) {
        this.length = l;
        this.width = w;
        this.area = l * w;
    }


}
