package someObj;

import java.io.*;

public class CreateLargeFile {
    public static void main(String[] args) throws Exception{
        DataOutputStream output = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream("largedata.dat")));

        for (int i = 0; i < 800004; i++)
            output.writeInt((int)(Math.random() * 1000000));

        output.close();

        DataInputStream input = new DataInputStream(
                new BufferedInputStream(new FileInputStream("largedata.dat")));

        int length = 0;
        int temp = 0;
        try {
            while ((temp = input.readInt()) != -1) {
                // System.out.print(temp + " ");
                length++;
            }
        } catch (EOFException e) {
            e.printStackTrace();
        }
        System.out.println(length);

        input.close();
    }


}
