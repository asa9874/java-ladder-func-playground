
package util;

public class LadderVaildator {
    public static void validateLadderHeight(String height) {
        if (height == null || height.isEmpty()) {
            throw new IllegalArgumentException("사다리 높이는 비어있을 수 없습니다.");
        }

        if (height.matches("\\D+")) {
            throw new IllegalArgumentException("사다리 높이는 숫자로 입력해야 합니다.");
        }

        int heightValue = Integer.parseInt(height);

        if (heightValue <= 0) {
            throw new IllegalArgumentException("사다리 높이는 0보다 큰 숫자여야 합니다.");
        }

    }

    public static void validateLadderWidth(String width) {
        if (width == null || width.isEmpty()) {
            throw new IllegalArgumentException("사다리 넓이는 비어있을 수 없습니다.");
        }

        if (width.matches("\\D+")) {
            throw new IllegalArgumentException("사다리 넓이는 숫자로 입력해야 합니다.");
        }

        int widthValue = Integer.parseInt(width);

        if (widthValue <= 0) {
            throw new IllegalArgumentException("사다리 넓이는 0보다 큰 숫자여야 합니다.");
        }

    }
}