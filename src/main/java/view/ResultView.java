package view;

import model.LadderGame;
import model.ladder.Ladder;
import model.player.Players;
import model.prize.Prizes;

public class ResultView {

    private final static String COMMAND_ABOUT_ALL_PLAYER_PRINT = "all";

    public void printLadderFormWithGameElements(Players players, Ladder ladder, Prizes prizes){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n사다리 결과\n\n");

        ViewResolver.resolvePlayers(stringBuilder,players);
        ViewResolver.resolveLadder(stringBuilder,ladder);
        ViewResolver.resolvePrizes(stringBuilder,prizes);

        System.out.println(stringBuilder);
    }

    public void printLadderResult(String playerName, LadderGame ladderGame){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n실행 결과\n");

        if (playerName.equals(COMMAND_ABOUT_ALL_PLAYER_PRINT)){

            ViewResolver.resolveLadderResultByCommand(stringBuilder,ladderGame);

            System.out.println(stringBuilder);
            return;
        }

        ViewResolver.resolveLadderResultByPlayerName(stringBuilder,ladderGame,playerName);

        System.out.println(stringBuilder);
    }
}
