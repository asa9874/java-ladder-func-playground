package domain.ladder;

public class LadderWidth {

    private final int value;

    public LadderWidth(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("사다리의 넓이는 1이상입니다.");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
