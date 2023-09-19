package space.unai.connexions;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ConnClient {

    private static Scanner sc;
    public static int QUANTITY;

    public static void main(String[] args) {
        System.out.println("[SERVER] INIT CONNECTION");
        sc = new Scanner(System.in);

        QUANTITY = sc.nextInt();

        try {
            Socket sk = new Socket("127.0.0.1", 8100); // Abrimos socket para enviar


            byte b = 10;

            for (int i = 0; i < QUANTITY; i++) {
                OutputStream outStream = sk.getOutputStream(); // Instanciamos OutputStream
                outStream.write(b); // Escribimos byte en el Socket y enviamos
                System.out.println("Sent byte: " + b + " (" + sk.getInetAddress() + ":" + sk.getPort() + ")"); // Imprimimos por pantalla que hemos enviado
                b++;
                Thread.sleep(1000);
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
