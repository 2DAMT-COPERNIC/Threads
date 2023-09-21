package space.unai.connexions.pol;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;


// @author iamnoddy

public class ServerConn {
    public static void main(String[] args) throws IOException {
        System.out.println("Incia Servidor");

        ServerSocket ssk = new ServerSocket(8100); // Abrir ServerSocket
        while (true) { // Bucle infinito
            Socket sk = ssk.accept(); // Aceptar socket
            Server sv = new Server(sk); // Abrir servidor
            sv.start(); // Encender Hilo
        }
    }

    public static class Server extends Thread {
        private Socket sk;

        Server( Socket sk) {
            this.sk = sk;
        }

        @Override
        public void run() {
            InputStream is;
            try {
                is = sk.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(is); // Convertir el InputStream en metadatos

                System.out.println("[!] Datos recibidos (" + dataInputStream.readUTF() + ")"); // Leer datos

                sk.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}