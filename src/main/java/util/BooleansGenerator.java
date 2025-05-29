package util;

import java.util.List;

@FunctionalInterface
public interface BooleansGenerator {
    List<Boolean> generateBooleans(final int size);
}
