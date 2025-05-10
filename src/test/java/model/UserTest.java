package model;

import model.user.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class UserTest {

    @Test
    public void 유저의_이름이_5자_초과이면_예외가_발생해야_한다() {
        String username = "사다리게임장인";
        assertThatThrownBy(() -> new User(username, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유저 이름은 최대 5자 입니다!");
    }
}
