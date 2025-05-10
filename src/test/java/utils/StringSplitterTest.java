package utils;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class StringSplitterTest {

    @Test
    public void 문자열을_쉼표로_구분하여_리스트로_반환되어야_한다() {
        String inputString = "짱구, 철수,유리,맹구,훈이";
        List<String> strings = StringSplitter.splitByComma(inputString);
        assertThat(strings).hasSize(5);
    }
}
