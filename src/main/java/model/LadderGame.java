package model;

import model.ladder.Ladder;
import model.player.Player;
import model.player.Players;
import model.prize.Prize;
import model.prize.Prizes;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;
    private final Prizes prizes;

    private final Map <Player, Prize> ladderResultRepository;

    public LadderGame(Players players, Ladder ladder, Prizes prizes) {
        this.players = players;
        this.ladder = ladder;
        this.prizes = prizes;

        this.ladderResultRepository = new HashMap<>();
    }

    public void playLadderGame(){
        players.climbLadder(ladder);

        saveLadderResultToRepository();
    }

    private void saveLadderResultToRepository(){
        for (Player player : players.getPlayers()) {

            int index = player.getPosition();
            Prize prize = prizes.getPrizes().get(index);

            ladderResultRepository.put(player,prize);
        }
    }

    public Prize findPrizeByPlayerName(String playerName) throws IllegalArgumentException{
        Player player = players.findPlayerByPlayerName(playerName);
        return ladderResultRepository.get(player);
    }

    public Map<Player, Prize> getLadderResult() {
        return Collections.unmodifiableMap(ladderResultRepository);
    }
}
