package ladder.io;

import ladder.*;

import java.util.List;

public class ConsoleOutputHandler implements OutputHandler {

    @Override
    public void printLadder(Ladder ladder, Participants participants, GameResults gameResults) {
        participants.getParticipants().forEach((participant) -> System.out.print(participant.getName() + " "));
        System.out.println();

        final List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            printLine(line.getPoints());
        }

        gameResults.getGameResults().forEach((gameResult) -> System.out.print(gameResult.getName() + "   "));
        System.out.println();
    }

    @Override
    public void printResult(Participants participants, GameResults gameResults) {
        System.out.println();
        participants.getParticipants().forEach(participant -> {
            System.out.print(participant.getName() + " -> ");
            System.out.println(gameResults.findByIndex(participant.getCurrentIndex()).getName());
        });
    }

    private void printLine(List<Boolean> points) {
        for (Boolean point : points) {
            printHorizontalLine(point);
        }
        alignNewLine();
    }

    private void printHorizontalLine(Boolean point) {
        if (point) {
            System.out.print("|-----");
            return;
        }
        System.out.print("|     ");
    }

    private static void alignNewLine() {
        System.out.println();
    }
}
