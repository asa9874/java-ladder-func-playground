package model.ladder;

public enum Link {
    LINKED,
    UNLINKED;

    public static Link from(boolean linked) {
        if (linked) {
            return LINKED;
        }
        return UNLINKED;
    }

    public boolean isLinked() {
        return this == LINKED;
    }
}
