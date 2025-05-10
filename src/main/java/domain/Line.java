package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points =  points;
    }

    public static Line from(int width) {
        return new Line(createRandomLine(width));
    }

    private static List<Point> createRandomLine(int width) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(PointState.randomState()));
        for (int i = 1; i < width; i++) {
            Point lastState = points.get(points.size() - 1);
            PointState newState = generateNextState(lastState);
            points.add(new Point(newState));
        }
        return points;
    }

    private static PointState generateNextState(Point lastPoint) {
        if (lastPoint.isMovable()) {
            return PointState.NOT_MOVABLE;
        }
        return PointState.randomState();
    }

    public List<Point> getPoints() {
        return points;
    }
}
