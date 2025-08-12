import model.Ladder;
import util.InputParser;
import view.InputView;
import view.OutPutView;

public class LadderSimulator {

    private Ladder ladder;

    public void start() {
        int height = InputParser.parseLadderHeight(InputView.inputLadderHeight());
        int width = InputParser.parseLadderWidth(InputView.inputLadderWidth());

        this.ladder = new Ladder(height, width);

        OutPutView.printLadder(ladder);
    }

}
