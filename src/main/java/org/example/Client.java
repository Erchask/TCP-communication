package org.example;

import java.io.IOException;
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
            Socket socket=new Socket(nomeServer,portaServer);
            System.out.println("CLIENT: client connesso al server");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return portaServer;
    }
    void scrivi(){
        try {
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream);
            writer.print("ciao server");
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    void leggi(){
        /*
         try {
            InputStream inputStream =clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String testo= reader.readLine();
            System.out.println("Server ha letto dal client");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
         */
    }
    void chiudi(){

    }
}
