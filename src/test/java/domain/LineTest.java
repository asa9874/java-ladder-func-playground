package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    void 라인은_지정된_길이만큼_Point_리스트를_생성한다() {
        int width = 5;

        Line line = Line.from(width);
        List<Point> points = line.getPoints();

        assertThat(points).hasSize(width);
    }

    @Test
    void 라인의_인접한_Point는_동시에_MOVABLE일_수_없다() {
        List<Point> points = Line.from(100).getPoints();

        for (int i = 1; i < points.size(); i++) {
            assertThat(points.get(i - 1).isMovable() && points.get(i).isMovable()).isFalse();
        }
    }

    @Test
    void 점의_상태는_Movable_또는_NotMovable_만_있어야한다() {
        int width = 5;

        Line line = Line.from(width);

        List<Point> points = line.getPoints();
        points.forEach(point -> {
            assertThat(point.isMovable()).isIn(true, false);
        });
    }
}
