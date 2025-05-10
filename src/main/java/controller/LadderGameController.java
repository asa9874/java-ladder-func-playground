package controller;

import model.*;
import model.Prize.Prizes;
import model.ladder.Ladder;
import model.ladder.LinkGenerator;
import model.user.User;
import model.user.Users;
import utils.StringSplitter;
import view.InputValidator;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Optional;

import static utils.Constants.FINAL_QUERY_KEYWORD;

public class LadderGameController {

    private final LinkGenerator linkGenerator;
    private final InputValidator inputValidator = new InputValidator();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    
    public LadderGameController(LinkGenerator linkGenerator) {
        this.linkGenerator = linkGenerator;
    }

    public void run() {
        Users users = getUsers();
        Prizes prizes = getPrizes(users.size());
        int height = getHeight();

        Ladder ladder = Ladder.of(height, users.size(), linkGenerator);
        outputView.printLadder(ladder, users, prizes);

        LadderGameResult ladderGameResult = LadderGameResult.of(users, prizes, ladder);
        handleUserResultQuery(ladderGameResult, users);
    }

    private void handleUserResultQuery(LadderGameResult ladderGameResult, Users users) {

        Optional<User> findUser = getFindUsername(users);

        if (findUser.isEmpty()) {
            outputView.printAllResults(ladderGameResult);
            return;
        }

        outputView.printPrize(ladderGameResult.findByUser(findUser.get()));
        handleUserResultQuery(ladderGameResult, users);
    }

    private Optional<User> getFindUsername(Users users) {
        outputView.printQueryInputMessage();
        String findUsername = inputView.getString();
        if (findUsername.equals(FINAL_QUERY_KEYWORD)) {
            return Optional.empty();
        }
        try {
            return Optional.of(users.findByUsername(findUsername));
        } catch (Exception e) {
            outputView.printErrorMessage(e.getMessage());
            return getFindUsername(users);
        }
    }

    private Users getUsers() {
        outputView.printUsernameInputMessage();
        try {
            return Users.from(readAndSplitInput());
        } catch (Exception e) {
            outputView.printErrorMessage(e.getMessage());
            return getUsers();
        }
    }

    private Prizes getPrizes(int participantCount) {
        outputView.printPrizeInputMessage();
        try {
            return Prizes.of(readAndSplitInput(), participantCount);
        } catch (Exception e) {
            outputView.printErrorMessage(e.getMessage());
            return getPrizes(participantCount);
        }
    }

    private List<String> readAndSplitInput() {
        String inputString = inputView.getString();
        inputValidator.validateInputStringPattern(inputString);
        return StringSplitter.splitByComma(inputString);
    }

    private int getHeight() {
        outputView.printHeightInputMessage();
        return inputView.getInt();
    }
}
