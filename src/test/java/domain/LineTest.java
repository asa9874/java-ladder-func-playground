package domain;

import domain.ladder.Line;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LineTest {

    @Test
    void 가로선이_들어갈수있는_칸수() {
        Line line = new Line(5);

        assertEquals(4, line.getPoints().size());
    }

    @Test
    void 움직임_유효성_테스트() {
        Line line = new Line(5);

        assertFalse(line.isAbleToMoveLeft(0));
        assertFalse(line.isAbleToMoveRight(4));
    }
}
