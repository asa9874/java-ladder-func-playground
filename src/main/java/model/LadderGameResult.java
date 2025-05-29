package model;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LadderGameResult {

    private final Map<String, Integer> result;

    private LadderGameResult(final Map<String, Integer> result) {
        this.result = new HashMap<>(result);
    }

    public static LadderGameResult of(final Participants participants, final List<Integer> positions) {
        Map<String, Integer> result = new HashMap<>();
        List<String> names = participants.getNames();
        for (int i = 0; i < names.size(); i++) {
            result.put(names.get(i), positions.get(i));
        }
        return new LadderGameResult(result);
    }

    public Map<String, Integer> getResult() {
        return new HashMap<>(result);
    }

    public Integer getParticipantPosition(String name) {
        return result.get(name);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderGameResult that)) return false;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
