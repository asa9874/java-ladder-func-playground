package model;

import java.util.List;
import java.util.Objects;

public class Rewards {

    private final int MAX_REWARD_LENGTH = 5;
    private final List<String> rewards;

    public Rewards(final List<String> rewards) {
        validateRewardLength(rewards);
        this.rewards = rewards;
    }

    public String rewardAt(final int index) {
        return rewards.get(index);
    }

    private void validateRewardLength(final List<String> rewards) {
        rewards.forEach(name -> {
            if (name.length() > MAX_REWARD_LENGTH) {
                throw new IllegalArgumentException("보상은 5글자 이하여야 합니다.:" + name);
            }
        });
    }

    public List<String> getRewards() {
        return List.copyOf(rewards);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Rewards rewards1)) return false;
        return Objects.equals(getRewards(), rewards1.getRewards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRewards());
    }
}
