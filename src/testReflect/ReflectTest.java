package testReflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {
    private String pri_color;

    protected void getPri_color() {
        System.out.println(pri_color);
    }

    public static Car initByDefaultConst() throws Throwable {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader); //AppClassLoader
        System.out.println(loader.getParent()); //ExtClassLoader
        System.out.println(loader.getParent().getParent()); //rootClassLoader is invisible in Java

        Class clazz = loader.loadClass("testReflect.Car");

        Constructor constructor = clazz.getDeclaredConstructor((Class[])null);
        Car car = (Car)constructor.newInstance();

        Method setBrand = clazz.getDeclaredMethod("setBrand", String.class);
        setBrand.setAccessible(true);
        setBrand.invoke(car, "Kayan");
        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car, "White");
        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class, String.class);
        setMaxSpeed.invoke(car, 200, "asd");
        return car;
    }

    public static void main(String[] args) throws Throwable {
        Car car = initByDefaultConst();
        car.introduce();
    }
}
