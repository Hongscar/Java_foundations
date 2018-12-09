package mySocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        DataOutputStream toServer = null;
        DataInputStream fromServer = null;
        Scanner input = new Scanner(System.in);

        try {
            Socket socket = new Socket("localhost", 8000);

            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());
            input = new Scanner(System.in);
            System.out.println("connect the server successful.");
            System.out.println("local port: " + socket.getLocalPort());
        } catch (IOException e) {
            System.err.println("Connect refused!");
            e.printStackTrace();
        }

        DataOutputStream finalToServer = toServer;
        Scanner finalInput = input;
        DataInputStream finalFromServer = fromServer;
        new Thread(() -> {
            try {
                double radius;
                while (true) {
                    radius = finalInput.nextDouble();
                    System.out.println("radius is : " + radius);
                    finalToServer.writeDouble(radius);
                    finalToServer.flush();

                    double area = finalFromServer.readDouble();
                    System.out.println("Area received from the server is " + area);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
