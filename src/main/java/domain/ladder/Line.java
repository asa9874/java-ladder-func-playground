package domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Boolean> points;
    private final Random RANDOM = new Random();

    public Line(int width) {
        this.points = createLine(width);
    }

    private List<Boolean> createLine(int width) {
        List<Boolean> linePoints = new ArrayList<>();

        boolean previousPoint = false; //이전에 가로선 있었는지

        for (int i = 0; i < width - 2; i++) {
            boolean point = RANDOM.nextBoolean() && !previousPoint;
            linePoints.add(point);
            previousPoint = point;
        }
        linePoints.add(false);

        return linePoints;
    }

    public boolean isAbleToMoveRight(int currentPoint) {
        return (currentPoint < points.size() - 1) && points.get(currentPoint);
    }

    public boolean isAbleToMoveLeft(int currentPoint) {
        return (currentPoint > 0) && points.get(currentPoint - 1);
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }

}
