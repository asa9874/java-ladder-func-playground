package model;

import util.BooleansGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private final int laneCount;
    private final int height;
    private final List<Line> lines;

    private Ladder(final int laneCount, final int height, final List<Line> lines) {
        validateLadderScale(laneCount, height);
        validateNumberOfCreatedLines(lines, height);
        this.lines = lines;
        this.laneCount = laneCount;
        this.height = height;
    }

    public static Ladder of(final int laneCount, final int height, BooleansGenerator booleansGenerator) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.of(laneCount, booleansGenerator));
        }
        return new Ladder(laneCount, height, lines);
    }

    public static Ladder ofLines(final int laneCount, final int height, List<Line> lines) {
        return new Ladder(laneCount, height, lines);
    }

    public List<Integer> getPositionAfterExecute() {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < laneCount; i++) {
            int position = moveThroughLadder(i);
            result.add(position);
        }
        return result;
    }

    private int moveThroughLadder(int start) {
        int position = start;
        for (int row = 0; row < height; row++) {
            Line line = lines.get(row);
            position = moveHorizontally(line, position);
        }
        return position;
    }

    private int moveHorizontally(Line line, int position) {
        if (line.canMoveLeft(position)) return position - 1;
        if (line.canMoveRight(position)) return position + 1;
        return position;
    }

    private void validateLadderScale(final int laneCount, final int height) {
        if (laneCount < 2) throw new IllegalArgumentException("사다리의 레인은 2개이상이어야 합니다.");
        if (height < 1) throw new IllegalArgumentException("사다리의 높는 1이상이어야 합니다.");
    }

    private void validateNumberOfCreatedLines(final List<Line> lines, final int height) {
        if (lines.size() != height)
            throw new invalidLadderHeightException("제작된 라인의 갯수는 height 값과 일치해야합니다.");
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int getLaneCount() {
        return laneCount;
    }

    public int getHeight() {
        return height;
    }

    private static class invalidLadderHeightException extends IllegalArgumentException {
        public invalidLadderHeightException(final String s) {
            super(s);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Ladder ladder)) return false;
        return laneCount == ladder.laneCount && height == ladder.height && Objects.equals(getLines(), ladder.getLines());
    }

    @Override
    public int hashCode() {
        return Objects.hash(laneCount, height, getLines());
    }
}
