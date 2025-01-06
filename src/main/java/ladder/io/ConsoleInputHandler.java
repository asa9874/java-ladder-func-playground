package ladder.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;
import ladder.GameResult;
import ladder.GameResults;
import ladder.Participant;
import ladder.Participants;
import ladder.Position;
import ladder.Size;

public class ConsoleInputHandler implements InputHandler {

    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public Participants inputParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        try {
            final String[] split = SCANNER.nextLine().split(",");
            List<Participant> participants = new ArrayList<>();
            for (int i = 0; i < split.length; i++) {
                participants.add(new Participant(split[i], new Position(i)));
            }
            return new Participants(participants);
        } catch (Exception e) {
            throw new IllegalArgumentException("이름은 쉼표(,)로 구분해야 합니다.");
        }
    }

    @Override
    public GameResults inputResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        try {
            final List<GameResult> gameResults = Stream.of(SCANNER.nextLine().split(","))
                .map(GameResult::new)
                .toList();
            return new GameResults(gameResults);
        } catch (Exception e) {
            throw new IllegalArgumentException("결과는 쉼표(,)로 구분해야 합니다.");
        }
    }

    @Override
    public String getParticipantName() {
        System.out.println("결과를 보고 싶은 사람은?");
        return SCANNER.next();
    }

    @Override
    public Size inputSize(final int width) {
        final int height = inputHeight();

        return new Size(width, height);
    }

    private static int inputHeight() {
        System.out.println("사다리의 높이는 몇 개 인가요?");
        return SCANNER.nextInt();
    }
}
