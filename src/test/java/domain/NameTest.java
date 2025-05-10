package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameTest {

    @Test
    void 이름이_정상적으로_설정된다() {
        String validName = "Alice";

        Name name = new Name(validName);

        assertEquals(validName, name.getName());
    }

    @Test
    void 이름이_빈_문자열_일때_예외가_발생한다() {
        String invalidName = "";

        assertThatThrownBy(() -> new Name(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 null이나 빈 문자열일 수 없습니다.");
    }

    @Test
    void 이름이_null일_때_예외가_발생한다() {
        String invalidName = null;

        assertThatThrownBy(() -> new Name(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 null이나 빈 문자열일 수 없습니다.");
    }

    @Test
    void 이름이_5자_초과일_때_예외가_발생한다() {
        String invalidName = "ABCDEFG";

        assertThatThrownBy(() -> new Name(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이하이어야 합니다.");
    }
}
