package view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class InputValidatorTest {

    @Test
    public void 입력_문자열의_구분자가_쉼표가_아니면_예외가_발생해야_한다() {
        String inputString = "짱구&철수&유리&맹구&훈이";
        assertThatThrownBy(() -> InputValidator.validateInputStringPattern(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력은 쉼표로 구분 되어야 합니다!");
    }
}
