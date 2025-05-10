package model;

import model.user.Users;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class UsersTest {

    @Test
    public void 참가자의_이름이_중복되면_예외가_발생해야_한다() {
        List<String> usernames = List.of("짱구","철수","유리","맹구","짱구");
        assertThatThrownBy(() -> Users.from(usernames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("게임 참가자의 이름은 중복이 되면 안됩니다!");
    }

    @Test
    public void 참가자_이름_수_만큼_User가_생성되어야_한다() {
        List<String> usernames = List.of("짱구","철수","유리","맹구","훈이");
        Users users = Users.from(usernames);
        assertThat(users.size()).isEqualTo(5);
    }

    @Test
    public void 찾으려는_유저의_이름이_리스트에_존재하지_않으면_예외가_발생해야_한다() throws Exception {
        List<String> usernames = List.of("짱구","철수","유리","맹구","훈이");
        Users users = Users.from(usernames);
        assertThatThrownBy(() -> users.findByUsername("수지"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 유저가 존재하지 않습니다!");
    }
}
