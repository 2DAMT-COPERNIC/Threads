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
            ServerSocket ssk = new ServerSocket(8100);
            Socket sk = ssk.accept();

            InputStream inStream = sk.getInputStream();
            OutputStream outStream = sk.getOutputStream();

            byte leido = (byte) inStream.read();

            System.out.println("Read byte: " + leido);

            sk.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
