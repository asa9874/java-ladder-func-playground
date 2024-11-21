package domain;

import domain.ladder.Ladder;

import java.util.List;

public class LadderGame {

    private final Ladder ladder;
    private final List<String> gameResults;

    public LadderGame(Ladder ladder, List<String> gameResults) {
        this.ladder = ladder;
        this.gameResults = gameResults;
    }

    public LadderResult playGame(){
        return new LadderResult(ladder.calculateResults(gameResults));
    }
}
