package domain;


import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayersTest {

    private Players players;

    @BeforeEach
    void setUp() {
        players = Players.of(List.of("Alice", "Bob", "John"));
    }

    @Test
    void 플레이어_리스트가_정상적으로_생성된다() {
        int size = players.getPlayers().size();
        assertThat(size).isEqualTo(3);
    }

    @Test
    void 플레이어_이름으로_찾기() {
        Name name = new Name("Bob");
        Player foundPlayer = players.findByName(name);
        assertThat(foundPlayer.getName().getName()).isEqualTo("Bob");
    }

    @Test
    void 존재하지_않는_이름으로_플레이어_찾기() {
        Name name = new Name("Dave");

        assertThatThrownBy(() -> players.findByName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하지 않는 이름입니다: Dave");
    }

    @Test
    void 중복된_이름으로_플레이어_생성시_예외가_발생한다() {
        assertThatThrownBy(() -> Players.of(List.of("Alice", "Alice")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름이 있습니다: Alice");
    }
}
