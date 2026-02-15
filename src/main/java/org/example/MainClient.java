package org.example;

public class MainClient {
    public static void main(String[] args) {
        Client client= new Client("Chadi");
        client.connetti("localHost",4000);
	System.out.println(Stile.BIANCO + Stile.SfondoV + "Client connesso al server" + Stile.RESET);
	client.scrivi();
	client.leggi();
	
    }
    }
