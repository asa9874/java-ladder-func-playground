package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(int width, int height) {
        validate(width, height);
        lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.from(width - 1));
        }
    }

    private void validate(int width, int height) {
        if (width <= 1) {
            throw new IllegalArgumentException("사다리의 너비는 1보다 커야 합니다.");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("사다리의 높이는 0보다 커야 합니다.");
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
