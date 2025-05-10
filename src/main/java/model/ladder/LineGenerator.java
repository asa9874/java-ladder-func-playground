package model.ladder;

import java.util.ArrayList;
import java.util.List;

public class LineGenerator {

    public static HorizontalLine generateHorizontalLine(int width, LinkGenerator generator) {
        Link prev = Link.UNLINKED;
        List<Link> link = new ArrayList<>();
        
        for (int i = 0; i < width - 1; i++) {
            prev = addLink(prev, generator.generate(), link);
        }
        link.add(Link.UNLINKED);
        return new HorizontalLine(link);
    }

    private static Link addLink(Link prev, Link now, List<Link> link) {
        if (prev.isLinked()) {
            now = Link.UNLINKED;
        }
        link.add(now);
        return now;
    }
}
