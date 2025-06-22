package model.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private List<Floor> floors;

    public Ladder(int height, int width, Random random) {
        this.floors = generateFloors(height, width, random);
    }

    private List<Floor> generateFloors(int height, int width, Random random) {
        List<Floor> floors = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            floors.add(new Floor(width, random));
        }
        return floors;
    }

    public List<Floor> getFloors() {
        return floors;
    }
}
