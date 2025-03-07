package service;

import domain.LadderGame;
import dto.LadderDTO;

public class LadderService {
    public LadderDTO createLadderGame(int height, int width) {
        LadderGame game = new LadderGame(height, width);
        return new LadderDTO(
                LadderConverter.convertToDTO(game.getLadders()).ladders(),
                game.getLadderResults()
        );
    }
}

