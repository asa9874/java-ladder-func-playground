package domain;

import java.util.List;

public class Player {
    private final Name name;
    private final Position position;

    public Player(Name name, Position position) {
        this.position = position;
        this.name = name;
    }

    public void downLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            checkAndMove(line);
        }
    }

    public void checkAndMove(Line line) {
        List<Point> points = line.getPoints();
        if (checkLeft(points)) {
            position.moveLeft();
            return;
        }
        if (checkRight(points)) {
            position.moveRight();
        }
    }

    public boolean checkLeft(List<Point> points) {
        Point leftPoint = null;
        if (position.getPosition() > 0) {
            leftPoint = points.get(position.getPosition() - 1);
        }

        return leftPoint != null && leftPoint.isMovable();
    }

    public boolean checkRight(List<Point> points) {
        Point rightPoint = null;
        if (position.getPosition() < points.size()) {
            rightPoint = points.get(position.getPosition());
        }

        return rightPoint != null && rightPoint.isMovable();
    }

    public boolean hasName(Name other) {
        return name.equals(other);
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }
}
