package view;

import model.*;
import model.Prize.Prize;
import model.Prize.Prizes;
import model.ladder.HorizontalLine;
import model.ladder.Ladder;
import model.ladder.Link;
import model.user.User;
import model.user.Users;

import java.util.List;
import java.util.function.Function;

public class OutputView {

    public void printUsernameInputMessage() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public void printHeightInputMessage() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public void printPrizeInputMessage() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    public void printQueryInputMessage() {
        System.out.println("결과를 보고 싶은 사람은?");
    }

    public void printPrize(Prize prize) {
        System.out.println("실행결과");
        System.out.println(prize.getPrizeName());
        System.out.println();
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
        System.out.println();
    }

    public void printLadder(Ladder ladder, Users users, Prizes prizes) {
        System.out.println("사다리 결과");
        printAligned(users.getUsers(), User::getName);
        ladder.getLines().forEach(OutputView::printHorizontalLine);
        printAligned(prizes.getPrizes(), Prize::getPrizeName);
        System.out.println();
    }

    public void printAllResults(LadderGameResult ladderGameResult) {
        System.out.println("실행결과");
        ladderGameResult.getGameResults().forEach((user, prize) ->
            System.out.println(user.getName() + " : " + prize.getPrizeName())
        );
        System.out.println();
    }

    private static <T> void printAligned(List<T> items, Function<T, String> mapper) {
        items.forEach(item ->
                System.out.printf("%-6s", mapper.apply(item)));
        System.out.println();
    }

    private static void printHorizontalLine(HorizontalLine line) {
        System.out.print(" ");
        line.getPoints().forEach(point -> {
            System.out.print("|");
            printCrossing(point);
        });
        System.out.println();
    }

    private static void printCrossing(Link point) {
        if (point == Link.LINKED) {
            System.out.print("-----");
        }
        if (point == Link.UNLINKED) {
            System.out.print("     ");
        }
    }
}
