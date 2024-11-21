package view;

import model.LadderGame;
import model.ladder.Ladder;
import model.ladder.LadderLine;
import model.ladder.LadderPoint;
import model.player.Player;
import model.player.Players;
import model.prize.Prize;
import model.prize.Prizes;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ViewResolver {

    private static final String SEPARATOR = ",";

    private final static int LADDER_CONNECTION_INTERVAL = 5;

    private final static String PART_OF_LADDER_VERTICAL = "|";
    private final static String PART_OF_LADDER_CONNECTION= "-";
    private final static String PART_OF_LADDER_DISCONNECTION =" ";

    private final static String LADDER_CONNECTION_FORM = PART_OF_LADDER_CONNECTION.repeat(LADDER_CONNECTION_INTERVAL);
    private final static String LADDER_DISCONNECTION_FORM = PART_OF_LADDER_DISCONNECTION.repeat(LADDER_CONNECTION_INTERVAL);

    public static List<String> resolvePlayerNames(String playerNames) {
        return Arrays.stream(playerNames.split(SEPARATOR))
                .map(String::trim)
                .toList();

    }

    public static List<String> resolvePrizeNames(String prizeNames) {
        return Arrays.stream(prizeNames.split(SEPARATOR))
                .map(String::trim)
                .toList();
    }

    public static void resolvePlayers(StringBuilder stringBuilder, Players players){
        for (Player player : players.getPlayers()) {
            int sortInterval = LADDER_CONNECTION_INTERVAL - player.getName().length() + 1;
            stringBuilder.append(player.getName() + " ".repeat(sortInterval));
        }

        stringBuilder.append("\n");
    }

    public static void resolveLadder(StringBuilder stringBuilder, Ladder ladder) {
        for (LadderLine ladderLine : ladder.getLadder()) {
            resolveLadderLine (ladderLine, stringBuilder);
            stringBuilder.append("\n");
        }
    }

    private static void resolveLadderLine(LadderLine ladderLine, StringBuilder stringBuilder) {
        for (LadderPoint ladderPoint : ladderLine.getLadderLine()) {

            stringBuilder.append(PART_OF_LADDER_VERTICAL);

            if (ladderPoint.isConnected()){
                stringBuilder.append(LADDER_CONNECTION_FORM);
                continue;
            }

            stringBuilder.append(LADDER_DISCONNECTION_FORM);

        }
    }

    public static void resolvePrizes(StringBuilder stringBuilder, Prizes prizes){
        for (Prize prize : prizes.getPrizes()) {
            int sortInterval = LADDER_CONNECTION_INTERVAL - prize.getPrizeName().length() + 1;
            stringBuilder.append(prize.getPrizeName() + " ".repeat(sortInterval));
        }

        stringBuilder.append("\n");
    }

    public static void resolveLadderResultByCommand(StringBuilder stringBuilder, LadderGame ladderGame){
        Map<Player, Prize> ladderResult = ladderGame.getLadderResult();

        for (Player player : ladderResult.keySet()) {
            stringBuilder.append(player.getName()+" : "+ladderResult.get(player).getPrizeName()+"\n");
        }
    }

    public static void resolveLadderResultByPlayerName(StringBuilder stringBuilder, LadderGame ladderGame,String playerName){
        Prize prize = ladderGame.findPrizeByPlayerName(playerName);
        stringBuilder.append(prize.getPrizeName());
    }
}
