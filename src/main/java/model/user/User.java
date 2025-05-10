package model.user;

import static utils.Constants.FINAL_QUERY_KEYWORD;
import static utils.Constants.MAX_USERNAME_LENGTH;

public class User {

    private final String name;
    private final int position;

    public User(String name, int position) {
        validateUsername(name);
        this.name = name;
        this.position = position;
    }

    private static void validateUsername(String name) {
        validateUsernameLength(name);
        validateUsernameKeyword(name);
    }

    private static void validateUsernameLength(String name) {
        if (name.length() > MAX_USERNAME_LENGTH) {
            throw new IllegalArgumentException("유저 이름은 최대 " + MAX_USERNAME_LENGTH + "자 입니다!");
        }
    }

    private static void validateUsernameKeyword(String name) {
        if (name.equals(FINAL_QUERY_KEYWORD)) {
            throw new IllegalArgumentException("유저 이름으로 \"" + FINAL_QUERY_KEYWORD + "\"는 사용할 수 없습니다!");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
