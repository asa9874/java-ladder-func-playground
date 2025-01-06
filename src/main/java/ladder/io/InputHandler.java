package ladder.io;

import ladder.GameResults;
import ladder.Participants;
import ladder.Size;

public interface InputHandler {

    Participants inputParticipants();

    GameResults inputResults();

    String getParticipantName();

    Size inputSize(final int width);

}
