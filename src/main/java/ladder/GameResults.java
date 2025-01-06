package ladder;

import java.util.List;

public class GameResults {

    private final List<GameResult> gameResults;

    public GameResults(List<GameResult> gameResults) {
        this.gameResults = gameResults;
    }

    public List<GameResult> getGameResults() {
        return List.copyOf(gameResults);
    }

    public GameResult findByIndex(int index) {
        return gameResults.get(index);
    }

    public int size() {
        return gameResults.size();
    }
}
