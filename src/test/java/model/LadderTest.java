package model;

import model.Prize.Prize;
import model.Prize.Prizes;
import model.ladder.Ladder;
import model.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class LadderTest {

    private final int height = 10;
    private final int participantCount = 5;
    private User user;
    private Prizes prizes;

    @BeforeEach
    void setUp() {
        user = new User("이창희", 0);
        prizes = Prizes.of(List.of("1등", "꽝","꽝","꽝","꽝"), participantCount);
    }

    @Test
    public void 주어진_높이만큼_사다리가_생성되어야_한다() {
        Ladder ladder = Ladder.of(height, participantCount, new LinkedGenerator());
        int ladderHeight = ladder.getLines().size();
        assertThat(ladderHeight).isEqualTo(height);
    }

    @Test
    public void 사다라가_연결되어_있지_않다면_사다리를_탔을_때_유저와_같은_위치의_prize가_반환되어야_한다() {
        Ladder ladder = Ladder.of(height, participantCount, new UnLinkedGenerator());
        Prize result = ladder.ride(user, prizes);
        Prize expectPrize = prizes.getPrizeAtPosition(user.getPosition());
        assertThat(result).isEqualTo(expectPrize);
    }
}
