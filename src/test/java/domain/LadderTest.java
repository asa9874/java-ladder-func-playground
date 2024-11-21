package domain;

import domain.ladder.LadderHeight;
import domain.ladder.Ladder;
import domain.ladder.LadderWidth;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    @Test
    public void 사다리_크기_확인_테스트() {
        LadderWidth width = new LadderWidth(4);
        LadderHeight height = new LadderHeight(3);
        Ladder ladder = new Ladder(width, height, List.of("A", "B", "C"), List.of("1", "2", "3"));

        assertEquals(width.getValue(), ladder.getWidth());
        assertEquals(height.getValue(), ladder.getLines().size());
    }

}
