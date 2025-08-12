import java.util.List;

import model.Ladder;
import model.Person;
import util.InputParser;
import view.InputView;
import view.OutPutView;

public class LadderSimulator {

    private Ladder ladder;
    private List<Person> persons;
    private List<String> results;

    private int height;
    private int width;

    public void start() {
        processLadderInput();
        processLadderSimulate();
        processLadderResult();
    }

    private void processLadderInput() {
        persons = InputParser.parsePersons(InputView.inputPersons());
        results = InputParser.parseResults(InputView.inputResults());
        height = InputParser.parseLadderHeight(InputView.inputLadderHeight());
        width = this.persons.size() + 1;

        this.ladder = new Ladder(height, width);
        OutPutView.printLadder(ladder);
    }

    private void processLadderSimulate() {
    }

    private void processLadderResult() {
    }
}
