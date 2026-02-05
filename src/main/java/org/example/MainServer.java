package org.example;

import java.io.IOException;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args) {
        int porta =4000;
        Server server ;
        try {
            server = new Server(porta);
            System.out.println("Server in ascolto");
            Socket socket= server.attendi();
            System.out.println("Server connesso al client");

        } catch (IOException e) {
            System.exit(1);
        }


    }
}
