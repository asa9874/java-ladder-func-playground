package model.ladder;

public enum LadderPoint {

    CONNECTED(true),
    DISCONNECTED(false);

    private final Boolean isConnected;

    LadderPoint(Boolean isConnected) {
        this.isConnected = isConnected;
    }

    public boolean isPossibleToMoveRight() {
        return this.isConnected;
    }

    public boolean isPossibleToMoveLeft(LadderPoint beforeLadderPoint) {
        return beforeLadderPoint.isConnected;
    }

    public Boolean isConnected() {
        return isConnected;
    }

}
