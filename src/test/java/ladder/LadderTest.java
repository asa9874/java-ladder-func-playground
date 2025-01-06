package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import ladder.generator.StaticPointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderTest {

    @DisplayName("지정한 위치에서 사다리를 타고 도착지점을 찾는다.")
    @ParameterizedTest
    @CsvSource(value = {"0, 2", "1, 0", "2, 3", "3, 1"})
    void test(int start, int expected) {
        // given
        Ladder ladder = new Ladder(new StaticPointGenerator(), new Size(4, 2));

        // when
        int result = ladder.play(start);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
