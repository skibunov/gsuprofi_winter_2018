package by.gsu.examples.example1.nothttp.responce;

import by.gsu.examples.example1.nothttp.Status;

public class EmptyResponse extends Response {

    public EmptyResponse() {
    }

    public EmptyResponse(String message) {
        super(Status.FAILURE, message);
    }
}
