package view;

import java.util.List;

import model.Ladder;
import model.Line;

public class OutPutView {

    public static void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            System.out.println(line);
        }
    }
}
