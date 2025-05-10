package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointStateTest {

    @Test
    void MOVABLE_상태의_getDisplay_는_하이픈_5개여야_한다() {
        PointState movableState = PointState.MOVABLE;

        String result = movableState.getDisplay();

        assertThat(result).isEqualTo("-----");
    }

    @Test
    void NOT_MOVABLE_상태의_getDisplay_는_공백_5개여야_한다() {
        PointState notMovableState = PointState.NOT_MOVABLE;

        String result = notMovableState.getDisplay();

        assertThat(result).isEqualTo("     ");
    }

    @Test
    void randomState_메서드는_MOVABLE_또는_NOT_MOVABLE_을_반환해야_한다() {
        PointState randomState = PointState.randomState();

        assertThat(randomState).isIn(PointState.MOVABLE, PointState.NOT_MOVABLE);
    }
}
