package model;

import model.Prize.Prize;
import model.Prize.Prizes;
import model.ladder.Ladder;
import model.user.User;
import model.user.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

class LadderGameResultTest {

    private Users users;
    private Prizes prizes;
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        int height = 10;
        users = Users.from(List.of("짱구", "철수", "유리", "맹구", "훈이"));
        prizes = Prizes.of(List.of("1등", "꽝","꽝","꽝","꽝"), users.size());
        ladder = Ladder.of(height, users.size(), new UnLinkedGenerator());
    }

    @Test
    public void 사다리가_연결되지_않는다면_입력한_순서대로_당첨됨다() {
        LadderGameResult result = LadderGameResult.of(users, prizes, ladder);

        Map<User, Prize> gameResults = result.getGameResults();

        IntStream.range(0, gameResults.size()).forEach(i ->
                    assertThat(result.findByUser(users.getUsers().get(i))).isEqualTo(prizes.getPrizeAtPosition(i))
        );
    }

    @Test
    public void 결과조회시_유저가_존재하지_않으면_예외가_발생해야_한다() {
        LadderGameResult result = LadderGameResult.of(users, prizes, ladder);
        User user = new User("수지", 5);

        assertThatThrownBy(() -> result.findByUser(user))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("결과를 조회하려는 유저가 존재하지 않습니다!");
    }
}
