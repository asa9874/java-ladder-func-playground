package ladder;

import ladder.io.ConsoleInputHandler;
import ladder.io.ConsoleOutputHandler;
import ladder.io.InputHandler;
import ladder.io.OutputHandler;

public class LadderGameApplication {
    public static void main(String[] args) {
        final InputHandler inputHandler = new ConsoleInputHandler();
        final OutputHandler outputHandler = new ConsoleOutputHandler();

        final LadderGame ladderGame = new LadderGame(inputHandler, outputHandler);
        ladderGame.start();
    }
}
