package space.unai.connexions.suma_resta;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 8081; // Puerto

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("[!!] Servidor online. Esperando conexiones...");

            Socket clientSocket = serverSocket.accept(); // Aceptar zocalo
            System.out.println("[!] Cliente conectado (" + clientSocket.getInetAddress() + ":" + clientSocket.getPort() + ")"); // Avisar que se ha conectado alguien

            // Data Streams
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // Auxiliares y operador
            int calc = 0;
            int receivedValue;
            String receivedOperator = in.readUTF();

            do {
                receivedValue = in.readInt(); // Recibir valores
                System.out.println("[!] Recibido: " + receivedValue); // Valor recibido
                System.out.println("-----------------");

                switch (receivedOperator) { // Depende el operador cambiar la operación
                    case "+":
                        calc += receivedValue;
                        break;
                    case "-":
                        if (calc == 0) { // Evitar restar 0
                            calc = receivedValue;
                        } else {
                            calc -= receivedValue;
                        }
                        break;
                    case "/":
                        if (calc == 0) { // Evitar dividir por 0
                            calc = receivedValue;
                        } else {
                            calc /= receivedValue;
                        }
                        break;
                    case "*":
                        if (calc == 0) { // Evitar multiplicar por 0
                            calc = receivedValue;
                        } else {
                            calc *= receivedValue;
                        }
                        break;
                }
                out.writeInt(calc); // Enviar calculo
            } while (receivedValue != 0); // Mientras no sea 0 el valor recibido

            System.out.println(" ");
            System.out.println(" ");
            System.out.println("[?] Calculo total enviada al cliente: " + calc); // Avisar del calculo total enviado

            // Cerrar código
            in.close();
            out.close();
            clientSocket.close();

        } catch (IOException e) {
            System.out.println("[!] ERROR: " + e.getMessage()); // Cazar errores
        }
    }
}
