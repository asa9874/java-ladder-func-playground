package view;

import dto.LadderDTO;

import java.util.List;

public class ResultView {
    public static void displayLadder(LadderDTO ladderDTO, List<String> participants, List<String> results) {
        System.out.println("\n사다리 결과\n");
        System.out.print("  ");
        for (String participant : participants) {
            System.out.printf("%-6s", participant);
        }
        System.out.println();

        for (List<Boolean> line : ladderDTO.ladders()) {
            System.out.print("    |");
            for (Boolean step : line) {
                System.out.print(step ? "-----" : "     ");
                System.out.print("|");
            }
            System.out.println();
        }

        System.out.print("    ");
        for (String result : results) {
            System.out.printf("%-6s", result);
        }
        System.out.println();
    }

    public static void displayResults(LadderDTO ladderDTO, List<String> participants, List<String> results) {
        System.out.println();
        while (true) {
            String query = InputView.getQuery();
            if (query.equals("all")) {
                System.out.println("실행 결과\n");
                for (int i = 0; i < participants.size(); i++) {
                    System.out.println(participants.get(i) + " : " + results.get(ladderDTO.results().get(i)));
                }
                break;
            } else {
                int index = participants.indexOf(query);
                if (index != -1) {
                    System.out.println("실행 결과: " + results.get(ladderDTO.results().get(index)) + "\n");
                } else {
                    System.out.println("존재하지 않는 이름입니다.");
                }
            }
        }
    }
}
