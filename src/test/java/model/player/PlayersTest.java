package model.player;

import model.ladder.Ladder;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

public class PlayersTest {

    @Test
    public void 플레이어_수가_2명_미만일_경우_예외가_발생한다(){
        List <String> playerNames = List.of("test");

        assertThatThrownBy(() -> new Players(playerNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어는 최소 2명 이상이어야 합니다.");
    }

    @Test
    public void 플레이어의_이름이_중복되는_경우_예외가_발생한다(){
        List <String> playerNames = List.of("test","test");

        assertThatThrownBy(() -> new Players(playerNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 플레이어가 존재합니다.");
    }

    @Test
    public void 플레이어들이_사다리_타기를_시작하면_각_플레이어들은_독립적으로_사다리를_탄다(){
        Player player1 = mock(Player.class);
        Player player2 = mock(Player.class);

        List<String> playerNames = List.of("test1", "test2");
        Players players = new Players(playerNames);

        List<Player> mockPlayers = List.of(player1, player2);
        ReflectionTestUtils.setField(players, "players", mockPlayers);

        Ladder ladder = mock(Ladder.class);

        players.climbLadder(ladder);

        verify(player1).climbLadder(ladder);
        verify(player2).climbLadder(ladder);
    }

    @Test
    public void 플레이어_이름으로_플레이어_객체를_찾아_반환할_수_있다(){
        List<String> playerNames = List.of("test1","test2");
        Players players = new Players(playerNames);

        Player findPlayer1 = players.findPlayerByPlayerName("test1");
        Player findPlayer2 = players.findPlayerByPlayerName("test2");

        assertThat(findPlayer1.getName()).isEqualTo("test1");
        assertThat(findPlayer2.getName()).isEqualTo("test2");
     }

     @Test
    public void 없는_플레이어를_찾으려고_하는_경우_예외가_발생한다(){
         List<String> playerNames = List.of("test1","test2");
         Players players = new Players(playerNames);

         assertThatThrownBy(() -> players.findPlayerByPlayerName("test3"))
                 .isInstanceOf(IllegalArgumentException.class)
                 .hasMessage("찾고자 하는 플레이어가 존재하지 않습니다.");
     }

}
