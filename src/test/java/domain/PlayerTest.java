package domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    private Ladder ladder;
    private Player player;

    @BeforeEach
    void setUp() {
        Name playerName = new Name("Test");
        Position playerPosition = new Position(1);
        player = new Player(playerName, playerPosition);
        ladder = new Ladder(3, 1);
    }

    @Test
    void 플레이어가_왼쪽_이동_가능하면_위치가_변한다() {
        ladder.getLines().get(0).getPoints().get(0).setMovable(true);
        ladder.getLines().get(0).getPoints().get(1).setMovable(false);

        player.downLadder(ladder);

        assertThat(player.getPosition().getPosition()).isEqualTo(0);
    }

    @Test
    void 플레이어가_오른쪽_이동_가능하면_위치가_변한다() {
        ladder.getLines().get(0).getPoints().get(0).setMovable(false);
        ladder.getLines().get(0).getPoints().get(1).setMovable(true);

        player.downLadder(ladder);

        assertThat(player.getPosition().getPosition()).isEqualTo(2);
    }

    @Test
    void 플레이어가_이동_불가능하면_위치가_변하지_않는다() {
        ladder.getLines().get(0).getPoints().get(0).setMovable(false);
        ladder.getLines().get(0).getPoints().get(1).setMovable(false);

        player.downLadder(ladder);

        assertThat(player.getPosition().getPosition()).isEqualTo(1);
    }

}
