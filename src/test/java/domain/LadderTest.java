package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    @Test
    void 사다리_너비가_1이하_일경우_예외_발생() {
        int width = 1;
        int height = 5;

        assertThatThrownBy(() -> new Ladder(width, height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 너비는 1보다 커야 합니다.");
    }

    @Test
    void 사다리_높이가_0이하_일경우_예외_발생() {
        int width = 5;
        int height = 0;

        assertThatThrownBy(() -> new Ladder(width, height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 0보다 커야 합니다.");
    }

    @Test
    void 유효한_너비와_높이로_사다리_생성() {
        int width = 5;
        int height = 3;

        Ladder ladder = new Ladder(width, height);

        assertThat(ladder.getLines()).hasSize(height);
    }
}
