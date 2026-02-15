package org.example;

import java.io.IOException;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args) {
        int porta =4000;
        Server server ;
        try {
            server = new Server(porta);
            System.out.println(Stile.BIANCO + Stile.SfondoG + "Server in ascolto" + Stile.RESET);
            Socket socket= server.attendi();
            System.out.println(Stile.BIANCO + Stile.SfondoV + "Server connesso al client" + Stile.RESET);
            server.leggi();
	    server.scrivi(Stile.SfondoB + "GASI, benventuo sul server"+ Stile.RESET);
	    server.chiudi();

        } catch (IOException e) {
	System.out.println(Stile.ROSSO +Stile.GRASSETTO +Stile.SOTTOLINEATO + "Errore durante la connessione" + Stile.RESET);
            System.exit(1);
        }


    }
}
