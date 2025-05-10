package model.Prize;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Prizes {

    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes of(List<String> prizeList, int participantCount) {
        validatePrizeCount(prizeList, participantCount);
        return new Prizes(
                IntStream.range(0, prizeList.size())
                        .mapToObj(position -> new Prize(prizeList.get(position), position))
                        .toList()
        );
    }

    private static void validatePrizeCount(List<String> prizeList, int participantCount) {
        if (prizeList.size() != participantCount) {
            throw new IllegalArgumentException("참가자 인원만큼 실행결과를 입력해야 합니다!");
        }
    }

    public int size() {
        return prizes.size();
    }

    public Prize getPrizeAtPosition(int position) {
        return prizes.stream()
                .filter(prize -> prize.getPosition() == position)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 위치의 결과가 존재하지 않습니다!"));
    }

    public List<Prize> getPrizes() {
        return Collections.unmodifiableList(prizes);
    }
}
