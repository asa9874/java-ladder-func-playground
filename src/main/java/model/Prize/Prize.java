package model.Prize;

public class Prize {

    private final String prizeName;
    private final int position;

    public Prize(String prizeName, int position) {
        this.prizeName = prizeName;
        this.position = position;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public int getPosition() {
        return position;
    }
}
