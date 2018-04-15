package by.gsu.examples.example1.nothttp.responce;

import java.io.Serializable;
import java.util.List;

public class GetAllResponse<T extends Serializable>
        extends Response {

    private List<T> data;

    public void setData(List<T> data) {
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }
}
