package model;

import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public boolean isPoint(int index) {
        if (index < 0 || index >= points.size()) {
            throw new IndexOutOfBoundsException("인덱스 범위 초과");
        }
        return points.get(index);
    }
}
