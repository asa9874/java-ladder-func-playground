import java.util.List;

import model.Ladder;
import model.Person;
import util.InputParser;
import view.InputView;
import view.OutPutView;

public class LadderSimulator {

    private Ladder ladder;

    private int height;
    private int width;

    public void start() {
        processLadderInput();
        processLadderSimulate();
    }

    private void processLadderInput() {
        // persons = InputParser.parsePersons(InputView.inputPersons());
        // results = InputParser.parseResults(InputView.inputResults());

        // 임시데이터
        List<Person> persons = List.of(
                new Person("Alice", 0),
                new Person("Bob", 1),
                new Person("Charlie", 2),
                new Person("David", 3));

        List<String> results = List.of("1st", "2nd", "3rd", "4th");

        height = InputParser.parseLadderHeight(InputView.inputLadderHeight());
        width = persons.size() - 1;

        this.ladder = new Ladder(height, width, persons, results);
        OutPutView.printLadder(ladder);
    }

    private void processLadderSimulate() {
        for (Person person : ladder.getPersons()) {
            PersonMovement(person);
        }

        OutPutView.printLadderResult(ladder);
    }

    // 우측우선이동임
    private void PersonMovement(Person person) {
        for (int nowHeight = 0; nowHeight < height; nowHeight++) {
            if (canMoveRight(person, ladder, nowHeight)) {
                person.moveRight();
                continue;
            }

            if (canMoveLeft(person, ladder, nowHeight)) {
                person.moveLeft();
                continue;
            }
        }
    }

    private boolean canMoveLeft(Person person, Ladder ladder, int nowHeight) {
        return person.getPosition() > 0 && ladder.isPoint(nowHeight, person.getPosition() - 1);
    }

    private boolean canMoveRight(Person person, Ladder ladder, int nowHeight) {
        return person.getPosition() < width && ladder.isPoint(nowHeight, person.getPosition());
    }

}
