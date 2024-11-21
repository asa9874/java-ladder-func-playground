package controller;

import domain.LadderGame;
import domain.ladder.LadderHeight;
import domain.ladder.Ladder;
import domain.LadderResult;
import domain.ladder.LadderWidth;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderController {

    public void createLadder(){
        List<String> players = InputView.inputPlayerNames();
        List<String> results = InputView.inputGamePrice();

        LadderWidth width = new LadderWidth(players.size());
        LadderHeight height = new LadderHeight(InputView.inputLadderHeight());

        Ladder ladder = new Ladder(width, height, players, results);

        playLadderGame(ladder, players, results);
    }

    public void playLadderGame(Ladder ladder, List<String> players, List<String> results){
        LadderGame ladderGame = new LadderGame(ladder, results);
        LadderResult ladderResult = ladderGame.playGame();

        List<String> gameResult = ladderResult.getResults();

        OutputView.printLadder(ladder, players, results);

        checkLadderGameResult(players, gameResult);
    }

    public void checkLadderGameResult(List<String> players, List<String> gameResult){
        while (true){
            String who = InputView.inputWhoseResult();

            if (who.equals("exit")){
                OutputView.printExitMessage();
                break;
            }
            if (who.equals("all")){
                OutputView.printAllResult(gameResult, players);
                continue;
            }
            OutputView.printIndividualResult(gameResult,players, who);
        }
    }
}
