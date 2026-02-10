package org.example;

public class MainClient {
    public static void main(String[] args) {
        Client client= new Client("Chadi");
        client.connetti("localHost",4000);
    }
    }
