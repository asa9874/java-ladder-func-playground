package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    void MOVABLE_상태일_때_isMovable_반환값이_true여야_한다() {
        Point movablePoint = new Point(PointState.MOVABLE);

        boolean result = movablePoint.isMovable();

        assertThat(result).isTrue();
    }

    @Test
    void NOT_MOVABLE_상태일_때_isMovable_반환값이_false여야_한다() {
        Point notMovablePoint = new Point(PointState.NOT_MOVABLE);

        boolean result = notMovablePoint.isMovable();

        assertThat(result).isFalse();
    }
}
