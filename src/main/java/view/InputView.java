package view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public int getInt() {
        int inputInt = scanner.nextInt();
        System.out.println();
        return inputInt;
    }

    public String getString() {
        String inputString = scanner.next();
        System.out.println();
        return inputString;
    }
}
