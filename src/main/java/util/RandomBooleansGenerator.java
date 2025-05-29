package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomBooleansGenerator implements BooleansGenerator {
    private static final Random random = new Random();

    public List<Boolean> generateBooleans(final int size) {
        List<Boolean> result = new ArrayList<>();
        boolean prev = false;

        for (int i = 0; i < size; i++) {
            boolean current = generateNext(prev);
            result.add(current);
            prev = current;
        }
        return result;
    }

    private boolean generateNext(boolean prev) {
        if (prev) {
            return false;
        }
        return random.nextBoolean();
    }

}
