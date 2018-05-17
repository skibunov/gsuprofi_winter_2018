package by.gsu.examples.example1;

import by.gsu.examples.example1.auto.Car;
import by.gsu.examples.example1.nothttp.*;
import by.gsu.examples.example1.nothttp.request.AddRequest;
import by.gsu.examples.example1.nothttp.request.GetRequest;
import by.gsu.examples.example1.nothttp.request.RemoveRequest;
import by.gsu.examples.example1.nothttp.request.Request;
import by.gsu.examples.example1.nothttp.responce.EmptyResponse;
import by.gsu.examples.example1.nothttp.responce.GetAllResponse;
import by.gsu.examples.example1.nothttp.responce.Response;
import by.gsu.examples.example1.nothttp.responce.SizeResponse;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SimpleServer<T extends Serializable> {

    List<T> list = new CopyOnWriteArrayList<>();


    public void start(int port) throws Exception {
        ServerSocket serverSocket = new ServerSocket(port);
        while (!Thread.interrupted()) {
            Socket accept = serverSocket.accept();

            new Thread(() -> {
                try {
                    InputStream is = accept.getInputStream();
                    ObjectInputStream ois = new ObjectInputStream(is);

                    Request request = (Request) ois.readObject();

                    Response response = processRequest(request);

                    OutputStream os = accept.getOutputStream();
                    ObjectOutputStream oos = new ObjectOutputStream(os);

                    oos.writeObject(response);
                    oos.flush();

                    accept.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    private Response processRequest(Request request) {
        Action action = request.getAction();
        Response result = null;
        switch (action) {
            case ADD: {
                result = processAdd((AddRequest<T>) request);
                break;
            }
            case REMOVE: {
                result = processRemove((RemoveRequest) request);
                break;
            }
            case SIZE: {
                result = processSize((GetRequest) request);
                break;
            }
            case GET_ALL: {
                result = processGetAll((GetRequest) request);
                break;
            }
            default: throw new IllegalArgumentException();
        }
        return result;
    }

    private EmptyResponse processAdd(AddRequest<T> request) {
        try {
            T data = request.getData();
            list.add(data);
            return new EmptyResponse();
        } catch (Exception e) {
            return new EmptyResponse(e.getMessage());
        }
    }

    private EmptyResponse processRemove(RemoveRequest request) {
        try {
            int id = request.getId();
            list.remove(id);
            return new EmptyResponse();
        } catch (Exception e) {
            return new EmptyResponse(e.getMessage());
        }
    }

    private SizeResponse processSize(GetRequest request) {
        return new SizeResponse(list.size());
    }

    private GetAllResponse<T> processGetAll(GetRequest request) {
        GetAllResponse<T> response = new GetAllResponse<>();
        try {

            ArrayList<T> ts = new ArrayList<>(list);
            response.setData(ts);
        } catch (Exception e) {
            response.setStatus(Status.FAILURE);
            response.setMessage(e.getMessage());
        }
        return response;

    }


    public static void main(String[] args) throws Exception {
        SimpleServer<Car> carServer = new SimpleServer<>();
        carServer.start(8081);
    }
}
