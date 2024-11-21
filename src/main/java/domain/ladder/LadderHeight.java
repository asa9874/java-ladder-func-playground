package domain.ladder;

public class LadderHeight {

    private final int value;
    private final int MIN_LADDER_HEIGHT = 1;

    public LadderHeight(int value) {
        if (value < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 1이상입니다.");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
