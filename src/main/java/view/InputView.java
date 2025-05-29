package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> readParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] participants = scanner.nextLine().split(",");
        return Arrays.stream(participants).toList();
    }

    public static List<String> readRewards() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String[] result = scanner.nextLine().split(",");
        return Arrays.stream(result).toList();
    }

    public static int readLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = scanner.nextInt();
        scanner.nextLine();
        return height;
    }

    public static String readParticipantNameToQuery() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        return scanner.nextLine().trim();
    }

}

