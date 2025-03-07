package View;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView
{
    private static Scanner sc = new Scanner(System.in);

    private static List<String> splitStringByComma(String inputNames) {
        return Pattern.compile(",\\s*")
                .splitAsStream(inputNames)
                .filter(name -> name.length() <= 5)
                .collect(Collectors.toList());
    }

    public static List<String> getParticipantString() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputString = sc.nextLine();

        if (inputString == null || inputString.isEmpty())
            throw new IllegalArgumentException("올바르지 않은 이름입니다.");

        return splitStringByComma(inputString);
    }

    public static List<String> getResultString(int participantCount) {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String inputString = sc.nextLine();

        if (inputString == null || inputString.isEmpty())
            throw new IllegalArgumentException("올바르지 않은 결과입니다.");

        List<String> result = splitStringByComma(inputString);

        if (result.size() != participantCount)
            throw new IllegalArgumentException("참여자의 수와 일치하지 않습니다.");

        return result;
    }

    public static int getLadderHeight() {
        System.out.println("\n사다리의 높이는 몇 개인가요?");
        int ladderHeight = Integer.parseInt(sc.nextLine());

        if (ladderHeight <= 0)
            throw new IllegalArgumentException("사다리의 높이는 1 이상이어야 합니다.");

        return ladderHeight;
    }

    public static String getLadderResultName() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        String resultName = sc.nextLine();

        if (resultName == null || resultName.isEmpty())
            throw new IllegalArgumentException("올바르지 않은 이름입니다.");

        return resultName;
    }
}
