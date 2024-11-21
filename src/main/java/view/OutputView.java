package view;

import domain.ladder.Ladder;
import domain.ladder.Line;

import java.util.List;

public class OutputView {

    public static void printLadder(Ladder ladder, List<String> playerNames, List<String> resultNames) {
        System.out.println("실행 결과");

        System.out.println(String.join(" ", playerNames));

        for (Line line : ladder.getLines()) {
            printLine(line);
        }

        System.out.println(String.join(" ", resultNames));
    }

    private static void printLine(Line line) {
        StringBuilder result = new StringBuilder("|");

        for (boolean point : line.getPoints()) {
            if (point) {
                result.append("----|");
                continue;
            }
            result.append("    |");
        }
        System.out.println(result);
    }

    public static void printAllResult(List<String> results, List<String> playerNames) {
        for (int i = 0; i < playerNames.size(); i++) {
            System.out.println(playerNames.get(i) + " :" + results.get(i));
        }
    }

    public static void printIndividualResult(List<String> results, List<String> playerNames, String who) {
        if (playerNames.contains(who)) {
            System.out.println(who + " : " + results.get(playerNames.indexOf(who)));
        } else {
            System.out.println("해당 이름의 결과가 없습니다.");
        }
    }

    public static void printExitMessage() {
        System.out.println("결과 조회를 종료합니다.");
    }
}
