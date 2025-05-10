package domain;

public class Point {
    private PointState state;

    public Point(PointState state) {
        this.state = state;
    }

    public boolean isMovable() {
        return state == PointState.MOVABLE;
    }

    public void setMovable(boolean movable) {
        if (movable) {
            state = PointState.MOVABLE;
        }
        if (!movable) {
            state = PointState.NOT_MOVABLE;
        }
    }
}
