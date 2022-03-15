package server;

import java.io.*;

public class ClientThread extends Thread{
    final DataOutputStream dout;
    final DataInputStream dis;

    public ClientThread(DataInputStream dis, DataOutputStream dout){
        this.dout = dout;
        this.dis = dis;
    }

    @Override
    public void run() {
        
    }
    
}
