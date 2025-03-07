package Model;

public enum Move
{
    LEFT(-1),
    RIGHT(1),
    NONE(0);

    private final int delta;

    Move(int delta) {
        this.delta = delta;
    }

    public int getDelta() {
        return delta;
    }

    // 현재 위치와 사다리의 특정 높이(curY)에서 이동 방향 결정
    public static Move fromLadder(Ladder ladder, int currentPosition, int curY) {
        // 왼쪽 이동 가능 여부 체크
        if (currentPosition > 0 && ladder.getData(currentPosition - 1, curY)) {
            return LEFT;
        }
        // 오른쪽 이동 가능 여부 체크
        if (currentPosition < ladder.getWidth() && ladder.getData(currentPosition, curY)) {
            return RIGHT;
        }
        return NONE;
    }
}
