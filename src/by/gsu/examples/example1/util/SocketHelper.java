package by.gsu.examples.example1.util;

import by.gsu.examples.example1.nothttp.Status;
import by.gsu.examples.example1.nothttp.request.Request;
import by.gsu.examples.example1.nothttp.responce.Response;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SocketHelper {
    private final String host;
    private final int port;

    public SocketHelper(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void communicate(Supplier<Request> requestSupplier, Consumer<Response> responseConsumer) {
        try (Socket socket = new Socket(host, port)) {

            processRequest(socket, requestSupplier);
            processResponse(socket, responseConsumer);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void processRequest(Socket socket, Supplier<Request> requestSupplier) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        Request request = requestSupplier.get();

        oos.writeObject(request);
        oos.flush();
    }

    private void processResponse(Socket socket, Consumer<Response> responseConsumer) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        Response response = (Response) ois.readObject();
        if (checkStatus(response)) {
            responseConsumer.accept(response);
        }
    }

    private boolean checkStatus(Response response) {
        boolean success = Status.SUCCESS.equals(response.getStatus());
        if (!success) {
            System.out.println("Failure! " + response.getMessage());
        }
        return success;
    }
}
