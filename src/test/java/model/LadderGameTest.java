package model;

import model.ladder.Ladder;
import model.player.Player;
import model.player.Players;
import model.prize.Prize;
import model.prize.Prizes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class LadderGameTest {

    private LadderGame ladderGame;
    private Players players;
    private Ladder ladder;
    private Prizes prizes;

    @BeforeEach
    void 초기_세팅() {
        players = mock(Players.class);
        ladder = mock(Ladder.class);
        prizes = mock(Prizes.class);

        ladderGame = new LadderGame(players, ladder, prizes);
    }

    @Test
    void 사다리_게임을_실행하면_각_플레이어들의_사다리_결과가_저장된다() {
        Player player1 = mock(Player.class);
        Player player2 = mock(Player.class);
        Prize prize1 = mock(Prize.class);
        Prize prize2 = mock(Prize.class);

        when(players.getPlayers()).thenReturn(List.of(player1, player2));
        when(player1.getPosition()).thenReturn(0);
        when(player2.getPosition()).thenReturn(1);
        when(prizes.getPrizes()).thenReturn(List.of(prize1, prize2));

        ladderGame.playLadderGame();

        Map<Player, Prize> result = ladderGame.getLadderResult();

        assertThat(result.get(player1)).isEqualTo(prize1);
        assertThat(result.get(player2)).isEqualTo(prize2);

        verify(players).climbLadder(ladder);
    }

    @Test
    public void 플레이어의_이름을_통해_플레이어의_사다리_상품을_찾을_수_있다(){
        Player player = mock(Player.class);
        Prize prize = mock(Prize.class);

        when(players.findPlayerByPlayerName("test")).thenReturn(player);
        when(players.getPlayers()).thenReturn(List.of(player));
        when(player.getPosition()).thenReturn(0);
        when(prizes.getPrizes()).thenReturn(List.of(prize));

        ladderGame.playLadderGame();

        Prize findPrize = ladderGame.findPrizeByPlayerName("test");

        assertThat(findPrize).isEqualTo(prize);
    }
}
