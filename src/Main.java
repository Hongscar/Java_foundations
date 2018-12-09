import testReflect.ReflectTest;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Main {
    public static <E> void test(E var) {
        System.out.println(var);
    }

    public static void main(String[] args) throws Throwable{
//        DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("in.txt")));
//        output.writeUTF("John");
//        output.writeDouble(85.5);
//
//        output.close();
//
//
//        DataInputStream input = new DataInputStream(new FileInputStream("in.txt"));
//        int value = 0;
////        while((value = input.readInt()) != -1) {
////            System.out.println(value);
////        }
//        System.out.println(input.readUTF());
//        System.out.println(input.readDouble());
//        if(args.length != 2) {
//            System.out.println("Usage:java copy sourceFile targetfile");
//            System.exit(0);
//        }
//
//        File sourceFile = new File(args[0]);
//        if(!sourceFile.exists()) {
//            System.out.println("Source file " + args[0] + "not exist");
//            System.exit(0);
//        }
//
//        File targetFile = new File(args[1]);
//        if(targetFile.exists()) {
//            System.out.println("Target File " + args[1] + " already exists");
//            System.exit(0);
//        }
//
//        DataInputStream inputStream =
//                new DataInputStream(new BufferedInputStream(new FileInputStream(sourceFile)));
//
//        DataOutputStream outputStream =
//                new DataOutputStream((new BufferedOutputStream(new FileOutputStream(targetFile))));
//
//        int r;
//        int numberOfBytesCopied = 0;
//        while((r = inputStream.read()) != -1) {
//            outputStream.write((byte)r);
//            numberOfBytesCopied++;
//        }
//        inputStream.close();
//        outputStream.close();
//
//        System.out.println(numberOfBytesCopied + " bytes copied");

//        ArrayList<String> list = new ArrayList<>();
//        list.add(new String("asd"));
//       // list.add(3);
//        String s = list.get(0);
//        System.out.println(s);
        //test("asd");

//        int hashCode = 1010110;
//       // hashCode = hashCode >> 2;
//        System.out.println(Integer.toBinaryString(hashCode));
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("testReflect.ReflectTest");
        ReflectTest reflectTest = (ReflectTest)clazz.newInstance();
        Field color = clazz.getDeclaredField("pri_color");

        color.setAccessible(true);
        color.set(reflectTest, "red");

        Method method = clazz.getDeclaredMethod("getPri_color", (Class[]) null);

        method.setAccessible(true);
        method.invoke(reflectTest, (Object[]) null);
    }
}
