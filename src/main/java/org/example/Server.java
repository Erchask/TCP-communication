package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
        try {
            InputStream inputStream =clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String testo= reader.readLine();
            System.out.println("Server ha letto dal client");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void chiudi(){
        try {
            socket.close();
        } catch (IOException e) {
           System.err.println("errore nella chiusura del socket");
        }
    }
    public void termina(){
        try {
            serverSocket.close();
        } catch (IOException e) {
            System.err.println("errore nella chiusura del socket della connessione");
        }
    }
}
