package model.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<LadderLine> ladderLines;

    public Ladder(int playerCount, int ladderHeight) {
        this.ladderLines = new ArrayList<>();
        generateLadder(playerCount,ladderHeight);
    }

    private void generateLadder(int ladderWidth, int ladderHeight) {
        for (int i = 0; i < ladderHeight; i++) {
            ladderLines.add(new LadderLine(ladderWidth));
        }
    }

    public List<LadderLine> getLadder() {
        return Collections.unmodifiableList(ladderLines);
    }
}
