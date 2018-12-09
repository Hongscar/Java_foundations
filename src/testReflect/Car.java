package testReflect;


public class Car {
    private String brand;
    private String color;
    private int maxSpeed;

    public Car(String brand, String color, int maxSpeed) {
        this.brand = brand;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public Car() {

    }

    public void introduce() {
        System.out.println("brand: " + getBrand());
        System.out.println("color: " + color);
        System.out.println("maxSpeed: " + maxSpeed);
    }

    private String getBrand() {
        return brand;
    }

    protected void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed, String str) {
        this.maxSpeed = maxSpeed;
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.setBrand("kayan");
        car.introduce();

        Car car1 = new Car("kayan", "black", 2900);
        car1.introduce();

    }
}
