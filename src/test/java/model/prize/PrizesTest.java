package model.prize;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PrizesTest {

    @Test
    public void 유효한_사다리_상품들이_정상적으로_생성된다(){
        List <String> prizeNames = Arrays.asList("test1","test2","test3");
        int playerCount = 3;

        Prizes prizes = new Prizes(playerCount, prizeNames);

        assertThat(prizes.Count()).isEqualTo(playerCount);
        assertThat(prizes.getPrizes().get(0).getPrizeName()).isEqualTo("test1");
        assertThat(prizes.getPrizes().get(1).getPrizeName()).isEqualTo("test2");
        assertThat(prizes.getPrizes().get(2).getPrizeName()).isEqualTo("test3");
    }

    @Test
    public void 생성된_사다리_상품의_개수가_플레이어_수와_다를_경우_예외가_발생한다(){
        List<String> prizeNames = Arrays.asList("test1","test2");
        int playerCount = 3;

        assertThatThrownBy(()->new Prizes(playerCount,prizeNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 상품의 개수가 플레이어의 수와 다릅니다.");
    }

}
