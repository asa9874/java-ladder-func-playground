import controller.LadderController;
import model.LadderGame;
import util.RandomBooleansGenerator;

public class Main {
    public static void main(String[] args) {
        LadderController ladderController = new LadderController(new RandomBooleansGenerator());
        LadderGame ladderGame = ladderController.createGameAndPrintLadder();
        ladderController.printGameResult(ladderGame);
    }
}
