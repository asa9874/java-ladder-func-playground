package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    @Test
    void Position_생성자는_음수_값에_대해_예외를_던져야_한다() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Position은 음수일 수 없습니다.");
    }

    @Test
    void Position_생성자는_0이상_값을_허용해야_한다() {
        Position position = new Position(0);

        assertThat(position.getPosition()).isEqualTo(0);
    }

    @Test
    void moveLeft_메서드는_위치를_하나씩_왼쪽으로_이동시킨다() {
        Position position = new Position(3);

        position.moveLeft();

        assertThat(position.getPosition()).isEqualTo(2);
    }

    @Test
    void moveRight_메서드는_위치를_하나씩_오른쪽으로_이동시킨다() {
        Position position = new Position(3);

        position.moveRight();

        assertThat(position.getPosition()).isEqualTo(4);
    }

    @Test
    void equals_메서드는_같은_위치_값을_비교한다() {
        Position position1 = new Position(3);
        Position position2 = new Position(3);
        Position position3 = new Position(4);

        assertThat(position1).isEqualTo(position2);
        assertThat(position1).isNotEqualTo(position3);
    }

    @Test
    void hashCode_메서드는_같은_위치값에_대해_같은_해시코드를_반환해야_한다() {
        Position position1 = new Position(3);
        Position position2 = new Position(3);

        assertThat(position1.hashCode()).isEqualTo(position2.hashCode());
    }
}
