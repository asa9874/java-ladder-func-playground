import model.Line;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.RandomBooleansGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    @DisplayName("레인 수가 N이면, 포인트 개수는 N - 1이다")
    void whenCreatedByStaticFactoryMethod_thenHasValidLinesSize() {
        int laneCount = 3;
        int expectedPointsSize = laneCount - 1;

        Line line = Line.of(laneCount, new RandomBooleansGenerator());

        assertThat(line.getPoints()).hasSize(expectedPointsSize);
    }

    @Test
    @DisplayName("랜덤 Boolean 리스트는 연속된 true를 포함하지 않는다")
    void connectedPointsCannotBeContinuous() {
        int width = 100;
        List<Boolean> points = Line.of(width, new RandomBooleansGenerator()).getPoints();

        for (int i = 0; i < points.size() - 1; i++) {
            boolean current = points.get(i);
            boolean next = points.get(i + 1);
            assertThat(current && next).isFalse();
        }
    }


    @Test
    @DisplayName("왼쪽 이동 가능 판단 메서드 테스트")
    void testCanMoveLeftMethod() {
        Line line = Line.of(4, size -> List.of(true, false, false));
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(line.canMoveLeft(1)).isTrue();
        softly.assertThat(line.canMoveLeft(0)).isFalse();
        softly.assertThat(line.canMoveLeft(2)).isFalse();
        softly.assertAll();
    }

    @Test
    @DisplayName("오른쪽 이동 가능 판단 메서드 테스트")
    void testCanMoveRightMethod() {
        Line line = Line.of(4, size -> List.of(true, false, false));
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(line.canMoveRight(0)).isTrue();
        softly.assertThat(line.canMoveRight(2)).isFalse();
        softly.assertThat(line.canMoveRight(3)).isFalse();
        softly.assertAll();
    }
}
