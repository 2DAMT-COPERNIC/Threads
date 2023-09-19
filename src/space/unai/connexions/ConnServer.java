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
            ServerSocket ssk = new ServerSocket(8100);
            int n = 5;
            while (n > 0) {
                Socket sk = ssk.accept();
                Server sv = new Server(sk);
                sv.start();
                n--;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static class Server extends Thread {
        private Socket sk;
        private InputStream in;
        private OutputStream os;

        public Server(Socket sk) {
            this.sk = sk;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < ConnClient.QUANTITY; i++) {
                    in = sk.getInputStream();
                    os = sk.getOutputStream();

                    System.out.println("Leido byte (" + sk.getInetAddress() + ":" + sk.getPort() + "): " + in.read());
                }
                sk.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
