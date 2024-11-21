package model.prize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prizes {

    private final List<Prize> prizes;

    public Prizes(int playerCount, List<String> prizeNames) {

        validatePrize(prizeNames.size(),playerCount);

        this.prizes = new ArrayList<>();

        for (int i = 0; i < prizeNames.size(); i++) {
            Prize prize = new Prize(prizeNames.get(i));
            this.prizes.add(prize);
        }

    }

    private void validatePrize(int prizeCount, int playerCount) {
        if (prizeCount != playerCount){
            throw new IllegalArgumentException("사다리 상품의 개수가 플레이어의 수와 다릅니다.");
        }
    }

    public int Count(){
        return prizes.size();
    }

    public List<Prize> getPrizes() {
        return Collections.unmodifiableList(prizes);
    }
}
