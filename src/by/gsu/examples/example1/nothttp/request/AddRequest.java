package by.gsu.examples.example1.nothttp.request;

import by.gsu.examples.example1.nothttp.Action;

import java.io.Serializable;

public class AddRequest<T extends Serializable> extends Request {
    private final T data;


    public AddRequest(T data) {
        super(Action.ADD);
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
