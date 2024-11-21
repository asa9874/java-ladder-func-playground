package domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;
    private final LadderWidth width;
    private final LadderHeight height;

    public Ladder(LadderWidth width, LadderHeight height, List<String> players, List<String> results) {
        validateSizes(players, results);
        this.width = width;
        this.height = height;
        this.lines = createLadder();
    }

    private void validateSizes(List<String> players, List<String> results) {
        if (players.size() != results.size()) {
            throw new IllegalArgumentException("참여자와 결과의 개수가 일치하지 않습니다.");
        }
    }

    private List<Line> createLadder() {
        List<Line> ladderLines = new ArrayList<>();
        for (int i = 0; i < height.getValue(); i++) {
            ladderLines.add(new Line(width.getValue()));
        }


        return ladderLines;
    }

    public List<String> calculateResults(List<String> gameResults) {

        List<String> results = new ArrayList<>();

        for (int i = 0; i < getWidth(); i++) {
            int endPoint = calculateEndPoint(i);
            results.add(gameResults.get(endPoint));
        }
        return results;
    }

    private int calculateEndPoint(int startPoint) {
        int currentPoint = startPoint;

        for (Line line : lines) {
            if (line.isAbleToMoveRight(currentPoint)) {
                currentPoint++;
            } else if (line.isAbleToMoveLeft(currentPoint)) {
                currentPoint--;
            }
        }
        return currentPoint;
    }

    public int getWidth() {
        return width.getValue();
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

}
