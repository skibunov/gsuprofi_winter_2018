package by.gsu.examples.example1.nothttp.request;

import by.gsu.examples.example1.nothttp.Action;

import java.io.Serializable;

public abstract class Request implements Serializable {
    private final Action action;

    public Request(Action action) {
        this.action = action;
    }

    public Action getAction() {
        return action;
    }
}
