package model;

import model.ladder.HorizontalLine;
import model.ladder.LineGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MovingDirectionTest {

    @Test
    public void 오른쪽_이동_전략() {
        HorizontalLine line = LineGenerator.generateHorizontalLine(5, new LinkedGenerator());
        int position = 0;

        boolean canMove = MovingDirection.RIGHT.canMove(position, line);
        int resultPosition = MovingDirection.RIGHT.move(position);

        assertThat(canMove).isTrue();
        assertThat(resultPosition).isEqualTo(position + 1);
    }

    @Test
    public void 왼쪽_이동_전략() {
        HorizontalLine line = LineGenerator.generateHorizontalLine(5, new LinkedGenerator());
        int position = 1;

        boolean canMove = MovingDirection.LEFT.canMove(position, line);
        int resultPosition = MovingDirection.LEFT.move(position);

        assertThat(canMove).isTrue();
        assertThat(resultPosition).isEqualTo(position - 1);
    }
}
