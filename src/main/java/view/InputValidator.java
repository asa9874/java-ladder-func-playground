package view;

public class InputValidator {

    private static final String USERNAME_NAMES_PATTERN = "^([a-zA-Z가-힣0-9]+)(,[a-zA-Z가-힣0-9]+)*$";

    public void validateInputStringPattern(String input) {
        if (!input.matches(USERNAME_NAMES_PATTERN)) {
            throw new IllegalArgumentException("입력은 쉼표로 구분 되어야 합니다!");
        }
    }
}
