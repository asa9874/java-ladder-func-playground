package Controller;

import Model.Ladder;
import View.InputView;
import View.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Application
{
    public static void main(String[] args) {
        List<String> participants = InputView.getParticipantString();
        List<String> result = InputView.getResultString(participants.size());

        int ladderHeight = InputView.getLadderHeight();
        Ladder ladder = new Ladder(result.size(), ladderHeight);
        ladder.setAllLadder();

        // 생성한 사다리 출력
        ResultView.printLadder(ladder, participants, result);

        // 결과 확인 1
        ResultView.printResult(ladder, InputView.getLadderResultName(), participants, result);

        // 결과 확인 2
        ResultView.printResult(ladder, InputView.getLadderResultName(), participants, result);
    }
}
