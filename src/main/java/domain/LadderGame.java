package domain;

import domain.model.Ladder;
import domain.model.Ladders;

import java.util.*;

public class LadderGame {
    private final Ladders ladders;

    public LadderGame(int height, int width) {
        this.ladders = new Ladders(generateLadders(height, width));
    }

    private List<Ladder> generateLadders(int height, int width) {
        List<Ladder> ladderList = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladderList.add(new Ladder(generateLadderLine(width)));
        }
        return ladderList;
    }

    private List<Boolean> generateLadderLine(int width) {
        List<Boolean> steps = new ArrayList<>(Collections.nCopies(width - 1, false));
        Random random = new Random();
        for (int j = 0; j < width - 1; j++) {
            processStep(steps, j, random);
        }
        return steps;
    }

    private void processStep(List<Boolean> steps, int index, Random random) {
        if (index > 0 && steps.get(index - 1)) {
            return;
        }
        steps.set(index, random.nextBoolean());
    }

    public Ladders getLadders() {
        return ladders;
    }

    public Map<Integer, Integer> getLadderResults() {
        int width = ladders.ladders().get(0).steps().size() + 1;
        Map<Integer, Integer> results = new HashMap<>();
        for (int i = 0; i < width; i++) {
            results.put(i, traverseLadder(i));
        }
        return results;
    }

    private int traverseLadder(int start) {
        int position = start;
        for (Ladder ladder : ladders.ladders()) {
            position = movePosition(position, ladder);
        }
        return position;
    }

    private int movePosition(int position, Ladder ladder) {
        if (position > 0 && ladder.steps().get(position - 1)) {
            return position - 1;
        } else if (position < ladder.steps().size() && ladder.steps().get(position)) {
            return position + 1;
        }
        return position;
    }
}
