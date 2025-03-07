package View;

import Model.Ladder;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView
{
    // 출력 처리
    private static void getLadderSegment(int x, int y, Ladder ladder) {
        if (x % 2 == 0) {
            System.out.print("|");
            return;
        }

        if (ladder.getData(x/2, y)) {
            System.out.print("-----");
            return;
        }

        System.out.print("     ");
    }

    // 가로줄 출력처리
    private static void printRowLadder(int y, Ladder ladder) {
        int ladderWidth = ladder.getWidth();

        System.out.print("    ");
        IntStream.range(0, ladderWidth*2+1)
                .forEach(x -> getLadderSegment(x, y, ladder));
        System.out.println();
    }

    // 전체 사다리 출력처리
    public static void printLadder(Ladder ladder, List<String> participants, List<String> result) {
        System.out.println("\n사다리 결과");

        System.out.print("  ");
        for (String name : participants)
            System.out.printf("%-5s ", name);

        System.out.println();
        IntStream.range(0, ladder.getHeight())
                .forEach(y -> printRowLadder(y, ladder));

        System.out.print("  ");
        for (String name : result)
            System.out.printf("%-5s ", name);
    }

    // 입력받은 이름의 시작점 위치 반환
    private static int findNamePosition(String resultName, List<String> participants) {
        return IntStream.range(0, participants.size())
                .filter(i -> participants.get(i).equals(resultName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("그런 이름을 가진 사람이 없습니다."));
    }

    // 모든 사람의 시작점, 도착점 출력처리
    private static void printFinalPosition(Ladder ladder, List<String> participants, List<String> result) {
        for (int i = 0; i < ladder.getWidth()+1; i++)
            System.out.printf("%s : %s\n", participants.get(i), result.get(ladder.getFinalPosition(i)));
    }

    // 특정 사람의 사다리 결과 출력
    public static void printResult(Ladder ladder, String resultName, List<String> participants, List<String> result) {
        System.out.println("\n실행 결과");
        if (!resultName.equals("all"))
        {
            int namePositions = findNamePosition(resultName, participants);
            System.out.println(result.get(ladder.getFinalPosition(namePositions)));
            return;
        }

        printFinalPosition(ladder, participants, result);
    }
}
