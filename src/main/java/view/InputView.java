package view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);
    private static final String INPUT_WIDTH_MESSAGE = "사다리의 넓이는 몇 개인가요?";
    private static final String INPUT_HEIGHT_MESSAGE = "사다리의 높이는 몇 개인가요?";

    public static int enterLadderWidth() {
        System.out.println(INPUT_WIDTH_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static int enterLadderHeight() {
        System.out.println(INPUT_HEIGHT_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }
}
