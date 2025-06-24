package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Boolean> connection;

    public Line(List<Boolean> connection) {
        this.connection = new ArrayList<Boolean>(connection);
    }

    public boolean hasConnection(int index) {
        return connection.get(index);
    }

    public int getSize() {
        return connection.size();
    }
}
