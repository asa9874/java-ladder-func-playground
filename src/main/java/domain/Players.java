package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players of(List<String> names) {
        validate(names);
        List<Player> players = names.stream()
                .map(name -> new Player(new Name(name), new Position(names.indexOf(name))))
                .collect(Collectors.toList());
        return new Players(players);
    }

    private static void validate(List<String> names) {
        Set<String> nameSet = new HashSet<>();
        names.forEach(name -> checkDuplicate(nameSet, name));
    }

    private static void checkDuplicate(Set<String> nameSet, String name) {
        if (!nameSet.add(name)) {
            throw new IllegalArgumentException("중복된 이름이 있습니다: " + name);
        }
    }

    public void moveDown(Ladder ladder) {
        players.forEach(player -> player.downLadder(ladder));
    }

    public Player findByName(Name name) {
        return players.stream()
                .filter(player -> player.hasName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 이름입니다: " + name.getName()));
    }

    public List<Player> getPlayers() {
        return players;
    }
}
