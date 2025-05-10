package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> inputPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] names = scanner.nextLine().split(",");
        return Arrays.stream(names).toList();
    }

    public static List<String> inputResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String[] results = scanner.nextLine().split(",");
        return Arrays.stream(results).toList();
    }

    public static int inputHeight() {
        System.out.println("사다리의 높이는 몇 개인가요?");
        int height = scanner.nextInt();
        scanner.nextLine();
        return height;
    }

    public static String inputPlayerNameToCheckResult() {
        System.out.println("결과를 보고 싶은 사람은?(공백인 상태로 엔터를 입력하면 종료됩니다)");
        return scanner.nextLine();
    }
}
