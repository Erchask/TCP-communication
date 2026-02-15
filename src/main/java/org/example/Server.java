package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket serverSocket;
    Socket clientSocket;
    int porta;

    public Server(int porta) throws IOException {
        this.porta = porta;
        serverSocket = new ServerSocket(porta);

    }

    public Socket attendi(){
        try {
            clientSocket = serverSocket.accept();

        } catch (IOException e) {
            //server non riesce ad instaurare la connessione con il client

        }
        return clientSocket;
    }

  public void scrivi(String messaggio) {
    try {
        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
        writer.println(messaggio);
    } catch (IOException e) {
        System.err.println("Errore invio messaggio al client: " + e.getMessage());
    }
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
            clientSocket.close();
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
