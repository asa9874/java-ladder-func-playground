package view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputLadderHeight() {
        System.out.print("사다리의 높이는 몇 개인가요?");
        return scanner.nextLine();
    }

    public static String inputLadderWidth() {
        System.out.print("사다리의 넓이는 몇 개인가요?");
        return scanner.nextLine();
    }
}
