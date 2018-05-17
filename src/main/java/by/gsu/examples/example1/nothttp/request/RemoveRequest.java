package by.gsu.examples.example1.nothttp.request;

import by.gsu.examples.example1.nothttp.Action;

public class RemoveRequest extends Request {
    private final int id;

    public RemoveRequest(int id) {
        super(Action.REMOVE);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
