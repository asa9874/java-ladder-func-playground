package view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputLadderHeight() {
        System.out.print("사다리의 높이는 몇 개인가요?");
        return scanner.nextLine();
    }

    // public static String inputLadderWidth() {
    //     System.out.print("사다리의 넓이는 몇 개인가요?");
    //     return scanner.nextLine();
    // }

    public static String inputPersons() {
        System.out.print("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public static String inputResults() {
        System.out.print("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }
}
