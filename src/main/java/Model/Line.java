package Model;

import java.util.ArrayList;
import java.util.List;

public class Line
{
    private final List<Boolean> points;

    public Line(LadderSetting setting) {
        points = new ArrayList<>(setting.getHeight());
        for (int i = 0; i < setting.getHeight(); i++)
            points.add(false);
    }

    public boolean checkIsConflict(Line leftLine, int addLineNumber) { return leftLine.getPoints(addLineNumber); }

    public boolean getPoints(int lineNumber) { return points.get(lineNumber); }

    public void setPoints(int lineNumber, boolean point) { points.set(lineNumber, point); }
}
