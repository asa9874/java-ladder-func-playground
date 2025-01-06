package ladder;

import java.util.List;

public class Participants {

    private static final String ALL = "all";
    private final List<Participant> participants;

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public int size() {
        return participants.size();
    }

    public List<Participant> getParticipants() {
        return List.copyOf(participants);
    }

    public Participants findAllByName(String participantName) {
        if (ALL.equals(participantName)) {
            return new Participants(getParticipants());
        }

        final List<Participant> candidates = participants.stream()
            .filter(participant -> participant.hasSameName(participantName))
            .toList();

        checkIfEmpty(candidates);

        return new Participants(candidates);
    }

    public void move(Ladder ladder) {
        checkIfEmpty(participants);
        participants.forEach(participant -> participant.move(ladder));
    }

    private void checkIfEmpty(List<Participant> candidates) {
        if (candidates.isEmpty()) {
            throw new IllegalArgumentException("참여자가 존재하지 않습니다.");
        }
    }
}
