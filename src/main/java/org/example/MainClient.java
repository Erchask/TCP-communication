package org.example;

import java.io.*;
import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) {

        Client client = new Client("Chadi");
        client.connetti("localhost", 4000);

        System.out.println("Client connesso al server");

        try {
            PrintWriter writer = new PrintWriter(client.socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(client.socket.getInputStream()));
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print(Stile.BLU+"Scrivi messaggio: "+Stile.RESET);
                String messaggio = scanner.nextLine();

                writer.println(messaggio);

                if (messaggio.equalsIgnoreCase("esci")) {
                    break;
                }

                String risposta = reader.readLine();
                System.out.println("Server: " + risposta);
            }

            client.chiudi();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
