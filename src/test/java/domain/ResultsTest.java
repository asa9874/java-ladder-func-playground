package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultsTest {

    @Test
    void 문자열_리스트로부터_Results_객체를_생성할_수_있다() {
        List<String> resultStrings = Arrays.asList("1등", "2등", "3등");

        Results results = Results.of(resultStrings);

        List<Result> resultList = results.getResults();
        assertThat(resultList).hasSize(3);
        assertThat(resultList).extracting(Result::getResult)
                .containsExactly("1등", "2등", "3등");
    }

    @Test
    void position에_해당하는_결과를_찾을_수_있다() {
        Results results = Results.of(Arrays.asList("2000", "꽝", "3000"));
        Position position = new Position(1);

        Result result = results.findByPosition(position);

        assertThat(result.getResult()).isEqualTo("꽝");
    }

    @Test
    void position이_결과_리스트_범위를_벗어나면_예외를_던진다() {
        Results results = Results.of(Arrays.asList("a", "b"));
        Position invalid = new Position(5);

        assertThatThrownBy(() -> results.findByPosition(invalid))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }
}
