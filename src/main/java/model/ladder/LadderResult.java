package model.ladder;

public class LadderResult {
    private final Ladder ladder;

    public LadderResult(Ladder ladder) {
        this.ladder = ladder;
    }

    public int move(int startIndex) {
        int position = startIndex;
        for (Floor floor : ladder.getFloors()) {
            position = movePosition(floor, position);
        }
        return position;
    }

    private int movePosition(Floor floor, int index) {
        if (floor.getConnections().get(index).isConnected()) {
            return index + 1;
        }

        if (floor.getConnections().get(index - 1).isConnected()) {
            return index - 1;
        }

        return index;
    }
}

