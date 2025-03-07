package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder
{
    private final List<Line> lines = new ArrayList<>();
    private final LadderSetting setting;

    public Ladder(int ladderWidth, int ladderHeight) {
        this.setting = new LadderSetting(ladderWidth, ladderHeight);
    }

    private boolean randomBoolean() {
        int randomNumber = (int)(Math.random() + 0.3);
        if (randomNumber == 1)
            return true;

        return false;
    }

    private void addLines(Line leftLine, Line curLine) {
        IntStream.range(0, setting.getHeight())
                .filter(curHeight -> !curLine.checkIsConflict(leftLine, curHeight))
                .forEach(curHeight -> curLine.setPoints(curHeight, randomBoolean()));
    }

    public void setAllLadder() {
        // 0번 라인 생성
        Line firstLine = new Line(setting);
        lines.add(firstLine);
        addLines(firstLine, firstLine);

        // 이후 라인 생성 및 설정
        for (int lineNumber = 1; lineNumber < setting.getWidth(); lineNumber++) {
            Line newLine = new Line(setting);
            addLines(lines.get(lineNumber - 1), newLine);
            lines.add(newLine);
        }
    }

    public int getFinalPosition(int startPosition) {
        int finalPosition = startPosition;
        for (int curY = 0; curY < setting.getHeight(); curY++) {
            Move move = Move.fromLadder(this, finalPosition, curY);
            finalPosition += move.getDelta();
        }

        return finalPosition;
    }

    public int getWidth() {
        return setting.getWidth();
    }

    public int getHeight() {
        return setting.getHeight();
    }

    public boolean getData(int ladderNumber, int ladderHeight) {
        return lines.get(ladderNumber).getPoints(ladderHeight);
    }
}
