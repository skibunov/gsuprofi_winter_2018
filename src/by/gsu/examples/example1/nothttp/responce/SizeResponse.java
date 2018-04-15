package by.gsu.examples.example1.nothttp.responce;

public class SizeResponse extends Response {
    private int size;

    public SizeResponse() {
    }

    public SizeResponse(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
