package space.unai.connexions.suma_resta;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Servidor
        int serverPort = 8081; // Puerto

        try (Socket socket = new Socket(serverAddress, serverPort)) { // Probar que funcione la conexión, si existe que proceda
            Scanner scanner = new Scanner(System.in); // Initialize scanner
            // Data Stream
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Auxiliares
            int value;
            String operador;

            System.out.println("[?] Introduce el operador (+, -, /, *):");
            operador = scanner.next(); // Declarar operador
            out.writeUTF(operador);

            do {
                System.out.print("[?] Introduce un entero (0 para finalizar): "); // Introducir número
                value = scanner.nextInt();
                out.writeInt(value); // Enviado

                int receivedSum = in.readInt(); // Recibir que ha recibido el número
                System.out.println("=====================================");
                System.out.println("[!] Calculo recibido del servidor: " + receivedSum);

            } while (value != 0); // Mientras el value no sea 0

            in.close(); // Cerrar instancias
            out.close();
            scanner.close();

        } catch (IOException e) {
            System.out.println("[!] Error: " + e.getMessage()); // Cazar errores
        }
    }
}
