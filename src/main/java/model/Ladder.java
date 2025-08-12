package model;

import java.util.List;
import java.util.stream.Stream;

public class Ladder {
    
    private final List<Line> lines;

    public Ladder(int height, int width) {
        this.lines = Stream.generate(() -> new Line(width))
                .limit(height)
                .toList();
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
