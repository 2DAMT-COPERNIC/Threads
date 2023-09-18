package space.unai.connexions;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ConnClient {

    public static void main(String[] args) {
        System.out.println("[SERVER] INIT CONNECTION");

        try {
            Socket sk = new Socket("127.0.0.1", 8100); // Abrimos socket para enviar

            OutputStream outStream = sk.getOutputStream(); // Instanciamos OutputStream

            byte b = 1; // Contenido para enviar

            outStream.write(b); // Escribimos byte en el Socket y enviamos

            System.out.println("Sent byte: " + b); // Imprimimos por pantalla que hemos enviado

            sk.close(); // Cerramos socket
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
