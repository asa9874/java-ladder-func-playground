package service;

import domain.model.Ladder;
import domain.model.Ladders;
import dto.LadderDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LadderConverter {
    public static LadderDTO convertToDTO(Ladders ladders) {
        List<List<Boolean>> ladderData = new ArrayList<>();
        for (Ladder ladder : ladders.ladders()) {
            ladderData.add(new ArrayList<>(ladder.steps()));
        }
        return new LadderDTO(ladderData, new HashMap<>());
    }
}
