package domain;

import domain.ladder.LadderHeight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderHeightTest {

    @Test
    void 유효한_높이_확인_테스트() {
        LadderHeight height = new LadderHeight(5);
        assertEquals(5, height.getValue());
    }

    @Test
    void 유효하지_않은_높이_에러_확인_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new LadderHeight(0));
    }
}
