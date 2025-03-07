package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> getParticipants() {
        System.out.print("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)\n");
        return Arrays.asList(scanner.nextLine().split(","));
    }

    public static List<String> getResults() {
        System.out.print("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)\n");
        return Arrays.asList(scanner.nextLine().split(","));
    }

    public static int getHeight() {
        System.out.print("\n최대 사다리 높이는 몇 개인가요?\n");
        return scanner.nextInt();
    }

    public static String getQuery() {
        System.out.print("결과를 보고 싶은 사람은?\n");
        return scanner.next();
    }
}