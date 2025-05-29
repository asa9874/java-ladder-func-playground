package controller;


import model.Ladder;
import model.LadderGame;
import model.Participants;
import model.Rewards;

import util.BooleansGenerator;
import view.InputView;
import view.OutputView;

public class LadderController {

    private final BooleansGenerator booleansGenerator;

    public LadderController(final BooleansGenerator booleansGenerator) {
        this.booleansGenerator = booleansGenerator;
    }

    public LadderGame createGameAndPrintLadder() {

        Participants participants = new Participants(InputView.readParticipants());
        Rewards rewards = new Rewards(InputView.readRewards());

        int laneCount = participants.size();
        int height = InputView.readLadderHeight();

        Ladder ladder = Ladder.of(laneCount, height, booleansGenerator);

        LadderGame ladderGame = LadderGame.of(participants, rewards, ladder);
        OutputView.printLadderResult(ladderGame.toDto());

        return ladderGame;
    }

    public void printGameResult(LadderGame ladderGame) {
        while (true) {
            String input = InputView.readParticipantNameToQuery();
            if (input.equalsIgnoreCase("all")) {
                OutputView.printExecutedResult(ladderGame.allResults());
                break;
            }
            OutputView.printResultFor(ladderGame.resultFor(input));
        }
    }

}
