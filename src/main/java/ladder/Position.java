package ladder;

public class Position {

    private int currentIndex;

    public Position(int startIndex) {
        this.currentIndex = startIndex;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }
    
    public void updateCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }
}
