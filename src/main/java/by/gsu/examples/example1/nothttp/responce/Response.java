package by.gsu.examples.example1.nothttp.responce;

import by.gsu.examples.example1.nothttp.Status;

import java.io.Serializable;

public abstract class Response implements Serializable {
    private Status status = Status.SUCCESS;
    private String message;

    public Response() {
    }

    public Response(Status status, String message) {
        this.status = status;
        this.message = message;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
