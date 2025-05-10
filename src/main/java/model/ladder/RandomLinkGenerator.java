package model.ladder;

import java.util.concurrent.ThreadLocalRandom;

public class RandomLinkGenerator implements LinkGenerator {

    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    @Override
    public Link generate() {
        return Link.from(random.nextBoolean());
    }
}
