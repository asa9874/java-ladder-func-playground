package model.prize;

public class Prize {

    private final String prizeName;

    public Prize(String prizeName) {

        validatePrizeName(prizeName);

        this.prizeName = prizeName;
    }

    private void validatePrizeName(String prizeName) {
        if (prizeName.isBlank()){
            throw new IllegalArgumentException("사다리 상품 이름은 비어있을 수 없습니다.");
        }
    }

    public String getPrizeName() {
        return prizeName;
    }
}
