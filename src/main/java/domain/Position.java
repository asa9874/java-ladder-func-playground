package domain;

import java.util.Objects;

public class Position {
    private int position;

    public Position(int position) {
        validate(position);
        this.position = position;
    }

    private void validate(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("Position은 음수일 수 없습니다.");
        }
    }

    public void moveLeft() {
        position--;
    }

    public void moveRight() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Position other)) {
            return false;
        }
        return position == other.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
