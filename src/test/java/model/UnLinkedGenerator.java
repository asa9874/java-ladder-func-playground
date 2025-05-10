package model;

import model.ladder.Link;
import model.ladder.LinkGenerator;

public class UnLinkedGenerator implements LinkGenerator {
    @Override
    public Link generate() {
        return Link.from(false);
    }
}
