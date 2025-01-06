package ladder.generator;

import java.util.List;

public class StaticPointGenerator implements PointGenerator {

    private static final List<List<Boolean>> points = List.of(
        List.of(true, false, true, false),
        List.of(false, true, false, false)
    );

    private int i = 0;

    @Override
    public List<Boolean> generate(int size) {
        return points.get(i++);
    }
}
