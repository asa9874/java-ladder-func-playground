package domain;

public class Result {
    private final String result;

    public Result(String result) {
        validate(result);
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    private void validate(String result) {
        if (result == null || result.trim().isEmpty()) {
            throw new IllegalArgumentException("결과는 빈 문자열일 수 없습니다.");
        }
        if (result.length() > 5) {
            throw new IllegalArgumentException("결과는 5자 이하로 제한됩니다.");
        }
    }
}
