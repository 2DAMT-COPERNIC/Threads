package space.unai.connexions.pol;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

// @author iamnoddy

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Incia Client");

        Socket sk = new Socket("localhost", 8100); // Conectar al servidor

        OutputStream os = sk.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(os); // Convertir OutputStream en metadatos

        dataOutputStream.writeUTF("Buenas 22/09/2023 00:00 Quevedo con el Saiko"); // Contenido a enviar
        System.out.println("[!] Datos enviados");

        sk.close();
    }
}
