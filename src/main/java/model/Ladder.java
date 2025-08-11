package model;

import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public boolean isPoint(int lineIndex, int pointIndex) {
        if (lineIndex < 0 || lineIndex >= lines.size()) {
            throw new IndexOutOfBoundsException("인덱스 범위 초과");
        }
        return lines.get(lineIndex).isPoint(pointIndex);
    }
}
