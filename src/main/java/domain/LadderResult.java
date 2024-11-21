package domain;

import java.util.List;

public class LadderResult {

    private final List<String> gameResults;

    public LadderResult(List<String> gameResults) {
        this.gameResults = gameResults;
    }

    public List<String> getResults(){
        return gameResults;
    }

}
