package model;

import model.ladder.HorizontalLine;
import model.ladder.Link;

public enum MovingDirection {

    RIGHT(1, (index, line) -> index < line.size() && line.getLink(index) == Link.LINKED),
    LEFT(-1, (index, line) -> index > 0 && line.getLink(index-1) == Link.LINKED),
    STAY(0, (index, line) -> true);


    private final int direction;
    private final MoveCondition condition;

    MovingDirection(int direction, MoveCondition condition) {
        this.direction = direction;
        this.condition = condition;
    }

    public boolean canMove(int index, HorizontalLine line) {
        return condition.canMove(index, line);
    }

    public int move(int index) {
        return index + direction;
    }
}
