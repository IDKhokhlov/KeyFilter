package implemetations;

import strategy.RegexSplit;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IdsWithSpaces implements RegexSplit {
    public List<String> split(String string) {
        return Arrays.stream(string.split(",+"))
                .filter(el -> !el.isBlank())
                .collect(Collectors.toList());
    }
}
