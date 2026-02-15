package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    String nome;
    String colore;
    Socket socket;

    public Client(String nome){
        this.nome=nome;
    }
    int connetti(String nomeServer, int portaServer)  {
        try {
            this.socket=new Socket(nomeServer,portaServer);
            System.out.println("CLIENT: client connesso al server");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return portaServer;
    }
    void scrivi(){
        try {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("ciao server");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    void leggi() {
    try {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String risposta = reader.readLine();
        System.out.println("Risposta dal server: " + risposta);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}

    void chiudi(){
	try {
		socket.close();
	} catch (IOException e) {
		
		e.printStackTrace();
	}

    }
}
