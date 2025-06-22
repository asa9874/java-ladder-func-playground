package controller;

import java.util.Random;
import model.ladder.Ladder;
import model.ladder.LadderResult;
import view.InputView;
import view.OutputView;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int width = inputView.readWidth();
        int height = inputView.readHeight();

        Ladder ladder = new Ladder(width, height, new Random());
        outputView.printLadder(ladder);

        LadderResult result = new LadderResult(ladder);
        outputView.printResult(result, width);
    }
}
