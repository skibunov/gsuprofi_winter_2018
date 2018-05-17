package by.gsu.lesson12;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Sockets {

    public static void main(String[] args) throws IOException {
        InetAddress address
                = InetAddress.getByName("www.gsu.by");


        Socket socket = new Socket(address, 80);

        InputStream is = socket.getInputStream();

        byte[] buff = new byte[10000];
        is.read(buff);

        System.out.println(new String(buff));


    }
}
