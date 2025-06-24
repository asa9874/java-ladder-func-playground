package domain;

public class Size {

    private final int height;
    private final int width;
    private static final String LADDER_SIZE_INVALID_MESSAGE = "높이와 넓이는 모두 1 이상이어야 합니다.";

    public Size(int height, int width) {
        validate(height, width);
        this.height = height;
        this.width = width;
    }

    private void validate(int height, int width) {
        if (height < 1 || width < 1) {
            throw new IllegalArgumentException(LADDER_SIZE_INVALID_MESSAGE);
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
