package model.user;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

public class Users {

    private final List<User> users;

    private Users(List<User> users) {
        this.users = users;
    }

    public static Users from(List<String> usernames) {
        validateDuplicatedUser(usernames);
        return new Users(
                IntStream.range(0, usernames.size())
                        .mapToObj(position -> new User(usernames.get(position), position))
                        .toList()
        );
    }

    private static void validateDuplicatedUser(List<String> usernames) {
        HashSet<String> usernameMap = new HashSet<>(usernames);
        if (usernames.size() != usernameMap.size()) {
            throw new IllegalArgumentException("게임 참가자의 이름은 중복이 되면 안됩니다!");
        }
    }

    public User findByUsername(String findUsername) {
        return users.stream()
                .filter(user -> user.getName().equals(findUsername))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다!"));
    }

    public int size() {
        return users.size();
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }
}
