package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket serverSocket;
    private Socket socket;
    Socket clientSocket;
    int porta;

    public Server(int porta) throws IOException {
        this.porta = porta;
        serverSocket = new ServerSocket(porta);

    }

    public Socket attendi(){
        try {
            socket = serverSocket.accept();

        } catch (IOException e) {
            //server non riesce ad instaurare la connessione con il client

        }
        return socket;
    }

    public void scrivi(){

    }
    public void leggi(){

    }
    public void chiudi(){

    }
    public void termina(){

    }
}
