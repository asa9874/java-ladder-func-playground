package util;

public class InputParser {

    public static int parseLadderHeight(String input) {
        LadderVaildator.validateLadderHeight(input);
        return Integer.parseInt(input);
    }

    public static int parseLadderWidth(String input) {
        LadderVaildator.validateLadderWidth(input);
        return Integer.parseInt(input);
    }
}
