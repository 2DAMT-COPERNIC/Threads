package space.unai.connexions;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class ConnClient {

    public static void main(String[] args) {
        System.out.println("[SERVER] INIT CONNECTION");

        try {
            Socket sk = new Socket("127.0.0.1", 8100);

            InputStream inStream = sk.getInputStream();
            OutputStream outStream = sk.getOutputStream();

            byte b = 1;

            outStream.write(b);

            System.out.println("Sent byte: " + b);

            sk.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
