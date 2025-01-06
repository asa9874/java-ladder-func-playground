package ladder;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import ladder.io.InputHandler;
import ladder.io.OutputHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameTest {

    @Test
    @DisplayName("참가자와 실행 결과 수가 다르면 예외가 발생한다.")
    void test() {

        class TestInputHandler implements InputHandler {

            @Override
            public Participants inputParticipants() {
                return new Participants(
                    List.of(new Participant("a", new Position(0)),
                            new Participant("b", new Position(1)))
                );
            }

            @Override
            public GameResults inputResults() {
                return new GameResults(
                    List.of(new GameResult("꽝"))
                );
            }

            @Override
            public String getParticipantName() {
                return null;
            }

            @Override
            public Size inputSize(int width) {
                return null;
            }
        }

        class TestOutputHandler implements OutputHandler {

            @Override
            public void printLadder(Ladder ladder, Participants participants, GameResults gameResults) {
            }

            @Override
            public void printResult(Participants participants, GameResults gameResults) {
            }
        }

        assertThatThrownBy(() -> new LadderGame(new TestInputHandler(), new TestOutputHandler()).start())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("참여자 수와 결과 수가 일치하지 않습니다.");
    }
}
