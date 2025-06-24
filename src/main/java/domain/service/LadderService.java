package domain.service;

import domain.Ladder;
import domain.LadderGenerator;
import domain.Line;
import domain.Size;
import java.util.List;

public class LadderService {
    private final LadderGenerator generator;
    private final Size size;

    public LadderService(Size size) {
        this.generator = new LadderGenerator();
        this.size = size;
    }

    public Ladder createLadder() {
        int height = size.getHeight();
        int width = size.getWidth();
        List<Line> lines = generator.generateLadder(height, width);

        return new Ladder(lines, width);
    }
}
