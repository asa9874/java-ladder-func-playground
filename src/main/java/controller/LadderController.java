package controller;

import dto.LadderDTO;
import service.LadderService;
import view.InputView;
import view.ResultView;

import java.util.List;

public class LadderController {
    private final LadderService ladderService;

    public LadderController() {
        this.ladderService = new LadderService();
    }

    public void startGame() {
        List<String> participants = InputView.getParticipants();
        List<String> results = InputView.getResults();
        int height = InputView.getHeight();

        LadderDTO ladderDTO = ladderService.createLadderGame(height, participants.size());
        ResultView.displayLadder(ladderDTO, participants, results);
        ResultView.displayResults(ladderDTO, participants, results);
    }
}
