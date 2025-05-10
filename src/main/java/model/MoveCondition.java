package model;

import model.ladder.HorizontalLine;

@FunctionalInterface
public interface MoveCondition {
    boolean canMove(int index, HorizontalLine line);
}
