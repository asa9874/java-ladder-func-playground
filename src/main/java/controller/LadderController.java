package controller;

import domain.Ladder;
import domain.Name;
import domain.Player;
import domain.Players;
import domain.Result;
import domain.Results;
import view.InputView;
import view.OutputView;

public class LadderController {

    private final Players players;
    private final Results results;

    public LadderController() {
        players = Players.of(InputView.inputPlayerNames());
        results = Results.of(InputView.inputResults());
    }

    public void run() {
        Ladder ladder = createLadder();
        OutputView.printLadderInfo(players, results, ladder);
        players.moveDown(ladder);
        runResultQueryLoop();
    }

    private Ladder createLadder() {
        int ladderWidth = players.getPlayers().size();
        int ladderHeight = InputView.inputHeight();
        return new Ladder(ladderWidth, ladderHeight);
    }

    private void runResultQueryLoop() {
        while (checkResultLoop());
    }

    private Boolean checkResultLoop() {
        String name = InputView.inputPlayerNameToCheckResult();
        if (name.isEmpty()) {
            return false;
        }
        if (name.trim().equals("all")) {
            printAllResults(players, results);
            return true;
        }
        printSingleResult(name, players, results);
        return true;
    }

    private void printAllResults(Players players, Results results) {
        for (Player player : players.getPlayers()) {
            Result result = results.findByPosition(player.getPosition());
            OutputView.printResult(player, result);
        }
    }

    private void printSingleResult(String name, Players players, Results results) {
        Player player = players.findByName(new Name(name));
        Result result = results.findByPosition(player.getPosition());
        OutputView.printResult(player, result);
    }

}
