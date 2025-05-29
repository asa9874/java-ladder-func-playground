package model.dto;

import java.util.List;

public class LadderGameDto {

    private final List<String> participants;
    private final List<String> rewards;
    private final List<LineDto> lines;

    public LadderGameDto(final List<String> participants, final List<String> rewards, final List<LineDto> lines) {
        this.participants = participants;
        this.rewards = rewards;
        this.lines = lines;
    }
    
    public List<String> getParticipants() {
        return participants;
    }

    public List<String> getRewards() {
        return rewards;
    }

    public List<LineDto> getLines() {
        return lines;
    }
}
