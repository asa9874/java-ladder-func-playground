package controller;

import domain.Ladder;
import domain.Size;
import domain.service.LadderService;
import view.InputView;
import view.OutputView;

public class LadderController {

    private final OutputView outputView = new OutputView();

    public void runLadder() {

        int width = InputView.enterLadderWidth();
        int height = InputView.enterLadderHeight();

        Size size = new Size(height, width);
        LadderService ladderService = new LadderService(size);

        Ladder ladder = ladderService.createLadder();
        outputView.printLadder(ladder);
    }
}
