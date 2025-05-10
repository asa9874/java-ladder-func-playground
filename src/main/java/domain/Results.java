package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private final List<Result> results;

    private Results(List<Result> results) {
        this.results = results;
    }

    public static Results of(List<String> results) {
        List<Result> resultList = results.stream()
                .map(Result::new)
                .collect(Collectors.toList());
        return new Results(resultList);
    }

    public Result findByPosition(Position position) {
        return results.get(position.getPosition());
    }

    public List<Result> getResults() {
        return results;
    }
}
