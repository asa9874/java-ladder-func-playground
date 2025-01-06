package ladder;

public class Participant {

    private final String name;
    private final Position position;

    public Participant(String name, Position position) {
        validate(name);
        this.name = name;
        this.position = position;
    }

    public void move(Ladder ladder) {
        int finalPosition = ladder.play(position.getCurrentIndex());
        position.updateCurrentIndex(finalPosition);
    }

    public boolean hasSameName(String name) {
        return this.name.equals(name);
    }

    public String getName() {
        return name;
    }

    public int getCurrentIndex() {
        return position.getCurrentIndex();
    }

    private void validate(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("참여자 이름은 5자 이하여야 합니다.");
        }
    }
}
