package model.ladder;

import model.MovingDirection;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

public class HorizontalLine {

    private final List<Link> points;
    private final EnumSet<MovingDirection> movingDirections;

    public HorizontalLine(List<Link> points) {
        this.points = points;
        this.movingDirections = EnumSet.allOf(MovingDirection.class);
    }

    public int move(int position) {
        return movingDirections.stream()
                .filter(movingDirection -> movingDirection.canMove(position, this))
                .findFirst()
                .map(movingDirection -> movingDirection.move(position))
                .orElse(position);
    }

    public int size() {
        return points.size();
    }

    public Link getLink(int index) {
        return points.get(index);
    }

    public List<Link> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
