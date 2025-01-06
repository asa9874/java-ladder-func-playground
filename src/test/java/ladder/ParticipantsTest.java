package ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParticipantsTest {
    
    @DisplayName("all을 입력하여 회원 전부를 찾느다.")
    @Test
    void findAllByNameInputAll() {
        // given
        Participants participants = new Participants(
            List.of(new Participant("하이", new Position(0)),
                    new Participant("안녕", new Position(1)))
        );
        
        // when
        final Participants findParticipants = participants.findAllByName("all");

        // then
        assertThat(findParticipants.size()).isEqualTo(2);
        assertThat(findParticipants.getParticipants())
            .extracting("name", String.class)
            .containsExactly("하이", "안녕");
    }

    @DisplayName("특정 이름을 입력하여 회원을 찾는다.")
    @Test
    void findAllBySpecificName() {
        // given
        Participants participants = new Participants(
            List.of(new Participant("하이", new Position(0)),
                    new Participant("안녕", new Position(1)))
        );

        // when
        final Participants findParticipants = participants.findAllByName("안녕");

        // then
        assertThat(findParticipants.size()).isEqualTo(1);
        assertThat(findParticipants.getParticipants())
            .extracting("name", String.class)
            .containsExactly("안녕");
    }

    @DisplayName("존재하지 않는 회원을 검색하면 얘외가 발생한다.")
    @Test
    void notExistingParticipant() {
        // given
        Participants participants = new Participants(
            List.of(new Participant("하이", new Position(0)),
                    new Participant("안녕", new Position(1)))
        );

        // when / then
        assertThatThrownBy(
            () -> participants.findAllByName("노우")
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("참여자가 존재하지 않습니다.");
    }

    @DisplayName("참가자 없을 때 참가자 이동을 시도하면 예외가 발생한다.")
    @Test
    void moveException() {
        // given
        Participants participants = new Participants(
            List.of()
        );

        // when / then
        assertThatThrownBy(() -> participants.move(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("참여자가 존재하지 않습니다.");
    }
}
