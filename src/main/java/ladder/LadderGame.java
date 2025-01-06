package ladder;

import ladder.generator.RandomPointGenerator;
import ladder.io.InputHandler;
import ladder.io.OutputHandler;

public class LadderGame {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public LadderGame(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void start() {
        final Participants participants = inputHandler.inputParticipants();
        final GameResults gameResults = inputHandler.inputResults();

        validateParticipantsAndGameResults(participants, gameResults);

        final int width = participants.size();
        final Size size = inputHandler.inputSize(width);
        final Ladder ladder = new Ladder(new RandomPointGenerator(), size);

        outputHandler.printLadder(ladder, participants, gameResults);

        final String participantName = inputHandler.getParticipantName();
        final Participants findParticipants = participants.findAllByName(participantName);

        findParticipants.move(ladder);
        outputHandler.printResult(findParticipants, gameResults);
    }

    private void validateParticipantsAndGameResults(Participants participants, GameResults gameResults) {
        if (participants.size() != gameResults.size()) {
            throw new IllegalArgumentException("참여자 수와 결과 수가 일치하지 않습니다.");
        }
    }
}
