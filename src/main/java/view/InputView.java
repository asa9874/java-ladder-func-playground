package view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner =  new Scanner(System.in);

    public List <String> inputLadderGamePlayerNames(){

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String playerNames = scanner.next();
        return ViewResolver.resolvePlayerNames(playerNames);

    }

    public List <String> inputLadderGamePrizes(){

        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        String prizeNames = scanner.next();
        return ViewResolver.resolvePrizeNames(prizeNames);
    }

    public int inputLadderHeight(){

        System.out.println("최대 사다리 높이는 몇 개인가요?");

        return scanner.nextInt();

    }

    public String inputSelectPlayerToKnowPrize(){

        System.out.println("결과를 보고 싶은 사람은?");

        return scanner.next();

    }

}
