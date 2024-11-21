import controller.LadderController;
import view.InputView;
import view.ResultView;

public class LadderApplication {
    public static void main(String[] args) {

        LadderController ladderController = new LadderController(
                new InputView(), new ResultView()
        );

        ladderController.runLadderApplication();
    }
}
