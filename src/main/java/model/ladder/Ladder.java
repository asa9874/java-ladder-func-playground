package model.ladder;

import model.Prize.Prize;
import model.Prize.Prizes;
import model.user.User;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final List<HorizontalLine> lines;

    private Ladder(List<HorizontalLine> horizontalLines) {
        this.lines = horizontalLines;
    }

    public static Ladder of(int height, int participantCount, LinkGenerator generator) {
        return new Ladder(getRandomLines(height, participantCount, generator));
    }

    private static List<HorizontalLine> getRandomLines(int height, int participantCount, LinkGenerator generator) {
        return IntStream.range(0, height)
                .mapToObj(position -> LineGenerator.generateHorizontalLine(participantCount, generator))
                .toList();
    }

    public Prize ride(User user, Prizes prizes) {
        int position = user.getPosition();
        for (HorizontalLine line : lines) {
            position = line.move(position);
        }
        return prizes.getPrizeAtPosition(position);
    }

    public List<HorizontalLine> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
