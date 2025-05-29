package model.dto;

import java.util.List;

public class LineDto {
    private final List<Boolean> points;

    public LineDto(final List<Boolean> points) {
        this.points = points;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}

