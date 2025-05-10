package view;

import domain.Ladder;
import domain.Line;
import domain.Player;
import domain.Players;
import domain.Point;
import domain.Result;
import domain.Results;
import java.util.List;

public class OutputView {

    private static final String LADDER_POINT = "-----";
    private static final String NO_LADDER_POINT = "     ";

    public static void printLadderInfo(Players players, Results results, Ladder ladder) {
        System.out.println("사다리 결과");
        printPlayers(players.getPlayers());
        printLadder(ladder);
        printResults(results.getResults());
    }

    public static void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            printLine(line);
        }
    }

    public static void printPlayers(List<Player> players) {
        for (Player player : players) {
            System.out.printf("%-5s ", player.getName().getName());
        }
        System.out.println();
    }

    public static void printResults(List<Result> results) {
        for (Result result : results) {
            System.out.printf("%-5s ", result.getResult());
        }
        System.out.println();
    }

    private static void printLine(Line line) {
        List<Point> points = line.getPoints();
        System.out.print("  ");
        for (Point point : points) {
            System.out.print("|");
            System.out.print(getPointFormat(point.isMovable()));
        }
        System.out.println("|");
    }

    public static void printResult(Player player, Result result) {
        System.out.println(player.getName().getName() + " : " + result.getResult());
    }

    private static String getPointFormat(Boolean point) {
        if (point) {
            return LADDER_POINT;
        }
        return NO_LADDER_POINT;
    }
}
