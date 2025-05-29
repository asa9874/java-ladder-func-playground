import model.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.RandomBooleansGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    @Test
    @DisplayName("Ladder는 height만큼 line 수를 갖는다.")
    void whenCreatedByStaticFactoryMethod_thenHasValidLinesSize() {

        int laneCount = 2;
        int height = 1;
        Ladder ladder = Ladder.of(laneCount, height, new RandomBooleansGenerator());

        assertThat(ladder.getLines()).hasSize(height);
    }

    @Test
    @DisplayName("사다리 레인 수가 2미만이면 throw IllegalArgumentException")
    void whenLadderWidthIsInvalide_thenThrowsException() {
        int laneCount = 1;
        int height = 5;
        assertThatThrownBy(() -> assertThat(Ladder.of(laneCount, height, new RandomBooleansGenerator())))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("사다리의 레인은 2개이상이어야 합니다.");
    }


    @Test
    @DisplayName("사다리의 높이가 1미만이면 throw IllegalArgumentException")
    void whenLadderScaleIsInvalide_thenThrowsException() {
        int laneCount = 3;
        int height = 0;
        assertThatThrownBy(() -> assertThat(Ladder.of(laneCount, height, new RandomBooleansGenerator())))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("사다리의 높는 1이상이어야 합니다.");
    }
}
