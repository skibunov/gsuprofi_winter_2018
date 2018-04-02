package by.gsu.lesson12;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8081);

        while (true) {
            Socket accept = server.accept();

            OutputStream os = accept.getOutputStream();
            InputStream is = accept.getInputStream();

            byte[] buff = new byte[10000];
            is.read(buff);

            System.out.println(new String(buff));

            os.write("Hello!".getBytes());
            os.flush();

            accept.close();
        }


    }
}
