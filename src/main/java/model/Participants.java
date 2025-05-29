package model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Participants {
    private static final int MAX_NAME_LENGTH = 5;
    private final List<String> names;

    public Participants(final List<String> names) {
        validateSize(names);
        validateNameLength(names);
        validateDuplicatedName(names);
        validateDoesNotContainReservedNames(names);
        this.names = names;
    }

    private void validateSize(final List<String> names) {
        if (names.size() < 2) {
            throw new IllegalArgumentException("참가자는 2인 이상이어야 합니다.");
        }
    }

    private void validateNameLength(final List<String> names) {
        names.forEach(name -> {
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("참여자 이름은 5글자 이하여야 합니다.:" + name);
            }
        });
    }

    private void validateDuplicatedName(final List<String> names) {
        Set<String> nameSet = new HashSet<>(names);
        if (nameSet.size() != names.size()) {
            throw new IllegalArgumentException("참여자의 이름이 중복되면 안됩니다.");
        }
    }

    private void validateDoesNotContainReservedNames(final List<String> names) {
        boolean containsReserved = names.stream().anyMatch(name -> name.equalsIgnoreCase("all"));
        if (containsReserved) {
            throw new IllegalArgumentException("\"all\"은 참가자 이름으로 사용할 수 없습니다.");
        }
    }

    public int size() {
        return names.size();
    }

    public List<String> getNames() {
        return List.copyOf(names);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Participants that)) return false;
        return Objects.equals(getNames(), that.getNames());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNames());
    }
}
