import model.Participants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantsTest {

    @Test
    @DisplayName("참여자가 2명 미만이면 throws IllegalArgumentException")
    void whenParticipantsNumberIsLessThenTwo_thenThrowsException() {
        assertThatThrownBy(() -> new Participants(List.of("yejin")))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("참가자는 2인 이상이어야 합니다.");
    }

    @Test
    @DisplayName("이름이 5자를 넘어가면 throws IllegalArgumentException")
    void whenNameUpperThenFive_thenThrowsException() {
        assertThatThrownBy(() -> new Participants(List.of("yejin2", "ohzzi", "zhang", "kwon")))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("참여자 이름은 5글자 이하여야 합니다.:yejin2");
    }

    @Test
    @DisplayName("중복된 이름을 포함하면 throws IllegalArgumentException")
    void whenNamesAreDuplicated_thenThrowsException() {
        assertThatThrownBy(() -> new Participants(List.of("yejin", "yejin", "ohzzi", "zhang", "kwon")))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("참여자의 이름이 중복되면 안됩니다.");
    }

    @Test
    @DisplayName("예약된 상수 all을 참여자 이름으로 사용하면 throws IllegalArgumentsException")
    void whenNamesAreReserved_thenThrowsException() {
        assertThatThrownBy(() -> new Participants(List.of("all", "yejin", "ohzzi", "zhang", "kwon")))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("\"all\"은 참가자 이름으로 사용할 수 없습니다.");
    }

    @Test
    @DisplayName("인자가 생성 조건을 만족하는 경우, Participants객체를 생성한다.")
    void testCreateParticipants() {
        assertThatCode(() -> new Participants(List.of("yejin", "Bong")))
                .doesNotThrowAnyException();
    }
}
