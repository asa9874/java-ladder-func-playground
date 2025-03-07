package dto;

import java.util.List;
import java.util.Map;

public record LadderDTO(List<List<Boolean>> ladders, Map<Integer, Integer> results) {
}