package model;

import model.ladder.Link;
import model.ladder.LinkGenerator;

public class LinkedGenerator implements LinkGenerator {
    @Override
    public Link generate() {
        return Link.from(true);
    }
}
