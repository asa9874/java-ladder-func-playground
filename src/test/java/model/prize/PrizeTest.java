package model.prize;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PrizeTest {

    @Test
    public void 사다리_상품_이름이_정상적으로_설정된다(){
        String validPrizeName = "test";

        Prize prize = new Prize(validPrizeName);

        assertThat(prize.getPrizeName()).isEqualTo(validPrizeName);
    }

    @Test
    public void 사다리_상품이_비어있을_경우_예외가_발생한다(){
        String blankPrizeName = "   ";
        String emptyPrizeName = "";

        assertThatThrownBy(()-> new Prize(blankPrizeName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 상품 이름은 비어있을 수 없습니다.");

        assertThatThrownBy(()-> new Prize(emptyPrizeName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 상품 이름은 비어있을 수 없습니다.");
    }

}
