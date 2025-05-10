package domain;

import java.util.Objects;

public class Name {
    private final String name;


    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름은 null이나 빈 문자열일 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하이어야 합니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof Name other) {
            return Objects.equals(name, other.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
