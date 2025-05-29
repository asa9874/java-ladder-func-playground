import model.*;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderGameTest {

    @Test
    @DisplayName("참가자 수와 보상의 수가 일치하지 않으면 예외를 던진다.")
    void whenParticipantsSizeAndRewardsSizeIsNotSame_thenThrowsException() {

        Participants participants = new Participants(List.of("ohzzi", "zhang", "kwon", "yejin"));
        Rewards rewards = new Rewards(List.of("3000", "꽝", "2000"));

        List<Line> lines = List.of(
                Line.of(participants.size(), size -> List.of(true, false, false)),
                Line.of(participants.size(), size -> List.of(true, false, true)),
                Line.of(participants.size(), size -> List.of(false, false, false))
        );

        Ladder ladder = Ladder.ofLines(participants.size(), 3, lines);
        assertThatThrownBy(() -> LadderGame.of(participants, rewards, ladder))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자 수와 보상의 갯수가 일치해야합니다.");

    }

    @Test
    @DisplayName("게임 결과에 대한 참가자별 보상 일치 여부 확인")
    void testRewardsMapping() {
        Participants participants = new Participants(List.of("ohzzi", "zhang", "kwon", "yejin"));
        Rewards rewards = new Rewards(List.of("3000", "꽝", "2000", "1000"));

        int width = participants.size();
        int height = 3;
        List<Line> lines = List.of(
                Line.of(width, size -> List.of(true, false, false)),
                Line.of(width, size -> List.of(true, false, true)),
                Line.of(width, size -> List.of(false, false, false))
        );

        Ladder ladder = Ladder.ofLines(width, height, lines);
        LadderGame game = LadderGame.of(participants, rewards, ladder);

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(game.allResults()).isEqualTo(Map.of("ohzzi", "3000", "zhang", "꽝", "kwon", "1000", "yejin", "2000"));
        softly.assertThat(game.resultFor("ohzzi")).isEqualTo("3000");
        softly.assertThat(game.resultFor("zhang")).isEqualTo("꽝");
        softly.assertThat(game.resultFor("kwon")).isEqualTo("1000");
        softly.assertThat(game.resultFor("yejin")).isEqualTo("2000");

        softly.assertAll();
    }
}
