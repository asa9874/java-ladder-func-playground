package model;

import model.Prize.Prize;
import model.Prize.Prizes;
import model.ladder.Ladder;
import model.user.User;
import model.user.Users;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class LadderGameResult {

    private final Map<User, Prize> gameResults;

    private LadderGameResult(Map<User, Prize> gameResults) {
        this.gameResults = gameResults;
    }

    public static LadderGameResult of(Users users, Prizes prizes, Ladder ladder) {
        return new LadderGameResult(calculateResult(users, prizes, ladder));
    }

    private static Map<User, Prize> calculateResult(Users users, Prizes prizes, Ladder ladder) {
        return users.getUsers().stream()
                .collect(Collectors.toMap(
                        user -> user,
                        user -> ladder.ride(user, prizes)
                ));
    }

    public Prize findByUser(User user) {
        return Optional.ofNullable(gameResults.get(user))
                .orElseThrow(() -> new IllegalArgumentException("결과를 조회하려는 유저가 존재하지 않습니다!"));
    }

    public Map<User, Prize> getGameResults() {
        return Collections.unmodifiableMap(gameResults);
    }
}
