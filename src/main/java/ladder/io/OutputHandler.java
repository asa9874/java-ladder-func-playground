package ladder.io;

import ladder.GameResults;
import ladder.Ladder;
import ladder.Participants;

public interface OutputHandler {

    void printLadder(Ladder ladder, Participants participants, GameResults gameResults);

    void printResult(Participants participants, GameResults gameResults);
}
