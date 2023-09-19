package space.unai.connexions;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnServer {

    public static void main(String[] args) {
        try {
            System.out.println("[!] SERVER CONNECTION IS NOW ONLINE");
            ServerSocket ssk = new ServerSocket(8100); // Abrimos Server
            int n = ConnClient.QUANTITY; // Iteramos hasta
            while (n > 0) {
                Socket sk = ssk.accept(); // Aceptamos Socket
                Server sv = new Server(sk); // Abrimos Server
                sv.start(); // Starteamos el Thread
                n--;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static class Server extends Thread {

        // Declaraciones de variables
        private Socket sk;
        private InputStream in;
        private OutputStream os;

        public Server(Socket sk) {
            this.sk = sk; // Seteamos el socket
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < ConnClient.QUANTITY; i++) { // Declaramos cuantas veces se va a iterar
                    in = sk.getInputStream(); // Declaramos el input
                    os = sk.getOutputStream(); // Declaramos el output

                    System.out.println("Leido byte (" + sk.getInetAddress() + ":" + sk.getPort() + "): " + in.read()); // Imprimimos por pantalla
                }
                sk.close(); // Cerramos socket
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
