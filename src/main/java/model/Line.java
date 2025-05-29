package model;

import model.dto.LineDto;
import util.BooleansGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {
    private final List<Boolean> points;

    private Line(final List<Boolean> points) {
        this.points = new ArrayList<>(points);
    }

    public static Line of(final int laneCount, BooleansGenerator booleansGenerator) {
        int pointCount = laneCount - 1;
        List<Boolean> points = booleansGenerator.generateBooleans(pointCount);
        validatePointsSize(points, laneCount);
        return new Line(points);
    }

    public LineDto toDto() {
        return new LineDto(getPoints());
    }

    public boolean canMoveLeft(int position) {
        return position > 0 && points.get(position - 1);
    }

    public boolean canMoveRight(int position) {
        return position < points.size() && points.get(position);
    }

    private static void validatePointsSize(final List<Boolean> points, final int width) {
        if (points.size() != width - 1) throw new invalidLineWidthException("라인의 사이즈는 width-1이어야 합니다.");
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }

    private static class invalidLineWidthException extends IllegalArgumentException {
        public invalidLineWidthException(final String s) {
            super(s);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Line line)) return false;
        return Objects.equals(getPoints(), line.getPoints());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPoints());
    }
}
