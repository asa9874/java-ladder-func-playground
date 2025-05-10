package utils;

import java.util.Arrays;
import java.util.List;

public class StringSplitter {

    public static List<String> splitByComma(String inputString) {
        return Arrays.asList(inputString.split(","));
    }
}
