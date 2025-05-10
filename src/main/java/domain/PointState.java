package domain;

import java.util.Random;

public enum PointState {
    MOVABLE("-----"),
    NOT_MOVABLE("     ");

    private final String display;
    private static final Random random = new Random();

    PointState(String display) {
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }

    public static PointState randomState() {
        if (random.nextBoolean()){
            return MOVABLE;
        }
        return NOT_MOVABLE;
    }
}
