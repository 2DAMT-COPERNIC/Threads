package space.unai.connexions;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnServer {

    public static void main(String[] args) {
        System.out.println("[SERVER] INIT CONNECTION");

        try {
            ServerSocket ssk = new ServerSocket(8100); // Instanciamos el servidor
            Socket sk = ssk.accept(); // Abrimos socket para recibir

            InputStream inStream = sk.getInputStream(); // Instanciamos el InputStream

            byte leido = (byte) inStream.read(); // Leemos el InputStream

            System.out.println("Read byte: " + leido); // Soltamos por pantalla

            sk.close(); // Cerramos socket
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
