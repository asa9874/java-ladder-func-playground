package model;

import model.Prize.Prizes;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PrizesTest {

    private List<String> prizeList = List.of("1등", "꽝","꽝","꽝","꽝");
    private final int participantCount = 5;

    @Test
    public void 참가자_인원보다_Prize가_적으면_예외가_발생해야_한다() {
        assertThatThrownBy(() -> Prizes.of(prizeList, participantCount - 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자 인원만큼 실행결과를 입력해야 합니다!");
    }

    @Test
    public void 찾으려는_위치에_Prize가_존재하지_않으면_예외가_발생해야_한다() {
        Prizes prizes = Prizes.of(prizeList, participantCount);
        assertThatThrownBy(() -> prizes.getPrizeAtPosition(90))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당하는 위치의 결과가 존재하지 않습니다!");
    }
}
