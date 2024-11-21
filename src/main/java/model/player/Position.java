package model.player;

public class Position {

    private int position;

    private final static int INITIAL_POSITION = 0;

    public Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    private void validatePosition(int position) {
        if(position < INITIAL_POSITION){
            throw new IllegalArgumentException("플레이어의 위치가 유효하지 않습니다.");
        }
    }

    public void move(int direction) {
        position += direction;
    }

    public int getPosition() {
        return position;
    }
}
