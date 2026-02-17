package org.example;

import java.io.*;
import java.net.Socket;

public class MainServer {

    public static void main(String[] args) {

        int porta = 4000;

        try {
            Server server = new Server(porta);
            System.out.println("Server in ascolto...");

            while (true) {
                Socket socket = server.attendi();
                System.out.println("Nuovo client connesso!");

                Thread t = new Thread(() -> gestisciClient(socket));
                t.start();
            }

        } catch (IOException e) {
            System.out.println("Errore durante la connessione");
        }
    }

    private static void gestisciClient(Socket socket) {

        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(
                    socket.getOutputStream(), true);

            String messaggio;

            while ((messaggio = reader.readLine()) != null) {

                if (messaggio.equalsIgnoreCase("esci")) {
                    writer.println("Connessione chiusa.");
                    break;
                }

                System.out.println("Client: " + messaggio);
                writer.println("Ricevuto: " + messaggio);
            }

            socket.close();

        } catch (IOException e) {
            System.out.println("Errore client");
        }
    }
}
