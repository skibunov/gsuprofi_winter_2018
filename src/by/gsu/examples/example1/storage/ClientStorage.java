package by.gsu.examples.example1.storage;

import by.gsu.examples.example1.Storage;
import by.gsu.examples.example1.nothttp.Action;
import by.gsu.examples.example1.nothttp.request.AddRequest;
import by.gsu.examples.example1.nothttp.request.GetRequest;
import by.gsu.examples.example1.nothttp.request.RemoveRequest;
import by.gsu.examples.example1.nothttp.responce.GetAllResponse;
import by.gsu.examples.example1.nothttp.responce.SizeResponse;
import by.gsu.examples.example1.util.SocketHelper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ClientStorage<T extends Serializable> implements Storage<T> {

    private SocketHelper helper;

    public ClientStorage(String host, int port) {
        helper = new SocketHelper(host, port);
    }

    @Override
    public void add(T element) {
        helper.communicate(
            () -> new AddRequest<>(element),
            response -> {}
        );
    }

    @Override
    public void delete(int id) {
        helper.communicate(
            () -> new RemoveRequest(id),
            response -> {}
        );

    }

    @Override
    public int size() {
        AtomicInteger result = new AtomicInteger();

        helper.communicate(
            () -> new GetRequest(Action.SIZE),
            response -> result.set(((SizeResponse) response).getSize())
        );

        return result.get();
    }

    @Override
    public List<T> getAll() {
        List<T> result = new ArrayList<>();

        helper.communicate(
            () -> new GetRequest(Action.GET_ALL),
            response -> result.addAll(((GetAllResponse<T>) response).getData())
        );

        return result;
    }


}
