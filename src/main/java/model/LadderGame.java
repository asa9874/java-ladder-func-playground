package model;

import model.dto.LadderGameDto;
import model.dto.LineDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LadderGame {
    private final Participants participants;
    private final Ladder ladder;
    private final Rewards rewards;
    private final LadderGameResult ladderGameResult;

    private LadderGame(final Participants participants, final Rewards rewards, final Ladder ladder, final LadderGameResult ladderGameResult) {
        this.participants = participants;
        this.ladder = ladder;
        this.rewards = rewards;
        this.ladderGameResult = ladderGameResult;
    }

    public static LadderGame of(final Participants participants, final Rewards rewards, final Ladder ladder) {
        validateParticipantsAndRewardSize(participants.getNames(), rewards.getRewards());
        List<Integer> positions = ladder.getPositionAfterExecute();
        LadderGameResult ladderGameResult = LadderGameResult.of(participants, positions);
        return new LadderGame(participants, rewards, ladder, ladderGameResult);
    }

    private static void validateParticipantsAndRewardSize(List<String> participants, List<String> rewards) {
        if (participants.size() != rewards.size())
            throw new IllegalArgumentException("참가자 수와 보상의 갯수가 일치해야합니다.");
    }

    public String resultFor(final String name) {
        int position = ladderGameResult.getParticipantPosition(name);
        return rewards.rewardAt(position);
    }

    public Map<String, String> allResults() {
        Map<String, String> allResults = new HashMap<>();
        ladderGameResult.getResult().forEach((key, value) -> allResults.put(key, rewards.rewardAt(value)));
        return allResults;
    }

    public LadderGameDto toDto() {
        List<LineDto> lines = this.ladder.getLines().stream().map(Line::toDto).toList();
        return new LadderGameDto(participants.getNames(), rewards.getRewards(), lines);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderGame)) return false;
        LadderGame that = (LadderGame) o;
        return Objects.equals(participants, that.participants) && Objects.equals(rewards, that.rewards) && Objects.equals(ladder, that.ladder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participants, rewards, ladder);
    }
}
