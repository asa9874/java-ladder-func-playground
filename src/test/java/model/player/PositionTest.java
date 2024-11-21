package model.player;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PositionTest {

    @Test
    public void 위치가_유효한_경우_올바르게_저장된다(){
        int validPosition = 5;
        Position position = new Position(validPosition);

        assertThat(position.getPosition()).isEqualTo(validPosition);
    }

    @Test
    public void 위치가_유효하지_않을_경우_예외가_발생한다(){
        int invalidPosition = -1;

        assertThatThrownBy(()->new Position(invalidPosition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어의 위치가 유효하지 않습니다.");
    }

    @Test
    public void 플레이어가_주어진_방향으로_움직일_때_위치가_정확히_변해야_한다(){
        int initialPlayerPosition = 3;

        Position position1 = new Position(initialPlayerPosition);
        Position position2 = new Position(initialPlayerPosition);
        Position position3 = new Position(initialPlayerPosition);


        int left_direction = -1;
        int straight_direction = 0;
        int right_direction = 1;

        position1.move(left_direction);
        position2.move(straight_direction);
        position3.move(right_direction);

        assertThat(position1.getPosition()).isEqualTo(2);
        assertThat(position2.getPosition()).isEqualTo(3);
        assertThat(position3.getPosition()).isEqualTo(4);
    }

}
