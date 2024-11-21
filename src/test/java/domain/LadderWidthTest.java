package domain;

import domain.ladder.LadderWidth;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderWidthTest {

    @Test
    void 유효_너비_확인_테스트() {
        LadderWidth width = new LadderWidth(3);
        assertEquals(3, width.getValue());
    }

    @Test
    void 유효하지_않은_너비_에러_확인_테스트() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new LadderWidth(0));
        assertEquals("사다리의 넓이는 1이상입니다.", exception.getMessage());
    }
}
