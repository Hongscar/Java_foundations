package mySocket;

import sun.reflect.generics.scope.Scope;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class MultiThreadServer {
    private  static int clientNo = 0;

    static class HandleAClient implements Runnable {
        private Socket socket;

        public HandleAClient(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

                //Continuous serve the client
                while (true) {

                    double radius = inputStream.readDouble();

                    double area = radius * radius * Math.PI;

                    outputStream.writeDouble(area);
                    System.out.println("radius received from client: " + radius);
                    System.out.println("Area found: " + area);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8000);
                System.out.println("MultiThreadServer started at " + new Date());

                while (true) {
                    Socket socket = serverSocket.accept();
                    clientNo++;
                    System.out.println("Starting thread for client " + clientNo +
                        " at " + new Date());
                    InetAddress inetAddress = socket.getInetAddress();
                    System.out.println("Client " + clientNo + "'s host name is " +
                        inetAddress.getHostName());
                    System.out.println("Client " + clientNo + "'s IP Address is " +
                        inetAddress.getHostAddress());

                    //Create and start a new thread for the connection
                    new Thread(new HandleAClient(socket)).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
