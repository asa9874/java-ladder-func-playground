package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderGenerator {

    private final Random random = new Random();

    public List<Line> generateLadder(int height, int width) {
        List<Line> ladderLine = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladderLine.add(generateLine(width));
        }
        return ladderLine;
    }

    private Line generateLine(int width) {
        List<Boolean> connections = new ArrayList<>();

        for (int i = 0; i < width - 1; i++) {
            boolean canConnect = !hasPreviousConnection(connections, i);
            boolean connection = canConnect && random.nextBoolean();
            connections.add(connection);
        }

        return new Line(connections);
    }

    private boolean hasPreviousConnection(List<Boolean> connections, int currentIndex) {
        if (currentIndex == 0) {
            return false;
        }
        return connections.get(currentIndex - 1);
    }
}
