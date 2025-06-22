package view;

import model.ladder.Connection;
import model.ladder.Floor;
import model.ladder.Ladder;
import model.ladder.LadderResult;

public class OutputView {
    public void printLadder(Ladder ladder) {
        for (Floor floor : ladder.getFloors()) {
            printFloor(floor);
        }
    }

    private void printFloor(Floor floor) {
        for (Connection connection : floor.getConnections()) {
            printConnection(connection);
        }
        System.out.println("|");
    }

    private void printConnection(Connection connection) {
        if (connection.isConnected()) {
            System.out.print("|-----");
            return;
        }
        System.out.print("|     ");
    }

    public void printResult(LadderResult result, int width) {
        for (int i = 0; i < width; i++) {
            int end = result.move(i);
            System.out.println(i + " -> " + end);
        }
    }
}
