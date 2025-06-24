package view;

import domain.Ladder;
import domain.Line;
import domain.model.LadderSymbol;

public class OutputView {

    public static final String PRINT_RESULT_MESSAGE = "\n실행결과\n";

    public void printLadder(Ladder ladder) {

        System.out.println(PRINT_RESULT_MESSAGE);

        for (Line line : ladder.getLines()) {
            printLadderLine(line, ladder.getWidth());
        }
    }

    private void printLadderLine(Line line, int width) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < width; i++) {
            result.append(LadderSymbol.VERTICAL.getSymbol());
            appendHorizontalSymbol(result, line, i, width);
        }
        System.out.println(result.toString());
    }

    private void appendHorizontalSymbol(StringBuilder result, Line line, int index, int width) {
        if (isLastColumn(index, width)) {
            return;
        }

        if (line.hasConnection(index)) {
            result.append(LadderSymbol.HORIZONTAL.getSymbol());
            return;
        }

        result.append(LadderSymbol.EMPTY.getSymbol());
    }

    private boolean isLastColumn(int index, int width) {
        return index == width - 1;
    }
}
