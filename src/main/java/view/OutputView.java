package view;

import model.dto.LadderGameDto;
import model.dto.LineDto;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printLadderResult(final LadderGameDto dto) {
        System.out.println("사다리 결과");
        printParticipants(dto.getParticipants());
        printLadder(dto.getLines());
        printRewards(dto.getRewards());
    }

    public static void printExecutedResult(final Map<String, String> resultMap) {
        System.out.println("\n실행 결과");
        resultMap.forEach((name, result) -> System.out.println(name + " : " + result));
    }

    public static void printResultFor(final String reward) {
        System.out.println("실행 결과");
        System.out.println(reward);
    }

    private static void printRewards(final List<String> rewards) {
        rewards.forEach(reward -> System.out.printf("%-5s", reward));
        System.out.println();
    }

    private static void printParticipants(final List<String> participants) {
        participants.forEach(
                participant -> System.out.printf("%-5s", participant));
        System.out.println();
    }

    private static void printLadder(List<LineDto> lines) {
        lines.forEach(OutputView::printLine);
    }

    private static void printLine(LineDto dto) {
        dto.getPoints().forEach(
                point -> {
                    if (point) System.out.print("|-----");
                    if (!point) System.out.print("|     ");
                });
        System.out.print("|\n");
    }

}
