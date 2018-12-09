package mySocket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server{
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8000);

                System.out.println("Server started at " + new Date());
                Socket socket = serverSocket.accept();
                System.out.println("A client connect!");

//                InetAddress inetAddress = socket.getInetAddress();
//                System.out.println("Client's host name is " + inetAddress.getCanonicalHostName());
//                System.out.println("Client's host name is " + inetAddress.getHostName());
//                System.out.println("Client's IP address is " + inetAddress.getHostAddress());
//                System.out.println("Client's address is " + inetAddress.getAddress());

                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

                while (true) {
                    double radius = inputFromClient.readDouble();

                    double area = radius * radius * Math.PI;

                    outputToClient.writeDouble(area);

                    System.out.println("Radius received from client: " + radius);
                    System.out.println("Area is: " + area);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
