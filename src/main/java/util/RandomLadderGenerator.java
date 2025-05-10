package util;

import java.util.Random;

public class RandomLadderGenerator implements LadderGenerator {

    private final Random random = new Random();

    public boolean generate() {
        return random.nextBoolean();
    }
}
