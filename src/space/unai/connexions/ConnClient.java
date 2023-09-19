package space.unai.connexions;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ConnClient {

    private static Scanner sc; // Declaramos scanner
    public static int QUANTITY = 1; // Declaramos cantidad en estático (declaramos por encima de uno para poder hacer start del servidor)

    public static void main(String[] args) {
        System.out.println("[SERVER] INIT CONNECTION");
        sc = new Scanner(System.in); // Inicializamos scanner

        System.out.println("[!] ¿Cuantos bytes quieres enviar?");
        QUANTITY = sc.nextInt(); // Pedimos datos al usuario

        try {
            Socket sk = new Socket("127.0.0.1", 8100); // Abrimos socket para enviar


            byte b = 10;

            for (int i = 0; i < QUANTITY; i++) {
                OutputStream outStream = sk.getOutputStream(); // Instanciamos OutputStream
                outStream.write(b); // Escribimos byte en el Socket y enviamos
                System.out.println("Sent byte: " + b + " (" + sk.getInetAddress() + ":" + sk.getPort() + ")"); // Imprimimos por pantalla que hemos enviado
                b++; // Iteramos el byte;
                Thread.sleep(1000); // Dormimos hilo
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
