package server;

import java.net.*;
import java.io.*;

public class Server {
    
    private ServerSocket server;
    private final int portNum = 3333;

    public void startServer() throws Exception {
        this.server = new ServerSocket(portNum);
        System.out.println("Starting socket server at port : " + portNum);
        while (true) {
            this.createClientThreads();
        }
    }

    private void createClientThreads() throws Exception {
        Socket s = null;
        try {
            s = this.server.accept();
            System.out.println("A new client is connected : " + s);
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            System.out.println("Assigning new thread for this client..");
            Thread t = new ClientThread(dis, dout);
            t.start();
        } catch (Exception e) {
            e.printStackTrace();
            s.close();
        }
    }
}
