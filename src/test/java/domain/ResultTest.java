package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ResultTest {

    @Test
    void 결과는_정상적으로_생성되어야_한다() {
        String value = "성공";

        Result result = new Result(value);

        assertThat(result.getResult()).isEqualTo(value);
    }

    @Test
    void 결과가_null이면_예외를_던져야_한다() {
        assertThatThrownBy(() -> new Result(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("결과는 빈 문자열일 수 없습니다.");
    }

    @Test
    void 결과가_빈_문자열이면_예외를_던져야_한다() {
        assertThatThrownBy(() -> new Result("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("결과는 빈 문자열일 수 없습니다.");
    }

    @Test
    void 결과가_6자_이상이면_예외를_던져야_한다() {
        assertThatThrownBy(() -> new Result("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("결과는 5자 이하로 제한됩니다.");
    }
}
